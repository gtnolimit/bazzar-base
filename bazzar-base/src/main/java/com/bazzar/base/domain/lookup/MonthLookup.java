package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOKUP_MONTH")
public class MonthLookup  extends AbstractLookupType  {

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final MonthLookup JAN = createConstant("JAN", "JANUARY", MonthLookup.class);
	public static final MonthLookup FEB = createConstant("FEB", "FEBRUARY", MonthLookup.class);
	public static final MonthLookup MAR = createConstant("MAR", "MARCH", MonthLookup.class);
	public static final MonthLookup APR = createConstant("APR", "APRIL", MonthLookup.class);
	public static final MonthLookup MAY = createConstant("MAY", "MAY", MonthLookup.class);
	public static final MonthLookup JUN = createConstant("JUN", "JUNE", MonthLookup.class);
	public static final MonthLookup JUL = createConstant("JUL", "JULY", MonthLookup.class);
	public static final MonthLookup AUG = createConstant("AUG", "AUGUST", MonthLookup.class);
	public static final MonthLookup SEP = createConstant("SEP", "SEPTEMBER", MonthLookup.class);
	public static final MonthLookup OCT = createConstant("OCT", "OCTOBER", MonthLookup.class);
	public static final MonthLookup NOV = createConstant("NOV", "NOVEMBER", MonthLookup.class);
	public static final MonthLookup DEC = createConstant("DEC", "DECEMPER", MonthLookup.class);

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
