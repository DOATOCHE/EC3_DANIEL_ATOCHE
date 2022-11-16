package com.daniel.atoche.pe.ec3danielatoche.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdHospital;
    private String nombre;
    private String descripcion;
    private String distrito;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "intermedia",
            joinColumns = @JoinColumn(
                    name = "id_cliente",
                    nullable = false,
                    unique = true,
                    foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references cliente(id_cliente)")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_hospital",
                    nullable = false,
                    unique = true,
                    foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (id_hospital) references hospital(id_hospital)")
            )
    )
    private List<Cliente> clientes = new ArrayList<>();


    public Integer getIdHospital() {
        return IdHospital;
    }

    public void setIdHospital(Integer idHospital) {
        IdHospital = idHospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
