package jmock.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;

/**
 * @author lhfcws
 * @since 15/6/2.
 */
public class GsonSerializer {
    private static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();

    /**
     * This method is in case of memory leak.
     * @return Gson object
     */
    public static Gson getGson() {
        return new GsonBuilder().disableHtmlEscaping().enableComplexMapKeySerialization().create();
    }

    /**
     * Safe method to deserialize from json.
     *
     * @param json the json to be deserialized
     * @param klass the class deserialize to
     * @return the object deserialize to
     */
    public static <T> T fromJson(String json, Class<T> klass) {
        if (String.class.isInstance(klass)) return (T) json;

        JsonReader reader = new JsonReader(new StringReader(json.trim()));
        reader.setLenient(true);
        return getGson().fromJson(reader, klass);
    }

    /**
     * Safe method to deserialize from json.
     *
     * @param json the json to be deserialized
     * @param klass the class deserialize to
     * @return the object deserialize to
     */
    public static <T> T deserialize(String json, Class<T> klass) {
        return fromJson(json, klass);
    }

    /**
     * 把Json字符串反序列化成实现了Type接口的实体类对象
     * @param json 待反序列化的json字符串
     * @param type 泛型类型
     * @return 反序列化后的对象
     */
    public static <T> T fromJson(String json, java.lang.reflect.Type type) {
        JsonReader reader = new JsonReader(new StringReader(json.trim()));
        reader.setLenient(true);
        return getGson().fromJson(reader, type);
    }

    /**
     * 把Json字符串反序列化成实现了Type接口的实体类对象
     * @param json 待反序列化的json字符串
     * @param type 泛型类型
     * @return 反序列化后的对象
     */
    public static <T> T deserialize(String json, java.lang.reflect.Type type) {
        return fromJson(json, type);
    }

    /**
     * Wrapper of json serialization.
     *
     * @param obj 待序列化的对象
     * @return 对象序列化后的json字符串
     */
    public static <T> String toJson(T obj) {
        if (obj.toString().equals(obj))
            return obj.toString();
        return getGson().toJson(obj);
    }

    /**
     * Wrapper of json serialization.
     *
     * @param obj 待序列化的对象
     * @return 对象序列化后的json字符串
     */
    public static <T> String serialize(T obj) {
        return toJson(obj);
    }

    public static <T> String serializePretty(T obj) {
        return new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create().toJson(obj);
    }
}
