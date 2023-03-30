package com.proshore.powerplant.application.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.exception.InvalidDataException;
import com.proshore.powerplant.application.mapper.BatteryMapper;
import com.proshore.powerplant.application.repository.BatteryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

@Component
@AllArgsConstructor
public class BatteryLoader {

    private final BatteryMapper batteryMapper;
    private final BatteryRepository repository;

    @PostConstruct
    void load() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<BatteryRequest>> typeReference = new TypeReference<>() {};
        InputStream inputStream = getClass().getResourceAsStream("/data.json");
        try {
            List<BatteryRequest> users = mapper.readValue(inputStream, typeReference);
            repository.saveAll(batteryMapper.toModels(users));
        } catch (Exception e) {
            throw new InvalidDataException("Failed to read data");
        }
    }
}
