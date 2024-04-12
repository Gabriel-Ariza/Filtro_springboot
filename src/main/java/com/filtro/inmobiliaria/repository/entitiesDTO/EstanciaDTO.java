package com.filtro.inmobiliaria.repository.entitiesDTO;



import jakarta.validation.constraints.NotEmpty;
//import com.filtro.inmobiliaria.repository.entities.Cliente;
import lombok.Data;



@Data
public class EstanciaDTO {
    

    @NotEmpty(message = "no puede estar vacio")
    private Long id_estancia;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;
    
}
