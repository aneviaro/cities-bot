package com.aneviaro.service;

import com.aneviaro.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aneviaro.repository.CityRepository;
import com.aneviaro.service.dto.CityDTO;
import com.aneviaro.service.mapper.CityMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityService {

    private CityMapper cityMapper;

    @Autowired
    private CityRepository cityRepository;

    public CityService(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public CityDTO save(CityDTO cityDTO){
        City city = cityMapper.toEntity(cityDTO);
        city = cityRepository.save(city);
        return cityMapper.toDto(city);
    }

    public void delete(String name){
        cityRepository.deleteByName(name);
    }


    @Transactional(readOnly = true)
    public List<CityDTO> findAll(){
        return cityRepository.findAll().stream()
                .map(cityMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<CityDTO> findOne(Long id){
        return cityRepository.findById(id)
                .map(cityMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<CityDTO> findOneByName(String name){
        return cityRepository.findOneByName(name)
                .map(cityMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<String> getDescriptionByName(String name){
        return cityRepository.getDescriptionByName(name);
    }
}
