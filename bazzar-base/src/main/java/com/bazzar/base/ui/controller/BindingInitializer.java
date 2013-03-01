package com.bazzar.base.ui.controller;

//import java.util.List;

//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

//import com.bazzar.base.domain.lookup.LookupType;
//import com.bazzar.base.service.impl.LookupTypeServiceImpl;
//import com.bazzar.base.ui.LookupTypeEditor;


public class BindingInitializer implements WebBindingInitializer {

	public void initBinder(WebDataBinder arg0, WebRequest arg1) {
		// TODO Auto-generated method stub
		
	}

    /**
     * Service to provide reference types
     */
  //  @Resource
   // LookupTypeServiceImpl lookupTypeService;

    /**
     * List of Reference Type Editors to be bound
     */
  //  LookupTypeEditor[] lookupTypeEditors;

    /**
     * Build a list of Reference Type Editors. These are thread safe, so okay to
     * create once and add to the binders on demand
     */
  //  @PostConstruct
  //  void initLookupTypeEditors() {

  //      List<Class<? extends LookupType>> lookupTypeClasses = lookupTypeService
  //              .getLookupTypeClassList();

   //     lookupTypeEditors = new LookupTypeEditor[lookupTypeClasses.size()];
   //     for (int iLoop = 0; iLoop < lookupTypeClasses.size(); iLoop++) {
   //         lookupTypeEditors[iLoop] = new LookupTypeEditor(lookupTypeClasses
   //                 .get(iLoop), lookupTypeService);
  //      }

//    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.bind.support.WebBindingInitializer#initBinder
     * (org.springframework.web.bind.WebDataBinder,
     * org.springframework.web.context.request.WebRequest)
     */
  //  public final void initBinder(WebDataBinder binder, WebRequest request) {
        // Insert the Common Binding Editors
  //      for (LookupTypeEditor editor : lookupTypeEditors) {
  //          binder.registerCustomEditor(editor.getSpecificType(), editor);
  //      }
  //  }
}

