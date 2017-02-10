package jmock.weibo;

import io.codearte.jfairy.producer.BaseProducer;
import jmock.util.GsonSerializer;
import org.apache.commons.io.IOUtils;
import jmock.util.Pair;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * jmock.weibo.ChineseCityNProvProducer
 * Produce chinese city and province names or ids.
 * The ids are compatible with China Identification Card location system.
 * If you have a Chinese ID card, plz check it out your self.
 * @author lhfcws
 * @since 2017/2/7
 */
public class ChineseCityNProvProducer {
    private static BaseProducer baseProducer = new BaseProducer(new Random());
    public static HashMap<String, String> prov = new HashMap<>();
    public static HashMap<String, String> city = new HashMap<>();

    static {
        init();
    }

    /**
     * static init
     */
    private static void init() {
        // init area json by resource file area.json
        try {
            InputStream inputStream = ChineseCityNProvProducer.class.getClassLoader().getResourceAsStream("area.json");
            String areaJson = IOUtils.toString(inputStream);
            if (areaJson != null) {
                AreaJson obj = GsonSerializer.deserialize(areaJson, AreaJson.class);
                List<AreaJsonProvinceEntry> plist = obj.get("provinces");
                for (AreaJsonProvinceEntry pe : plist) {
                    prov.put(pe.getId(), pe.getName());
                    for (Map<String, String> p : pe.getCitys()) {
                        for (Map.Entry<String, String> e : p.entrySet()) {
                            city.put(pe.getId() + "-" + e.getKey(), e.getValue());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProvStr(Object key) {
        return prov.get(String.valueOf(key));
    }

    public static String getCityStr(Object provKey, Object cityKey) {
        return city.get(provKey + "-" + cityKey);
    }

    public static Pair<String, String> getRandomProvNCity() {
        String key = baseProducer.randomElement(new ArrayList<>(city.keySet()));
        String[] arr = key.split("-");
        String provStr = prov.get(arr[0]);
        String cityStr = city.get(arr[1]);
        return new Pair<>(provStr, cityStr);
    }

    public static Pair<Integer, Integer> getRandomProvNCityId() {
        String key = baseProducer.randomElement(new ArrayList<>(city.keySet()));
        String[] arr = key.split("-");
        return new Pair<>(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]));
    }

    /**
     * inner classes for json serialization
     */
    public static class AreaJson extends HashMap<String, List<AreaJsonProvinceEntry>> {
    }

    public static class AreaJsonProvinceEntry {
        String id;
        String name;
        List<HashMap<String, String>> citys;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<HashMap<String, String>> getCitys() {
            return citys;
        }

        public void setCitys(List<HashMap<String, String>> citys) {
            this.citys = citys;
        }

        @Override
        public String toString() {
            return "{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", citys=" + citys +
                    '}';
        }
    }
}
