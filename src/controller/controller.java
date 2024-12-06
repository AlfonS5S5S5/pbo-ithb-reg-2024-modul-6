package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import model.classessss.KTP;
import model.enummm.JenisAgama;
import model.enummm.JenisKelamin;
import model.enummm.StatusPerkawinan;

public class controller {

    public static boolean checkInput(
            JTextField nikField, JTextField namaField, JTextField tempatLahirField, JDatePickerImpl datePicker,
            ButtonGroup genderGroup, ButtonGroup bloodGroup, JTextField alamatField, JTextField rtField,
            JTextField rwField, JTextField kelurahanField, JTextField kecamatanField, JComboBox<String> agamaComboBox,
            JComboBox<String> perkawinanBox, JCheckBox karyawanSwastaCheck, JCheckBox pnsCheck,
            JCheckBox wiraswastaCheck, JCheckBox akademisiCheck, JCheckBox pengangguranCheck,
            ButtonGroup citizenshipGroup, JTextField citizenshipField, File photoFile, File signatureFile,
            JTextField tglBerlakuField, JTextField kotaPembuatanField, JDatePickerImpl tglPembuatanPicker) {

        if (nikField.getText().trim().isEmpty()
                || namaField.getText().trim().isEmpty()
                || tempatLahirField.getText().trim().isEmpty()
                || datePicker.getModel().getValue() == null
                || genderGroup.getSelection() == null
                || bloodGroup.getSelection() == null
                || alamatField.getText().trim().isEmpty()
                || rtField.getText().trim().isEmpty()
                || rwField.getText().trim().isEmpty()
                || kelurahanField.getText().trim().isEmpty()
                || kecamatanField.getText().trim().isEmpty()
                || agamaComboBox.getSelectedIndex() == -1
                || perkawinanBox.getSelectedIndex() == -1
                || (!karyawanSwastaCheck.isSelected()
                        && !pnsCheck.isSelected()
                        && !wiraswastaCheck.isSelected()
                        && !akademisiCheck.isSelected()
                        && !pengangguranCheck.isSelected())
                || citizenshipGroup.getSelection() == null
                || (citizenshipGroup.getSelection().getActionCommand().equals("WNA")
                        && citizenshipField.getText().trim().isEmpty())
                || photoFile == null
                || signatureFile == null
                || tglBerlakuField.getText().trim().isEmpty()
                || kotaPembuatanField.getText().trim().isEmpty()
                || tglPembuatanPicker.getModel().getValue() == null) {

            return false;

        } else {

            return true;

        }

    }

    public static void resetFields(JTextField nikField, JTextField namaField, JTextField tempatLahirField,
            JDatePickerImpl datePicker, ButtonGroup genderGroup, ButtonGroup bloodGroup, JTextField alamatField,
            JTextField rtField, JTextField rwField, JTextField kelurahanField, JTextField kecamatanField,
            JComboBox<String> agamaComboBox, JComboBox<String> perkawinanBox, JCheckBox karyawanSwastaCheck,
            JCheckBox pnsCheck, JCheckBox wiraswastaCheck, JCheckBox akademisiCheck, JCheckBox pengangguranCheck,
            ButtonGroup citizenshipGroup, JTextField citizenshipField, File[] photoFile, File[] signatureFile,
            JTextField tglBerlakuField, JTextField kotaPembuatanField, JDatePickerImpl tglPembuatanPicker) {

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

        // Reset date picker
        datePicker.getModel().setValue(null);
        tglPembuatanPicker.getModel().setValue(null);

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

    // public static String getGolDarah (String gol) {
    //     String golDarah = "";

    //     if(gol.equalsIgnoreCase("A")) {
    //         golDarah = "A";
    //     } else if (gol.equalsIgnoreCase("B")) {
    //         golDarah = "B";
    //     } else if (gol.equalsIgnoreCase("O")) {
    //         golDarah = "O";
    //     } else {
    //         golDarah = "AB";
    //     }
    //     return golDarah;
    // }

    public static KTP createKTP(String nik, String nama, String tempatLahir, String tanggalLahir, JenisKelamin jenisKelamin, String golDarah, String alamat, String rt, String rw, String kelDesa, String kecamatan,
            JenisAgama agama, StatusPerkawinan statusPerkawinan, String pekerjaan, String kewarganegaraan, String wargaNegaraAsal, File photoFile, File signatureFile, String berlakuHingga, String kotaPembuatan, String tanggalPembuatan, int actionValue) {
        
        KTP ktp = new KTP(nik, nama, tempatLahir, tanggalLahir, jenisKelamin, golDarah, alamat, rt, rw, kelDesa, kecamatan,
                                agama, statusPerkawinan, pekerjaan, kewarganegaraan, wargaNegaraAsal, photoFile,
                                signatureFile, berlakuHingga, kotaPembuatan, tanggalPembuatan);
        
        if (actionValue == 1) {
            
            DBController.insertNewUser(ktp); // ADD TO DATABASE

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