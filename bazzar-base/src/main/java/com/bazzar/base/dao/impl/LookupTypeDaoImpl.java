package com.bazzar.base.dao.impl;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
//import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.LookupTypeDao;
import com.bazzar.base.domain.LookupType;

//@Repository("lookupTypeDao")
@Repository
@Transactional
public class LookupTypeDaoImpl implements LookupTypeDao {

	static final Logger logger = Logger.getLogger(LookupTypeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public <T extends LookupType> List<T> findReferenceTypes(Class<T> type) {
        String entityName = type.getName();

        if(logger.isDebugEnabled()) {
            logger.debug("Retrieving Lookup Types for Entity: " + entityName);
        }

        Query q = (Query) sessionFactory.getCurrentSession().createQuery("from " + entityName);
        return ((Criteria) q).list();
    }

}
