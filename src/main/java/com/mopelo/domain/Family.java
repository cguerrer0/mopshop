/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mopelo.domain;

import com.mopelo.common.domain.GenericEntity;

/**
 * 
 * @author guerrero
 *
 */
public class Family extends GenericEntity {
    public Family(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Family() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
  
    private String name;
    private String abbreviation;

    /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the abbreviation
	 */
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * @param abbreviation the abbreviation to set
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (getId()!= null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Family other = (Family) obj;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.abbreviation == null) ? (other.abbreviation != null) : !this.abbreviation.equals(other.abbreviation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FAMILY[id="+this.getId()+",name:"+this.name+"]";
    }

}
