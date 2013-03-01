package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOKUP_CUSTOMERTYPE")
public class EntityTypeLookup extends AbstractLookupType {

	public static final EntityTypeLookup BUYER = createConstant("B", "BUYER", EntityTypeLookup.class);
	public static final EntityTypeLookup SELLER = createConstant("S", "SELLER",EntityTypeLookup.class);
	public static final EntityTypeLookup CONTACTPERSON = createConstant("CP", "CONTACTPERSON", EntityTypeLookup.class);
		
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
