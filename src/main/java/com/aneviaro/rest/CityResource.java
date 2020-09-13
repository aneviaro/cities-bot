package com.aneviaro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aneviaro.service.CityService;
import com.aneviaro.service.dto.CityDTO;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class CityResource {

    private final CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/city/{name}")
    public ResponseEntity<CityDTO> findOne(@PathVariable String name){
        return ResponseEntity.of(cityService.findOneByName(name));
    }

    public Optional<String> getDescription(String name){
        return cityService.getDescriptionByName(name);
    }

}
