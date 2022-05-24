package LYC.注释;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {
    public int colIndex();//excel 列角标
    public String defaultValue() default "";
    public boolean isDate() default false; //是否是日期类型 是的话统一格式yyyyymmdd

}