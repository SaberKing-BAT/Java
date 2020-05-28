package com.lyc.dao;

import com.lyc.bean.ActiveInfo;
import com.lyc.bean.Resident;
import com.lyc.bean.Wuyebx;

import java.util.List;

public interface ActiceInfoMapper {
    //查询全部
    public List<ActiveInfo> selectAll();
    //查询数量
    public long counts();
    //id删除
    public Integer deleteByid(String[] hids);
    //添加
    public Integer addOne(ActiveInfo activeInfo);
    public Integer updateActive(ActiveInfo activeInfo);
    //条件查询
    public List<ActiveInfo> selectIf(ActiveInfo activeInfo);
    //根据hid查询
    public ActiveInfo findActiveInfoByHid(String hid);
}
