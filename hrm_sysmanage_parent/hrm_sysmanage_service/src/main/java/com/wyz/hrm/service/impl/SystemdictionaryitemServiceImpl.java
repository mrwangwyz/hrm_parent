package com.wyz.hrm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wyz.hrm.domain.Systemdictionary;
import com.wyz.hrm.domain.Systemdictionaryitem;
import com.wyz.hrm.mapper.SystemdictionaryMapper;
import com.wyz.hrm.mapper.SystemdictionaryitemMapper;
import com.wyz.hrm.service.ISystemdictionaryitemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2019-08-30
 */
@Service
public class SystemdictionaryitemServiceImpl extends ServiceImpl<SystemdictionaryitemMapper, Systemdictionaryitem> implements ISystemdictionaryitemService {

    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;
    @Autowired
    private SystemdictionaryMapper systemdictionaryMapper;
    @Override
    public List<Systemdictionaryitem> selectBySn(String sn) {
        List<Systemdictionary> systemdictionaries = systemdictionaryMapper
                .selectList(new EntityWrapper<Systemdictionary>().eq("sn", sn));
        Systemdictionary systemdictionary = systemdictionaries.get(0);
        return systemdictionaryitemMapper.selectList(new EntityWrapper<Systemdictionaryitem>()
                .eq("parent_id", systemdictionary.getId()));
    }
}
