package com.wyz.hrm.client;

import com.wyz.hrm.domain.Menu;
import com.wyz.hrm.query.MenuQuery;
import com.wyz.hrm.util.AjaxResult;
import com.wyz.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "RENLI-HRM-SYSMANAGE",configuration = FeignClientsConfiguration.class,
        fallbackFactory = MenuClientHystrixFallbackFactory.class)
@RequestMapping("/product/menu")
public interface MenuClient {
    /**
     * 保存和修改公用的
     * @param menu  传递的实体
     * @return Ajaxresult转换结果
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    AjaxResult save(Menu menu);

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @RequestMapping("/{id}")
    Menu get(@RequestParam(value="id",required=true) Long id);


    /**
     * 查看所有的员工信息
     * @return
     */
    @RequestMapping("/list")
    public List<Menu> list();

    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    PageList<Menu> json(@RequestBody MenuQuery query);
}
