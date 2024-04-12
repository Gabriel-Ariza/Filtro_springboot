package com.filtro.inmobiliaria.repository.entities;


import java.util.List;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inmueble")
public class Inmueble {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inmueble;

    @Column(name = "codigo" , nullable = false)
    private String codigo;

    @Column(name = "nuevo" , nullable = false)
    private String nuevo;

    @Column(name = "superficie" , nullable = false)
    private String superficie;

    @Column(name = "urbanizacion" , nullable = false)
    private String urbanizacion;

    @Column(name = "direccion" , nullable = false)
    private String direccion;

    @Column(name = "caracteristicas" , nullable = false)
    private String caracteristicas;

    @Column(name = "nom_propietario" , nullable = false)
    private String nom_propietario;

    @Column(name = "tel_propietario" , nullable = false)
    private String tel_propietario;

    @Column(name = "precio" , nullable = false)
    private String precio;

    public enum ofrecido_como {
        venta,
        alquiler,
        alquier_venta
    }
    @Column(name = "ofrecido_como", nullable = false)
    private ofrecido_como ofrecido_como; 

    @ManyToMany
    @JoinTable(
        name = "estancia_inmueble",
        joinColumns = @JoinColumn(name = "id_inmueble"),
        inverseJoinColumns = @JoinColumn(name = "id_estancia")
        )
    private List<Estancia> estancias;


    @ManyToMany
    @JoinTable(
        name = "visita_inmueble",
        joinColumns = @JoinColumn(name = "id_inmueble"),
        inverseJoinColumns = @JoinColumn(name = "id_visita"),
        foreignKey = @ForeignKey(name = "none")
        //inverseforeignKey = @ForeignKey(name = "none")
        )
    private List<Visita> visitas;

}
