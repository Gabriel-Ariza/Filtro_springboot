package com.filtro.inmobiliaria.repository.entitiesDTO;



import jakarta.validation.constraints.NotEmpty;
//import com.filtro.inmobiliaria.repository.entities.Cliente;
import lombok.Data;



@Data
public class ClienteDTO {


    private Long id_cliente;

    @NotEmpty(message = "no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "no puede estar vacio")
    private String apellido;
    @NotEmpty(message = "no puede estar vacio")
    private String telefono;
    @NotEmpty(message = "no puede estar vacio")
    private String correo;
}
