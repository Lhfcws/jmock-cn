package jmock.weibo;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.DateProducer;
import weibo4j.model.Status;
import weibo4j.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

/**
 * jmock.weibo.Weibo
 *
 * @author lhfcws
 * @since 2017/2/7
 */
public class Weibo implements Serializable {
    public static Status createStatus() {
        Status status = new Status();
        Random r = new Random();
        Date date = new Date();
        Fairy fairy = Fairy.create();
        BaseProducer baseProducer = fairy.baseProducer();
        DateProducer dateProducer = fairy.dateProducer();

        status.setCommentsCount(r.nextInt(10000));
        status.setRepostsCount(r.nextInt(10000));
        status.setAttitudesCount(r.nextInt(10000));
        status.setMid(baseProducer.numerify("4###############"));
        status.setId(Long.valueOf(status.getMid()));
        status.setCreatedAt(dateProducer.randomDateBetweenYearAndNow(date.getYear()).toDate());
        status.setFavorited(baseProducer.trueOrFalse());
        status.setText(fairy.textProducer().text());

        return status;
    }

    public static Status createStatusWithUser() {
        Status status = createStatus();
        User user = WeiboUser.create();
        status.setUser(user);
        return status;
    }

    public static Status createStatusWithRetweet() {
        Status status = createStatus();
        Status srcStatus = createStatus();
        status.setRetweetedStatus(srcStatus);
        return status;
    }

    public static Status createStatusWithUserNRetweet() {
        Status status = createStatusWithUser();
        Status srcStatus = createStatusWithUser();
        status.setRetweetedStatus(srcStatus);
        return status;
    }
}
