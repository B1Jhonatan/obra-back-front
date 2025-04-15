package com.jaimes.back_calculadora.elementos3d.controller;

import com.jaimes.back_calculadora.elementos3d.service.ElementoService;
import com.jaimes.back_calculadora.elementos3d.dto.input.MedidasDTO;
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
    public ResponseEntity<?> areas(@RequestBody MedidasDTO medidasDTO){
        return ResponseEntity.ok(elementoService.area3D(medidasDTO));
    }

}
