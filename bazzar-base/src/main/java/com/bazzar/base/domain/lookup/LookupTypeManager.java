package com.bazzar.base.domain.lookup;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.bazzar.base.domain.LookupType;

public class LookupTypeManager {
    static final Map<Class<? extends LookupType>, Map<String, LookupType>> lookupTypeCache = new HashMap<Class<? extends LookupType>, Map<String, LookupType>>();

    protected LookupTypeManager() {
    }

    protected static <T extends LookupType> T createConstant(String code,
            String description, Class<T> lookupTypeClass) {
        try {
            T retVal = lookupTypeClass.newInstance();
            retVal.setCode(code);
            retVal.setDescription(description);

            addToCache(retVal);
            return retVal;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected static void addToCache(LookupType lookupType) {
        Map<String, LookupType> referenceMap = lookupTypeCache.get(lookupType
                .getClass());

        if (referenceMap == null) {
        	referenceMap = new HashMap<String, LookupType>();
            lookupTypeCache.put(lookupType.getClass(), referenceMap);
        }

        // If this is an existing item, update the Cache object
        if (mergeExistingItem(lookupType)) {
            return;
        }

        referenceMap.put("CODE_" + lookupType.getCode().toUpperCase(),
                lookupType);
        referenceMap.put("ID_" + lookupType.getId(), lookupType);
    }

    protected static boolean mergeExistingItem(LookupType lookupType) {

        LookupType cachedItem = getFromCacheByCode(lookupType.getCode(),
                lookupType.getClass());
        if (cachedItem == null) {
            return false;
        }

        BeanUtils.copyProperties(lookupType, cachedItem);

        return true;
    }

    @SuppressWarnings("unchecked")
    protected static <T extends LookupType> T getFromCacheByCode(String code,
            Class<T> lookupType) {
        Map<String, LookupType> referenceMap = lookupTypeCache.get(lookupType);

        if (referenceMap == null) {
            return null;
        }

        LookupType retVal = referenceMap.get("CODE_" + code.toUpperCase());
        return (T) retVal;
    }

    protected static <T extends LookupType> T getFromCacheById(long id,
            Class<T> lookupType) {
        return getFromCacheById("" + id, lookupType);
    }

    @SuppressWarnings("unchecked")
    protected static <T extends LookupType> T getFromCacheById(String id,
            Class<T> lookupType) {
        Map<String, LookupType> referenceMap = lookupTypeCache.get(lookupType);

        if (referenceMap == null) {
            return null;
        }

        LookupType retVal = referenceMap.get("ID_" + id);
        return (T) retVal;
    }
}
