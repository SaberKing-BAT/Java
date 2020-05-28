package com.lyc.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyc.bean.PageParams;
import com.lyc.bean.Wuyebx;
import com.lyc.dao.WuyebxMapper;
import com.lyc.service.WuyebxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("wuyebxService")
public class WuyebxServiceImpl implements WuyebxService {

    @Autowired
    private WuyebxMapper wuyebxMapper;
    @Override
    public PageInfo<Wuyebx> selectAll(PageParams pageParams) {
        int pageNo = pageParams.getPageNo();
        int pageSize = pageParams.getPageSize();
        PageHelper.startPage(pageNo, pageSize);
        List<Wuyebx> wuyebxList = wuyebxMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo<Wuyebx> pageInfo = new PageInfo<Wuyebx>(wuyebxList);
        return pageInfo;
    }

    @Override
    public long counts() {
        return wuyebxMapper.counts();
    }
    @Override
    public Integer addOne(Wuyebx wuyebx) {
        System.out.println("Service层add方法被调用！");
        int w=wuyebxMapper.addOne(wuyebx);
        System.out.println(w+"这是结果");
        return w;
    }
    @Override
    public Integer deleteByid(String[] wids) {
        System.out.println("Service层删除方法被调用！");
        int w=wuyebxMapper.deleteByid(wids);
        System.out.println("结果为"+w);
        return w;
    }
    public List<Wuyebx> selectIf(Wuyebx wuyebx){
        return wuyebxMapper.selectIf(wuyebx);
    }

    @Override
    public int updateWuyebx(Wuyebx wuyebx) {
        return wuyebxMapper.updateWuyebx(wuyebx);
    }
}
