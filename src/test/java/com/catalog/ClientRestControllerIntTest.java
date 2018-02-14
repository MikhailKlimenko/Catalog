package com.catalog;

import com.catalog.to.ClientWithYearOfManufacture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Year;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringBoot.class)
public class ClientRestControllerIntTest {

//    @Autowired
//    private TestRestTemplate restTemplate;
//
//
//    @Test
//    public void createClient() throws Exception {
//        ResponseEntity responseEntity =
//                restTemplate.postForEntity("/client/create", new ClientWithYearOfManufacture("Mikhail", LocalDate.of(1988, 4, 20), "BMW", Year.of(1988)), ClientWithYearOfManufacture.class);
//        System.out.println(responseEntity.toString());
//    }
//

}
