package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "LOOKUP_STATUSTYPE")
public class StatusTypeLookup extends AbstractLookupType {

	public static final StatusTypeLookup A = createConstant("A", "Active", StatusTypeLookup.class);
    public static final StatusTypeLookup I = createConstant("I", "Inactive", StatusTypeLookup.class);
	
	 private static final long serialVersionUID = 3212625355790851086L;
	
	 	@Id
	    @Column(name="CODE")
	    @Override
	    public String getCode() {
	        return super.getCode();
	    }

	    @Column(name="DESCRIPTION")
	    @Override
	    public String getDescription() {
	        return super.getDescription();
	    }
}
