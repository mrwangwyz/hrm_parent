package com.wyz.hrm.mapper;

import com.wyz.hrm.domain.Tenant;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyz
 * @since 2019-09-03
 */
public interface TenantMapper extends BaseMapper<Tenant> {

    void saveTenantMeals(List<Map<String,Long>> mealsMap);

    void removeTenantMeals(Serializable id);
}
