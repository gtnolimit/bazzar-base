package com.bazzar.base.services;

import com.bazzar.base.domain.Home;

public interface HomeService {
	
	public Long create ( Home home );
	public void edit ( Home home );
	public Home get ( Long id );

}
