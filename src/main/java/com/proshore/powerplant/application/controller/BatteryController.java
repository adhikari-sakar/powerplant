package com.proshore.powerplant.application.controller;

import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.BatteryResponse;
import com.proshore.powerplant.application.service.BatteryService;
import com.proshore.powerplant.domain.model.Range;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequestMapping("api/v1/batteries")
@AllArgsConstructor
public class BatteryController {

    private final BatteryService service;

    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid List<BatteryRequest> requests) {
        service.registerBatteries(requests);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info/{from}/{to}")
    @ResponseStatus(OK)
    public ResponseEntity<BatteryResponse> batteryInfo(@PathVariable("from") Integer from, @PathVariable("to") Integer to) {
        return ResponseEntity.ok(service.batteryInfo(from, to));
    }
}
