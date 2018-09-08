package casic.ht3.smartcity.radarplatform.test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import casic.ht3.smartcity.radarplatform.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void homePage() throws Exception {
        // N.B. jsoup can be useful for asserting HTML content
        mockMvc.perform(get("/index.html"))
                .andExpect(content().string(containsString("Get your greeting")));
    }

    @Test
    public void addCustomer() throws Exception {
        mockMvc.perform(post("/customer/add").param("id", "999999")
        		.param("name", "测试用户")
        		.param("address", "测试地点")
        		.param("gender", "男")
        		.param("phone_num", "")
        		.param("password", "123456"))
        		.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void deleteCustomer() throws Exception {
        mockMvc.perform(get("/customer/delete").param("id", "1"))
        		.andExpect(status().isOk())
        		.andDo(print());
    }
    
    @Test
    public void getAllCustomer() throws Exception {
        mockMvc.perform(get("/customer/all"))
        		.andExpect(status().isOk())
        		.andDo(print());
    }

}
