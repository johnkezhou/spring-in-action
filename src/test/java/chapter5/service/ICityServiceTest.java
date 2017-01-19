package chapter5.service;

import chapter5.bean.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by daoya <daoya@2dfire.com> on 2017/1/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ICityServiceTest {

    @Autowired
    private ICityService cityService;

    @Test
    public void testList(){
        City city = cityService.queryByID(1);
        Assert.assertNotNull(city);
    }
}
