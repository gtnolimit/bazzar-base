package com.bazzar.base.ui.controller;

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

import com.bazzar.base.domain.item.Item;
import com.bazzar.base.services.impl.ItemServiceImpl;

@Controller
public class ItemController {

	@Autowired
	private ItemServiceImpl itemService_i;
	
	@Autowired
	private View jsonView_i;
	
	private static final String ITEM_FIELD = "item";
	private static final String ITEMS_FIELD = "items";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping(value = "/item/", method = RequestMethod.GET)
	public ModelAndView getItems() {
		return new ModelAndView(jsonView_i, ITEMS_FIELD, itemService_i.getAllItems());
	}
	
	@RequestMapping ( value = "/item/{itemId}", method = RequestMethod.GET )
	public ModelAndView getItem ( @PathVariable ( "itemId" ) String itemId ) {
		Long _id = (long) 0;
		Item item = null;
		try {
			/*
			String id = null; String user = null; String pass = null;
			StringTokenizer st = new StringTokenizer(itemId, "&"); 
			while(st.hasMoreTokens()) { 
				String word = st.nextToken();
				StringTokenizer object = new StringTokenizer ( word, "=");
				while (object.hasMoreTokens()){
					String parameter = object.nextToken();
					if (parameter.equals("id"))
						id = object.nextToken();
					else if (parameter.equals("user"))
						user = object.nextToken();
					else if (parameter.equals("pass"))
						pass = object.nextToken();
				}
			}
			System.out.println(" id : " + id + " - user : " + user + " - pass : " + pass);
			*/
			System.out.println("looking for item : " + itemId);
			_id = Long.parseLong ( itemId );
			item = itemService_i.getItem ( _id );
			System.out.println(" Item found : " + item.getSubgect());
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, ITEM_FIELD, item );
	}

	@RequestMapping ( value = "/itemQuestions/{itemId}", method = RequestMethod.GET )
	public ModelAndView getItemQuestions ( @PathVariable ( "itemId" ) String itemId ) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong ( itemId );
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, ITEM_FIELD, itemService_i.getItemQuestions ( _id ) );
	}
	
	@RequestMapping ( value = "/itemReviews/{itemId}", method = RequestMethod.GET )
	public ModelAndView getItemReviews ( @PathVariable ( "itemId" ) String itemId ) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong ( itemId );
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, ITEM_FIELD, itemService_i.getItemReviews ( _id ) );
	}
	
	@RequestMapping ( value = "/itemAccessories/{itemId}", method = RequestMethod.GET )
	public ModelAndView getItemAccessories ( @PathVariable ( "itemId" ) String itemId ) {
		Long _id = (long) 0;
		try {
			_id = Long.parseLong ( itemId );
		} catch (Exception e) {
			String sMessage = "Error converting ID into numeric value";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		return new ModelAndView ( jsonView_i, ITEM_FIELD, itemService_i.getItemAccessories ( _id ) );
	}
	
	@RequestMapping(value = { "/item/" }, method = { RequestMethod.POST })
	public ModelAndView createItem(@RequestBody Item item_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createItemId;
		try {
			createItemId = (long) itemService_i.addItem ( item_p );
			item_p.setId( createItemId );
		} catch (Exception e) {
			String sMessage = "Error creating new category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("item", request_p.getContextPath() + "/item/" + createItemId);
		return new ModelAndView(jsonView_i, ITEM_FIELD, item_p );
	}

	@RequestMapping(value = { "/item/{itemId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateItem(@RequestBody Item item_p, @PathVariable("itemId") String itemId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			itemService_i.editItem(item_p);
		} catch (Exception e) {
			String sMessage = "Error updating category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ITEM_FIELD, null);
	}

	@RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
	public ModelAndView removeItem(@PathVariable("itemId") String itemId_p,
								   HttpServletResponse httpResponse_p) {

		try {
			Long id = Long.parseLong(itemId_p);
			itemService_i.delete( id);
		} catch (Exception e) {
			String sMessage = "Error invoking getFunds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ITEM_FIELD, null);
	}	

	public void setJsonView(View view) {
		jsonView_i = view;
	}
	
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}

}
