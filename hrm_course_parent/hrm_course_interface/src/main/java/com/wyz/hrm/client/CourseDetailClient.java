package com.wyz.hrm.client;

import com.wyz.hrm.domain.CourseDetail;
import com.wyz.hrm.query.CourseDetailQuery;
import com.wyz.hrm.util.AjaxResult;
import com.wyz.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "RENLI-HRM-COURSE",configuration = FeignClientsConfiguration.class,
        fallbackFactory = CourseDetailClientHystrixFallbackFactory.class)
@RequestMapping("/product/courseDetail")
public interface CourseDetailClient {
    /**
     * 保存和修改公用的
     * @param courseDetail  传递的实体
     * @return Ajaxresult转换结果
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    AjaxResult save(CourseDetail courseDetail);

    /**
     * 删除对象信息
     * @param id
     * @return
     */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @RequestMapping("/{id}")
    CourseDetail get(@RequestParam(value="id",required=true) Long id);


    /**
     * 查看所有的员工信息
     * @return
     */
    @RequestMapping("/list")
    public List<CourseDetail> list();

    /**
     * 分页查询数据
     *
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    PageList<CourseDetail> json(@RequestBody CourseDetailQuery query);
}
