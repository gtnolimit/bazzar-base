package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOKUP_STATETYPE")
public class StateTypeLookup extends AbstractLookupType {

	public static final StateTypeLookup AL = createConstant("AL", "Alabama", StateTypeLookup.class); 	 	
	public static final StateTypeLookup AK = createConstant("AK", "Alaska", StateTypeLookup.class); 		 	
	public static final StateTypeLookup AZ = createConstant("AZ", "Arizona", StateTypeLookup.class); 	 	
	public static final StateTypeLookup AR = createConstant("AR", "Arkansas", StateTypeLookup.class); 	 	
	public static final StateTypeLookup CA = createConstant("CA", "California", StateTypeLookup.class);	 	
	public static final StateTypeLookup CO = createConstant("CO", "Colorado", StateTypeLookup.class); 	 	
	public static final StateTypeLookup CT = createConstant("CT", "Connecticut", StateTypeLookup.class); 	 	
	public static final StateTypeLookup DE = createConstant("DE", "Delaware", StateTypeLookup.class); 	 	
	public static final StateTypeLookup FL = createConstant("FL", "Florida", StateTypeLookup.class); 	 	
	public static final StateTypeLookup GA = createConstant("GA", " Georgia", StateTypeLookup.class); 	 	
	public static final StateTypeLookup HI = createConstant("HI", "Hawaii", StateTypeLookup.class); 		 	
	public static final StateTypeLookup ID = createConstant("ID", "Idaho", StateTypeLookup.class); 		 	
	public static final StateTypeLookup IL = createConstant("IL", "Illinois", StateTypeLookup.class); 	 	
	public static final StateTypeLookup IN = createConstant("IN", "Indiana", StateTypeLookup.class); 	 	
	public static final StateTypeLookup IA = createConstant("IA", "Iowa", StateTypeLookup.class); 		 	
	public static final StateTypeLookup KS = createConstant("KS", "Kansas", StateTypeLookup.class); 		 	
	public static final StateTypeLookup KY = createConstant("KY", "Kentucky", StateTypeLookup.class); 	 	
	public static final StateTypeLookup LA = createConstant("LA", "Louisiana", StateTypeLookup.class);	 	
	public static final StateTypeLookup ME = createConstant("ME", "Maine", StateTypeLookup.class);		 	
	public static final StateTypeLookup MD = createConstant("MD", "Maryland", StateTypeLookup.class);	 	
	public static final StateTypeLookup MA = createConstant("MA", "Massachusetts", StateTypeLookup.class); 	 	
	public static final StateTypeLookup MI = createConstant("MI", "Michigan", StateTypeLookup.class); 	 	
	public static final StateTypeLookup MN = createConstant("MN", "Minnesota", StateTypeLookup.class); 	 	
	public static final StateTypeLookup MS = createConstant("MS", "Mississippi", StateTypeLookup.class); 	 	
	public static final StateTypeLookup MO = createConstant("MO", "Missouri", StateTypeLookup.class); 	 	
	public static final StateTypeLookup MT = createConstant("MT", "Montana", StateTypeLookup.class);	
	public static final StateTypeLookup NE = createConstant("NE", "Nebraska", StateTypeLookup.class); 	
	public static final StateTypeLookup NV = createConstant("NV", "Nevada", StateTypeLookup.class); 		
	public static final StateTypeLookup NH = createConstant("NH", "New Hampshire", StateTypeLookup.class); 	
	public static final StateTypeLookup NJ = createConstant("NJ", "New Jersey", StateTypeLookup.class);	
	public static final StateTypeLookup NM = createConstant("NM", "New Mexico", StateTypeLookup.class); 	
	public static final StateTypeLookup NY = createConstant("NY", "New York", StateTypeLookup.class); 	
	public static final StateTypeLookup NC = createConstant("NC", "North Carolina", StateTypeLookup.class); 	
	public static final StateTypeLookup ND = createConstant("ND", "North Dakota", StateTypeLookup.class); 	
	public static final StateTypeLookup OH = createConstant("OH", "Ohio", StateTypeLookup.class); 		
	public static final StateTypeLookup OK = createConstant("OK", "Oklahoma", StateTypeLookup.class); 	
	public static final StateTypeLookup OR = createConstant("OR", "Oregon", StateTypeLookup.class); 		
	public static final StateTypeLookup PA = createConstant("PA", "Pennsylvania", StateTypeLookup.class); 	
	public static final StateTypeLookup RI = createConstant("RI", "Rhode Island", StateTypeLookup.class); 	
	public static final StateTypeLookup SC = createConstant("SC", "South Carolina", StateTypeLookup.class); 	
	public static final StateTypeLookup SD = createConstant("SD", "South Dakota", StateTypeLookup.class); 	
	public static final StateTypeLookup TN = createConstant("TN", "Tennessee", StateTypeLookup.class); 	
	public static final StateTypeLookup TX = createConstant("TX", "Texas", StateTypeLookup.class); 		
	public static final StateTypeLookup UT = createConstant("UT", "Utah", StateTypeLookup.class); 		
	public static final StateTypeLookup VT = createConstant("VT", "Vermont", StateTypeLookup.class); 	
	public static final StateTypeLookup VA = createConstant("VA", "Virginia", StateTypeLookup.class); 	
	public static final StateTypeLookup WA = createConstant("WA", "Washington", StateTypeLookup.class);	
	public static final StateTypeLookup WV = createConstant("WV", "West Virginia", StateTypeLookup.class); 	
	public static final StateTypeLookup WI = createConstant("WI", "Wisconsin", StateTypeLookup.class); 	
	public static final StateTypeLookup WY = createConstant("WY", "Wyoming", StateTypeLookup.class);	
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
