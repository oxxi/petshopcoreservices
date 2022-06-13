package com.jramos.petshopcoreservices.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "WareHouse")
@NoArgsConstructor
@Getter
@Setter
public class WareHouseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String Name;
    private String Description;
    private String Direction;
}
