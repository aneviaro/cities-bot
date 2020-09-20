package com.aneviaro.rest;

import com.aneviaro.domain.City;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.aneviaro.service.CityService;
import com.aneviaro.service.dto.CityDTO;

import javax.ws.rs.BadRequestException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityResource {

    private static final String ENTITY_NAME = "city";
    private final CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/city")
    public ResponseEntity<CityDTO> addOne(@RequestBody CityDTO cityDTO) throws URISyntaxException {
        if(cityDTO.getId()!=null){
            throw new BadRequestException("A new city cannot already have an ID");
        } else{
            CityDTO result = cityService.save(cityDTO);
            return ResponseEntity.created(new URI("/api/city/" + result.getId())).body(result);
        }
    }

    @PutMapping("/city")
    public ResponseEntity<CityDTO> updateOne(@RequestBody CityDTO cityDTO) {
        if (cityDTO.getId() == null) {
            throw new BadRequestException("Invalid id");
        }
        CityDTO result = cityService.save(cityDTO);
        return ResponseEntity.ok()
                .body(result);
    }

    @DeleteMapping("/city/{name}")
    public ResponseEntity<Void> deleteCity(@PathVariable String name){
        cityService.delete(name);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/city/{name}")
    public ResponseEntity<CityDTO> findOne(@PathVariable String name){
        return ResponseEntity.of(cityService.findOneByName(name));
    }

    public Optional<String> getDescription(String name){
        return cityService.getDescriptionByName(name);
    }

}
