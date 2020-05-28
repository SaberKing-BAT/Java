package com.lyc.dao;

import com.lyc.bean.Wuyebx;

import java.util.List;

public interface WuyebxMapper {
    //查询全部
    public List<Wuyebx> selectAll();
    //查询数量
    public long counts();
    //添加
    public Integer addOne(Wuyebx wuyebx);
    //删除通过id
    public Integer deleteByid(String[] wids);
    //条件查询
    public List<Wuyebx> selectIf(Wuyebx wuyebx);
    //修改
    public int updateWuyebx(Wuyebx wuyebx);
}
