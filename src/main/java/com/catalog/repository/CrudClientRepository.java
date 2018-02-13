package com.catalog.repository;

import com.catalog.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Component
public interface CrudClientRepository extends JpaRepository<Client, Integer> {

    Client findByNameAndCar(String name, String car);

    Client findByName(String name);
}
