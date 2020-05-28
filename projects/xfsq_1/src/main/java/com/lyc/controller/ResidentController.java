package com.lyc.controller;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.PageParams;
import com.lyc.bean.Resident;
import com.lyc.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ResidentController {

    @Autowired
    private ResidentService residentService;
    //转发到居民页面
    @RequestMapping("/goResident")
    public String goResident(){
        System.out.println("ResidentController被调用");
        return "resident";
    }
    //查询居民信息单
    @ResponseBody
    @RequestMapping("/ResidentList")
    public HashMap<String, Object> loadData(PageParams pageParams){
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageInfo<Resident> pageInfo = residentService.selectAll(pageParams);
        List<Resident> rlist = pageInfo.getList();
        map.put("rlist", rlist);
        map.put("counts",residentService.counts());
        return map;
    }
    //批量删除居民信息
    @RequestMapping("/residentDel")
    @ResponseBody
    public String deleteByid(@RequestParam(value="jids[]",required=false) String[] jids){
        System.out.println("进入批量删除controller，接收参数为："+jids[0]);
        System.out.println(jids.length);
        int reslut=residentService.deleteByid(jids);
        System.out.println("执行结果"+reslut);
        return "seccuss";
    }
    //去往添加页面
    @RequestMapping("/goAddResident")
    public String goAddResident(){
        System.out.println("去往添加页面Controller被调用！");
        return "resident_add";
    }
    //添加
    @RequestMapping("/addResident")
    @ResponseBody
    public String addResident(Resident resident){
        System.out.println("进入到addResident方法接收参数为"+resident);
        int r=residentService.addOne(resident);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
    //去修改页面
    @RequestMapping("/goResidentUpdate")
    public String goUpdateResident(){
        System.out.println("进入修改页面");
        return "resident_update";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateResident")
    public String updateResident(Resident resident){
        System.out.println("进入修改"+resident);
        int r=residentService.updateResident(resident);
        System.out.println("结果为："+r);
        return "success";
    }
    //条件查询
    @ResponseBody
    @RequestMapping("/ifResident")
    public HashMap<String, Object> ifResident(String tiaojian,String canshu){
        Resident resident=new Resident();
        switch (tiaojian){
            case "0":resident.setJid(canshu);break;
            case "1":resident.setJname(canshu);break;
            case "2":resident.setJsex(canshu);break;
            case "3":resident.setJage(Integer.parseInt(canshu));break;
            case "4":resident.setJphone(canshu);break;
            case "5":resident.setJadress(canshu);break;
            case "6":resident.setidadress(canshu);break;
            case "7":resident.setintime(canshu);break;
        }
        List<Resident> residents=residentService.selectIf(resident);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",residents);
        return rmap;
    }
    @RequestMapping("/goResidentStatistical")
    public String goResidentStatistical(){
        return "residentStatistical";
    }
    //年龄统计
    @ResponseBody
    @RequestMapping("/residentData")
    public HashMap<String, Object> ageCounts(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        System.out.println("进入年龄统计");
        List<Integer> ages=new ArrayList<Integer>();
        List<Integer> years=new ArrayList<Integer>();
        ages.add((int)residentService.ageCounts(0,12));
        ages.add((int)residentService.ageCounts(12,18));
        ages.add((int)residentService.ageCounts(18,40));
        ages.add((int)residentService.ageCounts(40,60));
        ages.add((int)residentService.ageCounts(60,150));
        years.add((int)residentService.yearCounts("2011-1-1","2011-12-31"));
        years.add((int)residentService.yearCounts("2012-1-1","2012-12-31"));
        years.add((int)residentService.yearCounts("2013-1-1","2013-12-31"));
        years.add((int)residentService.yearCounts("2014-1-1","2014-12-31"));
        years.add((int)residentService.yearCounts("2015-1-1","2015-12-31"));
        years.add((int)residentService.yearCounts("2016-1-1","2016-12-31"));
        years.add((int)residentService.yearCounts("2017-1-1","2017-12-31"));
        years.add((int)residentService.yearCounts("2018-1-1","2018-12-31"));
        years.add((int)residentService.yearCounts("2019-1-1","2019-12-31"));
        years.add((int)residentService.yearCounts("2020-1-1","2020-12-31"));
        map.put("ages",ages);
        map.put("years",years);
        return map;
    }
}
