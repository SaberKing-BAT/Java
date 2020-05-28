package com.lyc.service;

import com.lyc.bean.Admin;
import com.lyc.bean.LoginForm;

import java.util.List;

public interface AdminService {
    public Admin login(LoginForm loginForm);
    public List<Admin> selectAll();
    public int updatePw(Admin admin);
}
