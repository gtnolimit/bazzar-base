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

import com.bazzar.base.dao.redis.ItemRepository;
import com.bazzar.base.services.ItemService;

@Controller
public class ImportItemsController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private View jsonView_i;

	@Autowired
	private ItemRepository itemRepository;

	private static final String JOB_FIELD = "job";
	private static final String ERROR_FIELD = "error";

	@RequestMapping(value = { "/item/import/job" }, method = { RequestMethod.POST })
	public ModelAndView importItems(@RequestBody String json,
	        HttpServletResponse httpResponse_p, WebRequest request_p) {
		Long jobId = null;
		try {
			jobId = itemService.importItems(itemService
			        .validateImportItemRequest(json));
		} catch (Exception e) {
			String sMessage = "Error importing items. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, JOB_FIELD,
		        itemRepository.getJob(jobId));
	}

	@RequestMapping(value = { "/item/import/jobStatus/{jobId}" }, method = { RequestMethod.GET })
	public ModelAndView importItemsStatus(@PathVariable("jobId") Long jobId,
	        HttpServletResponse httpResponse_p) {
		return new ModelAndView(jsonView_i, JOB_FIELD,
		        itemRepository.getJob(jobId));
	}

	public void setJsonView(View view) {
		jsonView_i = view;
	}

	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}

}
