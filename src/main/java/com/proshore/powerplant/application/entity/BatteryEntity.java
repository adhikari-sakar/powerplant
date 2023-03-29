package com.proshore.powerplant.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "DRONE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatteryEntity extends BaseEntity {

    @Column(nullable = false, updatable = false)
    private String name;
    @Column(nullable = false, updatable = false)
    private String postCode;
    @Column(nullable = false, updatable = false)
    private Integer capacity;
}
