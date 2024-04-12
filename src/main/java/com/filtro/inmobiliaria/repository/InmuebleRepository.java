package com.filtro.inmobiliaria.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.filtro.inmobiliaria.repository.entities.Inmueble;



public interface InmuebleRepository extends JpaRepository<Inmueble, Long>{
    

    String LISTADO_ESTANCIAS = "SELECT COUNT(*) AS cantidad, e.nombre AS nombre FROM estancia e JOIN estancia_inmueble ON e.id_estancia = estancia_inmueble.id_estancia JOIN inmueble ON estancia_inmueble.id_inmueble = inmueble.id_inmueble WHERE inmueble.id_inmueble = 1 GROUP BY e.nombre;";

    @Query(value = LISTADO_ESTANCIAS, nativeQuery = true)
    List<Inmueble> ListadoEstancias();
    //List<Inmueble> ListadoEstancias(@Param("id_inmueble") Inmueble id_inmueble);


}
