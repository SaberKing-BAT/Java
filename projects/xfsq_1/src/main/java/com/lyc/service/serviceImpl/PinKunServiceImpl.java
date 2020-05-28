package com.lyc.service.serviceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyc.bean.PageParams;
import com.lyc.bean.PinKun;
import com.lyc.dao.PinKunMapper;
import com.lyc.service.PinKunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("pinKunService")
public class PinKunServiceImpl implements PinKunService {
    @Autowired
    PinKunMapper pinKunMapper;
    @Override
    public long counts() {
        return pinKunMapper.counts();
    }

    @Override
    public PageInfo<PinKun> selectAll(PageParams pageParams) {
        int pageNo = pageParams.getPageNo();
        int pageSize = pageParams.getPageSize();
        PageHelper.startPage(pageNo, pageSize);
        List<PinKun> pinKuns = pinKunMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo<PinKun> pageInfo = new PageInfo<PinKun>(pinKuns);
        return pageInfo;
    }

    @Override
    public List<PinKun> findIf(PinKun pinKun) {
        return pinKunMapper.findIf(pinKun);
    }

    @Override
    public Integer pinKun_Add(PinKun pinKun) {
        return pinKunMapper.pinKun_Add(pinKun);
    }

    @Override
    public Integer pinKun_Update(PinKun pinKun) {
        return pinKunMapper.pinKun_Update(pinKun);
    }

    @Override
    public Integer pinKun_Del(String[] pids) {
        System.out.println("进入service"+pids[0]);
        int r=pinKunMapper.pinKun_Del(pids);
        System.out.println();
        return r;
    }
}
