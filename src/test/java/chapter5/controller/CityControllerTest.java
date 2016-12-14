package chapter5.controller;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import javax.annotation.Resource;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/14.
 */
@ContextConfiguration(locations = { "classpath:application-test.xml" })
public class CityControllerTest {

    @Test
    public void testCityList() throws Exception {
        CityController cityController = new CityController();
        MockMvc mockMvc = standaloneSetup(cityController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("city_list"))
                .andExpect(forwardedUrl("/WEB-INF/views/home.jsp"))
                .andExpect(model().attribute("citis", hasSize(2)));
    }
}
