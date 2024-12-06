package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.classessss.KTP;
import model.enummm.JenisAgama;
import model.enummm.JenisKelamin;
import model.enummm.StatusPerkawinan;


public class controller {

    public static boolean checkInput(
        JTextField nikField, JTextField namaField, JTextField tempatLahirField,
        ButtonGroup genderGroup, ButtonGroup golDarahGroup, JTextField alamatField, JTextField rtField,
        JTextField rwField, JTextField kelurahanField, JTextField kecamatanField, JComboBox<String> agamaComboBox,
        JComboBox<String> perkawinanBox, JCheckBox karyawanSwastaCheck, JCheckBox pnsCheck,
        JCheckBox wiraswastaCheck, JCheckBox akademisiCheck, JCheckBox pengangguranCheck,
        ButtonGroup citizenshipGroup, JTextField citizenshipField, File photoFile, File signatureFile,
        JTextField tglBerlakuField, JTextField kotaPembuatanField) {

        if (nikField.getText().trim().isEmpty()
                || namaField.getText().trim().isEmpty()
                || tempatLahirField.getText().trim().isEmpty()
                || alamatField.getText().trim().isEmpty()
                || rtField.getText().trim().isEmpty()
                || rwField.getText().trim().isEmpty()
                || kelurahanField.getText().trim().isEmpty()
                || kecamatanField.getText().trim().isEmpty()
                || tglBerlakuField.getText().trim().isEmpty()
                || kotaPembuatanField.getText().trim().isEmpty()) {

            return false;
        }

        if (agamaComboBox.getSelectedIndex() == -1 || perkawinanBox.getSelectedIndex() == -1) {
            return false;
        }

        if (genderGroup.getSelection() == null) {
            return false;
        }

        if (golDarahGroup.getSelection() == null) {
            return false;
        }

        if (!karyawanSwastaCheck.isSelected()
                && !pnsCheck.isSelected()
                && !wiraswastaCheck.isSelected()
                && !akademisiCheck.isSelected()
                && !pengangguranCheck.isSelected()) {

            return false;
        }

        if (citizenshipGroup.getSelection() == null) {
            return false;
        }

        if (citizenshipGroup.getSelection().getActionCommand().equals("WNA")
                && (citizenshipField == null || citizenshipField.getText().trim().isEmpty())) {

            return false;
        }

        if (photoFile == null || signatureFile == null) {
            return false;
        }
        return true;
    }


    public static void resetFields(JTextField nikField, JTextField namaField, JTextField tempatLahirField,
             ButtonGroup genderGroup, ButtonGroup bloodGroup, JTextField alamatField,
            JTextField rtField, JTextField rwField, JTextField kelurahanField, JTextField kecamatanField,
            JComboBox<String> agamaComboBox, JComboBox<String> perkawinanBox, JCheckBox karyawanSwastaCheck,
            JCheckBox pnsCheck, JCheckBox wiraswastaCheck, JCheckBox akademisiCheck, JCheckBox pengangguranCheck,
            ButtonGroup citizenshipGroup, JTextField citizenshipField, File[] photoFile, File[] signatureFile,
            JTextField tglBerlakuField, JTextField kotaPembuatanField) {

        // Reset text fields
        nikField.setText("");
        namaField.setText("");
        tempatLahirField.setText("");
        alamatField.setText("");
        rtField.setText("");
        rwField.setText("");
        kelurahanField.setText("");
        kecamatanField.setText("");
        citizenshipField.setText("");
        tglBerlakuField.setText("");
        kotaPembuatanField.setText("");

        // Clear radio button selections
        genderGroup.clearSelection();
        bloodGroup.clearSelection();
        citizenshipGroup.clearSelection();

        // Clear combo box selections
        agamaComboBox.setSelectedIndex(0);
        perkawinanBox.setSelectedIndex(0);

        // Clear check box selections
        karyawanSwastaCheck.setSelected(false);
        pnsCheck.setSelected(false);
        wiraswastaCheck.setSelected(false);
        akademisiCheck.setSelected(false);
        pengangguranCheck.setSelected(false);

        // Reset file references
        if (photoFile != null && photoFile.length > 0) {
            photoFile = null;
        }
        if (signatureFile != null && signatureFile.length > 0) {
            signatureFile = null;
        }

    }
    public static String getSelectedJobs(JCheckBox karyawanSwastaCheck, JCheckBox pnsCheck, JCheckBox wiraswastaCheck, JCheckBox akademisiCheck, JCheckBox pengangguranCheck) {
        List<String> listJob = new ArrayList<>();
        String job = "";
        if (pengangguranCheck.isSelected()) {
            job = "PENGANGGURAN";
        }
        else {
            if (karyawanSwastaCheck.isSelected()) {
                listJob.add("KARYAWAN SWASTA");
            }
            if (pnsCheck.isSelected()) {
                listJob.add("PNS");
            }
            if (wiraswastaCheck.isSelected()) {
                listJob.add("WIRASWASTA");
            }
            if (akademisiCheck.isSelected()) {
                listJob.add("AKADEMISI");
            }
        }
        if (listJob.size() > 1) {
            for (int i = 0; i < listJob.size() - 1; i++) {
                job += listJob.get(i) + ", ";
            }
        }
        job += listJob.get(listJob.size() - 1);
        return job;
    }

