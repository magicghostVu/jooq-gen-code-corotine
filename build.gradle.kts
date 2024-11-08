import org.jooq.meta.jaxb.ForcedType
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property

plugins {
    kotlin("jvm") version "2.0.20"
    id("nu.studer.jooq") version "8.2"
}


repositories {
    mavenCentral()
}

val log4jVersion = "2.17.2"
dependencies {

    // jooq
    implementation("org.jooq:jooq:3.18.7")
    implementation("org.jooq:jooq-meta:3.18.7")
    implementation("org.jooq:jooq-codegen:3.18.7")


    // driver for gen code and use
    jooqGenerator("org.postgresql:postgresql:42.5.1")


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

    // connection pool
    implementation("io.r2dbc:r2dbc-pool:1.0.1.RELEASE")

    // connect r2dbc vs postgres
    implementation("org.postgresql:r2dbc-postgresql:1.0.2.RELEASE")

    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion"){
        exclude("org.slf4j", "slf4j-api")
    }
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
}

kotlin {
    jvmToolchain(17)
}


val dbUrl = "jdbc:postgresql://localhost:5432/bcs_static"
val dbUser = "postgres"
val dbPassword = "password"
val dbDriver = "org.postgresql.Driver"

jooq {
    version.set("3.18.7")  // the default (can be omitted)
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)  // the default (can be omitted)
    configurations {
        create("main") {  // name of the jOOQ configuration
            generateSchemaSourceOnCompilation.set(true)  // default (can be omitted)

            jooqConfiguration.apply {
                logging = Logging.WARN
                jdbc.apply {
                    driver = dbDriver
                    url = dbUrl
                    user = dbUser
                    password = dbPassword
                    properties.add(Property().apply {
                        key = "ssl"
                        value = "false"
                    })
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                        /*forcedTypes.addAll(listOf(
                            ForcedType().apply {
                                name = "varchar"
                                includeExpression = ".*"
                                includeTypes = "JSONB?"
                            },
                            ForcedType().apply {
                                name = "varchar"
                                includeExpression = ".*"
                                includeTypes = "INET"
                            }
                        ))*/

                        // các bảng exclude khi gen
                        excludes = """
                            _prisma_migrations
                        """.trimIndent()
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "com.magicghostvu.model"
                        directory = "src/main/java"  // default (can be omitted)
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }

}