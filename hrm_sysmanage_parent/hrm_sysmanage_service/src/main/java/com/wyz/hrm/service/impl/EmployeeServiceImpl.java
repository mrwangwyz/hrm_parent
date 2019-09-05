package com.wyz.hrm.service.impl;

import com.wyz.hrm.domain.Employee;
import com.wyz.hrm.mapper.EmployeeMapper;
import com.wyz.hrm.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2019-09-03
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
