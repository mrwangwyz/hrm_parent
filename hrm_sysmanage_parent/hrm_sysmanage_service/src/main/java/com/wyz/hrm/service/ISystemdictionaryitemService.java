package com.wyz.hrm.service;

import com.wyz.hrm.domain.Systemdictionaryitem;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyz
 * @since 2019-08-30
 */
public interface ISystemdictionaryitemService extends IService<Systemdictionaryitem> {

    List<Systemdictionaryitem> selectBySn(String sn);
}
