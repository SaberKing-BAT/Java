package com.lyc.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyc.bean.ActiveInfo;
import com.lyc.bean.ActiveMan;
import com.lyc.bean.PageParams;
import com.lyc.dao.ActiceInfoMapper;
import com.lyc.dao.ActiveManMapper;
import com.lyc.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activeService")
public class ActiveServiceImpl  implements ActiveService {
    @Autowired
    private ActiceInfoMapper acticeInfoMapper;
    @Autowired
    private ActiveManMapper activeManMapper;

    @Override
    public PageInfo<ActiveInfo> selectAll(PageParams pageParams) {
        int pageNo = pageParams.getPageNo();
        int pageSize = pageParams.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<ActiveInfo> activeInfos = acticeInfoMapper.selectAll();
        //用PageInfo对结果进行包装
        PageInfo<ActiveInfo> pageInfo = new PageInfo<ActiveInfo>(activeInfos);

        return pageInfo;
    }

    @Override
    public long counts() {
        return acticeInfoMapper.counts();
    }

    @Override
    public Integer deleteByid(String[] hids) {
        return acticeInfoMapper.deleteByid(hids);
    }
    public Integer addOne(ActiveInfo activeInfo){
        int i=acticeInfoMapper.addOne(activeInfo);
        System.out.println(i+"涛涛涛涛");
        return i;
    }
    public Integer updateActive(ActiveInfo activeInfo){
        return acticeInfoMapper.updateActive(activeInfo);
    }
    //条件查询
    public List<ActiveInfo> selectIf(ActiveInfo activeInfo){
        return acticeInfoMapper.selectIf(activeInfo);
    }

    //活动人员查询
    public PageInfo<ActiveMan> selectAllman(PageParams pageParams) {
        //System.out.println("进入到service层");
        int pageNo = pageParams.getPageNo();
        int pageSize = pageParams.getPageSize();
       // System.out.println(pageNo+pageSize);
        PageHelper.startPage(pageNo, pageSize);
        List<ActiveMan> activeMans = activeManMapper.selectAll();
        /*for (ActiveMan i:activeMans){
            System.out.println(i);
        }*/
        //用PageInfo对结果进行包装
        PageInfo<ActiveMan> pageInfo = new PageInfo<ActiveMan>(activeMans);
        return pageInfo;
    }
    //查数量
    @Override
    public long manCounts() {
        return activeManMapper.counts();
    }
    //删除人员
    public Integer deleteManByid(String[] aaids){
        return activeManMapper.deleteManByid(aaids);
    }

    @Override
    public Integer addMan(ActiveMan activeMan) {
        return activeManMapper.addMan(activeMan);
    }

    @Override
    public Integer updateActiveMan(ActiveMan activeMan) {
        System.out.println(activeMan);
        return activeManMapper.updateActiveMan(activeMan);
    }

    @Override
    public List<ActiveMan> selectIfMan(ActiveMan activeMan) {
        return activeManMapper.selectIfMan(activeMan);
    }
}
