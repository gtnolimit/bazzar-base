package com.bazzar.base.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.CartDao;
import com.bazzar.base.domain.order.Cart;
import com.bazzar.base.domain.order.CartDetail;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

	protected static Logger logger = Logger.getLogger("CartDao");

	@Autowired
	private SessionFactory sessionFactory;

	public Long create(Cart cart) {
		return (Long) sessionFactory.getCurrentSession().save(cart);
	}

	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	public void delete(Long cartId) {
		delete(get(cartId));
	}

	public void delete(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
	}

	public Cart edit(Cart cart) {
		return (Cart) sessionFactory.getCurrentSession().merge(cart);
	}

	public Cart save(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return new Cart();
	}

	public Cart get(Long cartId) {
		return (Cart) sessionFactory.getCurrentSession()
		        .createQuery("FROM Cart c WHERE c.id = :cartId")
		        .setLong("cartId", cartId).uniqueResult();
	}

	public Cart findCartByCustomerId(Long customerId) {
		return (Cart) sessionFactory.getCurrentSession()
		        .createQuery("FROM Cart c WHERE c.customer_id = :customerId")
		        .setLong("customerId", customerId).uniqueResult();
	}

	public Cart findCartBySession(String session) {
		return (Cart) sessionFactory.getCurrentSession()
		        .createQuery("FROM Cart c WHERE c.sessionNumber = :session")
		        .setString("session", session).uniqueResult();
	}

	public Cart findCartByIp(String ip) {
		return (Cart) sessionFactory.getCurrentSession()
		        .createQuery("FROM Cart c WHERE c.ip = :ip")
		        .setString("ip", ip).uniqueResult();
	}

	public Cart findCartDetailBySessionAndItemId(String sessionNumber,
	        Long itemId) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "select cart FROM Cart cart " + "join cart.detail detail "
		                + "where cart.sessionNumber = :sessionNumber "
		                + "and detail.itemId = :itemId");
		q.setParameter("sessionNumber", sessionNumber).setParameter("itemId",
		        itemId);
		return (Cart) q.uniqueResult();
	}

	public CartDetail findCartDetailByItemId(Long id,
	        Long detailId) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "select detail FROM Cart cart " + "join cart.detail detail "
		                + "where cart.id = :id "
		                + "and detail.id = :detailId");
		q.setParameter("id", id).setParameter("detailId",
		        detailId);
		return (CartDetail) q.uniqueResult();
	}

	@Override
	public CartDetail findCartDetailByDetailId(Long detailId) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "select cartDetail FROM CartDetail cartDetail "
		                + "where cartDetail.id = :detailId ");
		q.setParameter("detailId", detailId);
		return (CartDetail) q.uniqueResult();
	}

	@Override
    public void saveOrUpdate(CartDetail cartDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartDetail);
    }

}
