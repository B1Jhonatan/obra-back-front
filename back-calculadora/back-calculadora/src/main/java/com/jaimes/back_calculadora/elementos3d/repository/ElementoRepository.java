package com.jaimes.back_calculadora.elementos3d.repository;

import com.jaimes.back_calculadora.entity.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento, Integer> {
}
