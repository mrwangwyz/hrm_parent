package com.wyz.hrm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wyz.hrm.domain.Employee;
import com.wyz.hrm.domain.Tenant;
import com.wyz.hrm.mapper.EmployeeMapper;
import com.wyz.hrm.mapper.TenantMapper;
import com.wyz.hrm.service.ITenantService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2019-09-03
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {
    @Autowired
    private TenantMapper tenantMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public boolean insert(Tenant entity) {
        // 添加机构
        entity.setRegisterTime(new Date());
        entity.setState(false);
        tenantMapper.insert(entity);
        // 添加管理员
        Employee adminUser = entity.getAdminUser();
        adminUser.setInputTime(new Date());
        adminUser.setState(0);
        adminUser.setType(true);
        adminUser.setTenantId(entity.getId());
        employeeMapper.insert(adminUser);
        // 添加套餐中间表
        tenantMapper.saveTenantMeals(entity.getMealsMap());
        return true;
    }

    @Override
    public boolean deleteById(Serializable id) {
        // 删除 机构
        tenantMapper.deleteById(id);
        // 删除管理员
        employeeMapper.delete(new EntityWrapper<Employee>().eq("tenant_id", id));
        // 删除套餐中间表
        tenantMapper.removeTenantMeals(id);
        return true;
    }

    @Override
    public boolean updateById(Tenant entity) {
        // 修改机构
        tenantMapper.updateById(entity);
        // 修改管理员
        employeeMapper.updateById(entity.getAdminUser());
        // 修改中间表  先删除  再添加
        tenantMapper.removeTenantMeals(entity.getId());
        tenantMapper.saveTenantMeals(entity.getMealsMap());
        return true;
    }
}
