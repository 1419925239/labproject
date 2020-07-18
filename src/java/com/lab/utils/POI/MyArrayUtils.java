package com.lab.utils.POI;

/**
 * @author 张占恒.
 * @date 2020/3/9.
 * @time 12:06.
 */
public class MyArrayUtils {
    private MyArrayUtils() {

    }

    public static int getIndex(Object[] objs, Object object) {
        int index = -1;
        for (int i = 0; i < objs.length; i++) {
            Object obj = objs[i];
            if (obj.equals(object)) {
                return i;
            }
        }
        return index;
    }

}
