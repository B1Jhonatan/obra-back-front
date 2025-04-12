package com.jaimes.back_calculadora.elementos3d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Medidas3D")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medidas3D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Double largo;
    private Double ancho;
    private Double alto;

    @OneToOne
    @JoinColumn(name = "elemento3d_id")
    @JsonIgnore
    private Elementos3D elemento3D;

}
