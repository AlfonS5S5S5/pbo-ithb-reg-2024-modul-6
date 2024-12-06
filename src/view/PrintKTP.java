package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.classessss.KTP;

public class PrintKTP {

    private JFrame frame;

    public PrintKTP(KTP ktp) {
        showKTP(ktp);
    }

    public void showKTP(KTP ktp) {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // INIT TOOLKIT
        Dimension screenSize = toolkit.getScreenSize(); // GET MY SCREEN SIZE

        int screenWidth = screenSize.width; // GET PIXELS FOR WIDTH
        int screenHeight = screenSize.height; // GET PIXELS FOR HEIGHT

        final int FRAME_WIDTH = 1000; // SET WIDTH
        final int FRAME_HEIGHT = 600; // SET WEIGHT

        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2); // SET START LOCATION FOR X
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2); // SET START LOCATION FOR Y
        
        frame = new JFrame("Cetak KTP");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT); // SET FRAME BOUND
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        JLabel titleLabel = new JLabel("REPUBLIK HARAPAN BANGSA");
        titleLabel.setBounds(350, 15, 300, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); // CHANGE FONT
        panel.add(titleLabel); // ADD LABEL TO PANEL

        addLabelBold(panel, "NIK", 50, 80, 50, 50);
        addLabelBold(panel, ": " + ktp.getNik(), 280, 80, 300, 50);

        addLabelAndValue(panel, "Nama", ktp.getNama(), 50, 140);
        addLabelAndValue(panel, "Tempat/Tgl Lahir", ktp.getTempatLahir() + ", " + ktp.getTanggalLahir().toString(), 50, 170);
        addLabelAndValue(panel, "Jenis Kelamin", ktp.getJenisKelamin().toString(), 50, 200);

        addLabelPlain(panel, "Gol. Darah", 490, 200, 100, 25);
        addLabelPlain(panel, " : " + ktp.getGolDarah(), 580, 200, 100, 25);

        addLabelAndValue(panel, "Alamat", ktp.getAlamat(), 50, 230);

        addLabelPlain(panel, "RT/RW", 100, 260, 100, 25);
        addLabelPlain(panel, " : " + ktp.getRt() + "/" + ktp.getRw(), 300, 260, 300, 25);

        addLabelPlain(panel, "Kel/Desa", 100, 290, 100, 25);
        addLabelPlain(panel, " : " + ktp.getKelDesa(), 300, 290, 300, 25);

        addLabelPlain(panel, "Kecamatan", 100, 320, 100, 25);
        addLabelPlain(panel, " : " + ktp.getKecamatan(), 300, 320, 300, 25);

        addLabelAndValue(panel, "Agama", ktp.getAgama().toString(), 50, 350);
        addLabelAndValue(panel, "Status Perkawinan", ktp.getStatusPerkawinan().toString(), 50, 380);
        addLabelAndValue(panel, "Pekerjaan", ktp.getPekerjaan(), 50, 410);
        addLabelAndValue(panel, "Kewarganegaraan", ktp.getKewarganegaraan(), 50, 440);
        addLabelAndValue(panel, "Berlaku Hingga", ktp.getBerlakuHingga(), 50, 470);

        ImageIcon photoIcon = new ImageIcon(ktp.getFotoFilePath().getAbsolutePath());
        JLabel photoLabel = new JLabel(photoIcon);
        photoLabel.setBounds(690, 80, 240, 300);
        panel.add(photoLabel);

        addLabelPlain(panel, ktp.getKotaPembuatan(), 740, 390, 200, 25);
        addLabelPlain(panel, ktp.getTanggalPembuatan().toString(), 770, 410, 200, 25);

        ImageIcon signatureIcon = new ImageIcon(ktp.getTandaTanganFilePath().getAbsolutePath());
        JLabel signatureLabel = new JLabel(signatureIcon);
        signatureLabel.setBounds(690, 440, 240, 80);
        panel.add(signatureLabel);

        JButton backMainMenu = new JButton("Back To Main Menu");
        backMainMenu.setBounds(50, 505, 200, 30);
        panel.add(backMainMenu);

        backMainMenu.addActionListener(e -> {
            frame.dispose();
            new mainMenu();
        });

        frame.add(panel);
        frame.setVisible(true);

    }



    private void addLabelAndValue(JPanel panel, String label, String value, int x, int y) {

        JLabel jLabel = new JLabel(label);
        jLabel.setBounds(x, y, 200, 25);
        jLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        panel.add(jLabel);

        JLabel jValue = new JLabel(" : " + value);
        jValue.setBounds(x + 250, y, 300, 20);
        jValue.setFont(new Font("SansSerif", Font.PLAIN, 18));
        panel.add(jValue);

    }

    private void addLabelBold(JPanel panel, String label, int x, int y, int width, int height) {

        JLabel myLabel = new JLabel(label);
        myLabel.setBounds(x, y, width, height);
        myLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        panel.add(myLabel);

    }

    private void addLabelPlain(JPanel panel, String label, int x, int y, int width, int height) {

        JLabel myLabel = new JLabel(label);
        myLabel.setBounds(x, y, width, height);
        myLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        panel.add(myLabel);

    }

}