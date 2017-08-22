package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import metodos.MEncriptacion;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */
public class EncriptarPanel extends JPanel implements ActionListener {
    
    private JButton btnTxtEncriptar;
    private JButton btnLimpiar;
    
    private JLabel lblClaveCifrado;
    private JLabel lblTxtEncriptar;
    private JLabel lblTxtEncriptado;
    
    private JScrollPane scpTxtEncriptar;
    private JScrollPane scpTxtEncriptado;
    
    private JTextArea txaTxtEncriptar;
    private JTextArea txaTxtEncriptado;
    
    private JTextField txtClaveCifrado;
    
    public EncriptarPanel() {
        initPanel();
    }
    
    private void initPanel() {
        setLayout(null);
        setBackground(new Color(64,  224, 208));
        setSize(new Dimension(650, 325));
        setLocation(25, 125);

        lblClaveCifrado = new JLabel("Clave de cifrado");
        lblClaveCifrado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        lblClaveCifrado.setForeground(new Color(0,0,0));
        lblClaveCifrado.setHorizontalAlignment(JLabel.CENTER);
        lblClaveCifrado.setSize(new Dimension(250, 25));
        lblClaveCifrado.setLocation(25, 25);
        
        txtClaveCifrado = new JTextField();
        txtClaveCifrado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        txtClaveCifrado.setForeground(new Color(0, 0, 0));
        txtClaveCifrado.setHorizontalAlignment(JTextField.CENTER);
        txtClaveCifrado.setSize(new Dimension(250, 25));
        txtClaveCifrado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        txtClaveCifrado.setLocation(25, 60);
        
        lblTxtEncriptar = new JLabel("Texto a encriptar");
        lblTxtEncriptar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        lblTxtEncriptar.setForeground(new Color(0,0,0));
        lblTxtEncriptar.setHorizontalAlignment(JLabel.CENTER);
        lblTxtEncriptar.setSize(new Dimension(250, 25));
        lblTxtEncriptar.setLocation(25, 95);
        
        txaTxtEncriptar = new JTextArea(5, 10);
        txaTxtEncriptar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        txaTxtEncriptar.setForeground(new Color(0, 0, 0));
        txaTxtEncriptar.setBackground(new Color(255, 255, 255));
        txaTxtEncriptar.setEditable(true);

        scpTxtEncriptar = new JScrollPane(txaTxtEncriptar,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scpTxtEncriptar.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        scpTxtEncriptar.setSize(new Dimension(250, 175));
        scpTxtEncriptar.setLocation(25,130);

        btnTxtEncriptar = new JButton(">");
        btnTxtEncriptar.setBackground(new Color(26, 188, 156));
        btnTxtEncriptar.setContentAreaFilled(false);
        btnTxtEncriptar.setOpaque(true);
        btnTxtEncriptar.setFocusPainted(false);
        btnTxtEncriptar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnTxtEncriptar.setForeground(new Color(0,0,0));
        btnTxtEncriptar.setHorizontalAlignment(JLabel.CENTER);
        btnTxtEncriptar.setToolTipText("Presione para encriptar");
        btnTxtEncriptar.setSize(new Dimension(50, 25));
        btnTxtEncriptar.setLocation(300, 120);
        btnTxtEncriptar.addActionListener(this);

        btnLimpiar = new JButton("x");
        btnLimpiar.setBackground(new Color(26, 188, 156));
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setOpaque(true);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLimpiar.setForeground(new Color(0, 0, 0));
        btnLimpiar.setHorizontalAlignment(JLabel.CENTER);
        btnLimpiar.setToolTipText("Presione para limpiar");
        btnLimpiar.setSize(new Dimension(50, 25));
        btnLimpiar.setLocation(300, 220);
        btnLimpiar.addActionListener(this);
        
        lblTxtEncriptado = new JLabel("Texto encriptado");
        lblTxtEncriptado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        lblTxtEncriptado.setForeground(new Color(0,0,0));
        lblTxtEncriptado.setHorizontalAlignment(JLabel.CENTER);
        lblTxtEncriptado.setSize(new Dimension(250, 25));
        lblTxtEncriptado.setLocation(375, 25);
                
        txaTxtEncriptado = new JTextArea(5, 10);
        txaTxtEncriptado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        txaTxtEncriptado.setForeground(new Color(0,0,0));
        txaTxtEncriptado.setBackground(new Color(255, 255, 255));
        txaTxtEncriptado.setLineWrap(true);
        txaTxtEncriptado.setEditable(true);
        
        scpTxtEncriptado = new JScrollPane(txaTxtEncriptado,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scpTxtEncriptado.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        scpTxtEncriptado.setSize(new Dimension(250, 245));
        scpTxtEncriptado.setLocation(375,60);
        
        add(lblClaveCifrado);
        add(txtClaveCifrado);
        add(lblTxtEncriptar);
        add(scpTxtEncriptar);
        add(btnTxtEncriptar);
        add(btnLimpiar);
        add(lblTxtEncriptado);
        add(scpTxtEncriptado);
        setVisible(true);
    }
    private void limpiarCampos() {
        txtClaveCifrado.setText("");
        txaTxtEncriptar.setText("");
        txaTxtEncriptado.setText("");
    }
    private String validarCampos() {
        if (txtClaveCifrado.getText().isEmpty()) {
            return "Clave de cifrado vacia";
        }
        else if (txtClaveCifrado.getText().length() < 16) {
            return "Clave debe contener 16 caracteres";
        }
        else if (txtClaveCifrado.getText().length() > 16) {
            return "Clave no debe contener mas de 16 caracteres";
        }
        else if (txaTxtEncriptar.getText().isEmpty()) {
            return "Ingrese texto a encriptar";
        }
        return "ok";
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String msg = validarCampos();
        if (evt.getSource() == btnTxtEncriptar) {
            if (msg.compareTo("ok") == 0) {
                txaTxtEncriptado.setText(new MEncriptacion().encriptacionAES(
                        txtClaveCifrado.getText(), txaTxtEncriptar.getText()));
            } else {
                JOptionPane.showMessageDialog(this, msg, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (evt.getSource() == btnLimpiar) {
            limpiarCampos();
        }
    }
}
