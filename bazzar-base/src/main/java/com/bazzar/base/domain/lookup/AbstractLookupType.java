package com.bazzar.base.domain.lookup;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bazzar.base.domain.LookupType;

public abstract class AbstractLookupType implements LookupType, Serializable {
   private static final long serialVersionUID = -7509811352454828732L;

	    long id = -1;

	    String code;
	    
	    String name;

	    String description;

	    int sequenceNumber = 0;

	    Date startDate;
	    
	    Date endDate;
	    
	    Boolean status;
	    
	    public AbstractLookupType() {
	    }
	    
	    public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean active) {
			this.status = active;
		}
	    public long getId() {
	        return id;
	    }
	    public void setId(long id) {
	        this.id = id;
	    }
	    public String getCode() {
	        return code;
	    }
	    public void setCode(String code) {
	        this.code = code;
	    }
	    public String getName() {
	        if(name == null) {
	            return getCode();
	        }
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getDescription() {
	        if(description == null) {
	            return getName();
	        }
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }
	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (this == obj) {
	            return true;
	        }

	        if (obj instanceof String) {
	            if (equalsString((String) obj)) {
	                return true;
	            }
	        } 
	        else if (obj instanceof Long) {
	            if (equalsLong ((Long) obj)) {
	                return true;
	            }
	        } 
	        else if (code != null && this.getClass().isAssignableFrom(obj.getClass())) {
	            return code.equals(((LookupType) obj).getCode());
	        }

	        return super.equals(obj);
	    }

	    /**
	     * Checks the string against the code. If it doesn't match checks to see if
	     * the string is just a string representation of the id.
	     * 
	     * @param val
	     * @return
	     */
	    boolean equalsString(String val) {
	        // Check the code
	        if (code != null && code.equals(val)) {
	            return true;
	        }

	        try {
	            // If numeric, check the Id
	            long idVal = Long.parseLong(val);

	            if (id == idVal) {
	                return true;
	            }
	        } catch (Exception e) {
	        }

	        return false;
	    }

	    /**
	     * Checks the Integer to see if its a numeric representation of the code. If
	     * it doesn't match, checks to see if its the id
	     * 
	     * @param val
	     * @return
	     */
	    boolean equalsLong(Long val) {
	        if (code != null && code.equals(val.toString())) {
	            return true;
	        }

	        return id == val.longValue();
	    }

	    /*
	     * (non-Javadoc)
	     * 
	     * @see java.lang.Object#toString() Returns Code or Code:Description
	     */
	    @Override
	    public String toString() {
	        if (name == null) {
	            return code;
	        } 
	        else if (code.equals(name)) {
	            return code;
	        }

	        return code + ":" + getName();
	    }
	    
	    
	    /* (non-Javadoc)
	     * @see java.lang.Object#hashCode()
	     * Override to utilize the Hashcode of the Code Field
	     */
	    @Override
	    public int hashCode() {
	        return this.getCode().hashCode();
	    }
	    
	    
	    /**
	     * Returns all the Constants defined for the Specified LookupType Type. 
	     * Provides similar functionality to the enumeration values() methods.
	     * @param <T>
	     * @param referenceType
	     * @return
	     */
	    @SuppressWarnings("unchecked")
	    public static <T extends LookupType> List<T> getConstants(Class<T> referenceType) {
	        List<T> referenceConstants = new ArrayList<T>();
	        Field[] fields = referenceType.getDeclaredFields();
	        
	        for(Field field: fields) {
	            if(field.getDeclaringClass().equals(referenceType) && Modifier.isStatic(field.getModifiers())) {
	                try {
	                    T constant = (T) field.get(null);
	                    
	                    if(constant != null) {
	                        referenceConstants.add(constant);
	                    }
	                } catch (Exception e) {
	                }
	            }
	        }
	     
	        return referenceConstants;
	    }    
	    
	    
	    /**
	     * Creates a Reference Type Object and stores it into the cache. Typically
	     * called during Class Type Initialization to define Constants.
	     * 
	     * @param code
	     * @param lookupTypeClass
	     */
	    protected static <T extends LookupType> T createConstant(String code,
	            Class<T> lookupTypeClass) {
	        return createConstant(code, code, lookupTypeClass);
	    }

	    /**
	     * Creates a Reference Type Object and stores it into the cache. Typically
	     * called during Class Type Initialization to define Constants
	     * 
	     * @param code
	     * @param description
	     * @param lookupTypeClass
	     */
	    protected static <T extends LookupType> T createConstant(String code,
	            String description, Class<T> lookupTypeClass) {
	        return LookupTypeManager.createConstant(code, description, lookupTypeClass);
	    }
	    
	    
	    /**
	     * Retrieves a Cached Lookup type by its Code
	     * @param <T>
	     * @param code
	     * @param lookupTypeClass
	     * @return
	     */
	    protected static <T extends LookupType> T getLookupByCode(String code, Class<T> lookupTypeClass) {
	        return LookupTypeManager.getFromCacheByCode(code, lookupTypeClass);
	    }

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
	    
	    
	}