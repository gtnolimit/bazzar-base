package com.bazzar.base.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bazzar.base.dao.MenuDao;
import com.bazzar.base.domain.menu.Category;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.domain.menu.SubCategory;

@Repository
@Transactional
public class MenuDaoImpl implements MenuDao {
	protected static Logger logger = Logger.getLogger ( "MenuDao" );
	
	@Autowired
	private SessionFactory sessionFactory;
	  
	public Category getCategory ( Long id ){
		return ( Category ) sessionFactory.getCurrentSession ( ) .
				createQuery ( "FROM Category c WHERE c.id = :id" ).
				setParameter ( "id", id ).uniqueResult ( );
	}

	public SubCategory getSubCategory ( Long id ){
		return ( SubCategory ) sessionFactory.getCurrentSession ( ) .
				createQuery ( "FROM SubCategory sc WHERE sc.id = :id" ).
				setParameter ( "id", id ).uniqueResult ( );
	}
	
	public Product getProduct ( Long id ){
		return ( Product ) sessionFactory.getCurrentSession ( ) .
				createQuery ( "FROM Product p WHERE p.id = :productId" ).
				setParameter ( "productId", id ).uniqueResult ( );
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List <Category> getAllCategories ( ){
		logger.debug ( "Retrieving all Categories" );
        Query query = sessionFactory.getCurrentSession ().createQuery ( "FROM Category c" );
        return query.list ();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List <SubCategory> getAllSubCategories ( ){
		logger.debug ( "Retrieving all SubCategory" );
		return  (List<SubCategory>) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM SubCategory" ).list ( );
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List <Product> getAllProducts ( ){
		logger.debug ( "Retrieving all Product" );
		return  (List<Product>) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Product" ).list ( );
	}

	@SuppressWarnings("unchecked")
	public List <Product> findProductByName(String productName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.ilike ("attribute", productName +"%" ) );
		return criteria.list();
	}

	public void edit(Category category) {
		sessionFactory.getCurrentSession ( ).merge ( category );
	}

	public void edit(SubCategory subCategory) {
		sessionFactory.getCurrentSession ( ).merge ( subCategory );
	}
	
	public void edit ( Product product ) {
		sessionFactory.getCurrentSession ( ).merge ( product );
	}

	public Long add ( Category category ) {
		return ( Long ) sessionFactory.getCurrentSession ( ).save ( category );
	}

	public Long add ( SubCategory subCategory ) {
		return ( Long ) sessionFactory.getCurrentSession ( ).save ( subCategory );
	}

	public Long add ( Product product ) {
		return ( Long ) sessionFactory.getCurrentSession ( ).save ( product );
	}

	public void delete ( Category category ) {
		category.setActive( false );
		edit ( category );
	}

	public void delete ( SubCategory subCategory ) {
		subCategory.setActive( false );
		edit ( subCategory );
	}

	public void delete ( Product product ) {
		product.setActive( false );
		edit ( product );
	}

	public void deleteCategory(Long categoryId) {
		Category category = this.getCategory ( categoryId );
		category.setActive( false );
		edit ( category );
	}

	public void deleteSubCategory(Long subCategoryId) {
		SubCategory subCategory = this.getSubCategory ( subCategoryId );
		subCategory.setActive( false );
		edit ( subCategory );
	}

	public void deleteProduct(Long productId) {
		Product product = this.getProduct ( productId );
		product.setActive( false );
		edit ( product );
	}

	public Product getProductByAttribute(String attribute) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "FROM Product prd where prd.attribute = :attribute");
		q.setParameter("attribute", attribute);
		return (Product) q.uniqueResult();
	}

	public SubCategory getSubCategoryByAttribute(String attribute) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "FROM SubCategory sub where sub.attribute = :attribute");
		q.setParameter("attribute", attribute);
		return (SubCategory) q.uniqueResult();
	}

	public Category getCategoryByAttribute(String attribute) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "FROM Category cat where cat.attribute = :attribute");
		q.setParameter("attribute", attribute);
		return (Category) q.uniqueResult();
	}

	public SubCategory findSubCategoryChild(String category, String subCategory) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "select subCat FROM Category cat "
		                + "join cat.subCategory subCat "
		                + "where cat.attribute = :catName "
		                + "and subCat.attribute = :subCatName");
		q.setParameter("catName", category).setParameter("subCatName",
		        subCategory);
		return (SubCategory) q.uniqueResult();
	}

	public Product findProductChild(String category, String subCategory,
	        String product) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "select prd FROM Category cat "
		                + "join cat.subCategory subCat "
		                + "join subCat.product prd "
		                + "where cat.attribute = :catName "
		                + "and subCat.attribute = :subCatName "
		                + "and prd.attribute = :prdName");
		q.setParameter("catName", category)
		        .setParameter("subCatName", subCategory)
		        .setParameter("prdName", product);
		return (Product) q.uniqueResult();
	}

}
