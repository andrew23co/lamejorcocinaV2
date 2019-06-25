/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamejorcocina.entidades;

/**
 *
 * @author Gamba
 */
public class CamareroFacturacionMes {
    
    private String nombreCam;
    private String apellidoCam;
    private String mesRep;
    private int anno;    
    private Integer totalMes;

    public String getNombreCam() {
        return nombreCam;
    }

    public void setNombreCam(String nombreCam) {
        this.nombreCam = nombreCam;
    }

    public String getApellidoCam() {
        return apellidoCam;
    }

    public void setApellidoCam(String apellidoCam) {
        this.apellidoCam = apellidoCam;
    }

    public String getMesRep() {
        return mesRep;
    }

    public void setMesRep(String mesRep) {
        this.mesRep = mesRep;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Integer getTotalMes() {
        return totalMes;
    }

    public void setTotalMes(Integer totalMes) {
        this.totalMes = totalMes;
    }
}
