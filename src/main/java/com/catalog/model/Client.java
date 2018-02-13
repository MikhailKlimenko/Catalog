package com.catalog.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "model.Client")
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @ApiModelProperty(notes = "The database generated Car ID")
    private Integer id;

    @Size(min = 3, max = 20)
    @Column(name = "first_name", unique = true)
    @ApiModelProperty(notes = "This is the Client's name")
    private String name;

    @Column(name = "birth_date")
    @ApiModelProperty(notes = "Birthday of the client.")
    private LocalDate birthDate;

    @Column(name = "car")
    @ApiModelProperty(notes = "Client's machine.")
    private String car;

    public Client() {
    }

    public Client(String name, LocalDate birthDate, String car) {
        this.name = name;
        this.birthDate = birthDate;
        this.car = car;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name) &&
                Objects.equals(birthDate, client.birthDate) &&
                Objects.equals(car, client.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, car);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", car='" + car + '\'' +
                '}';
    }
}