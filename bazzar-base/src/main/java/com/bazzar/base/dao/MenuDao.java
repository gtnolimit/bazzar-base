package com.bazzar.base.dao;

import java.util.List;

import com.bazzar.base.domain.menu.Category;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.domain.menu.SubCategory;

public interface MenuDao {

	public Category getCategory ( Long id );
	public SubCategory getSubCategory ( Long id );
	public Product getProduct ( Long id );
	
	public List <Category> getAllCategories ();
	public List <SubCategory> getAllSubCategories ();
	public List <Product> getAllProducts ();
	
	public List <Product> findProductByName ( String productName );
	
	public void edit ( Category category );
	public void edit ( SubCategory subCategory );
	public void edit ( Product product );
	
	public Long add ( Category category );
	public Long add ( SubCategory subCategory );
	public Long add ( Product product );
	
	public void delete ( Category category );
	public void delete ( SubCategory subCategory );
	public void delete ( Product product );
	
	public void deleteCategory ( Long categoryId );
	public void deleteSubCategory ( Long subCategoryId );
	public void deleteProduct ( Long productId );
}
