package com.aneviaro.repository;

import com.aneviaro.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findOneByName(String name);

    @Query("select description from City c where c.name = :name")
    Optional<String> getDescriptionByName(@Param("name") String name);
}
