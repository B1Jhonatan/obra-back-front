package com.jaimes.back_calculadora.elementos3d.utilidades;

import com.jaimes.back_calculadora.elementos3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.TipoElementosDTO;
import com.jaimes.back_calculadora.elementos3d.entity.Areas3D;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elementos3d.entity.Medidas3D;
import com.jaimes.back_calculadora.elementos3d.dto.input.ElementoDTO;
import com.jaimes.back_calculadora.entity.Tipo;

import java.util.ArrayList;
import java.util.List;

public class Asignacion {

    public static Elementos3D elementos3dGuardar(ElementoDTO elementoDTO){
        Elementos3D elementos3D = new Elementos3D();
        Tipo tipo = new Tipo();
        tipo.setId(elementoDTO.getId());
        tipo.setTipo(elementoDTO.getTipo());
        elementos3D.setElemento3D(elementoDTO.getElemento());
        elementos3D.setCantidad(elementoDTO.getCantidad());
        elementos3D.setTipo(tipo);
        Medidas3D medidas3D = new Medidas3D();
        medidas3D.setLargo(elementoDTO.getLargo());
        medidas3D.setAncho(elementoDTO.getAncho());
        medidas3D.setAlto(elementoDTO.getAlto());
        medidas3D.setElemento3D(elementos3D);
        elementos3D.setMedidas(medidas3D);
        Areas3D areas3D = new Areas3D();
        areas3D.setAreaUnidad(elementoDTO.getAreaUnidad());
        areas3D.setAreaTotal(elementoDTO.getAreaTotal());
        areas3D.setElemento3D(elementos3D);
        elementos3D.setAreas(areas3D);
        return elementos3D;
    }

    public static Elementos3D elementos3dActualizar(ElementoDTO elementoDTO, Elementos3D elementos3D){
        elementos3D.setElemento3D(elementoDTO.getElemento());
        elementos3D.setCantidad(elementoDTO.getCantidad());
        Medidas3D medidas3D = elementos3D.getMedidas();
        medidas3D.setLargo(elementoDTO.getLargo());
        medidas3D.setAncho(elementoDTO.getAncho());
        medidas3D.setAlto(elementoDTO.getAlto());
        medidas3D.setElemento3D(elementos3D);
        Areas3D areas3D = elementos3D.getAreas();
        areas3D.setAreaUnidad(elementoDTO.getAreaUnidad());
        areas3D.setAreaTotal(elementoDTO.getAreaTotal());
        areas3D.setElemento3D(elementos3D);
        elementos3D.setMedidas(medidas3D);
        elementos3D.setMedidas(medidas3D);
        elementos3D.setAreas(areas3D);
        return elementos3D;
    }

    public static Elemento3dDTO convertirElemento3dDTO(Elementos3D elementos3D){
        Elemento3dDTO elemento3dDTO = new Elemento3dDTO();
        elemento3dDTO.setId(elementos3D.getId());
        elemento3dDTO.setElemento(elementos3D.getElemento3D());
        elemento3dDTO.setCantidad(elementos3D.getCantidad());
        elemento3dDTO.setLargo(elementos3D.getMedidas().getLargo());
        elemento3dDTO.setAncho(elementos3D.getMedidas().getAncho());
        elemento3dDTO.setAlto(elementos3D.getMedidas().getAlto());
        elemento3dDTO.setAreaUnitaria(elementos3D.getAreas().getAreaUnidad());
        elemento3dDTO.setAreaTotal(elementos3D.getAreas().getAreaTotal());
        return elemento3dDTO;
    }

    public static TipoElementosDTO tipoElementosDTO(Tipo tipo) {
        TipoElementosDTO tipoElementosDTO = new TipoElementosDTO();
        tipoElementosDTO.setId(tipo.getId());
        tipoElementosDTO.setTipo(tipo.getTipo());
        List<Elemento3dDTO> listaDTO = new ArrayList<>();
        for (Elementos3D e : tipo.getElementos3D()) {
            Elemento3dDTO dto = new Elemento3dDTO();
            dto.setId(e.getId());
            dto.setElemento(e.getElemento3D()); // asumiendo que e.getElemento() es otra entidad
            dto.setCantidad(e.getCantidad());
            dto.setLargo(e.getMedidas().getLargo());
            dto.setAncho(e.getMedidas().getAncho());
            dto.setAlto(e.getMedidas().getAlto());
            dto.setAreaUnitaria(e.getAreas().getAreaUnidad());
            dto.setAreaTotal(e.getAreas().getAreaTotal());
            listaDTO.add(dto);
        }
        tipoElementosDTO.setElementos3D(listaDTO);
        return tipoElementosDTO;
    }

}
