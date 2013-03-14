package com.bazzar.base.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bazzar.base.dao.ItemBatchDao;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.menu.Product;

@Repository
public class ItemBatchDaoImpl implements ItemBatchDao {

	protected static Logger logger = Logger.getLogger("ItemDao");

	@Autowired
	private SessionFactory sessionFactory;

	public void batchInsert(List<Item> items, Product product) {
		Session session = sessionFactory.openSession();
		session.setCacheMode(CacheMode.IGNORE);
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			item.setCPD(new Date());
			item.setUPD(new Date());
			item.setParent(product);
			session.saveOrUpdate(item);
			if (i % 50 == 0) { // 50, same as the JDBC batch size
				// flush a batch of inserts and release memory:
				session.flush();
				session.clear();
			}
		}
		session.evict(product);
		product = null;
		tx.commit();
		session.close();
	}

}
