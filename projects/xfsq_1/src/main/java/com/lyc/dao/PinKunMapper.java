package com.lyc.dao;

import com.lyc.bean.PinKun;

import java.util.List;

public interface PinKunMapper {

    //查询数据总条数
    public long counts();
    //查询所有selectAll
    public List<PinKun> selectAll();
    //条件查询findIf(参数:身份,名字,时间,通过)
    public List<PinKun> findIf(PinKun pinKun);
    //添加pinKun_Add
    public Integer pinKun_Add(PinKun pinKun);
    //修改PinKun_Update
    public Integer pinKun_Update(PinKun pinKun);
    //删除pinKun_Del
    public Integer pinKun_Del(String[] pids);
}
