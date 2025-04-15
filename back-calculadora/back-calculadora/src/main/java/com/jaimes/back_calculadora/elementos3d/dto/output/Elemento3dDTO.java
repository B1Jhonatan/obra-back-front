package com.jaimes.back_calculadora.elementos3d.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Elemento3dDTO {

    private Integer id;
    private String elemento;
    private Integer cantidad;
    private Double largo;
    private Double ancho;
    private Double alto;
    private Double areaUnitaria;
    private Double areaTotal;

}
