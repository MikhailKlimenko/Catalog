package com.catalog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Year;
import java.util.Objects;

@ApiModel(value = "model.Car")
@Entity
@Table(name = "car")
@Access(AccessType.FIELD)
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @ApiModelProperty(notes = "The database generated Car ID", hidden = true)
    private Integer id;

    @Column(name = "model")
    @ApiModelProperty(notes = "The model car")
    private String model;

    @Column(name = "year")
    @ApiModelProperty(notes = "The year of manufactory a car")
    private Year year;

    @Column(name = "client")
    @ApiModelProperty(notes = "The client who took this car.")
    private String client;

    public Car() {
    }

    public Car(String model, Year year, String client) {
        this.model = model;
        this.year = year;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(model, car.model) &&
                Objects.equals(year, car.year) &&
                Objects.equals(client, car.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, year, client);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}