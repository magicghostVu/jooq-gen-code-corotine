/*
 * This file is generated by jOOQ.
 */
package com.magicghostvu.model.tables.records;


import com.magicghostvu.model.enums.Adminrole;
import com.magicghostvu.model.tables.Adminroles;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AdminrolesRecord extends TableRecordImpl<AdminrolesRecord> implements Record2<String, Adminrole> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.AdminRoles.domainName</code>.
     */
    public AdminrolesRecord setDomainname(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.AdminRoles.domainName</code>.
     */
    public String getDomainname() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.AdminRoles.role</code>.
     */
    public AdminrolesRecord setRole(Adminrole value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.AdminRoles.role</code>.
     */
    public Adminrole getRole() {
        return (Adminrole) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, Adminrole> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, Adminrole> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Adminroles.ADMINROLES.DOMAINNAME;
    }

    @Override
    public Field<Adminrole> field2() {
        return Adminroles.ADMINROLES.ROLE;
    }

    @Override
    public String component1() {
        return getDomainname();
    }

    @Override
    public Adminrole component2() {
        return getRole();
    }

    @Override
    public String value1() {
        return getDomainname();
    }

    @Override
    public Adminrole value2() {
        return getRole();
    }

    @Override
    public AdminrolesRecord value1(String value) {
        setDomainname(value);
        return this;
    }

    @Override
    public AdminrolesRecord value2(Adminrole value) {
        setRole(value);
        return this;
    }

    @Override
    public AdminrolesRecord values(String value1, Adminrole value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AdminrolesRecord
     */
    public AdminrolesRecord() {
        super(Adminroles.ADMINROLES);
    }

    /**
     * Create a detached, initialised AdminrolesRecord
     */
    public AdminrolesRecord(String domainname, Adminrole role) {
        super(Adminroles.ADMINROLES);

        setDomainname(domainname);
        setRole(role);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised AdminrolesRecord
     */
    public AdminrolesRecord(com.magicghostvu.model.tables.pojos.Adminroles value) {
        super(Adminroles.ADMINROLES);

        if (value != null) {
            setDomainname(value.getDomainname());
            setRole(value.getRole());
            resetChangedOnNotNull();
        }
    }
}
