//package com.victorgarciarubio.ecommerce.unit_tests.repositories;
//
//import com.victorgarciarubio.ecommerce.dao.StateRepository;
//import com.victorgarciarubio.ecommerce.entity.Country;
//import com.victorgarciarubio.ecommerce.entity.State;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class TestStateRepository {
//
//    @Autowired
//    private StateRepository stateRepository;
//
//    @Test
//    public void getState() {
//        String code = "CODE";
//        String stateName = "TEST STATE";
//        Country country = new Country();
//        country.setCode(code);
//        State state = new State();
//        state.setName(stateName);
//        state.setCountry(country);
//        stateRepository.save(state);
//
//        List<State> foundStateList = stateRepository.findByCountryCode(code);
//        Assertions.assertEquals(stateName, foundStateList.get(0).getName());
//    }
//}