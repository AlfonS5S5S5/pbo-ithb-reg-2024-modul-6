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
    
    static DatabaseHandler conn = new DatabaseHandler();

    // SEARCH/GET KTP
    public static KTP getKTP(String nik) {

        KTP ktp = new KTP();

        try {

            conn.connect();
            String query = "SELECT * FROM ktp WHERE NIK='" + nik + "'";
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
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

        conn.disconnect();
        return ktp;

    }

    // INSERT
    public static boolean insertNewUser(KTP ktp) {

        String query = "INSERT INTO ktp (nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, gol_darah, alamat, rt, rw, keldesa, kecamatan, agama, status_perkawinan, pekerjaan, kewarganegaraan, negara_asal, photo_path, signature_path, berlaku_hingga, kota_pembuatan, tanggal_pembuatan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            
            stmt.setString(1, ktp.getNik());
            stmt.setString(2, ktp.getNama());
            stmt.setString(3, ktp.getTempatLahir());
            stmt.setString(4, ktp.getTanggalLahir());
            stmt.setString(5, ktp.getJenisKelamin().name());
            stmt.setString(6, ktp.getGolDarah());
            stmt.setString(7, ktp.getAlamat());
            stmt.setString(8, ktp.getRt());
            stmt.setString(9, ktp.getRw());
            stmt.setString(10, ktp.getKelDesa());
            stmt.setString(11, ktp.getKecamatan());
            stmt.setString(12, ktp.getAgama().name());
            stmt.setString(13, ktp.getStatusPerkawinan().name());
            stmt.setString(14, ktp.getPekerjaan());
            stmt.setString(15, ktp.getKewarganegaraan());
            stmt.setString(16, ktp.getWargaNegaraAsal());
            stmt.setString(17, ktp.getFotoFilePath().getPath());
            stmt.setString(18, ktp.getTandaTanganFilePath().getPath());
            stmt.setString(19, ktp.getBerlakuHingga());
            stmt.setString(20, ktp.getKotaPembuatan());
            stmt.setString(21, ktp.getTanggalPembuatan());

            stmt.executeUpdate();
            return true;

        } 
        catch (SQLException e) {
            
            e.printStackTrace();
            return false;

        } 
        finally {

            conn.disconnect();

        }

    }

    // UPDATE
    public static boolean updateData(KTP ktp) {

        String query = "UPDATE ktp SET nama=?, tempat_lahir=?, tanggal_lahir=?, jenis_kelamin=?, gol_darah=?, alamat=?, rt=?, rw=?, keldesa=?, kecamatan=?, agama=?, status_perkawinan=?, pekerjaan=?, kewarganegaraan=?, negara_asal=?, photo_path=?, signature_path=?, berlaku_hingga=?, kota_pembuatan=?, tanggal_pembuatan=? WHERE NIK=?";

        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            
            stmt.setString(1, ktp.getNama());
            stmt.setString(2, ktp.getTempatLahir());
            stmt.setString(3, ktp.getTanggalLahir());
            stmt.setString(4, ktp.getJenisKelamin().name());
            stmt.setString(5, ktp.getGolDarah());
            stmt.setString(6, ktp.getAlamat());
            stmt.setString(7, ktp.getRt());
            stmt.setString(8, ktp.getRw());
            stmt.setString(9, ktp.getKelDesa());
            stmt.setString(10, ktp.getKecamatan());
            stmt.setString(11, ktp.getAgama().name());
            stmt.setString(12, ktp.getStatusPerkawinan().name());
            stmt.setString(13, ktp.getPekerjaan());
            stmt.setString(14, ktp.getKewarganegaraan());
            stmt.setString(15, ktp.getWargaNegaraAsal());
            stmt.setString(16, ktp.getFotoFilePath().getPath());
            stmt.setString(17, ktp.getTandaTanganFilePath().getPath());
            stmt.setString(18, ktp.getBerlakuHingga());
            stmt.setString(19, ktp.getKotaPembuatan());
            stmt.setString(20, ktp.getTanggalPembuatan());
            
            // Where clause
            stmt.setString(21, ktp.getNik());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } 
        catch (SQLException e) {

            e.printStackTrace();
            return false;

        } 
        finally {

            conn.disconnect();

        }

    }

    // DELETE
    public static boolean deleteData(String nik) {

        String query = "DELETE FROM ktp WHERE NIK=?";

        try {

            conn.connect();
            PreparedStatement stmt = conn.con.prepareStatement(query);
            
            stmt.setString(1, nik);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } 
        catch (SQLException e) {

            e.printStackTrace();
            return false;

        } 
        finally {

            conn.disconnect();

        }

    }

}