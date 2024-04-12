package com.filtro.inmobiliaria.repository.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oficina")
public class Oficina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_oficina;

    @Column(name = "direccion" , nullable = false)
    private String direccion;

    @Column(name = "urbanizacion" , nullable = false)
    private String urbanizacion;


}
