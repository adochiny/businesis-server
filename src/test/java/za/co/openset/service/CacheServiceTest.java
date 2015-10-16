package za.co.openset.service;

import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.utils.CacheService;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class CacheServiceTest {

    @Inject
    private RiskReviewTestUtils iManagerTestUtils;

    @Inject
    private CacheService cacheService;

    @Test
    @Transactional
    public void testAddItem() throws Exception {

        String user1Key = iManagerTestUtils.generateRandomString();
        String user2Key = iManagerTestUtils.generateRandomString();
        String user3Key = iManagerTestUtils.generateRandomString();
        cacheService.addItem(user1Key, "Item 1");
        cacheService.addItem(user2Key, "Item 2");
        cacheService.addItem(user3Key, "Item 3");

        Object item2 = cacheService.getItem(user2Key);
        assertNotNull(item2);
        assertTrue("Item 2".equals(item2.toString()));

        Boolean bol = cacheService.isItemInCache(user3Key);
        assertTrue(bol);

        bol = cacheService.isItemInCache(user2Key);
        assertTrue(bol);
        cacheService.removeItem(user2Key);

        bol = cacheService.isItemInCache(user2Key);
        assertFalse(bol);
    }

    @Test
    @Transactional
    public void testEncryptDecrypt() throws Exception {
        //String username = "adochiny@gmail.com";
        /*String encrypted = cacheService.encrypt(username);
        System.out.println(encrypted);
        assertNotNull(encrypted);
        String decrypted = cacheService.decrypt(encrypted);
        System.out.println(decrypted);
        assertNotNull(decrypted);

        assertEquals(username, decrypted);*/
    }

}