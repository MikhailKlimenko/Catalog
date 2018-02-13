package com.catalog.service;


import com.catalog.model.Client;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;

@Component
public interface CarClientService {

    boolean isClientExist(String name);

    Client create(String name, LocalDate birthDate, String car, Year year);

    boolean delete(String name, String model);

}
