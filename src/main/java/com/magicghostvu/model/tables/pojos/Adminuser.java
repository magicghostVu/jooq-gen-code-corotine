/*
 * This file is generated by jOOQ.
 */
package com.magicghostvu.model.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Adminuser implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String domainname;

    public Adminuser(Adminuser value) {
        this.domainname = value.domainname;
    }

    public Adminuser(
        String domainname
    ) {
        this.domainname = domainname;
    }

    /**
     * Getter for <code>public.AdminUser.domainName</code>.
     */
    public String getDomainname() {
        return this.domainname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Adminuser other = (Adminuser) obj;
        if (this.domainname == null) {
            if (other.domainname != null)
                return false;
        }
        else if (!this.domainname.equals(other.domainname))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.domainname == null) ? 0 : this.domainname.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Adminuser (");

        sb.append(domainname);

        sb.append(")");
        return sb.toString();
    }
}
