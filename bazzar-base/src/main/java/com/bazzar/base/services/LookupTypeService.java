package com.bazzar.base.services;

import java.util.List;

import com.bazzar.base.domain.LookupType;

public interface LookupTypeService {

	   /**
     * @return A List of Class objects for the supported Reference Types. Note
     *         this list is not modifiable
     */
    public List<Class<? extends LookupType>> getLookupTypeClassList();

    /**
     * Returns a list of Lookup Types for the specified Lookup Type class
     * Generally utilized to set up Options in the UI.
     * 
     * @param <T>
     *            The Lookup Type Class.
     * @param referenceTypeClass
     *            The Lookup Type Class to retrieve the options list for.
     * @param addNullValue
     *            If <code>true</code> an empty (NULL) value is added to the top
     *            of the list. This value is treated as NULL in the system.
     * @return
     */
    public <T extends LookupType> List<T> getLookupTypeListOptions(
            Class<T> lookupTypeClass, boolean addNullValue);

    /**
     * Returns a ReferenceType instance that represents the empty/NULL type in
     * the system.
     * 
     * @param <T>
     * @param referenceTypeClass
     * @return
     */
    public <T extends LookupType> T getNullTypeOption(Class<T> lookupTypeClass);
    
    
    /**
     * Retrieves a Lookup type by its Code
     * @param <T>
     * @param code
     * @param lookupTypeClass
     * @return
     */
    public <T extends LookupType> T getLookupTypeByCode(String code, Class<T> lookupTypeClass);

}
