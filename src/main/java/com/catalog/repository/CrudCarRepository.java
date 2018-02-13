package com.catalog.repository;

import com.catalog.model.Car;
import com.catalog.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.time.Year;

@Component
public interface CrudCarRepository extends JpaRepository<Car, Integer> {

    Car findByModelAndYear(String model, Year year);

    Car findByModelAndClient(String model, String client);


}
