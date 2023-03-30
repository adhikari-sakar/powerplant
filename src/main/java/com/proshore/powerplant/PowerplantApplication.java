package com.proshore.powerplant;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.exception.InvalidDataException;
import com.proshore.powerplant.application.mapper.BatteryMapper;
import com.proshore.powerplant.application.repository.BatteryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class PowerplantApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerplantApplication.class, args);
    }

}
