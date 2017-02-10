package jmock.test;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.text.TextProducer;
import jmock.common.EntertainProducer;
import org.junit.Test;

import java.util.Locale;

/**
 * jmock.test.TestProducer
 *
 * @author lhfcws
 * @since 2017/2/8
 */
public class TestProducer {
    @Test
    public void testEntertainProducer() {
        EntertainProducer entertainProducer = new EntertainProducer();
        for (int i = 0; i < 3; i++) {
            System.out.println("---------------------");
            System.out.println(entertainProducer.getRandomApp());
            System.out.println(entertainProducer.getRandomBook());
            System.out.println(entertainProducer.getRandomBrand());
            System.out.println(entertainProducer.getRandomProduct());
            System.out.println(entertainProducer.getRandomMovie());
            System.out.println(entertainProducer.getRandomGame());
            System.out.println(entertainProducer.getRandomTag());
            System.out.println(entertainProducer.getRandomTvshow());
            System.out.println(entertainProducer.getRandomDrama());
        }
    }

    @Test
    public void testTextProducer() {
        Fairy fairy = Fairy.create(Locale.CHINA);
        TextProducer textProducer = fairy.textProducer();
        System.out.println(textProducer.text());
        System.out.println(textProducer.word());
        System.out.println(textProducer.paragraph());
    }
}
