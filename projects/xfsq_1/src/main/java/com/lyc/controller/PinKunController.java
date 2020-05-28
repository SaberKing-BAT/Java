package com.lyc.controller;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.*;
import com.lyc.service.PinKunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;

@Controller
public class PinKunController {
    @Autowired
    PinKunService pinKunService;
    // 跳转主页面
    @RequestMapping("/goMain")
    public String goMain(){
        return "pinkun";
    }
    // 查询所有
    @ResponseBody
    @RequestMapping("/pinKunList")
    public HashMap<String, Object> ActiveManList(PageParams pageParams){
        System.out.println("进入活动人员查询controller");
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageInfo<PinKun> pageInfo=pinKunService.selectAll(pageParams);
        List<PinKun> rlist = pageInfo.getList();
        //System.out.println(rlist);
        map.put("rlist", rlist);
        map.put("counts",pinKunService.counts());
        return map;
    }
    //条件查询
    @ResponseBody
    @RequestMapping("/findIfPinKun")
    public HashMap<String, Object> findIf(String tiaojian,String canshu){
        System.out.println("进入条件查询");
        System.out.println(canshu+tiaojian);
        PinKun pinKun=new PinKun();
        switch (tiaojian){
            case "0":pinKun.setPid(canshu);break;
            case "1":pinKun.setPname(canshu);break;
            case "2":pinKun.setSchedule(canshu);break;
            case "3":pinKun.setTime(canshu);break;
        }
        List<PinKun> rlist=pinKunService.findIf(pinKun);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",rlist);
        return rmap;
    }
    // 跳转添加页面
    @RequestMapping("/goAddPinKun")
    public String goAddPinKun(){
        return "pinkun_add";
    }
    // 添加贫困
    @RequestMapping("/addPinKun")
    @ResponseBody
    public String addPinKun(PinKun pinKun){
        System.out.println("进入到addActiveInfo方法接收参数为"+pinKun);
        int r=pinKunService.pinKun_Add(pinKun);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
    // 跳转修改页面
    @RequestMapping("/goUpdatePinKun")
    public String goUpdatePinKun(){
        return "pinkun_update";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updatePinKun")
    public String updatePinKun(PinKun pinKun){
        System.out.println("进入修改"+pinKun);
        int r=pinKunService.pinKun_Update(pinKun);
        System.out.println("结果为："+r);
        return "success";
    }
    //删除jp
    @RequestMapping("/delPinKun")
    @ResponseBody
    public String deletePinKun(@RequestParam(value="pids[]",required=false) String[] pids){
        System.out.println("进入批量删除controller，接收参数为："+pids);
        System.out.println(pids[0]);
        int r=pinKunService.pinKun_Del(pids);
        System.out.println("执行结果"+r);
        return "seccuss";
    }

    //————————————————————————————————用户——————————————————————————————
    // 跳转主页面
    @RequestMapping("/goMainMe")
    public String goMainMe(){
        return "pinkun_me";
    }

    // 查询用户的
    @ResponseBody
    @RequestMapping("/myPinKun")
    public HashMap<String, Object> myPinKunList(@SessionAttribute("userInfo") Resident userInfo){
        System.out.println("进入我的贫困查询controller");
        PinKun pinKun=new PinKun();
        pinKun.setPid(userInfo.getJid());
        List<PinKun> rlist=pinKunService.findIf(pinKun);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",rlist);
        return rmap;
    }
    // 跳转添加页面
    @RequestMapping("/goAddPinKunMe")
    public String goAddPinKunMe(){
        return "pinkun_addme";
    }
    // 添加贫困
    @RequestMapping("/addPinKunMe")
    @ResponseBody
    public String addPinKunMe(PinKun pinKun){
        System.out.println("进入到addActiveInfo方法接收参数为"+pinKun);
        pinKun.setSchedule("待审核");
        int r=pinKunService.pinKun_Add(pinKun);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
}
