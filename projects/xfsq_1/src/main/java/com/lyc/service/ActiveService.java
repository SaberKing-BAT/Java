package com.lyc.service;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.ActiveInfo;
import com.lyc.bean.ActiveMan;
import com.lyc.bean.PageParams;
import java.util.List;

public interface ActiveService {
    public PageInfo<ActiveInfo> selectAll(PageParams pageParams);
    public long counts();
    public Integer deleteByid(String[] hids);
    public Integer addOne(ActiveInfo activeInfo);
    //修改
    public Integer updateActive(ActiveInfo activeInfo);
    //条件查询
    public List<ActiveInfo> selectIf(ActiveInfo activeInfo);
    // 活动人员
    public PageInfo<ActiveMan> selectAllman(PageParams pageParams);
    public long manCounts();
    public Integer deleteManByid(String[] aaids);
    public Integer addMan(ActiveMan activeMan);
    //修改人员
    public Integer updateActiveMan(ActiveMan activeMan);
    //条件查询
    public List<ActiveMan> selectIfMan(ActiveMan activeMan);
}
