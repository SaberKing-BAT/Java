package com.lyc.dao;

import com.lyc.bean.ActiveInfo;
import com.lyc.bean.ActiveMan;

import java.util.List;

public interface ActiveManMapper {
    public List<ActiveMan> selectAll();

    public long counts();

    public Integer deleteManByid(String[] aaids);

    public Integer addMan(ActiveMan activeMan);
    public Integer updateActiveMan(ActiveMan activeMan);
    public List<ActiveMan> selectIfMan(ActiveMan activeMan);
}
