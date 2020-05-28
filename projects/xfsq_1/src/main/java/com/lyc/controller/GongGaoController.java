package com.lyc.controller;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.GongGao;
import com.lyc.bean.PageParams;
import com.lyc.service.GongGaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class GongGaoController {
    @Autowired
    GongGaoService gongGaoService;

    @RequestMapping("/goMyGongGaoMain")
    public String goMyGongGaoMain(){
        return "gonggao_me";
    }
    // 跳转管理员主页面
    @RequestMapping("/goGongGaoMain")
    public String goGongGaoMain(){
        return "gonggao";
    }
    // 查询所有
    @ResponseBody
    @RequestMapping("/gongGaoList")
    public HashMap<String, Object> ActiveManList(PageParams pageParams){
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageInfo<GongGao> pageInfo=gongGaoService.selectAll(pageParams);
        List<GongGao> rlist = pageInfo.getList();
        //System.out.println(rlist);
        map.put("rlist", rlist);
        map.put("counts",gongGaoService.counts());
        return map;
    }
    //条件查询
    @ResponseBody
    @RequestMapping("/findIfGongGao")
    public HashMap<String, Object> findIf(String tiaojian,String canshu){
        System.out.println("进入条件查询");
        System.out.println(canshu+tiaojian);
        GongGao gongGao=new GongGao();
        switch (tiaojian){
            case "0":gongGao.setGid(Long.parseLong(canshu));break;
            case "1":gongGao.setGname(canshu);break;
            case "2":gongGao.setGtype(canshu);break;
            case "3":gongGao.setGtime(canshu);
        }
        List<GongGao> rlist=gongGaoService.findIf(gongGao);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",rlist);
        return rmap;
    }
    // 跳转添加页面
    @RequestMapping("/goAddGongGao")
    public String goAddgongGao(){
        return "gonggao_add";
    }
    // 添加贫困
    @RequestMapping("/addGongGao")
    @ResponseBody
    public String addgongGao(GongGao gongGao){
        System.out.println("进入到addActiveInfo方法接收参数为"+gongGao);
        int r=gongGaoService.gongGao_Add(gongGao);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
    // 跳转修改页面
    @RequestMapping("/goUpdateGongGao")
    public String goUpdategongGao(){
        return "gonggao_update";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateGongGao")
    public String updategongGao(GongGao gongGao){
        System.out.println("进入修改"+gongGao);
        int r=gongGaoService.gongGao_Update(gongGao);
        System.out.println("结果为："+r);
        return "success";
    }
    //删除jp
    @RequestMapping("/delGongGao")
    @ResponseBody
    public String deletegongGao(@RequestParam(value="gids[]",required=false) String[] gids){
        System.out.println("进入批量删除controller，接收参数为："+gids);
        System.out.println(gids[0]);
        int r=gongGaoService.gongGao_Del(gids);
        System.out.println("执行结果"+r);
        return "seccuss";
    }

}
