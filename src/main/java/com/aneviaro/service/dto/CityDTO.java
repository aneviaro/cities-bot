package com.aneviaro.service.dto;

import com.aneviaro.domain.City;

import java.io.Serializable;
import java.util.Objects;

public class CityDTO implements Serializable {

    private Long id;
    private String name;
    private String description;

    public CityDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CityDTO(City city) {
        this.id=city.getId();
        this.name=city.getName();
        this.description=city.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO cityDTO = (CityDTO) o;
        return getId().equals(cityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
