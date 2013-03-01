package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOCUP_CUSTOMERTYPE")
public class CustomerTypeLookup extends AbstractLookupType {

	public static final CustomerTypeLookup BUYER = createConstant("B", "BUYER", CustomerTypeLookup.class);
	public static final CustomerTypeLookup SELLER = createConstant("S", "SELLER",CustomerTypeLookup.class);
	public static final CustomerTypeLookup CONTACTPERSON = createConstant("CP", "CONTACTPERSON", CustomerTypeLookup.class);
		
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
