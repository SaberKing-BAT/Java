package com.lyc.controller;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.ActiveInfo;
import com.lyc.bean.ActiveMan;
import com.lyc.bean.PageParams;
import com.lyc.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.List;

@Controller
public class ActiveManController {

    @Autowired
    ActiveService activeService ;

    @RequestMapping("/goActiveMan")
     public String goActiveMan(){
        return "activeman";
    }
    // 查询所有
    @ResponseBody
    @RequestMapping("/activeManList")
    public HashMap<String, Object> ActiveManList(PageParams pageParams){
        System.out.println("进入活动人员查询controller");
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageInfo<ActiveMan> pageInfo=activeService.selectAllman(pageParams);
        List<ActiveMan> rlist = pageInfo.getList();
        //System.out.println(rlist);
        map.put("rlist", rlist);
        map.put("counts",activeService.manCounts());
        return map;
    }
    // 批量删除
    @RequestMapping("/delActiveMan")
    @ResponseBody
    public String deleteByid(@RequestParam(value="aaids[]",required=false) String[] aaids){
        System.out.println("进入批量删除controller，接收参数为："+aaids);
        System.out.println(aaids[0]);
        int reslut=activeService.deleteManByid(aaids);
        System.out.println("执行结果"+reslut);
        return "seccuss";
    }
    //添加人员
    @RequestMapping("/ActiveManAdd")
    @ResponseBody
    public String addActiveInfo(@SessionAttribute("userPhone") String userPhone,long aid){
        System.out.println("进入到addActiveMan方法接收参数为"+aid+"电话"+userPhone);
        ActiveMan activeMan = new ActiveMan();
        activeMan.setAid(aid);
        activeMan.setAaid(System.currentTimeMillis());
        activeMan.setAphone(userPhone);
        activeMan.setSchedule("审核中");
        activeMan.setAresult("优秀");
        int r=activeService.addMan(activeMan);
        if (aid>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
    //去修改
    @RequestMapping("/goActiveManUpdate")
    public String goActiveUpdate(){
        return "activeman_update";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateActiveMan")
    public String updateActive(ActiveMan activeMan ){
        System.out.println("进入修改");
        System.out.println(activeMan);
        int r=activeService.updateActiveMan(activeMan);
        System.out.println("结果为："+r);
        return "success";
    }
    //条件查询
    @ResponseBody
    @RequestMapping("/ifActiveMan")
    public HashMap<String, Object> ifActive(long aaid){
        System.out.println("进入条件查询");
        System.out.println(aaid);
        ActiveMan activeMan = new ActiveMan();
        activeMan.setAaid(aaid);
        List<ActiveMan> rlist=activeService.selectIfMan(activeMan);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",rlist);
        return rmap;
    }
}
