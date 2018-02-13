package com.catalog.service;

import com.catalog.TimingRules;
import com.catalog.model.Car;
import com.catalog.model.Client;
import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Year;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@Configuration
public class CarClientServiceImplTest {

    @TestConfiguration
    static class CarClientServiceImplTestContextConfiguration {
        @Bean
        public CarClientService carClientService() {
            return Mockito.mock(CarClientService.class);
        }
    }

    @Autowired
    private CarClientService carClientService;

    @ClassRule
    public static ExternalResource summary = TimingRules.SUMMARY;

    @Rule
    public Stopwatch stopwatch = TimingRules.STOPWATCH;

    @Before
    public void setUp() {
        Client clientCreate = new Client("Mikhail", LocalDate.of(1988, 4, 20), "Mercedes");
        Mockito.when(carClientService.create("Mikhail", LocalDate.of(1988, 4, 20), "Mercedes", Year.of(1988))).thenReturn(clientCreate);
        Mockito.when(carClientService.delete("Mikhail", "Mercedes")).thenReturn(true);
    }

    @Test
    public void create() {
        Client found = carClientService.create("Mikhail", LocalDate.of(1988, 4, 20), "Mercedes", Year.of(1988));
        assertThat(found.getName()).isEqualTo("Mikhail");
    }



    @Test
    public void delete() {
        assertThat(carClientService.delete("Mikhail", "Mercedes")).isEqualTo(true);
    }


    @Test
    public void isClientExist() {

    }

}