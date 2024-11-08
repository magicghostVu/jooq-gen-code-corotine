/*
 * This file is generated by jOOQ.
 */
package com.magicghostvu.model.enums;


import com.magicghostvu.model.Public;

import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public enum Adminrole implements EnumType {

    SuperAdmin("SuperAdmin"),

    Admin("Admin");

    private final String literal;

    private Adminrole(String literal) {
        this.literal = literal;
    }

    @Override
    public Catalog getCatalog() {
        return getSchema().getCatalog();
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public String getName() {
        return "AdminRole";
    }

    @Override
    public String getLiteral() {
        return literal;
    }

    /**
     * Lookup a value of this EnumType by its literal
     */
    public static Adminrole lookupLiteral(String literal) {
        return EnumType.lookupLiteral(Adminrole.class, literal);
    }
}
