package com.lab.utils.POI;



import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * @author 张占恒.
 * @date 2020/3/9.
 * @time 12:08.
 */
public class MyObjectUtils {


    private MyObjectUtils() {

    }

    /**
     * 通过属性名称获取属性值
     *
     * @param object
     * //@param fieldName
     * @return
     */
    public static Object getFieldValueByName(Object object, Field field) {
        try {
            String fieldName = field.getName();
            StringBuilder sb = new StringBuilder();
            sb.append("get");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            Method method = object.getClass().getMethod(sb.toString());
            return method.invoke(object);
        } catch (Exception e) {
            return MessageUtils.ERROR;
        }
    }

    /**
     * 通过属性名称给对象赋值
     *
     * @param object
     * //@param fieldName
     * @param value
     * @return
     */
    public static Object setFieldValueByName(Object object, Field field, Object value) {
        try {
            String fieldName = field.getName();
            System.out.println("fieldName: "+fieldName);
            Class<?>[] paramTypes = new Class[1];
            paramTypes[0] = field.getType();
            StringBuilder sb = new StringBuilder();
            sb.append("set");
            sb.append(fieldName.substring(0, 1).toUpperCase());
            sb.append(fieldName.substring(1));
            Method method = object.getClass().getMethod(sb.toString(), paramTypes);
            System.out.println("object: "+object);
            System.out.println("value："+value+" "+value.getClass());
            return method.invoke(object, value);
        } catch (Exception e) {
            return MessageUtils.ERROR;
        }
    }
}
