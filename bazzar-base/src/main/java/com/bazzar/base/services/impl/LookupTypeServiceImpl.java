package com.bazzar.base.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Set;

//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
import javax.persistence.Entity;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
//import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.LookupTypeDao;
import com.bazzar.base.domain.LookupType;
import com.bazzar.base.domain.lookup.AbstractLookupType;
import com.bazzar.base.domain.lookup.LookupTypeManager;
import com.bazzar.base.services.LookupTypeService;


/**
 * Implements the Reference Type Service for retrieving Reference Options.
 */
@Service("lookupTypeService")
public class LookupTypeServiceImpl extends LookupTypeManager implements LookupTypeService {
    static final Logger logger = Logger.getLogger(LookupTypeServiceImpl.class);

    @Autowired
    LookupTypeDao lookupTypeDao;

    //@Resource
    //List<String> lookupTypeDomainSearchClassPaths;

    List<Class<? extends LookupType>> lookupTypeClassList = new ArrayList<Class<? extends LookupType>>();

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.hsc.fulfillment.service.ReferenceTypeService#getReferenceTypeClassList
     * ()
     */
    public List<Class<? extends LookupType>> getLookupTypeClassList() {
        return Collections.unmodifiableList(lookupTypeClassList);
    }

    /**
     * Scans the Class paths to locate Reference type classes and
     * initialize/load them
     
    @SuppressWarnings("unchecked")
    @PostConstruct
    void initializeLookupTypeClasses() {        
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
                false);
        provider.addIncludeFilter(new AssignableTypeFilter(LookupType.class));

        for (String basePackage : lookupTypeDomainSearchClassPaths) {
            basePackage = basePackage.replaceAll("\\.", "/"); // Convert from
            // dot notation to
            // path notation

            // Find Reference Type Classes. Note: This does not return Abstract
            // Classes or Interfaces so no need to filter them out
            Set<BeanDefinition> components = provider
                    .findCandidateComponents(basePackage);

            for (BeanDefinition component : components) {
                String refClassName = component.getBeanClassName();
                try {
                    Class<? extends LookupType> refTypeClass = (Class<? extends LookupType>) Class
                            .forName(refClassName);

                    if (logger.isDebugEnabled()) {
                        logger.debug("Found Lookup Type: "
                                + refTypeClass.getName());
                    }
                    lookupTypeClassList.add(refTypeClass);

                } catch (Exception e) {
                    // This should not occur in deployed runtime, should be
                    // caught and handled during development since it is
                    // generally
                    // a Code/Compilation phase issue
                    throw new RuntimeException(
                            "Exception on Processing Lookup Class Type: "
                                    + refClassName, e);
                }
            }
        }

        // Pre-load the Reference Classes, this merges them in from the database
        // So constants are updated with Descriptions etc.
        for (Class<? extends LookupType> refType : lookupTypeClassList) {
            getLookupTypeListOptions(refType, false);
        }
    }
     */
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.hsc.fulfillment.service.ReferenceTypeService#getReferenceTypeListOptions
     * (java.lang.Class, boolean)
     * 
     * Retrieves the Reference Type List. Also adds an Empty item if needed.
     * Registers the Reference Type list into the ReferenceTypeManager.
     */
    public <T extends LookupType> List<T> getLookupTypeListOptions(
            Class<T> lookupTypeClass, boolean addNullValue) {

        List<T> typeList = null;

        if (lookupTypeClass.getAnnotation(Entity.class) != null) {
            // This is a Database based reference Type, get the list from the DB
            typeList = lookupTypeDao.findReferenceTypes(lookupTypeClass);
        } else {
            typeList = getNonPersistedLookupTypeListOptions(lookupTypeClass);
        }

        // Register the Reference Types
        for (T lookupType : typeList) {
            LookupTypeManager.addToCache(lookupType);
        }

        if (addNullValue) {
            typeList.add(0, getNullTypeOption(lookupTypeClass));
        }

        return typeList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.hsc.fulfillment.service.ReferenceTypeService#getNullTypeOption(java
     * .lang.Class)
     */
    public <T extends LookupType> T getNullTypeOption(Class<T> lookupTypeClass) {

        // If there is a cached NULL type, return it.
        T retVal = LookupTypeManager.getFromCacheByCode("", lookupTypeClass);

        if (retVal != null) {
            return retVal;
        }

        return createConstant("", "", lookupTypeClass);
    }

    /**
     * This prepares Lookup Types Lists that are not Persisted.
     * 
     * @param <T>
     * @param referenceTypeClass
     * @param addNullValue
     * @return
     */
    <T extends LookupType> List<T> getNonPersistedLookupTypeListOptions(
            Class<T> referenceTypeClass) {
        
        // If this is a subclass of AbstractLookupType, return the Constants
        // Defined in the class type, in the order they are defined.
        // TODO, Deal with Deprecation when Lookups start supporting this concept
        if(AbstractLookupType.class.isAssignableFrom(referenceTypeClass)) {
            List<T> constants = AbstractLookupType.getConstants(referenceTypeClass);
            return constants;
        }
        

        // TODO Get the list from a registry of Lookup Types
        throw new RuntimeException("Lookup Type Not Available: "
                + referenceTypeClass.getName());

        // return typeList;
    }

    /* (non-Javadoc)
     * @see com.hsc.vantage.service.LookupTypeService#getLookupTypeByCode(java.lang.String, java.lang.Class)
     */
    public <T extends LookupType> T getLookupTypeByCode(String code,
            Class<T> lookupTypeClass) {
        
        return getFromCacheByCode(code, lookupTypeClass);
    }
    
}
