package com.aneviaro.service.mapper;

import com.aneviaro.domain.City;
import com.aneviaro.service.dto.CityDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityMapper{

    public CityDTO toDto(City city) {
        return new CityDTO(city);
    }

    public City toEntity(CityDTO cityDTO){
        if(cityDTO==null){
            return null;
        } else{
            City city = new City();
            city.setId(cityDTO.getId());
            city.setDescription(cityDTO.getDescription());
            city.setName(cityDTO.getName());
            return city;
        }
    }
}
