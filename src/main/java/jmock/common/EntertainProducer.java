package jmock.common;

import io.codearte.jfairy.data.MapBasedDataMaster;
import io.codearte.jfairy.producer.BaseProducer;

import java.io.IOException;
import java.util.Random;

/**
 * jmock.common.EntertainProducer
 *
 * Produce random value of fields that are related to some entertainment or businesses.
 *
 * @author lhfcws
 * @since 2017/2/7
 */
public class EntertainProducer {
    static MapBasedDataMaster dataMaster;

    public static void init() {
        dataMaster = new MapBasedDataMaster(new BaseProducer(new Random()));
        try {
            dataMaster.readResources("entertain-cn.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        init();
    }

    public String getRandomMovie() {
        return dataMaster.getRandomValue("movie");
    }

    public String getRandomBook() {
        return dataMaster.getRandomValue("book");
    }

    public String getRandomApp() {
        return dataMaster.getRandomValue("app");
    }

    public String getRandomBrand() {
        return dataMaster.getRandomValue("brand");
    }

    public String getRandomProduct() {
        return dataMaster.getRandomValue("product");
    }

    public String getRandomTag() {
        return dataMaster.getRandomValue("tag");
    }

    public String getRandomGame() {
        return dataMaster.getRandomValue("game");
    }

    public String getRandomTvshow() {
        return dataMaster.getRandomValue("tvshow");
    }

    public String getRandomDrama() {
        return dataMaster.getRandomValue("drama");
    }
}
