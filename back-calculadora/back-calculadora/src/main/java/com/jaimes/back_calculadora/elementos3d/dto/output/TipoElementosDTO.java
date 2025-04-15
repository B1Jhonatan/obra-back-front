package com.jaimes.back_calculadora.elementos3d.dto.output;


import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoElementosDTO {

    private Integer id;
    private String Tipo;
    private List<Elemento3dDTO> elementos3D;

}
