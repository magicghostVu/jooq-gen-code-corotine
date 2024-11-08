/*
 * This file is generated by jOOQ.
 */
package com.magicghostvu.model.tables.pojos;


import com.magicghostvu.model.enums.Adminrole;

import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Adminroles implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String domainname;
    private final Adminrole role;

    public Adminroles(Adminroles value) {
        this.domainname = value.domainname;
        this.role = value.role;
    }

    public Adminroles(
        String domainname,
        Adminrole role
    ) {
        this.domainname = domainname;
        this.role = role;
    }

    /**
     * Getter for <code>public.AdminRoles.domainName</code>.
     */
    public String getDomainname() {
        return this.domainname;
    }

    /**
     * Getter for <code>public.AdminRoles.role</code>.
     */
    public Adminrole getRole() {
        return this.role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Adminroles other = (Adminroles) obj;
        if (this.domainname == null) {
            if (other.domainname != null)
                return false;
        }
        else if (!this.domainname.equals(other.domainname))
            return false;
        if (this.role == null) {
            if (other.role != null)
                return false;
        }
        else if (!this.role.equals(other.role))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.domainname == null) ? 0 : this.domainname.hashCode());
        result = prime * result + ((this.role == null) ? 0 : this.role.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Adminroles (");

        sb.append(domainname);
        sb.append(", ").append(role);

        sb.append(")");
        return sb.toString();
    }
}