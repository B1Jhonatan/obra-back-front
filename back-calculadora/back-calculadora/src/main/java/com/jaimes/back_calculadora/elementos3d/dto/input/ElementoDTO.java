package com.jaimes.back_calculadora.elementos3d.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementoDTO {

    private Integer id;
    private String tipo;
    private String elemento;
    private Integer cantidad;
    private Double largo;
    private Double ancho;
    private Double alto;
    private Double areaUnidad;
    private Double areaTotal;

}
