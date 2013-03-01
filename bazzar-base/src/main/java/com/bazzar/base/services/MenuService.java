package com.bazzar.base.services;

import java.util.List;

import com.bazzar.base.domain.menu.Category;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.domain.menu.SubCategory;

public interface MenuService {

	public List <Category> getAllCategories ( );
	public List <SubCategory> getAllSubCategories ( );
	public List <Product> getAllProducts ( );
	
	public Category getCategory ( Long id );
	public SubCategory getSubCategory ( Long id );
	public Product getProduct ( Long id );
	
	public Long create ( Category category );
	public void update ( Category category );
	public void delete ( Category category );
	public void deleteCategoryById ( Long id );
	
	public Long create ( SubCategory subCategory );
	public void update ( SubCategory subCategory );
	public void delete ( SubCategory subCategory );
	public void deleteSubCategoryById ( Long id );
	
	public Long create ( Product product );
	public void update ( Product product );
	public void delete ( Product product );
	public void deleteProductById ( Long id );
	
	public List <Product> findProductByName ( String name );
}