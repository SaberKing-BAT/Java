package LYC.common;

import java.io.Serializable;
import lombok.Data;

/**
 * SYS_STUDENT
 * @author 
 */
@Data
public class SysStudent implements Serializable {
    /**
     * 学号
     */
    private Integer stuNum;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 性别
     */
    private String stuSex;

    /**
     * 生日
     */
    private String stuBirth;

    /**
     * 院系
     */
    private String stuDept;

    private static final long serialVersionUID = 1L;
}