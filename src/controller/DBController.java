package controller;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.classessss.KTP;
import model.enummm.JenisAgama;
import model.enummm.JenisKelamin;
import model.enummm.StatusPerkawinan;

public class DBController {
    
    static DatabaseHandler con = new DatabaseHandler();

    public static KTP getKTP(String nik) {
        KTP ktp = new KTP();
        try {
            con.connect();
            String query = "SELECT * FROM ktp WHERE NIK='" + nik + "'";
            Statement statement = con.con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                do {
                    ktp.setNik(rs.getString("NIK"));
                    ktp.setNama(rs.getString("nama"));
                    ktp.setTempatLahir(rs.getString("tempat_lahir"));
                    ktp.setTanggalLahir(rs.getString("tanggal_lahir"));
                    ktp.setJenisKelamin(JenisKelamin.valueOf(rs.getString("jenis_kelamin")));
                    ktp.setGolDarah(rs.getString("gol_darah"));
                    ktp.setAlamat(rs.getString("alamat"));
                    ktp.setRt(rs.getString("rt"));
                    ktp.setRw(rs.getString("rw"));
                    ktp.setKelDesa(rs.getString("keldesa"));
                    ktp.setKecamatan(rs.getString("kecamatan"));
                    ktp.setAgama(JenisAgama.valueOf(rs.getString("agama")));
                    ktp.setStatusPerkawinan(StatusPerkawinan.valueOf(rs.getString("status_perkawinan")));
                    ktp.setPekerjaan(rs.getString("pekerjaan"));
                    ktp.setKewarganegaraan(rs.getString("kewarganegaraan"));
                    ktp.setWargaNegaraAsal(rs.getString("negara_asal"));
                    ktp.setFotoFilePath(new File(rs.getString("photo_path")));
                    ktp.setTandaTanganFilePath(new File(rs.getString("signature_path")));
                    ktp.setBerlakuHingga(rs.getString("berlaku_hingga"));
                    ktp.setKotaPembuatan(rs.getString("kota_pembuatan"));
                    ktp.setTanggalPembuatan(rs.getString("tanggal_pembuatan"));
                } while (rs.next());
            }
            else {
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        con.disconnect();
        return ktp;

    }

    public static boolean insertNewUser(KTP ktp) {
        String query = "INSERT INTO ktp (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, gol_darah, alamat, rt, rw, keldesa, kecamatan, agama, status_perkawinan, pekerjaan, kewarganegaraan, negara_asal, photo_path, signature_path, berlaku_hingga, kota_pembuatan, tanggal_pembuatan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con.connect();
            PreparedStatement statement = con.con.prepareStatement(query);
            statement.setString(1, ktp.getNik());
            statement.setString(2, ktp.getNama());
            statement.setString(3, ktp.getTempatLahir());
            statement.setString(4, ktp.getTanggalLahir());
            statement.setString(5, ktp.getJenisKelamin().name());
            statement.setString(6, ktp.getGolDarah());
            statement.setString(7, ktp.getAlamat());
            statement.setString(8, ktp.getRt());
            statement.setString(9, ktp.getRw());
            statement.setString(10, ktp.getKelDesa());
            statement.setString(11, ktp.getKecamatan());
            statement.setString(12, ktp.getAgama().name());
            statement.setString(13, ktp.getStatusPerkawinan().name());
            statement.setString(14, ktp.getPekerjaan());
            statement.setString(15, ktp.getKewarganegaraan());
            statement.setString(16, ktp.getWargaNegaraAsal());
            statement.setString(17, ktp.getFotoFilePath().getPath());
            statement.setString(18, ktp.getTandaTanganFilePath().getPath());
            statement.setString(19, ktp.getBerlakuHingga());
            statement.setString(20, ktp.getKotaPembuatan());
            statement.setString(21, ktp.getTanggalPembuatan());

            statement.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            con.disconnect();
        }
    }
    public static boolean updateData(KTP ktp) {
        String query = "UPDATE ktp SET nama=?, tempat_lahir=?, tanggal_lahir=?, jenis_kelamin=?, gol_darah=?, alamat=?, rt=?, rw=?, keldesa=?, kecamatan=?, agama=?, status_perkawinan=?, pekerjaan=?, kewarganegaraan=?, negara_asal=?, photo_path=?, signature_path=?, berlaku_hingga=?, kota_pembuatan=?, tanggal_pembuatan=? WHERE NIK=?";
        try {
            con.connect();
            PreparedStatement statement = con.con.prepareStatement(query);
            statement.setString(1, ktp.getNama());
            statement.setString(2, ktp.getTempatLahir());
            statement.setString(3, ktp.getTanggalLahir());
            statement.setString(4, ktp.getJenisKelamin().name());
            statement.setString(5, ktp.getGolDarah());
            statement.setString(6, ktp.getAlamat());
            statement.setString(7, ktp.getRt());
            statement.setString(8, ktp.getRw());
            statement.setString(9, ktp.getKelDesa());
            statement.setString(10, ktp.getKecamatan());
            statement.setString(11, ktp.getAgama().name());
            statement.setString(12, ktp.getStatusPerkawinan().name());
            statement.setString(13, ktp.getPekerjaan());
            statement.setString(14, ktp.getKewarganegaraan());
            statement.setString(15, ktp.getWargaNegaraAsal());
            statement.setString(16, ktp.getFotoFilePath().getPath());
            statement.setString(17, ktp.getTandaTanganFilePath().getPath());
            statement.setString(18, ktp.getBerlakuHingga());
            statement.setString(19, ktp.getKotaPembuatan());
            statement.setString(20, ktp.getTanggalPembuatan());
            statement.setString(21, ktp.getNik());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            con.disconnect();
        }
    }

    public static boolean deleteData(String nik) {
        String query = "DELETE FROM ktp WHERE NIK=?";
        try {
            con.connect();
            PreparedStatement statement = con.con.prepareStatement(query);
            statement.setString(1, nik);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            con.disconnect();
        }
    }
}