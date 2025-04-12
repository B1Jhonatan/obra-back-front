package com.jaimes.back_calculadora.elementos3d.service.Implement;

import com.jaimes.back_calculadora.constantes.Constantes;
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

    @Autowired
    public ElementoImplement(ElementoRepository elementoRepository, Elemento3dRepository elemento3dRepository) {
        this.elementoRepository = elementoRepository;
        this.elemento3dRepository = elemento3dRepository;
    }

    @Override
    public Areas3D area3D(Elementos3D elementos3D) {
        Medidas3D medidas3D = elementos3D.getMedidas();
        Areas3D areas3D = new Areas3D();
        double areaUnidad = ((medidas3D.getLargo() * Constantes.METROS_A_MILIMETROS)
                * (medidas3D.getAncho() * Constantes.METROS_A_MILIMETROS)
                * (medidas3D.getAlto() * Constantes.METROS_A_MILIMETROS)
                / Constantes.MILIMETROS3_A_METROS3);
        double areaTotal = areaUnidad * elementos3D.getCantidad();
        areas3D.setAreaUnidad(areaUnidad);
        areas3D.setAreaTotal(areaTotal);
        return areas3D;
    }

    @Override
    public Elemento guardarElemento(Elemento elemento) {
        for (Elementos3D e3d : elemento.getElementos3D()) {
            e3d.setElemento(elemento);
            if (e3d.getMedidas() != null) {
                e3d.getMedidas().setElemento3D(e3d);
            }
            if (e3d.getAreas() != null) {
                e3d.getAreas().setElemento3D(e3d);
            }
        }
        return elementoRepository.save(elemento);
    }

    @Override
    public void eliminarElemento(Integer id) {
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
