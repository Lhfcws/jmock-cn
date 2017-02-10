package jmock.example;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.DateProducer;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.net.NetworkProducer;
import io.codearte.jfairy.producer.payment.CreditCard;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;

import java.util.Locale;

/**
 * jmock.example.CommonFakeExample
 * 通用造数据示例
 * 更多例子参见：https://github.com/Codearte/jfairy
 * http://ju.outofmemory.cn/entry/115449
 * @author lhfcws
 * @since 2017/2/10
 */
public class CommonFakeExample {
    public void fake() {
        // default is en ， locale is needed
        Fairy fairy = Fairy.create(Locale.CHINA);

        // person fake
        Person person = fairy.person();
        person.getAddress();
        person.getAge();
        person.getDateOfBirth();

        // common , covers number,collections,letter, etc.
        BaseProducer baseProducer = fairy.baseProducer();
        baseProducer.numerify("###-###"); // 123-456

        // text .  not work well for chinese
        TextProducer textProducer = fairy.textProducer();
        textProducer.text();
        textProducer.word();

        // company
        Company company = fairy.company();
        company.getUrl();
        company.getVatIdentificationNumber();

        // time
        DateProducer dateProducer = fairy.dateProducer();
        dateProducer.randomDateInThePast(0);    // 过去到现在的任意时间点
        dateProducer.randomDateBetweenYearAndNow(0);

        // others
        NetworkProducer networkProducer = fairy.networkProducer();
        networkProducer.ipAddress();
        CreditCard creditCard = fairy.creditCard();
        creditCard.getVendor();
        creditCard.getExpiryDateAsString();
    }
}
