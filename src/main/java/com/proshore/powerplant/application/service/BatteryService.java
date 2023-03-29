package com.proshore.powerplant.application.service;

import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.BatteryResponse;
import com.proshore.powerplant.application.mapper.BatterMapper;
import com.proshore.powerplant.application.repository.BatteryRepository;
import com.proshore.powerplant.domain.model.BatteryStatistics;
import com.proshore.powerplant.domain.model.Range;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BatteryService {

    private final BatteryRepository repository;
    private final BatterMapper mapper;

    public void registerBatteries(List<BatteryRequest> requests) {
        repository.saveAll(mapper.toModels(requests));
    }

    public BatteryResponse batteryInfo(Integer from, Integer to) {
        return mapper.toResponse(new BatteryStatistics(repository.findByRange(new Range(from, to))));
    }
}
