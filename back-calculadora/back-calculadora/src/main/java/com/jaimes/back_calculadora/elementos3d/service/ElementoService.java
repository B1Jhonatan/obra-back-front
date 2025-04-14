package com.jaimes.back_calculadora.elementos3d.service;

import com.jaimes.back_calculadora.elementos3d.service.dto.input.ElementoDTO;
import com.jaimes.back_calculadora.elementos3d.service.dto.input.MedidasDTO;
import com.jaimes.back_calculadora.elementos3d.service.dto.output.AreasDTO;
import com.jaimes.back_calculadora.elementos3d.service.dto.output.ElementoListaDTO;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ElementoService {

    AreasDTO area3D(MedidasDTO medidasDTO);
    List<ElementoListaDTO> todosElementos();
    List<Elementos3D> todosElementos3d();
    Elementos3D guardarElemento3d(ElementoDTO elementoDTO);
    Elementos3D actualizarElemento3d(ElementoDTO elementoDTO);
    void eliminarElemento3d(Integer id);

}
