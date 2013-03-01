package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOKUP_CREDITCARTTYPE")
public class CreditCardTypeLookup extends AbstractLookupType {

	public static final CreditCardTypeLookup VISA = createConstant("V", "Visa Card",  CreditCardTypeLookup.class);
	public static final CreditCardTypeLookup MASTERCARD = createConstant("MC", "Master Card", CreditCardTypeLookup.class);
	public static final CreditCardTypeLookup DISCOVER = createConstant("D", "Discover Card", CreditCardTypeLookup.class);
	public static final CreditCardTypeLookup AMERICANEXPRESS = createConstant("AX", "American Express Card", CreditCardTypeLookup.class);
    
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
