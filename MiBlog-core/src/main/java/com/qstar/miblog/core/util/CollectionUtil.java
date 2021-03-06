package com.qstar.miblog.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CollectionUtil {

    public static boolean isNullOrEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static List<Long> stringToLong(List<String> list) {
        List<Long> result = new ArrayList<>();
        for (String s : list) {
            result.add(Long.valueOf(s));
        }
        return result;
    }

}
