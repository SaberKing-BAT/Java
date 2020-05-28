package com.lyc.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyc.bean.LoginForm;
import com.lyc.bean.PageParams;
import com.lyc.bean.Resident;
import com.lyc.dao.ResidentMapper;
import com.lyc.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("residentService")
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    private ResidentMapper residentMapper;

    //登录验证服务
    @Override
    public Resident login(LoginForm loginForm){
        return residentMapper.login(loginForm);
    }
    //查询所有
    @Override
    public PageInfo<Resident> selectAll(PageParams pageParams) {
        int pageNo = pageParams.getPageNo();
        int pageSize = pageParams.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<Resident> residentList = residentMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo<Resident> pageInfo = new PageInfo<Resident>(residentList);

        return pageInfo;
    }

    @Override
    public long counts() {
        return residentMapper.counts();
    }

    @Override
    public Integer deleteByid(String[] jids) {
        System.out.println("Service层删除方法被调用！");
        int r=residentMapper.deleteByid(jids);
        System.out.println("结果为"+r);
        return r;
    }

    @Override
    public Integer addOne(Resident resident) {
        System.out.println("Service层add方法被调用！");
        int r=residentMapper.addOne(resident);
        System.out.println(r+"这是结果");
        return r;
    }

    @Override
    public Integer updateResident(Resident resident) {
        return residentMapper.updateResident(resident);
    }

    @Override
    public long ageCounts(int smallage, int bigage) {
        return residentMapper.ageCounts(smallage,bigage);
    }
    public long yearCounts(String staryear,String endyear){
        return residentMapper.yearCounts(staryear,endyear);
    }
    public List<Resident> selectIf(Resident resident){
        return residentMapper.selectIf(resident);
    }

    @Override
    public int updatePw(Resident resident) {
        return residentMapper.updatePw(resident);
    }

}
