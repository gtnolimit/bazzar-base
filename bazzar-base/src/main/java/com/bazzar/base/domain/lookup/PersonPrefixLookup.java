package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOKUP_PERSONPREFIX")
public class PersonPrefixLookup  extends AbstractLookupType{

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final PersonPrefixLookup MR = createConstant("MR", "MR", PersonPrefixLookup.class);
	public static final PersonPrefixLookup MRS = createConstant("MRS", "MRS", PersonPrefixLookup.class);
	public static final PersonPrefixLookup MISS = createConstant("MISS", "MISS", PersonPrefixLookup.class);
	public static final PersonPrefixLookup MS = createConstant("MS", "MS", PersonPrefixLookup.class);
	
	
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
