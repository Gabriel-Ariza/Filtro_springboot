package com.filtro.inmobiliaria.repository.entitiesDTO;


import com.filtro.inmobiliaria.repository.entities.Cliente;


import jakarta.validation.constraints.NotEmpty;
//import com.filtro.inmobiliaria.repository.entities.Cliente;
import lombok.Data;



@Data
public class VisitaDTO {
    
    private Long id_estancia;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;


    private Long id_visita;


    @NotEmpty(message = "no puede estar vacio")
    private String fecha;

    @NotEmpty(message = "no puede estar vacio")
    private String comentario;

    private Cliente cliente;
}
