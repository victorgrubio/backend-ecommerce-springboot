package com.victorgarciarubio.ecommerce.integration_tests;

import com.victorgarciarubio.ecommerce.EcommerceApplication;
import com.victorgarciarubio.ecommerce.dao.StateRepository;
import com.victorgarciarubio.ecommerce.entity.Country;
import com.victorgarciarubio.ecommerce.entity.State;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class StateRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StateRepository repository;

    // write test cases here
    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {


        String code = "CODE";
        String stateName = "TEST STATE";
        Country country = new Country();
        country.setCode(code);
        State state = new State();
        state.setName(stateName);
        state.setCountry(country);
        repository.save(state);

        mvc.perform(get("/api/states")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("bob")));
    }
}