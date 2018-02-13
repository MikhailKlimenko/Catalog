package com.catalog.repository;

import com.catalog.TimingRules;
import com.catalog.model.Car;
import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Year;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CrudCarRepositoryTest {

    @ClassRule
    public static ExternalResource summary = TimingRules.SUMMARY;

    @Rule
    public Stopwatch stopwatch = TimingRules.STOPWATCH;


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CrudCarRepository carRepository;

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("Mercedes", Year.of(1988), "Mikhail");
        entityManager.persist(car);
        entityManager.flush();
    }

    @Test
    public void findByModelAndYear() {
        Car found = carRepository.findByModelAndYear("Mercedes", Year.of(1988));
        assertThat(found.getClient()).isEqualTo("Mikhail");

    }

    @Test
    public void findByModelAndClient() {
        Car found = carRepository.findByModelAndClient("Mercedes", "Mikhail");
        assertThat(found.getClient()).isEqualTo("Mikhail");
    }

    @Test
    public void update() {
        car.setClient("Max");
        carRepository.save(car);
        assertThat(car.getClient()).isNotEqualTo("Mikhail");
    }
}