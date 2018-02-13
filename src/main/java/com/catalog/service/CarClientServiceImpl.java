package com.catalog.service;

import com.catalog.model.Car;
import com.catalog.model.Client;
import com.catalog.repository.CrudCarRepository;
import com.catalog.repository.CrudClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;

@Service
public class CarClientServiceImpl implements CarClientService {

    private CrudCarRepository carRepository;

    private CrudClientRepository clientRepository;

    public CarClientServiceImpl() {
    }

    @Autowired
    public CarClientServiceImpl(CrudCarRepository carRepository, CrudClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(String name, LocalDate birthDate, String model, Year year) {
        Client client = new Client(name, birthDate, model);
        clientRepository.save(client);
        carRepository.save(new Car(model, year, name));
        return clientRepository.findByName(name);
    }

    @Override
    public boolean delete(String name, String car) {
        Client client = clientRepository.findByNameAndCar(name, car);
        Car found = carRepository.findByModelAndClient(car, name);
        if (client != null && found.getModel().equals(car)) {
            clientRepository.delete(client);
            found.setClient("");
            carRepository.save(found);
            return true;
        }
        return false;
    }

    @Override
    public boolean isClientExist(String name) {
        return clientRepository.findByName(name) != null;
    }
}
