package com.jaimes.back_calculadora.elementos3d.service.Implement;

import com.jaimes.back_calculadora.elementos3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.TipoElementosDTO;
import com.jaimes.back_calculadora.elementos3d.utilidades.Asignacion;
import com.jaimes.back_calculadora.elementos3d.utilidades.Constantes;
import com.jaimes.back_calculadora.elementos3d.repository.Area3dRepoository;
import com.jaimes.back_calculadora.elementos3d.dto.input.ElementoDTO;
import com.jaimes.back_calculadora.elementos3d.dto.input.MedidasDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.AreasDTO;
import com.jaimes.back_calculadora.elementos3d.dto.output.TipoListaDTO;
import com.jaimes.back_calculadora.entity.Tipo;
import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elementos3d.repository.Elemento3dRepository;
import com.jaimes.back_calculadora.elementos3d.repository.ElementoRepository;
import com.jaimes.back_calculadora.elementos3d.service.ElementoService;
import jakarta.persistence.EntityNotFoundException;
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
        Elementos3D elementos3D = Asignacion.elementos3dGuardar(elementoDTO);
        return elemento3dRepository.save(elementos3D);
    }

    @Override
    public Elementos3D actualizarElemento3d(ElementoDTO elementoDTO) {
        Elementos3D elementos3D = elemento3dRepository.findById(elementoDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Elemento3D no encontrado"));;
        elementos3D = Asignacion.elementos3dActualizar(elementoDTO, elementos3D);
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
    public List<TipoListaDTO> todosTipos() {
        List<Tipo> elementosDb = elementoRepository.findAll();
        List<TipoListaDTO> tipoListaDTOS = new ArrayList<>();
        for (Tipo e : elementosDb){
            TipoListaDTO dto = new TipoListaDTO(e.getId(), e.getTipo());
            tipoListaDTOS.add(dto);
        }
        return tipoListaDTOS;
    }

    @Override
    public Elemento3dDTO unElemetnoById(Integer id) {
        Elementos3D elementos3D = elemento3dRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el elemento"));
        return Asignacion.convertirElemento3dDTO(elementos3D);
    }

    @Override
    public TipoElementosDTO todosTipoElementos(Integer id) {
        Tipo tipo = elementoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el elemento"));
        return Asignacion.tipoElementosDTO(tipo);
    }
}
