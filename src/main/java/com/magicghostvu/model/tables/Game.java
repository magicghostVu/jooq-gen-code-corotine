/*
 * This file is generated by jOOQ.
 */
package com.magicghostvu.model.tables;


import com.magicghostvu.model.Indexes;
import com.magicghostvu.model.Keys;
import com.magicghostvu.model.Public;
import com.magicghostvu.model.enums.Gametype;
import com.magicghostvu.model.tables.records.GameRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function8;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Game extends TableImpl<GameRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.Game</code>
     */
    public static final Game GAME = new Game();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GameRecord> getRecordType() {
        return GameRecord.class;
    }

    /**
     * The column <code>public.Game.id</code>.
     */
    public final TableField<GameRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).defaultValue(DSL.field(DSL.raw("nextval('\"Game_id_seq\"'::regclass)"), SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.Game.createTime</code>.
     */
    public final TableField<GameRecord, Long> CREATETIME = createField(DSL.name("createTime"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.Game.displayName</code>.
     */
    public final TableField<GameRecord, String> DISPLAYNAME = createField(DSL.name("displayName"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.Game.lastUpdateTime</code>.
     */
    public final TableField<GameRecord, Long> LASTUPDATETIME = createField(DSL.name("lastUpdateTime"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.Game.authorId</code>.
     */
    public final TableField<GameRecord, Long> AUTHORID = createField(DSL.name("authorId"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.Game.gameType</code>.
     */
    public final TableField<GameRecord, Gametype> GAMETYPE = createField(DSL.name("gameType"), SQLDataType.VARCHAR.nullable(false).defaultValue(DSL.field(DSL.raw("'SingleGame'::\"GameType\""), SQLDataType.VARCHAR)).asEnumDataType(com.magicghostvu.model.enums.Gametype.class), this, "");

    /**
     * The column <code>public.Game.parentGameId</code>.
     */
    public final TableField<GameRecord, Long> PARENTGAMEID = createField(DSL.name("parentGameId"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.Game.description</code>.
     */
    public final TableField<GameRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.CLOB.nullable(false).defaultValue(DSL.field(DSL.raw("''::text"), SQLDataType.CLOB)), this, "");

    private Game(Name alias, Table<GameRecord> aliased) {
        this(alias, aliased, null);
    }

    private Game(Name alias, Table<GameRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.Game</code> table reference
     */
    public Game(String alias) {
        this(DSL.name(alias), GAME);
    }

    /**
     * Create an aliased <code>public.Game</code> table reference
     */
    public Game(Name alias) {
        this(alias, GAME);
    }

    /**
     * Create a <code>public.Game</code> table reference
     */
    public Game() {
        this(DSL.name("Game"), null);
    }

    public <O extends Record> Game(Table<O> child, ForeignKey<O, GameRecord> key) {
        super(child, key, GAME);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.GAME_CREATETIME_ID_AUTHORID_LASTUPDATETIME_PARENTGAMEID_IDX);
    }

    @Override
    public UniqueKey<GameRecord> getPrimaryKey() {
        return Keys.GAME_PKEY;
    }

    @Override
    public List<ForeignKey<GameRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GAME__GAME_AUTHORID_FKEY, Keys.GAME__GAME_PARENTGAMEID_FKEY);
    }

    private transient User _user;
    private transient Game _game;

    /**
     * Get the implicit join path to the <code>public.User</code> table.
     */
    public User user() {
        if (_user == null)
            _user = new User(this, Keys.GAME__GAME_AUTHORID_FKEY);

        return _user;
    }

    /**
     * Get the implicit join path to the <code>public.Game</code> table.
     */
    public Game game() {
        if (_game == null)
            _game = new Game(this, Keys.GAME__GAME_PARENTGAMEID_FKEY);

        return _game;
    }

    @Override
    public Game as(String alias) {
        return new Game(DSL.name(alias), this);
    }

    @Override
    public Game as(Name alias) {
        return new Game(alias, this);
    }

    @Override
    public Game as(Table<?> alias) {
        return new Game(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Game rename(String name) {
        return new Game(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Game rename(Name name) {
        return new Game(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Game rename(Table<?> name) {
        return new Game(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, Long, String, Long, Long, Gametype, Long, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super Long, ? super Long, ? super String, ? super Long, ? super Long, ? super Gametype, ? super Long, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super Long, ? super Long, ? super String, ? super Long, ? super Long, ? super Gametype, ? super Long, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
