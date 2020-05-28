package com.lyc.controller;

import com.github.pagehelper.PageInfo;
import com.lyc.bean.ActiveInfo;
import com.lyc.bean.PageParams;
import com.lyc.service.ActiveService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class ActiveInfoController {
    @Autowired
    private ActiveService activeService;

    @RequestMapping("/goActiveInfo")
    public String goActiveInfo(HttpServletRequest request){
        HttpSession session=request.getSession();
        int userType= (int) session.getAttribute("userType");
        System.out.println(userType);
        if ((int)userType == 0)
            return "active0";
        else
            return "active";
    }

    @ResponseBody
    @RequestMapping("/activeList")
    public HashMap<String, Object> ActiveList(PageParams pageParams){
        System.out.println("进入活动啦啦啦啦啦啦啦啦啦");
        HashMap<String, Object> map = new HashMap<String, Object>();
        PageInfo<ActiveInfo> pageInfo=activeService.selectAll(pageParams);
        List<ActiveInfo> rlist = pageInfo.getList();
        System.out.println(rlist);
        map.put("rlist", rlist);
        map.put("counts",activeService.counts());
        return map;
    }
    //批量删除
    @RequestMapping("/delActiveInfo")
    @ResponseBody
    public String deleteByid(@RequestParam(value="jids[]",required=false) String[] jids){
        System.out.println("进入批量删除controller，接收参数为："+jids);
        System.out.println(jids[0]);
        int reslut=activeService.deleteByid(jids);
        System.out.println("执行结果"+reslut);
        return "seccuss";
    }
    //添加
    @RequestMapping("/goAddActive")
    public String goAddactive(){
        return "active_add";
    }

    @RequestMapping("/addActiveInfo")
    @ResponseBody
    public String addActiveInfo(ActiveInfo activeInfo){
        System.out.println("进入到addActiveInfo方法接收参数为"+activeInfo);
        activeInfo.setHid(System.currentTimeMillis());
        int r=activeService.addOne(activeInfo);
        if (r>0){
            return "seccuss";
        }else {
            return "fail";
        }
    }
    //去修改
    @RequestMapping("/goActiveUpdate")
    public String goActiveUpdate(){
        return "active_update";
    }
    //修改
    @ResponseBody
    @RequestMapping("/updateActive")
    public String updateActive(ActiveInfo activeInfo){
        System.out.println("进入修改"+activeInfo);
        int r=activeService.updateActive(activeInfo);
        System.out.println("结果为："+r);
        return "success";
    }
    //条件查询
    @ResponseBody
    @RequestMapping("/ifActive")
    public HashMap<String, Object> ifActive(String tiaojian,String canshu){
        System.out.println("进入条件查询");
        System.out.println(canshu+tiaojian);
        ActiveInfo activeInfo=new ActiveInfo();
        switch (tiaojian){
            case "0":activeInfo.setHid(Long.parseLong(canshu));break;
            case "1":activeInfo.setHname(canshu);break;
            case "2":activeInfo.setHtype(canshu);break;
            case "3":activeInfo.setHtime(canshu);break;
            case "4":activeInfo.setHstatus(canshu);break;
        }
        List<ActiveInfo> rlist=activeService.selectIf(activeInfo);
        HashMap<String, Object> rmap = new HashMap<String, Object>();
        rmap.put("rlist",rlist);
        return rmap;
    }
}
