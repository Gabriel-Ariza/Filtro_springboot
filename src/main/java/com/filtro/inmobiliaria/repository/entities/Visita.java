package com.filtro.inmobiliaria.repository.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "visita")
public class Visita {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_visita;


    @Column(name = "fecha" , nullable = false)
    private String fecha;

    @Column(name = "comentario" , nullable = false)
    private String comentario;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}
