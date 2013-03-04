package com.bazzar.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.ShippingDao;
import com.bazzar.base.domain.order.Shipping;

@Repository
@Transactional
public class ShippingDaoImpl implements ShippingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List <Shipping> get() {
		Query query = sessionFactory.getCurrentSession ().createQuery ( "FROM Shipping s" );
        return query.list ();
	}

	public Shipping get(Long id) {
		return (Shipping) sessionFactory.getCurrentSession ( )
				.createQuery("FROM Shipping i WHERE i.id = :id")
				.setParameter("id", id).uniqueResult();
	}

	public void update(Shipping shipping) {
		sessionFactory.getCurrentSession ( ).merge ( shipping );
	}

	public Long add(Shipping shipping) {
		return ( Long ) sessionFactory.getCurrentSession ( ).save ( shipping );
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
