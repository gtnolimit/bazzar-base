package com.bazzar.base.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.HomeDao;
import com.bazzar.base.domain.Home;

@Repository
@Transactional
public class HomeDaoImpl implements HomeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Long create ( Home home ) {
		return ( Long ) sessionFactory.getCurrentSession ().save ( home );
	}

	public void edit ( Home home ) {
		sessionFactory.getCurrentSession ().merge ( home );
	}

	public Home get ( Long homeId ) {
		System.out.println("insideHomeDao");
		return (Home) sessionFactory.getCurrentSession ( )
				.createQuery("FROM Home h WHERE h.id = :id")
				.setParameter("id", homeId).uniqueResult();
	}

}
