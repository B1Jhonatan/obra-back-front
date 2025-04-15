package com.jaimes.back_calculadora.elementos3d.repository;

import com.jaimes.back_calculadora.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoRepository extends JpaRepository<Tipo, Integer> {
}
