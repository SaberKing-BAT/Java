package com.lyc.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyc.bean.GongGao;
import com.lyc.bean.PageParams;
import com.lyc.dao.GongGaoMapper;
import com.lyc.service.GongGaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gongGaoService")
public class GongGaoServiceImpl implements GongGaoService {
    @Autowired
    GongGaoMapper gongGaoMapper;


    @Override
    public long counts() {
        return gongGaoMapper.counts();
    }

    @Override
    public PageInfo<GongGao> selectAll(PageParams pageParams) {
        int pageNo = pageParams.getPageNo();
        int pageSize = pageParams.getPageSize();
        PageHelper.startPage(pageNo, pageSize);
        List<GongGao> gongGaos = gongGaoMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo<GongGao> pageInfo = new PageInfo<GongGao>(gongGaos);
        return pageInfo;
    }

    @Override
    public List<GongGao> findIf(GongGao gongGao) {
        return gongGaoMapper.findIf(gongGao);
    }

    @Override
    public Integer gongGao_Add(GongGao gongGao) {
        return gongGaoMapper.gongGao_Add(gongGao);
    }

    @Override
    public Integer gongGao_Update(GongGao gongGao) {
        return gongGaoMapper.gongGao_Update(gongGao);
    }

    @Override
    public Integer gongGao_Del(String[] gids) {
        return gongGaoMapper.gongGao_Del(gids);
    }
}
