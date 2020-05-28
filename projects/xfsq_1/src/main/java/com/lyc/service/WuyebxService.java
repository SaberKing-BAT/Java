package com.lyc.service;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.PageParams;
import com.lyc.bean.Resident;
import com.lyc.bean.Wuyebx;

import java.util.List;

public interface WuyebxService {
    public PageInfo<Wuyebx> selectAll(PageParams pageParams);
    public long counts();
    public Integer addOne(Wuyebx wuyebx);
    public Integer deleteByid(String[] wids);
    //条件查询
    public List<Wuyebx> selectIf(Wuyebx wuyebx);
    public int updateWuyebx(Wuyebx wuyebx);
}
