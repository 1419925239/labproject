package com.lab.utils.POI;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 张占恒.
 * @date 2020/3/9.
 * @time 12:04.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ExcelTitle {


        String title();

        String dataMap() default "";


}
