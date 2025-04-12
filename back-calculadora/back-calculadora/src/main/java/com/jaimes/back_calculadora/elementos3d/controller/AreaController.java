package com.jaimes.back_calculadora.elementos3d.controller;

import com.jaimes.back_calculadora.elementos3d.entity.Areas3D;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elementos3d.service.ElementoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/medidas")
@AllArgsConstructor
public class AreaController {

    @Autowired
    private final ElementoService elementoService;

    @PostMapping("/calcular")
    public ResponseEntity<Areas3D> areas(@RequestBody Elementos3D elementos3D){
        return ResponseEntity.ok(elementoService.area3D(elementos3D));
    }

}
