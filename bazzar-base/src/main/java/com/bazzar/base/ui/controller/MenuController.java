package com.bazzar.base.ui.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.bazzar.base.domain.menu.Category;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.domain.menu.SubCategory;
import com.bazzar.base.services.impl.MenuServiceImpl;

@Controller
public class MenuController {
	
	@Autowired
	private MenuServiceImpl menuService_i;
	
	@Autowired
	private View jsonView_i;
	
	private static final String CATEGORY_FIELD = "category";
	private static final String SUBCATEGORY_FIELD = "subcategory";
	private static final String PRODUCT_FIELD = "product";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping ( value = "/menu/category/{categoryId}", method = RequestMethod.GET )
	public ModelAndView getCategory ( @PathVariable ( "categoryId" ) String categoryId ) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong ( categoryId );
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, CATEGORY_FIELD, menuService_i.getCategory ( _id ) );
	}
	@RequestMapping ( value = "/menu/subCategory/{subCategoryId}", method = RequestMethod.GET )
	public ModelAndView getSubCategory ( @PathVariable ( "subCategoryId" ) String subCategoryId ) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong ( subCategoryId );
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, SUBCATEGORY_FIELD, menuService_i.getSubCategory ( _id ) );
	}
	@RequestMapping ( value = "/menu/product/{productId}", method = RequestMethod.GET )
	public ModelAndView getProduct ( @PathVariable ( "productId" ) String productId ) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong ( productId );
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, PRODUCT_FIELD, menuService_i.getProduct ( _id ) );
	}
	@RequestMapping(value = "/menu/category/", method = RequestMethod.GET)
	public ModelAndView getCategories() {
		return new ModelAndView(jsonView_i, CATEGORY_FIELD, menuService_i.getAllCategories());
	}
	@RequestMapping(value = "/menu/subCategor/", method = RequestMethod.GET)
	public ModelAndView getSubCategories() {
		return new ModelAndView(jsonView_i, SUBCATEGORY_FIELD, menuService_i.getAllSubCategories());
	}
	@RequestMapping(value = "/menu/product/", method = RequestMethod.GET)
	public ModelAndView getProducts() {
			return new ModelAndView(jsonView_i, PRODUCT_FIELD, menuService_i.getAllProducts());
	}
	@RequestMapping(value = { "/menu/category/" }, method = { RequestMethod.POST })
	public ModelAndView createCategory(@RequestBody Category category_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createCategoryId;
		try {
			createCategoryId = menuService_i.create ( category_p );
			category_p.setId( createCategoryId );
		} catch (Exception e) {
			String sMessage = "Error creating new category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("caregory", request_p.getContextPath() + "/menu/category/" + createCategoryId);
		return new ModelAndView(jsonView_i, CATEGORY_FIELD, category_p );
	}
	@RequestMapping(value = { "/menu/subCategory/" }, method = { RequestMethod.POST })
	public ModelAndView createSubCategory(@RequestBody SubCategory subCategory_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createSubCategoryId;
		try {
			createSubCategoryId = menuService_i.create ( subCategory_p );
			subCategory_p.setId( createSubCategoryId );
		} catch (Exception e) {
			String sMessage = "Error creating new subcategory. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("subCaregory", request_p.getContextPath() + "/menu/category/" + createSubCategoryId);
		return new ModelAndView(jsonView_i, SUBCATEGORY_FIELD, subCategory_p );
	}
	@RequestMapping(value = { "/menu/product/" }, method = { RequestMethod.POST })
	public ModelAndView createProduct(@RequestBody Product product_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createProductId;
		try {
			createProductId = menuService_i.create ( product_p );
			product_p.setId( createProductId );
		} catch (Exception e) {
			String sMessage = "Error creating new subcategory. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("product", request_p.getContextPath() + "/menu/product/" + createProductId);
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, product_p );
	}
	@RequestMapping(value = { "/menu/category/{categoryId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateCategory(@RequestBody Category category_p, @PathVariable("categoryId") String categoryId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			menuService_i.update(category_p);
		} catch (Exception e) {
			String sMessage = "Error updating category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CATEGORY_FIELD, null);
	}
	@RequestMapping(value = { "/menu/subCategory/{subCategoryId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateSubCategory(@RequestBody SubCategory subCategory_p, @PathVariable("subCategoryId") String subCategoryId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			menuService_i.update(subCategory_p);
		} catch (Exception e) {
			String sMessage = "Error updating subcategory. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, SUBCATEGORY_FIELD, null);
	}	
	@RequestMapping(value = { "/menu/product/{productId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateProduct(@RequestBody Product product_p, @PathVariable("productId") String productId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			menuService_i.update(product_p);
		} catch (Exception e) {
			String sMessage = "Error updating subcategory. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, null);
	}
	@RequestMapping(value = { "/menu/find/product/{productName}" }, method = { RequestMethod.GET })
	public ModelAndView findProductByName(@PathVariable("productName") String productName,
				   HttpServletResponse httpResponse_p) {
		List <Product> productList;
		try {
			productList = menuService_i.findProductByName(productName);
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, productList);
	}
	@RequestMapping(value = { "/menu/find/product/id/{productId}" }, method = { RequestMethod.GET })
	public ModelAndView findProductById(@PathVariable("productId") String productId,
				   HttpServletResponse httpResponse_p) {
		Product product;
		try {
			Long id = Long.parseLong(productId);
			product = menuService_i.getProduct( id );
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, product);
	}
	@RequestMapping(value = "/menu/category/{categoryId}", method = RequestMethod.DELETE)
	public ModelAndView removeCategory(@PathVariable("categoryId") String categoryId_p,
								   HttpServletResponse httpResponse_p) {

		try {
			Long id = Long.parseLong(categoryId_p);
			menuService_i.deleteCategoryById( id);
		} catch (Exception e) {
			String sMessage = "Error invoking getFunds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CATEGORY_FIELD, null);
	}	
	@RequestMapping(value = "/menu/subCategory/{subCategoryId}", method = RequestMethod.DELETE)
	public ModelAndView removeSubCategory(@PathVariable("subCategoryId") String subCategoryId_p,
								   HttpServletResponse httpResponse_p) {

		try {
			Long id = Long.parseLong(subCategoryId_p);
			menuService_i.deleteSubCategoryById( id);
		} catch (Exception e) {
			String sMessage = "Error invoking getFunds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, SUBCATEGORY_FIELD, null);
	}	
	@RequestMapping(value = "/menu/product/{productId}", method = RequestMethod.DELETE)
	public ModelAndView removeProduct(@PathVariable("productId") String productId_p,
								   HttpServletResponse httpResponse_p) {

		try {
			Long id = Long.parseLong(productId_p);
			menuService_i.deleteProductById( id);
		} catch (Exception e) {
			String sMessage = "Error invoking getFunds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, null);
	}

	public void setJsonView(View view) {
		jsonView_i = view;
	}
	
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}

}
