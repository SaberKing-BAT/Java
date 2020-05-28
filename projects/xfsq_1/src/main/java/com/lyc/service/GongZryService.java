package com.lyc.service;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.GongZry;
import com.lyc.bean.PageParams;
import java.util.List;

public interface GongZryService {
    public long counts();
    //查询所有selectAll
    public PageInfo<GongZry> selectAll(PageParams pageParams);
    //条件查询findIf(参数:身份,名字,时间,通过)
    public List<GongZry> findIf(GongZry gongZry);
    //添加gongZry_Add
    public Integer gongZry_Add(GongZry gongZry);
    //修改GongZry_Update
    public Integer gongZry_Update(GongZry gongZry);
    //删除gongZry_Del
    public Integer gongZry_Del(String[] gids);
}
