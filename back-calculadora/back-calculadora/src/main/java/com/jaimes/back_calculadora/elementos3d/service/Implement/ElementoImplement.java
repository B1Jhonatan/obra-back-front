package com.jaimes.back_calculadora.elementos3d.service.Implement;

import com.jaimes.back_calculadora.constantes.Constantes;
import com.jaimes.back_calculadora.elementos3d.repository.Area3dRepoository;
import com.jaimes.back_calculadora.elementos3d.service.dto.input.ElementoDTO;
import com.jaimes.back_calculadora.elementos3d.service.dto.input.MedidasDTO;
import com.jaimes.back_calculadora.elementos3d.service.dto.output.AreasDTO;
import com.jaimes.back_calculadora.elementos3d.service.dto.output.ElementoListaDTO;
import com.jaimes.back_calculadora.entity.Elemento;
import com.jaimes.back_calculadora.elementos3d.entity.Areas3D;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elementos3d.entity.Medidas3D;
import com.jaimes.back_calculadora.elementos3d.repository.Elemento3dRepository;
import com.jaimes.back_calculadora.elementos3d.repository.ElementoRepository;
import com.jaimes.back_calculadora.elementos3d.service.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementoImplement implements ElementoService {

    private final ElementoRepository elementoRepository;
    private final Elemento3dRepository elemento3dRepository;
    private final Area3dRepoository area3dRepoository;

    @Autowired
    public ElementoImplement(ElementoRepository elementoRepository,
                             Elemento3dRepository elemento3dRepository,
                             Area3dRepoository area3dRepoository) {
        this.elementoRepository = elementoRepository;
        this.elemento3dRepository = elemento3dRepository;
        this.area3dRepoository = area3dRepoository;
    }

    @Override
    public AreasDTO area3D(MedidasDTO medidasDTO) {
        AreasDTO areasDTO = new AreasDTO();
        double areaUnidad = ((medidasDTO.getLargo() * Constantes.METROS_A_MILIMETROS)
                * (medidasDTO.getAncho() * Constantes.METROS_A_MILIMETROS)
                * (medidasDTO.getAlto() * Constantes.METROS_A_MILIMETROS)
                / Constantes.MILIMETROS3_A_METROS3);
        double areaTotal = areaUnidad * medidasDTO.getCantidad();
        areasDTO.setAreaUnidad(areaUnidad);
        areasDTO.setAreaTotal(areaTotal);
        return areasDTO;
    }

    @Override
    public Elementos3D guardarElemento3d(ElementoDTO elementoDTO) {
        Elemento elemento = elementoRepository.findById(elementoDTO.getId()).orElse(null);
        Elementos3D elementos3D = new Elementos3D();
        elementos3D.setElemento3D(elementoDTO.getElemento());
        elementos3D.setCantidad(elementoDTO.getCantidad());
        elementos3D.setElemento(elemento);
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
        return elemento3dRepository.save(elementos3D);
    }

    @Override
    public Elementos3D actualizarElemento3d(ElementoDTO elementoDTO) {
        Elementos3D elementos3D = elemento3dRepository.findById(elementoDTO.getId()).orElse(null);
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
        return elemento3dRepository.save(elementos3D);
    }

    @Override
    public void eliminarElemento3d(Integer id) {
        elemento3dRepository.deleteById(id);
    }

    @Override
    public List<Elementos3D> todosElementos3d() {
        return elemento3dRepository.findAll();
    }

    @Override
    public List<ElementoListaDTO> todosElementos() {
        List<Elemento> elementosDb = elementoRepository.findAll();
        List<ElementoListaDTO> elementoListaDTOS = new ArrayList<>();
        for (Elemento e : elementosDb){
            ElementoListaDTO dto = new ElementoListaDTO(e.getId(), e.getElemento());
            elementoListaDTOS.add(dto);
        }
        return elementoListaDTOS;
    }

}
