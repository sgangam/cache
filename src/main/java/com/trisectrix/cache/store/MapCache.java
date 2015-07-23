package com.trisectrix.cache.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Sriharsha Gangam
 */
public class MapCache {

    private static final Map<String, String> map = new ConcurrentHashMap<String, String>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }
}
