package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOKUP_ORDERSTATUSTYPE")
public class OrderStatusLookup extends AbstractLookupType  {

private static final long serialVersionUID = 3212625355790851086L;
	
	public static final OrderStatusLookup CR = createConstant("CR", "CREATED", OrderStatusLookup.class);
	public static final OrderStatusLookup PK = createConstant("PK", "PACKED", OrderStatusLookup.class);
	public static final OrderStatusLookup SH = createConstant("SH", "SHIPPED", OrderStatusLookup.class);
	public static final OrderStatusLookup PR = createConstant("PR", "PROCESSED", OrderStatusLookup.class);
	public static final OrderStatusLookup PD = createConstant("PD", "PAID", OrderStatusLookup.class);
	
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
