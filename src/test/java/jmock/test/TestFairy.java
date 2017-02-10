package jmock.test;

import io.codearte.jfairy.Fairy;
import org.junit.Test;

import java.util.Locale;


/**
 * jmock.test.TestFairy
 *
 * @author lhfcws
 * @since 2017/2/8
 */
public class TestFairy {
    @Test
    public void testFairy() {
        Fairy fairy = Fairy.create(Locale.CHINA);
        for (int i = 0; i < 5; i++) {
            System.out.println(fairy.textProducer().text());
        }
    }
}
