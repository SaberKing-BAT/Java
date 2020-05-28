package com.lyc.dao;

import com.lyc.bean.LoginForm;
import com.lyc.bean.Resident;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResidentMapper {
    //登录验证
    public Resident login(LoginForm loginForm);
    //查询全部
    public List<Resident> selectAll();
    //查询数量
    public long counts();
    //条件查询
    public List<Resident> selectIf(Resident resident);
    //删除通过id
    public Integer deleteByid(String[] jids);
    //添加
    public Integer addOne(Resident resident);
    //修改
    public Integer updateResident(Resident resident);
    public long ageCounts(@Param("smallage")int samllage,@Param("bigage") int bigage);
    public long yearCounts(@Param("staryear") String staryear,@Param("endyear") String endyear);
    public int updatePw(Resident resident);
    public Resident findResidentByjphone(String jphone);

}
