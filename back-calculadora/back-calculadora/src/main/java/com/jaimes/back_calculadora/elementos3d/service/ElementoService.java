package com.jaimes.back_calculadora.elementos3d.service;

import com.jaimes.back_calculadora.elementos3d.service.dto.output.ElementoListaDTO;
import com.jaimes.back_calculadora.entity.Elemento;
import com.jaimes.back_calculadora.elementos3d.entity.Areas3D;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;

import java.util.List;

public interface ElementoService {

    Areas3D area3D(Elementos3D elementos3D);
    List<ElementoListaDTO> todosElementos();
    List<Elementos3D> todosElementos3d();
    Elemento guardarElemento(Elemento elemento);
    void eliminarElemento(Integer id);

}
