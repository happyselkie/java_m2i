package org.example.tp_parc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Processor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProcessor;

    private String brand;
    private String name;
}
