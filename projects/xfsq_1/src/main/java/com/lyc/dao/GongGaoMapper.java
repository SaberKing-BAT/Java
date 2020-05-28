package com.lyc.dao;

import com.lyc.bean.GongGao;

import java.util.List;

public interface GongGaoMapper {
    //查询数据总条数
    public long counts();
    //查询所有selectAll
    public List<GongGao> selectAll();
    //条件查询findIf(参数:身份,名字,时间,通过)
    public List<GongGao> findIf(GongGao gongGao);
    //添加pinKun_Add
    public Integer gongGao_Add(GongGao gongGao);
    //修改PinKun_Update
    public Integer gongGao_Update(GongGao gongGao);
    //删除pinKun_Del
    public Integer gongGao_Del(String[] gids);
}
