package com.lyc.controller;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.PageParams;
import com.lyc.bean.GongZry;
import com.lyc.service.GongZryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@Controller
public class GongZryController {
    @Autowired
    GongZryService gongZryService;
    // 跳转主页面
    @RequestMapping("/goGongZry")
    public String goMain(){
        return "gongzry";
    }
    // 查询所有
    @ResponseBody
    @RequestMapping("/gongZryList")
    public HashMap<String, Object> ActiveManList(PageParams pageParams){
        System.out.println("进入活动人员查询controller");
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageInfo<GongZry> pageInfo=gongZryService.selectAll(pageParams);
        List<GongZry> rlist = pageInfo.getList();
        //System.out.println(rlist);
        map.put("rlist", rlist);
        map.put("counts",gongZryService.counts());
        return map;
    }
    //条件查询
    @ResponseBody
    @RequestMapping("/findIfGongZry")
    public HashMap<String, Object> findIf(String tiaojian,String canshu){
        System.out.println("进入条件查询");
        System.out.println(canshu+tiaojian);
        GongZry gongZry=new GongZry();
        switch (tiaojian){
            case "0":gongZry.setGid(Long.parseLong(canshu));break;
            case "1":gongZry.setGname(canshu);break;
            case "2":gongZry.setGsex(canshu);break;
            case "3":gongZry.setGage(Integer.parseInt(canshu));break;
            case "4":gongZry.setGphone(canshu);break;
            case "5":gongZry.setGidcard(canshu);break;
            case "6":gongZry.setGpost(canshu);break;
            case "7":gongZry.setGtype(canshu);break;
        }
        List<GongZry> rlist=gongZryService.findIf(gongZry);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",rlist);
        return rmap;
    }
    // 跳转添加页面
    @RequestMapping("/goAddGongZry")
    public String goAddGongZry(){
        return "gongzry_add";
    }
    // 添加贫困
    @RequestMapping("/addGongZry")
    @ResponseBody
    public String addGongZry(GongZry gongZry){
        System.out.println("进入到addActiveInfo方法接收参数为"+gongZry);
        int r=gongZryService.gongZry_Add(gongZry);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
    // 跳转修改页面
    @RequestMapping("/goUpdateGongZry")
    public String goUpdateGongZry(){
        return "gongzry_update";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateGongZry")
    public String updateGongZry(GongZry gongZry){
        System.out.println("进入修改"+gongZry);
        int r=gongZryService.gongZry_Update(gongZry);
        System.out.println("结果为："+r);
        return "success";
    }
    //删除jp
    @RequestMapping("/delGongZry")
    @ResponseBody
    public String deleteGongZry(@RequestParam(value="gids[]",required=false) String[] gids){
        System.out.println("进入批量删除controller，接收参数为："+gids);
        System.out.println(gids[0]);
        int r=gongZryService.gongZry_Del(gids);
        System.out.println("执行结果"+r);
        return "seccuss";
    }

}
