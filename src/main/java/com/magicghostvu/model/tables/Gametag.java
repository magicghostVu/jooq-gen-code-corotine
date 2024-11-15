/*
 * This file is generated by jOOQ.
 */
package com.magicghostvu.model.tables;


import com.magicghostvu.model.Indexes;
import com.magicghostvu.model.Keys;
import com.magicghostvu.model.Public;
import com.magicghostvu.model.tables.records.GametagRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Gametag extends TableImpl<GametagRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.GameTag</code>
     */
    public static final Gametag GAMETAG = new Gametag();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GametagRecord> getRecordType() {
        return GametagRecord.class;
    }

    /**
     * The column <code>public.GameTag.gameId</code>.
     */
    public final TableField<GametagRecord, Long> GAMEID = createField(DSL.name("gameId"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.GameTag.tag</code>.
     */
    public final TableField<GametagRecord, String> TAG = createField(DSL.name("tag"), SQLDataType.CLOB.nullable(false), this, "");

    private Gametag(Name alias, Table<GametagRecord> aliased) {
        this(alias, aliased, null);
    }

    private Gametag(Name alias, Table<GametagRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.GameTag</code> table reference
     */
    public Gametag(String alias) {
        this(DSL.name(alias), GAMETAG);
    }

    /**
     * Create an aliased <code>public.GameTag</code> table reference
     */
    public Gametag(Name alias) {
        this(alias, GAMETAG);
    }

    /**
     * Create a <code>public.GameTag</code> table reference
     */
    public Gametag() {
        this(DSL.name("GameTag"), null);
    }

    public <O extends Record> Gametag(Table<O> child, ForeignKey<O, GametagRecord> key) {
        super(child, key, GAMETAG);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.GAMETAG_GAMEID_TAG_IDX, Indexes.GAMETAG_GAMEID_TAG_KEY);
    }

    @Override
    public List<ForeignKey<GametagRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GAMETAG__GAMETAG_GAMEID_FKEY);
    }

    private transient Game _game;

    /**
     * Get the implicit join path to the <code>public.Game</code> table.
     */
    public Game game() {
        if (_game == null)
            _game = new Game(this, Keys.GAMETAG__GAMETAG_GAMEID_FKEY);

        return _game;
    }

    @Override
    public Gametag as(String alias) {
        return new Gametag(DSL.name(alias), this);
    }

    @Override
    public Gametag as(Name alias) {
        return new Gametag(alias, this);
    }

    @Override
    public Gametag as(Table<?> alias) {
        return new Gametag(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Gametag rename(String name) {
        return new Gametag(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Gametag rename(Name name) {
        return new Gametag(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Gametag rename(Table<?> name) {
        return new Gametag(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Long, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Long, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
