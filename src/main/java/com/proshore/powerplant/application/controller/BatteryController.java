package com.proshore.powerplant.application.controller;

import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.BatteryResponse;
import com.proshore.powerplant.application.dto.Range;
import com.proshore.powerplant.application.service.BatteryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping("api/v1/batteries")
@AllArgsConstructor
public class BatteryController {

    private final BatteryService service;

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid @NotNull List<BatteryRequest> requests) {
        service.registerBatteries(requests);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping(value = "/info", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<BatteryResponse> range(@NotNull @NotEmpty @RequestParam("from") String from,
                                                 @NotNull @NotEmpty @RequestParam("to") String to) {
        return ResponseEntity.ok(service.batteryStatistics(new Range(from, to)));
    }
}
