package jmock.example;

import jmock.weibo.Weibo;
import jmock.weibo.WeiboUser;
import org.junit.Test;
import weibo4j.model.Status;
import weibo4j.model.User;

/**
 * jmock.example.WeiboFakeExample
 * Sina weibo fake
 * @author lhfcws
 * @since 2017/2/10
 */
public class WeiboFakeExample {
    @Test
    public void fakeStatus() {
        // 不带转发不带用户     without retweet, without user
        Status status1 = Weibo.createStatus();
        // 带转发的不带用户     with retweet, without user
        Status status2 = Weibo.createStatusWithRetweet();
        // 带用户不带转发    without retweet, with user
        Status status3 = Weibo.createStatusWithUser();
        // 带用户带转发    with retweet, with user
        Status status4 = Weibo.createStatusWithUserNRetweet();

        System.out.println(status4);
    }

    @Test
    public void fakeUser() {
        // simply create User
        User user0 = WeiboUser.create();
        // get a User from Status
        Status status1 = Weibo.createStatusWithUser();
        User user1 = status1.getUser();

        System.out.println(user1);
    }
}
