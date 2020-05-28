package com.lyc.controller;

import com.lyc.bean.Admin;
import com.lyc.bean.LoginForm;

import com.lyc.bean.Resident;
import com.lyc.service.AdminService;
import com.lyc.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
@Controller

public class SystemController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ResidentService residentService;
    @GetMapping("/login")
    public String login(){
        System.out.println("GET login 被调用！");
        return "login";
    }
    @PostMapping ("/login")
    @ResponseBody
    public String login(LoginForm loginForm,HttpServletRequest request,HttpServletResponse response){

        System.out.println("login controller被调用！"+loginForm);

        switch (loginForm.getUserType()) {
            case 0:
                Resident resident = residentService.login(loginForm);
                if (resident != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userInfo", resident);
                    session.setAttribute("userPhone", loginForm.getUserName());
                    session.setAttribute("userType", loginForm.getUserType());
                    if (loginForm.isRememberMe()) {
                        try {
                            isMemory(loginForm, request, response);
                        } catch (Exception e) {
                            System.out.println("记住账号功能异常");
                        }
                    }
                    return "seccuss";
                }
                break;
            case 1:
                System.out.println("管理员");
                Admin admin = adminService.login(loginForm);
                System.out.println(admin+"这是管理员");
                if (admin != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userInfo", admin);
                    session.setAttribute("userPhone", loginForm.getUserName());
                    session.setAttribute("userType", loginForm.getUserType());
                    if (loginForm.isRememberMe()) {
                        try {
                            isMemory(loginForm, request, response);
                        } catch (Exception e) {
                            System.out.println("记住账号功能异常");
                        }
                    }
                    return "seccuss";
                }
                break;
            }
            return "登录失败";
        }
    /*
	 是否记忆密码
	 **/
    private void isMemory(LoginForm loginForm,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if (loginForm.isRememberMe()) {
            Cookie username = new Cookie("username", loginForm.getUserName());
            username.setPath("/");
            Cookie password = new Cookie("password", loginForm.getPassword());
            password.setPath("/");
            response.addCookie(username);
            response.addCookie(password);
            System.out.println("cookie设置成功");
        } else {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.equals("username") | cookie.equals("password")) {
                    cookie.setMaxAge(0);
                    ;
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }
    @RequestMapping("/goindex/{userType}")
    public String goIndex(@PathVariable("userType") int userType){
        System.out.println("goindex方法得到调用"+userType);
        if(userType==0){
            System.out.println("这是普通用户");
            return "index0";
        }else {
            System.out.println("这是管理员");
            return "index1";
        }
    }
    @GetMapping("/loginout")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("userInfo");
        request.getSession().removeAttribute("userType");

        //注销后重定向到登录页面
        try {
            response.sendRedirect("./login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //修改密码
    @RequestMapping("/goPassword")
    public String goPassword(){
        return "password_update";
    }
    @ResponseBody
    @RequestMapping("/password_update")
    public String passwordUpdate(String pass ,HttpServletRequest request){
        System.out.println("进入修改密码");
        System.out.println(pass+"嗡嗡嗡");
        HttpSession session = request.getSession();
        String phone= (String) session.getAttribute("userPhone");
        int type= (int) session.getAttribute("userType");

        if(type==1){
            Admin admin=new Admin();
            admin.setAphone(phone);
            admin.setApw(pass);
            adminService.updatePw(admin);
        }else {
            Resident resident=new Resident();
            resident.setJphone(phone);
            resident.setJpw(pass);
            residentService.updatePw(resident);
        }
        return "修改成功";
    }
    //
    @RequestMapping("/goinfo")
    public String goAllinfo(){
        return "info";
    }
}
