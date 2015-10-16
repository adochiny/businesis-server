package za.co.openset.utils;

import za.co.openset.model.BasePo;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by adonis on 2015/06/07.
 */
public class AManagerUtils {

    public static final String ABCDEFGHIJKLMNOPQRSTUVWXYZ = "abcdefghijklmnopqrstuvwxyz";

    public void setCommonFieldsCreate(BasePo po, Long crBy) {
        po.setIsactive(Boolean.TRUE);
        po.setCreated(new Date());
        po.setUpdated(new Date());
        po.setCreatedby(crBy);
        po.setUpdatedby(crBy);
    }

    public void setCommonFieldsUpdate(BasePo po, Long crBy) {
        po.setIsactive(Boolean.TRUE);
        po.setUpdated(new Date());
        po.setUpdatedby(crBy);
    }

    public String generateRandomString() {
        char[] chars = ABCDEFGHIJKLMNOPQRSTUVWXYZ.toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 29; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
