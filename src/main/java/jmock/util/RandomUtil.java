package jmock.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * jmock.util.RandomUtil
 *
 * @author lhfcws
 * @since 2017/2/8
 */
public class RandomUtil {
    public ArrayList<String> getRandomList(GetFunction<String> getFunc) {
        int n = new Random().nextInt(5) + 5;
        HashSet<String> set = new HashSet<>();
        // to avoid dead loop if the random list is smaller than n
        int c = 100;
        while (set.size() < n && c >= 0) {
            String s = getFunc.get();
            if (!set.contains(s)) {
                set.add(s);
            }
            c--;
        }
        return new ArrayList<>(set);
    }
}
