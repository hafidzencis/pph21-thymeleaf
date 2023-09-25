package com.exercise.web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false ,length = 200)
    private String name;

    @Column(name = "jenis_kelamin", nullable = false)
    private String jenisKelamin;

    @Column(name = "status_menikah",nullable = false)
    private Boolean statusMenikah;

    @Column(name = "pasangan", nullable = true)
    private String pasangan;

    @Column(name = "tanggungan", nullable = false)
    private Integer tanggungan;

    @Column(name = "PTKP",  nullable = false)
    private Double ptkp;

    @Column(name = "PKP", nullable = false)
    private Double pkp;

    @Column(name = "bruto",nullable = false)
    private Double bruto;

    @Column(name = "nett",nullable = false)
    private Double nett;

    @Column(name = "jumlah_pph_perbulan",  nullable = false)
    private Double jumlahPphPerbalun;

    @Column(name = "jumlah_pph_pertahun", nullable = false)
    private Double jumlahPphPertahun;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public Double getPtkp() {
        return ptkp;
    }

    public void setPtkp(Double ptkp) {
        this.ptkp = ptkp;
    }

    public Double getPkp() {
        return pkp;
    }

    public void setPkp(Double pkp) {
        this.pkp = pkp;
    }

    public Double getBruto() {
        return bruto;
    }

    public void setBruto(Double bruto) {
        this.bruto = bruto;
    }

    public Double getNett() {
        return nett;
    }

    public void setNett(Double nett) {
        this.nett = nett;
    }

    public Double getJumlahPphPerbalun() {
        return jumlahPphPerbalun;
    }

    public void setJumlahPphPerbalun(Double jumlahPphPerbalun) {
        this.jumlahPphPerbalun = jumlahPphPerbalun;
    }

    public Double getJumlahPphPertahun() {
        return jumlahPphPertahun;
    }

    public void setJumlahPphPertahun(Double jumlahPphPertahun) {
        this.jumlahPphPertahun = jumlahPphPertahun;
    }
}
