package com.lyc.controller;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.PageParams;
import com.lyc.bean.Resident;
import com.lyc.bean.Wuyebx;
import com.lyc.service.WuyebxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class WuyebxController {

    @Autowired
    private WuyebxService wuyebxService;

    //转发到物业页面
    @RequestMapping("/goWuyebx")
    public String goWuyebx(){
        System.out.println("ResidentController被调用");
        return "wuyebx";
    }
    //查询物业信息单
    @ResponseBody
    @RequestMapping("/wuyebx")
    public HashMap<String, Object> loadData(PageParams pageParams){
       // System.out.println("进入物业"+pageParams.getPageNo()+pageParams.getPageSize());
        HashMap<String, Object> map = new HashMap<String, Object>();
         PageInfo<Wuyebx> pageInfo = wuyebxService.selectAll(pageParams);
        List<Wuyebx> rlist = pageInfo.getList();
        map.put("rlist", rlist);
        map.put("counts",wuyebxService.counts());
        return map;
    }
    //转发到物业报修添加页面
    @RequestMapping("/goWuyebxAdd")
    public String goWuyebxAdd(){
        return "wuyebx_add";
    }
    //添加
    @RequestMapping("/wuyebxAdd")
    @ResponseBody
    public String addWuyebx(Wuyebx wuyebx){
        System.out.println("进入到addResident方法接收参数"+wuyebx);
        int r=wuyebxService.addOne(wuyebx);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
    //批量删除居民信息
    @RequestMapping("/wuyebxDel")
    @ResponseBody
    public String deleteByid(@RequestParam(value="wids[]",required=false) String[] wids){
        System.out.println("进入批量删除controller，接收参数为："+wids);
        System.out.println(wids.length);
        int reslut=wuyebxService.deleteByid(wids);
        System.out.println("执行结果"+reslut);
        return "seccuss";
    }
    //去修改页面
    @RequestMapping("/goWuyebxUpdate")
    public String goWuyebxUpdate(){
        System.out.println("进入修改页面");
        return "wuyebx_update";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateWuyebx")
    public String updateWuyebx(Wuyebx wuyebx){
        System.out.println("进入物业报修修改页面？？？？？？？？？？？？？？？");
        int r=wuyebxService.updateWuyebx(wuyebx);
        System.out.println("结果为："+r);
        return "success";
    }
    //条件查询
    @ResponseBody
    @RequestMapping("/ifWuyebx")
    public HashMap<String, Object> ifResident(String tiaojian,String canshu){
        Wuyebx wuyebx=new Wuyebx();
        switch (tiaojian){
            case "0":wuyebx.setWid(Long.parseLong(canshu));break;
            case "1":wuyebx.setWname(canshu);break;
            case "2":wuyebx.setWphone(canshu);break;
            case "3":wuyebx.setWtime(canshu);break;
            case "4":wuyebx.setWschedule(canshu);break;
        }
        List<Wuyebx> wuyebxes=wuyebxService.selectIf(wuyebx);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",wuyebxes);
        return rmap;
    }
    //转发到物业报修添加页面
    @RequestMapping("/goWuyebxMe")
    public String goWuyebxMe(){
        System.out.println("/goWuyebxMe被调用");
        return "wuyebx_me";
    }
    //用户查询报修信息
    @ResponseBody
    @RequestMapping("/wuyebxMeInfo")
    public HashMap<String, Object> wuyebxMeInfo(HttpServletRequest request){
        System.out.println("进入我的报修！");
        HashMap<String, Object> map = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        Resident resident=(Resident) session.getAttribute("userInfo");
        Wuyebx wuyebx=new Wuyebx();
        wuyebx.setWphone(resident.getJphone());
        List<Wuyebx> wuyebxes=wuyebxService.selectIf(wuyebx);
        map.put("rlist",wuyebxes);
        map.put("counts",wuyebxService.counts());
        return map;
    }
    //居民申报物业修理
    //转发到物业报修添加页面
    @RequestMapping("/goWuyebxAddme")
    public String goWuyebxAddMe(){
        System.out.println("/goWuyebxMe被调用");
        return "wuyebx_addme";
    }

    //添加
    @ResponseBody
    @RequestMapping("/wuyebxAddme")
    public String addmeWuyebx(Wuyebx wuyebx){
        System.out.println("进入到addResident方法接收参数"+wuyebx);
        wuyebx.setWid(System.currentTimeMillis());
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        wuyebx.setWtime(sdf.format(d));
        wuyebx.setWschedule("未处理");
        System.out.println(wuyebx);
        int r=wuyebxService.addOne(wuyebx);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
}
