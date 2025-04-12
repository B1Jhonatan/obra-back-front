package com.jaimes.back_calculadora.entity;

import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Elementos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String elemento;

    @OneToMany(mappedBy = "elemento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Elementos3D> elementos3D;

}
