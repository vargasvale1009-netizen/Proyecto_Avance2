package com.example;

import java.util.Arrays;
import java.util.List;

public class VehiculoInfo {

    private int id;
    private String nombre;
    private String specs;
    private String carpeta;
    private String imgPrincipal;
    private List<String> miniaturas;
    private Integer idAnterior;
    private Integer idSiguiente;

    public VehiculoInfo(int id, String nombre, String specs,
                        String carpeta, String imgPrincipal, List<String> miniaturas,
                        Integer idAnterior, Integer idSiguiente) {
        this.id           = id;
        this.nombre       = nombre;
        this.specs        = specs;
        this.carpeta      = carpeta;
        this.imgPrincipal = imgPrincipal;
        this.miniaturas   = miniaturas;
        this.idAnterior   = idAnterior;
        this.idSiguiente  = idSiguiente;
    }

    public int getId()                  { return id; }
    public String getNombre()           { return nombre; }
    public String getSpecs()            { return specs; }
    public String getCarpeta()          { return carpeta; }
    public String getImgPrincipal()     { return imgPrincipal; }
    public List<String> getMiniaturas() { return miniaturas; }
    public Integer getIdAnterior()      { return idAnterior; }
    public Integer getIdSiguiente()     { return idSiguiente; }
}
