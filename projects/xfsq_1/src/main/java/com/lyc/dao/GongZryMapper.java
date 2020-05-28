package com.lyc.dao;

import com.lyc.bean.GongZry;

import java.util.List;

public interface GongZryMapper {
    //查询数据总条数
    public long counts();
    //查询所有selectAll
    public List<GongZry> selectAll();
    //条件查询findIf(参数:身份,名字,时间,通过)
    public List<GongZry> findIf(GongZry ongZry);
    //添加GongZry_Add
    public Integer gongZry_Add(GongZry gongZry);
    //修改GongZry_Update
    public Integer gongZry_Update(GongZry gongZry);
    //删除GongZry_Del
    public Integer gongZry_Del(String[] pids);
}
