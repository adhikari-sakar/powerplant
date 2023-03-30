package com.proshore.powerplant.application.controller;

import com.proshore.powerplant.application.dto.BatteryRequest;
import com.proshore.powerplant.application.dto.BatteryResponse;
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
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping("api/v1/batteries")
@AllArgsConstructor
public class BatteryController {

    private final BatteryService service;

    @PostMapping(value = "/register", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid @NotNull List<BatteryRequest> requests) {
        service.registerBatteries(requests);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/info/{from}/{to}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<BatteryResponse> statistics(@NotNull @NotEmpty @PathVariable("from") String from,
                                                      @NotNull @NotEmpty @PathVariable("to") String to) {
        return ResponseEntity.ok(service.batteryStatistics(from, to));
    }
}
