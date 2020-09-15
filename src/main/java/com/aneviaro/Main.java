package com.aneviaro;

import com.aneviaro.repository.CityRepository;
import com.aneviaro.rest.CityResource;
import com.aneviaro.service.CityService;
import com.aneviaro.service.mapper.CityMapper;
import com.google.inject.internal.cglib.proxy.$Factory;
import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication()
@EnableJpaRepositories("com.aneviaro.repository")
public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(Main.class, args);
    }
}
