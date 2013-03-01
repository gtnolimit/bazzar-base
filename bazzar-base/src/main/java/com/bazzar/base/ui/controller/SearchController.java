package com.bazzar.base.ui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.bazzar.base.domain.item.Item;
import com.bazzar.base.services.impl.SearchServiceImpl;

@Controller
public class SearchController {
	
	@Autowired
	private SearchServiceImpl searchService_i;
	
	@Autowired
	private View jsonView_i;
	
	private static final String ITEMS_FIELD = "items";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping(value = { "/search/{parameter}" }, method = { RequestMethod.GET })
	public ModelAndView searchItems(@PathVariable("parameter") String parameter,
				   HttpServletResponse httpResponse_p) {
		List <Item> items = new ArrayList <Item> ();
		try {
			List <Item> items_Name = searchService_i.findItemsByName( parameter );
			if ( !isEmpty ( items_Name ) ) 
				items.addAll ( items_Name );
			List <Item> items_ManufactureNumber = searchService_i.findItemsByManufactureNumber( parameter );
			if ( !isEmpty ( items_ManufactureNumber ) ) 
				items.addAll ( items_ManufactureNumber );
			//List <Item> items_Manufacture = searchService_i.findItemsByManufacture( parameter );
			//if ( !isEmpty ( items_Manufacture ) ) 
			//	items.addAll ( items_Manufacture );
			List <Item> items_Description = searchService_i.findItemsByDescription( parameter );
			if ( !isEmpty ( items_Description ) ) 
				items.addAll ( items_Description );
			List <Item> items_BarCode = searchService_i.findItemsByBarCode( parameter );
			if ( !isEmpty ( items_BarCode ) ) 
				items.addAll ( items_BarCode );
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ITEMS_FIELD, items);
	}

	private boolean isEmpty ( List <Item> items ){
		return items.isEmpty();
	}
	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}


}
