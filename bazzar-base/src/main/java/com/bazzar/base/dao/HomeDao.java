package com.bazzar.base.dao;

import com.bazzar.base.domain.Home;

public interface HomeDao {

	public Long create ( Home home );
	public void edit ( Home home );
	public Home get ( Long homeId );
}
