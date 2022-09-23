package com.example.miProyectoIntegradorV2.Repository;


import com.example.miProyectoIntegradorV2.Entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository<Turno,Long> {
}
