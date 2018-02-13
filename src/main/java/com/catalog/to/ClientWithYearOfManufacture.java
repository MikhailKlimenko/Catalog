package com.catalog.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.Year;

@ApiModel(value = "to.ClientWithYearOfManufacture")
public class ClientWithYearOfManufacture {

    @ApiModelProperty(notes = "The database generated ClientWithYearOfManufacture ID", hidden = true)
    private Integer id;
    @ApiModelProperty(notes = "The name of client", position = 0, example = "Mikhail")
    private String name;
    @ApiModelProperty(notes = "The birthday of client", position = 1, example = "1988-04-20")
    private LocalDate birthDate;
    @ApiModelProperty(notes = "The car of client", position = 2, example = "Ford Mustang")
    private String car;
    @ApiModelProperty(notes = "The year of car", position = 3, example = "1988")
    private Year yearOfManufactury;

    public ClientWithYearOfManufacture() {
    }

    public ClientWithYearOfManufacture(String name, LocalDate birthDate, String car, Year yearOfManufactury) {
        this.name = name;
        this.birthDate = birthDate;
        this.car = car;
        this.yearOfManufactury = yearOfManufactury;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Year getYearOfManufactury() {
        return yearOfManufactury;
    }

    public void setYearOfManufactury(Year yearOfManufactury) {
        this.yearOfManufactury = yearOfManufactury;
    }

    @Override
    public String toString() {
        return "ClientWithYearOfManufacture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", car='" + car + '\'' +
                ", yearOfManufactury=" + yearOfManufactury +
                '}';
    }
}
