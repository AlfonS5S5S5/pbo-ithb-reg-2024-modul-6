package model.classessss;

import java.io.File;

import model.enummm.JenisAgama;
import model.enummm.JenisKelamin;
import model.enummm.StatusPerkawinan;

public class KTP {
    
    private String nik;
    private String nama;
    private String tempatLahir;
    private String tanggalLahir;
    private JenisKelamin jenisKelamin;
    private String golDarah;
    private String alamat;
    private String rt;
    private String rw;
    private String kelDesa;
    private String kecamatan;
    private JenisAgama agama;
    private StatusPerkawinan statusPerkawinan;
    private String pekerjaan;
    private String kewarganegaraan;
    private String wargaNegaraAsal;
    private File fotoFilePath;
    private File tandaTanganFilePath;
    private String berlakuHingga;
    private String kotaPembuatan;
    private String tanggalPembuatan;

    @Override
    public String toString() {
        return "KTP [nik=" + nik + ", nama=" + nama + ", tempatLahir=" + tempatLahir + ", tanggalLahir=" + tanggalLahir
                + ", jenisKelamin=" + jenisKelamin + ", golDarah=" + golDarah + ", alamat=" + alamat + ", rt=" + rt
                + ", rw=" + rw + ", kelDesa=" + kelDesa + ", kecamatan=" + kecamatan + ", agama=" + agama
                + ", statusPerkawinan=" + statusPerkawinan + ", pekerjaan=" + pekerjaan + ", kewarganegaraan="
                + kewarganegaraan + ", wargaNegaraAsal=" + wargaNegaraAsal + ", fotoFilePath=" + fotoFilePath
                + ", tandaTanganFilePath=" + tandaTanganFilePath + ", berlakuHingga=" + berlakuHingga
                + ", kotaPembuatan=" + kotaPembuatan + ", tanggalPembuatan=" + tanggalPembuatan + "]";
    }

    public KTP () {
        
    }

    public KTP(String nik, String nama, String tempatLahir, String tanggalLahir, JenisKelamin jenisKelamin,
            String golDarah, String alamat, String rt, String rw, String kelDesa, String kecamatan, JenisAgama agama,
            StatusPerkawinan statusPerkawinan, String pekerjaan, String kewarganegaraan, String wargaNegaraAsal,
            File fotoFilePath, File tandaTanganFilePath, String berlakuHingga, String kotaPembuatan,
            String tanggalPembuatan) {
        this.nik = nik;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.golDarah = golDarah;
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.kelDesa = kelDesa;
        this.kecamatan = kecamatan;
        this.agama = agama;
        this.statusPerkawinan = statusPerkawinan;
        this.pekerjaan = pekerjaan;
        this.kewarganegaraan = kewarganegaraan;
        this.wargaNegaraAsal = wargaNegaraAsal;
        this.fotoFilePath = fotoFilePath;
        this.tandaTanganFilePath = tandaTanganFilePath;
        this.berlakuHingga = berlakuHingga;
        this.kotaPembuatan = kotaPembuatan;
        this.tanggalPembuatan = tanggalPembuatan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getKelDesa() {
        return kelDesa;
    }

    public void setKelDesa(String kelDesa) {
        this.kelDesa = kelDesa;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public JenisAgama getAgama() {
        return agama;
    }

    public void setAgama(JenisAgama agama) {
        this.agama = agama;
    }

    public StatusPerkawinan getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(StatusPerkawinan statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getWargaNegaraAsal() {
        return wargaNegaraAsal;
    }

    public void setWargaNegaraAsal(String wargaNegaraAsal) {
        this.wargaNegaraAsal = wargaNegaraAsal;
    }

    public File getFotoFilePath() {
        return fotoFilePath;
    }

    public void setFotoFilePath(File fotoFilePath) {
        this.fotoFilePath = fotoFilePath;
    }

    public File getTandaTanganFilePath() {
        return tandaTanganFilePath;
    }

    public void setTandaTanganFilePath(File tandaTanganFilePath) {
        this.tandaTanganFilePath = tandaTanganFilePath;
    }

    public String getBerlakuHingga() {
        return berlakuHingga;
    }

    public void setBerlakuHingga(String berlakuHingga) {
        this.berlakuHingga = berlakuHingga;
    }

    public String getKotaPembuatan() {
        return kotaPembuatan;
    }

    public void setKotaPembuatan(String kotaPembuatan) {
        this.kotaPembuatan = kotaPembuatan;
    }

    public String getTanggalPembuatan() {
        return tanggalPembuatan;
    }

    public void setTanggalPembuatan(String tanggalPembuatan) {
        this.tanggalPembuatan = tanggalPembuatan;
    }

}