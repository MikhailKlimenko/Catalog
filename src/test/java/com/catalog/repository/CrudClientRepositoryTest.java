package com.catalog.repository;

import com.catalog.TimingRules;
import com.catalog.model.Client;
import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.catalog.AssertMatchArrayClientTest.assertMatch;
import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CrudClientRepositoryTest {

    @ClassRule
    public static ExternalResource summary = TimingRules.SUMMARY;

    @Rule
    public Stopwatch stopwatch = TimingRules.STOPWATCH;

    @Autowired
    public Environment env;


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CrudClientRepository clientRepository;


    private ArrayList<Client> arrayList;
    private Client client;
    private Client client2;

    @Before
    public void setUp() throws Exception {
        client = new Client("Mikhail", LocalDate.of(1988, 4, 20), "Mercedes");
        entityManager.persist(client);
        entityManager.flush();
        client2 = new Client("Nikolay", LocalDate.of(1982, 7, 11), "BMW");
        entityManager.persist(client2);
        entityManager.flush();
        arrayList = new ArrayList<>();
        arrayList.add(client);
    }

    @Test
    public void findByNameAndModel() {
        Client found = clientRepository.findByNameAndCar("Mikhail", "Mercedes");
        assertThat(found.getName()).isEqualTo(client.getName());
    }

    @Test
    public void findByName() {
        Client found = clientRepository.findByName(client.getName());
        assertThat(found.getName()).isEqualTo(client.getName());
    }

    @Test(expected = NullPointerException.class)
    public void findByNameNullPointer() throws Exception {
        Client found = clientRepository.findByName("Andrey");
        assertThat(found.getName()).isEqualTo("Mikhail");
    }

    @Test
    public void create() {
        Client found = clientRepository.findByName(client.getName());
        assertThat(found.getName()).isEqualTo(client.getName());
    }

    @Test
    public void delete() {
        clientRepository.delete(client2);
        assertMatch(arrayList, clientRepository.findAll());
    }
}