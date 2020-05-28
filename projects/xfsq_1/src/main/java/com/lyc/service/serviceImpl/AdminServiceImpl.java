package com.lyc.service.serviceImpl;

import com.lyc.bean.Admin;
import com.lyc.bean.LoginForm;
import com.lyc.dao.AdminMapper;
import com.lyc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admin login(LoginForm loginForm){return  adminMapper.login(loginForm);}

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public int updatePw(Admin admin) {
        return adminMapper.updatePw(admin);
    }

}
