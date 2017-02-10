package jmock.weibo;

import io.codearte.jfairy.Fairy;
import jmock.util.Pair;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import java.io.Serializable;
import java.util.Locale;

/**
 * jmock.weibo.WeiboUser
 *
 * @author lhfcws
 * @since 2017/2/7
 */
public class WeiboUser implements Serializable {
    public static User create() {
        User user = null;
        try {
            user = new User(null);
            Fairy fairy = Fairy.create(Locale.CHINA);
            String uid = fairy.baseProducer().numerify("##########");
            user.setId(Long.valueOf(uid));
            user.setCreatedAt(fairy.dateProducer().randomDateBetweenYearAndNow(0).toDate());
            Pair<Integer, Integer> pair = ChineseCityNProvProducer.getRandomProvNCityId();
            user.setProvince(pair.getKey());
            user.setCity(pair.getValue());
            user.setFavouritesCount(fairy.baseProducer().randomInt(10000));
            user.setBiFollowersCount(fairy.baseProducer().randomInt(10000));
            user.setFollowersCount(fairy.baseProducer().randomInt(10000));
            user.setFriendsCount(fairy.baseProducer().randomInt(10000));
            user.setStatusesCount(fairy.baseProducer().randomInt(10000));
            user.setVerifiedType(fairy.baseProducer().randomInt(8));
            user.setVerified(fairy.baseProducer().trueOrFalse());
            user.setName(fairy.person().getFirstName());
            user.setScreenName(user.getName());
            user.setUrl(fairy.networkProducer().url());
            user.setGender(fairy.baseProducer().randomElement("m", "f"));
            user.setLocation(ChineseCityNProvProducer.getProvStr(pair.getKey()) + " " + ChineseCityNProvProducer.getCityStr(pair.getKey(), pair.getValue()));
            return user;
        } catch (WeiboException e) {
            e.printStackTrace();
            return null;
        }
    }
}
