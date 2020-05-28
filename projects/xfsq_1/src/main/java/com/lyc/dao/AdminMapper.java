package com.lyc.dao;

import com.lyc.bean.Admin;
import com.lyc.bean.LoginForm;

import java.util.List;

public interface AdminMapper {
    //登录验证
    public Admin login(LoginForm loginForm);
    public List<Admin> selectAll();
    public int updatePw(Admin admin);
}
