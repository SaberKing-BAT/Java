package com.lyc.service;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.GongGao;
import com.lyc.bean.PageParams;
import java.util.List;

public interface GongGaoService {
    public long counts();
    //查询所有selectAll
    public PageInfo<GongGao> selectAll(PageParams pageParams);
    //条件查询findIf(参数:编号,主题,时间,类型)
    public List<GongGao> findIf(GongGao gongGao);
    //添加gongGao_Add
    public Integer gongGao_Add(GongGao gongGao);
    //修改gongGao_Update
    public Integer gongGao_Update(GongGao gongGao);
    //删除gongGao_Del
    public Integer gongGao_Del(String[] gids);
}
