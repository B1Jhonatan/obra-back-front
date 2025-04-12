package com.jaimes.back_calculadora.elementos3d.controller;

import com.jaimes.back_calculadora.elementos3d.service.dto.output.ElementoListaDTO;
import com.jaimes.back_calculadora.entity.Elemento;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elementos3d.service.ElementoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elementos")
@CrossOrigin("*")
@AllArgsConstructor
public class ElementosController {

    private final ElementoService elementoService;

    @GetMapping("/tipos")
    public ResponseEntity<?> elementos(){
        return ResponseEntity.ok(elementoService.todosElementos());
    }

    @GetMapping("/todos")
    public ResponseEntity<?> elementos3d(){
        return ResponseEntity.ok(elementoService.todosElementos3d());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Elemento elemento){
        return ResponseEntity.ok(elementoService.guardarElemento(elemento));
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> elimirar (@PathVariable Integer id){
        elementoService.eliminarElemento(id);
        return ResponseEntity.ok("Eliminado");
    }

}
