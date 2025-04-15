package com.jaimes.back_calculadora.elementos3d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaimes.back_calculadora.entity.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Elementos3D")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elementos3D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String elemento3D;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    @JsonIgnore
    private Tipo tipo;

    @OneToOne(mappedBy = "elemento3D", cascade = CascadeType.ALL, orphanRemoval = true)
    private Medidas3D medidas;

    @OneToOne(mappedBy = "elemento3D", cascade = CascadeType.ALL, orphanRemoval = true)
    private Areas3D areas;

}
