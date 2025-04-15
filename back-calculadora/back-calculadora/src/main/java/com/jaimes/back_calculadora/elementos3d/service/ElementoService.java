package com.jaimes.back_calculadora.elementos3d.service;

import com.jaimes.back_calculadora.elementos3d.dto.input.ElementoDTO;
import com.jaimes.back_calculadora.elementos3d.dto.input.MedidasDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.AreasDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.TipoElementosDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.TipoListaDTO;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;

import java.util.List;

public interface ElementoService {

    AreasDTO area3D(MedidasDTO medidasDTO);
    TipoElementosDTO todosTipoElementos(Integer id);
    List<TipoListaDTO> todosTipos();
    List<Elementos3D> todosElementos3d();
    Elemento3dDTO unElemetnoById(Integer id);
    Elementos3D guardarElemento3d(ElementoDTO elementoDTO);
    Elementos3D actualizarElemento3d(ElementoDTO elementoDTO);
    void eliminarElemento3d(Integer id);

}
