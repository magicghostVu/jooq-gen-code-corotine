/*
 * This file is generated by jOOQ.
 */
package com.magicghostvu.model.tables;


import com.magicghostvu.model.Indexes;
import com.magicghostvu.model.Keys;
import com.magicghostvu.model.Public;
import com.magicghostvu.model.enums.Adminrole;
import com.magicghostvu.model.tables.records.AdminrolesRecord;

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
public class Adminroles extends TableImpl<AdminrolesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.AdminRoles</code>
     */
    public static final Adminroles ADMINROLES = new Adminroles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AdminrolesRecord> getRecordType() {
        return AdminrolesRecord.class;
    }

    /**
     * The column <code>public.AdminRoles.domainName</code>.
     */
    public final TableField<AdminrolesRecord, String> DOMAINNAME = createField(DSL.name("domainName"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.AdminRoles.role</code>.
     */
    public final TableField<AdminrolesRecord, Adminrole> ROLE = createField(DSL.name("role"), SQLDataType.VARCHAR.nullable(false).asEnumDataType(com.magicghostvu.model.enums.Adminrole.class), this, "");

    private Adminroles(Name alias, Table<AdminrolesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Adminroles(Name alias, Table<AdminrolesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.AdminRoles</code> table reference
     */
    public Adminroles(String alias) {
        this(DSL.name(alias), ADMINROLES);
    }

    /**
     * Create an aliased <code>public.AdminRoles</code> table reference
     */
    public Adminroles(Name alias) {
        this(alias, ADMINROLES);
    }

    /**
     * Create a <code>public.AdminRoles</code> table reference
     */
    public Adminroles() {
        this(DSL.name("AdminRoles"), null);
    }

    public <O extends Record> Adminroles(Table<O> child, ForeignKey<O, AdminrolesRecord> key) {
        super(child, key, ADMINROLES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.ADMINROLES_DOMAINNAME_ROLE_IDX, Indexes.ADMINROLES_DOMAINNAME_ROLE_KEY);
    }

    @Override
    public List<ForeignKey<AdminrolesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ADMINROLES__ADMINROLES_DOMAINNAME_FKEY);
    }

    private transient Adminuser _adminuser;

    /**
     * Get the implicit join path to the <code>public.AdminUser</code> table.
     */
    public Adminuser adminuser() {
        if (_adminuser == null)
            _adminuser = new Adminuser(this, Keys.ADMINROLES__ADMINROLES_DOMAINNAME_FKEY);

        return _adminuser;
    }

    @Override
    public Adminroles as(String alias) {
        return new Adminroles(DSL.name(alias), this);
    }

    @Override
    public Adminroles as(Name alias) {
        return new Adminroles(alias, this);
    }

    @Override
    public Adminroles as(Table<?> alias) {
        return new Adminroles(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Adminroles rename(String name) {
        return new Adminroles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Adminroles rename(Name name) {
        return new Adminroles(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Adminroles rename(Table<?> name) {
        return new Adminroles(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, Adminrole> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super String, ? super Adminrole, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super String, ? super Adminrole, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
