package com.lyc.service;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.PageParams;
import com.lyc.bean.PinKun;

import java.util.List;

public interface PinKunService {
    public long counts();
    //查询所有selectAll
    public PageInfo<PinKun> selectAll(PageParams pageParams);
    //条件查询findIf(参数:身份,名字,时间,通过)
    public List<PinKun> findIf(PinKun pinKun);
    //添加pinKun_Add
    public Integer pinKun_Add(PinKun pinKun);
    //修改PinKun_Update
    public Integer pinKun_Update(PinKun pinKun);
    //删除pinKun_Del
    public Integer pinKun_Del(String[] pids);
}
