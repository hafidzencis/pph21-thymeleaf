package com.exercise.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ItemsDTO {
    private Long id;

    private String name;

    private String jenisKelamin;

    private Boolean statusMenikah;

    private String pasangan;

    private Integer tanggungan;

    private Double bruto;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Boolean getStatusMenikah() {
        return statusMenikah;
    }

    public void setStatusMenikah(Boolean statusMenikah) {
        this.statusMenikah = statusMenikah;
    }

    public String getPasangan() {
        return pasangan;
    }

    public void setPasangan(String pasangan) {
        this.pasangan = pasangan;
    }

    public Integer getTanggungan() {
        return tanggungan;
    }

    public void setTanggungan(Integer tanggungan) {
        this.tanggungan = tanggungan;
    }

    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
    }


}
