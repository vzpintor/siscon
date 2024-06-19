package com.siscon.challenge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "clasification")
public class Classification {

    @Id
    private Integer id;
    private String name;
}
