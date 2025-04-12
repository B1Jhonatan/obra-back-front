package com.jaimes.back_calculadora.elementos3d.controller;

import com.jaimes.back_calculadora.elementos3d.service.dto.input.ElementoDTO;
import com.jaimes.back_calculadora.elementos3d.service.ElementoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> guardar(@RequestBody ElementoDTO elementoDTO){
        return ResponseEntity.ok(elementoService.guardarElemento3d(elementoDTO));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ElementoDTO elementoDTO){
        return ResponseEntity.ok(elementoService.actualizarElemento3d(elementoDTO));
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> elimirar (@PathVariable Integer id){
        elementoService.eliminarElemento3d(id);
        return ResponseEntity.ok("Eliminado");
    }

}
