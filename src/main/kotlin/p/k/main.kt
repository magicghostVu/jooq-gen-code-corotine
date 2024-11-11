package p.k

import com.magicghostvu.model.tables.Game
import io.r2dbc.pool.PoolingConnectionFactoryProvider.*
import io.r2dbc.postgresql.PostgresqlConnectionFactoryProvider
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactoryOptions.*
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.map
import org.jooq.Record
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.impl.DefaultConfiguration
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import org.slf4j.LoggerFactory
import reactor.core.publisher.Flux
import java.time.Duration


suspend fun main(vararg args: String) {
    // tạo connection pool factory
    System.setProperty("log4j.configurationFile", "./log4j2.xml")
    val logger = LoggerFactory.getLogger("common")
    val connectionFactory = ConnectionFactories.get(
        builder()
            .option(PROTOCOL, "postgresql")
            .option<String>(DRIVER, "pool")
            .option<String>(HOST, "localhost")
            .option<Int>(PORT, 5432)
            .option<String>(USER, "postgres")
            .option(PASSWORD, "password")
            .option<String>(DATABASE, "bcs_static")
            .option(MAX_SIZE, 20)
            .option(INITIAL_SIZE, 2)
            .option(PostgresqlConnectionFactoryProvider.SCHEMA, "public")
            .option(MAX_ACQUIRE_TIME, Duration.ofSeconds(30))
            .option(MAX_IDLE_TIME, Duration.ofSeconds(30))
            .build()
    )
    val dsl = DSL
        .using(
            DefaultConfiguration()
                .set(connectionFactory)
                .set(SQLDialect.POSTGRES)
        )
        .dsl()
    val g = Game.GAME
    val rSelect = dsl
        .select() // select all
        .from(g)
        .limit(2)
    val flux = Flux.from(rSelect)
    val allRecord = channelFlow<Record> {
        val sub = SubscriberForChanel(this)
        flux.subscribe(sub)
        sub.wait.await()
    }
    logger.info("done create flow")
    allRecord.collect {
        val displayName = it.get(g.DISPLAYNAME)
        val gameType = it.get(g.GAMETYPE)
        val id = it.get(g.ID)
        logger.info("id {}, name {}, game type {}", id, displayName, gameType)
    }

}


class SubscriberForChanel<T>(
    private val sendChannel: SendChannel<T>,
    val wait: CompletableDeferred<Unit> = CompletableDeferred(),
) : Subscriber<T> {
    override fun onSubscribe(s: Subscription) {
        s.request(Int.MAX_VALUE.toLong())
    }

    override fun onNext(t: T) {
        sendChannel.trySend(t)
    }

    override fun onError(t: Throwable) {
        wait.completeExceptionally(t)
    }

    override fun onComplete() {
        wait.complete(Unit)
    }
}

class CCC(private var i: Int = 0) : suspend (Any?) -> Int {
    override suspend fun invoke(p1: Any?): Int {
        i++
        return i
    }
}


fun Flow<*>.counter2(): Flow<Int> {
    val i = 0
    val f = CCC(i)
    return map(f)
}
