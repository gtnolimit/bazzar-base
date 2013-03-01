package com.bazzar.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.SearchDao;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.menu.Product;

@Repository
@Transactional
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Item> findItemsByName ( String itemName ) {
		Query query = sessionFactory.getCurrentSession().
				createQuery("SELECT i FROM Item i WHERE i.subgect like :subgect").
				setParameter ( "subgect", "%" + itemName + "%" );
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findProductByName ( String productName ) {
		Query query = sessionFactory.getCurrentSession().
				createQuery("SELECT p FROM Product p WHERE p.attribute like :productName").
				setParameter ( "productName", "%" + productName + "%" );
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> findItemsByManufactureNumber(String manufactureNumber) {
		Query query = sessionFactory.getCurrentSession().
				createQuery("SELECT i FROM Item i WHERE i.manufactureModelNumber like :manufactureModelNumber").
				setString( "manufactureModelNumber", "%" + manufactureNumber + "%" );
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> findItemsByManufacture(String manufacture) {
		Query query = sessionFactory.getCurrentSession().
				createQuery("SELECT i FROM Item i WHERE i.manufacture like :manufacture").
				setString( "manufacture", "%" + manufacture + "%" );
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> findItemsByDescription(String description) {
		Query query = sessionFactory.getCurrentSession().
				createQuery("SELECT i FROM Item i WHERE i.description like :description").
				setString( "description", "%" + description + "%" );
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> findItemsByBarCode ( String barCode ) {
		Query query = sessionFactory.getCurrentSession().
				createQuery("SELECT i FROM Item i WHERE i.barCode like :barCode").
				setString( "barCode", "%" + barCode + "%" );
		return query.list();
	}
	

}
