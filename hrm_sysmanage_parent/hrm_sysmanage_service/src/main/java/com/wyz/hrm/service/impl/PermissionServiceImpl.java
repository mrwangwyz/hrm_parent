package com.wyz.hrm.service.impl;

import com.wyz.hrm.domain.Permission;
import com.wyz.hrm.mapper.PermissionMapper;
import com.wyz.hrm.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