    public static JenisAgama getJenisAgama(String agama) {
        if (agama.equalsIgnoreCase("KRISTEN")) {
            return JenisAgama.KRISTEN;
        }
        else if (agama.equalsIgnoreCase("KATHOLIK")) {
            return JenisAgama.KATHOLIK;
        }
        else if (agama.equalsIgnoreCase("ISLAM")) {
            return JenisAgama.ISLAM;
        }
        else if (agama.equalsIgnoreCase("HINDU")) {
            return JenisAgama.HINDU;
        }
        else if (agama.equalsIgnoreCase("BUDDHA")) {
            return JenisAgama.BUDDHA;
        }
        else {
            return JenisAgama.KONGHUCU;
        }
    }

    public static StatusPerkawinan getStatusPerkawinan(String status) {
        if (status.equalsIgnoreCase("BELUM MENIKAH")) {
            return StatusPerkawinan.BELUM_MENIKAH;
        }
        else if (status.equalsIgnoreCase("MENIKAH")) {
            return StatusPerkawinan.MENIKAH;
        }
        else if (status.equalsIgnoreCase("JANDA")) {
            return StatusPerkawinan.JANDA;
        }
        else {
            return StatusPerkawinan.DUDA;
        }
    }

    public static String getCitizenship(String citizen, String country) {
        String citizenship = "";
        if (citizen.equalsIgnoreCase("WNI")) {
            citizenship = "WNI";
        }
        else {
            citizenship = "WNA(" + country + ")";
        }
        return citizenship;
    }

    public static KTP createKTP(String nik, String nama, String tempatLahir, String tanggalLahir, JenisKelamin jenisKelamin, String golDarah, String alamat, String rt, String rw, String kelDesa, String kecamatan,
            JenisAgama agama, StatusPerkawinan statusPerkawinan, String pekerjaan, String kewarganegaraan, String wargaNegaraAsal, File photoFile, File signatureFile, String berlakuHingga, String kotaPembuatan, String tanggalPembuatan, int actionValue) {
        
        KTP ktp = new KTP(nik, nama, tempatLahir, tanggalLahir, jenisKelamin, golDarah, alamat, rt, rw, kelDesa, kecamatan,
                                agama, statusPerkawinan, pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile,
                                signatureFile, berlakuHingga, kotaPembuatan, tanggalPembuatan);
        
        if (actionValue == 1) {
            
            DBController.insertNewUser(ktp);

        }
        else {

            DBController.updateData(ktp);

        }

        return ktp;

    }

    public static String[] setSelectedJobs(String jobs) {

        String[] listJobs = jobs.split(", ");

        return listJobs;

    }
}