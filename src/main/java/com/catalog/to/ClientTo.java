package com.catalog.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(value = "to.ClientTo")
public class ClientTo {
    @ApiModelProperty(notes = "The database generated ClientTo ID", hidden = true)
    private Integer id;
    @ApiModelProperty(notes = "The name of client", position = 0, example = "Mikhail")
    private String name;
    @ApiModelProperty(notes = "The car of client", position = 1, name = "model", example = "Ford Mustang")
    private String car;

    public ClientTo() {
    }

    public ClientTo(Integer id, String name, String car) {
        this.name = name;
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
        ClientTo clientTo = (ClientTo) o;
        return Objects.equals(id, clientTo.id) &&
                Objects.equals(name, clientTo.name) &&
                Objects.equals(car, clientTo.car);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, car);
    }

    @Override
    public String toString() {
        return "ClientTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", car='" + car + '\'' +
                '}';
    }
}
