package com.lyc.service;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.LoginForm;
import com.lyc.bean.PageParams;
import com.lyc.bean.Resident;

import java.util.List;

public interface ResidentService {
    //登录验证
    public Resident login(LoginForm loginForm);
    //查询所有
    public PageInfo<Resident> selectAll(PageParams pageParams);
    public long counts();
    public Integer deleteByid(String[] jids);
    public Integer addOne(Resident resident);
    public Integer updateResident(Resident resident);
    public long ageCounts(int smallage,int bigage);
    public long yearCounts(String staryear,String endyear);
    //条件查询
    public List<Resident> selectIf(Resident resident);
    public int updatePw(Resident resident);
}
