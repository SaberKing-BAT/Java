package com.lyc.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyc.bean.GongZry;
import com.lyc.bean.PageParams;
import com.lyc.dao.GongZryMapper;
import com.lyc.service.GongZryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("gongZryService")
public class GongZryServiceImpl implements GongZryService {
    @Autowired
    GongZryMapper gongZryMapper;
    @Override
    public long counts() {
        return gongZryMapper.counts();
    }

    @Override
    public PageInfo<GongZry> selectAll(PageParams pageParams) {
        int pageNo = pageParams.getPageNo();
        int pageSize = pageParams.getPageSize();
        PageHelper.startPage(pageNo, pageSize);
        List<GongZry> gongZryList = gongZryMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo<GongZry> pageInfo = new PageInfo<GongZry>(gongZryList);
        return pageInfo;
    }

    @Override
    public List<GongZry> findIf(GongZry gongZry) {
        return gongZryMapper.findIf(gongZry);
    }

    @Override
    public Integer gongZry_Add(GongZry gongZry) {
        return gongZryMapper.gongZry_Add(gongZry);
    }

    @Override
    public Integer gongZry_Update(GongZry gongZry) {
        return gongZryMapper.gongZry_Update(gongZry);
    }

    @Override
    public Integer gongZry_Del(String[] gids) {
        return gongZryMapper.gongZry_Del(gids);
    }
}
