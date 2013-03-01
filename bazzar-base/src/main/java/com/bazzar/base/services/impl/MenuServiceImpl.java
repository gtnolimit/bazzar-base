package com.bazzar.base.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.MenuDao;
import com.bazzar.base.domain.menu.Category;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.domain.menu.SubCategory;
import com.bazzar.base.services.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenuDao menuDao;
	
	public List <Category> getAllCategories ( ){
		return menuDao.getAllCategories ( );
	}
	
	public List <SubCategory> getAllSubCategories ( ){
		return menuDao.getAllSubCategories ( );
	}
	public List <Product> getAllProducts ( ){
		return menuDao.getAllProducts ( );
	}

	public Category getCategory ( Long id ){
		return menuDao.getCategory ( id ); 
	}

	public SubCategory getSubCategory ( Long id ){
		return menuDao.getSubCategory ( id ); 
	}
	public Product getProduct ( Long id ){
		return menuDao.getProduct ( id );
	}

	public Long create(Category category) {
		category.setActive( true );
		category.setCPD( new Date () );
		category.setUPD( new Date () );
		return menuDao.add( category );
	}
	public void update ( Category category ) {
		category.setActive( true );
		category.setUPD( new Date () );
		menuDao.edit ( category );
	}
	public void delete ( Category category ) {
		menuDao.delete ( category );
	}
	public void deleteCategoryById(Long id) {
		menuDao.deleteCategory ( id );
	}
	
	public Long create(SubCategory subCategory) {
		subCategory.setActive( true );
		subCategory.setCPD( new Date () );
		subCategory.setUPD( new Date () );
		return menuDao.add(subCategory);
	}
	public void update(SubCategory subCategory) {
		subCategory.setActive( true );
		subCategory.setUPD( new Date () );
		menuDao.edit(subCategory);
	}
	public void delete(SubCategory subCategory) {
		menuDao.delete(subCategory);
	}
	public void deleteSubCategoryById(Long id) {
		menuDao.deleteSubCategory(id);
	}
	public Long create(Product product) {
		product.setActive( true );
		product.setCPD( new Date () );
		product.setUPD( new Date () );
		return menuDao.add(product);
	}
	public void update(Product product) {
		product.setActive( true );
		product.setUPD( new Date () );
		menuDao.edit(product);
	}
	public void delete(Product product) {
		menuDao.delete(product);
	}
	public void deleteProductById(Long id) {
		menuDao.deleteProduct(id);
	}
	public List <Product> findProductByName ( String name ){
		return menuDao.findProductByName(name);
	}
	
}
