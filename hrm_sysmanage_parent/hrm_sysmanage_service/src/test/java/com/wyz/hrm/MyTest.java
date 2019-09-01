package com.wyz.hrm;

import com.baomidou.mybatisplus.service.IService;
import com.wyz.hrm.domain.Systemdictionary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Sysmanage9001Application.class)
public class MyTest {
    @Autowired
    private IService<Systemdictionary> iService;
    @Test
    public void  testsave() throws Exception{
        for (Systemdictionary systemdictionary : iService.selectList(null)) {
            System.out.println(systemdictionary);
        }
    }
}
