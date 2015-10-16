package za.co.openset.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.crypto.Cipher;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by adonis on 2015/06/29.
 */

@Startup
@Singleton
public class CacheService {

    private Cache cache;
    private CacheManager cm;

    Cipher cipher;

    @PostConstruct
    public void init() throws Exception {
        //1. Create a cache manager
        cm = CacheManager.getInstance();
        //2. Create a cache called "cache1"
        // cm.addCache("cache1");
        //3. Get a cache called "cache1"
        cache = cm.getCache("cache1");

    }

    public void addItem(String key, Object value) {
        cache.put(new Element(key,value));
    }

    public void removeItem(String key) {
        cache.remove(key);
    }

    public Object getItem(String key) {
        Element ele = cache.get(key);
        return ele.getObjectValue();
    }

    public Boolean isItemInCache(String key) {
        return cache.isKeyInCache(key);
    }

    @PreDestroy
    public void cleanUp() {
        //8. shut down the cache manager
        cm.shutdown();
    }

}
