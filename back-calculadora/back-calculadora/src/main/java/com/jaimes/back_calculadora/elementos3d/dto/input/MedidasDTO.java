package com.jaimes.back_calculadora.elementos3d.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedidasDTO {

    private Double largo;
    private Double ancho;
    private Double alto;
    private Integer cantidad;

}
