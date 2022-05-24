/*
package LYC.Excel;


import LYC.注释.ExcelField;
import com.hs.clientManager.util.annotation.ExcelField;
import com.hs.util.StringUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelToEntity {
    //==========================================方式一，提供mapp映射==========================================

    */
/**
     * @Author: LYC
     * @Date: 2021/7/19 17:38
     * @FuntionName: excelToEntity
     * @Param: [filePath, sheetIndex, rowIndex, entityIndexMap]
     * @Return: java.util.ListR
     * @Description: 把excel数据转实体类 rowIndex:从第几行数据开始，entityIndexMap实体属性对应的excel col的index
    eg: enityIndexmap={"xl":"1","xb":"2","jcsj":3}
     **//*

    public static <T> List excelToEntity(String filePath, int sheetIndex, int rowIndex, Map<String, String> entityIndexMap, Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        List<Object> oList = new ArrayList<>();
        List<List<String>> list = new ReadExcel().read(filePath, sheetIndex);
        for (int i = rowIndex; i < list.size(); i++) {
            Object obj = clazz.newInstance();
            for (Map.Entry<String, String> entry : entityIndexMap.entrySet()) {
                String entityName = entry.getKey();
                String colIndex = entry.getValue();
                String data = list.get(rowIndex).get(Integer.parseInt(colIndex));
                setEntityValue(obj, entityName, data);
                oList.add(obj);
            }
        }
        return oList;
    }

    //给属性赋值
    private static void setEntityValue(Object entity, String entityName, String data) throws NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Field field = entity.getClass().getDeclaredField(entityName);
        String fieldType = field.getClass().getName();
        field.setAccessible(true);
        switch (fieldType) {
            case "java.lang.String":
                if (entityName.toLowerCase().contains("date"))//把时间统一格式yyyymmdd
                    data.replace("年", "").replace("月", "").replace("日", "").replaceAll("-", "");
                field.set(entity, data);
            case "java.math.BigDecimal":
                field.set(entity, new BigDecimal(data));
            case "java.lang.Integer":
                field.set(entity, Integer.parseInt(data));
            default:
                System.out.println("该字段类型未配置,请添加配置后使用!");

        }
        field.setAccessible(false);
    }

    //===============================================方式二：添加注释@ExcelField==============================================
    */
/**
     * @Author: LYC
     * @Date: 2021/7/20 11:19
     * @FuntionName: excelToEntityAnnotion
     * @Param: [filePath, sheetIndex, rowIndex, clazz]
     * @Return: java.util.ListR
     * @Description: 根据注释把excel数据赋值给实体类
     **//*


    public static List excelToEntityAnnotion(String filePath, int sheetIndex, int rowIndex, Class clazz) throws InstantiationException, IllegalAccessException {
        List<List<String>> list = new ReadExcel().read(filePath, sheetIndex);
        return ExcelListTOEntity(list,rowIndex,clazz);
    }

    */
/**
     * @Author: LYC
     * @Date: 2021/7/21 11:03
     * @Description: exccl list转 entity
     * @FuntionName: ExcelListTOEntity
     * @Param: [list, rowIndex, clazz]
     * @Return: java.util.ListR
     **//*

    public static List ExcelListTOEntity(List<List<String>> list,int rowIndex, Class clazz)  {

        List<Object> oList = new ArrayList<>();
//        int j=0;
//        String filename=null;
        try{
            for (int i = rowIndex; i < list.size(); i++) {
                //   j=i;

                Object obj = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field f : fields
                ) {
                    //        filename=f.getName();
                    setFieldValueAnnotion(f,obj,list.get(i));
                }
                oList.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
//            System.out.println(j);
//            System.out.println(filename);
        }
        return oList;
    }


    private static void setFieldValueAnnotion(Field field, Object obj, List<String> dataList) throws IllegalAccessException {
        ExcelField excleField = field.getAnnotation(ExcelField.class);
        int colIndex = 0;
        boolean isDate = false;
        String data = "";
        String defaultVale = "";
        if (excleField != null) {
            colIndex = excleField.colIndex();
            isDate = excleField.isDate();
            defaultVale = excleField.defaultValue();
            data = dataList.get(colIndex);
        }
        String fieldType = field.getType().getName();
        field.setAccessible(true);

        String fieldValue="";

        if (defaultVale!=null&&!defaultVale.equals(""))
            fieldValue=defaultVale;
        else if (data!=null&&!"".equals(data=data.replaceAll(" ","")))//有空格大坑
            fieldValue=data;

        if (!StringUtil.isEmpty(fieldValue)) { //无默认值，切无数据
            switch (fieldType) {            //根据字段类型赋值
                case "java.lang.String":
                    if (isDate)//把时间统一格式yyyymmdd
                        fieldValue.replace("年", "").replace("月", "").replace("日", "").replaceAll("-", "");
                    field.set(obj, fieldValue);
                    break;
                case "java.math.BigDecimal":
                    field.set(obj, new BigDecimal(fieldValue));
                    break;
                case "java.lang.Integer":
                    field.set(obj, Integer.parseInt(fieldValue));
                    break;
                default:
                    System.out.println("该字段类型未配置,请添加配置后使用!");
            }
        }
        field.setAccessible(false);
    }
}
*/
