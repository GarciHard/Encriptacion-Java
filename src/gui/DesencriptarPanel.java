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
public class DesencriptarPanel extends JPanel implements ActionListener {
    
    private JButton btnTxtDesencriptar;
    private JButton btnLimpiar;

    private JLabel lblClaveCifrado;
    private JLabel lblTxtDesencriptar;
    private JLabel lblTxtDesencriptado;

    private JScrollPane scpTxtDesencriptar;
    private JScrollPane scpTxtDesencriptado;

    private JTextArea txaTxtDesencriptar;
    private JTextArea txaTxtDesencriptado;

    private JTextField txtClaveCifrado;
    
    public DesencriptarPanel() {
        initPanel();
    }
    
    private void initPanel() {
        setLayout(null);
        setSize(new Dimension(650,325));
        setLocation(25, 125);
        setBackground(new Color(186,  85,  211));
        
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
        
        lblTxtDesencriptar = new JLabel("Texto a desencriptar");
        lblTxtDesencriptar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        lblTxtDesencriptar.setForeground(new Color(0,0,0));
        lblTxtDesencriptar.setHorizontalAlignment(JLabel.CENTER);
        lblTxtDesencriptar.setSize(new Dimension(250, 25));
        lblTxtDesencriptar.setLocation(25, 95);
        
        txaTxtDesencriptar = new JTextArea(5, 10);
        txaTxtDesencriptar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        txaTxtDesencriptar.setForeground(new Color(0, 0, 0));
        txaTxtDesencriptar.setBackground(new Color(255, 255, 255));
        txaTxtDesencriptar.setEditable(true);

        scpTxtDesencriptar = new JScrollPane(txaTxtDesencriptar,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scpTxtDesencriptar.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        scpTxtDesencriptar.setSize(new Dimension(250, 175));
        scpTxtDesencriptar.setLocation(25,130);

        btnTxtDesencriptar = new JButton(">");
        btnTxtDesencriptar.setBackground(new Color(26, 188, 156));
        btnTxtDesencriptar.setContentAreaFilled(false);
        btnTxtDesencriptar.setOpaque(true);
        btnTxtDesencriptar.setFocusPainted(false);
        btnTxtDesencriptar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnTxtDesencriptar.setForeground(new Color(0,0,0));
        btnTxtDesencriptar.setHorizontalAlignment(JLabel.CENTER);
        btnTxtDesencriptar.setToolTipText("Presione para desencriptar");
        btnTxtDesencriptar.setSize(new Dimension(50, 25));
        btnTxtDesencriptar.setLocation(300, 120);
        btnTxtDesencriptar.addActionListener(this);

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
        
        lblTxtDesencriptado = new JLabel("Texto original");
        lblTxtDesencriptado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        lblTxtDesencriptado.setForeground(new Color(0,0,0));
        lblTxtDesencriptado.setHorizontalAlignment(JLabel.CENTER);
        lblTxtDesencriptado.setSize(new Dimension(250, 25));
        lblTxtDesencriptado.setLocation(375, 25);
                
        txaTxtDesencriptado = new JTextArea(5, 10);
        txaTxtDesencriptado.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
        txaTxtDesencriptado.setForeground(new Color(0,0,0));
        txaTxtDesencriptado.setBackground(new Color(255, 255, 255));
        txaTxtDesencriptado.setEditable(true);
        
        scpTxtDesencriptado = new JScrollPane(txaTxtDesencriptado,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scpTxtDesencriptado.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
        scpTxtDesencriptado.setSize(new Dimension(250, 245));
        scpTxtDesencriptado.setLocation(375,60);
        
        add(lblClaveCifrado);
        add(txtClaveCifrado);
        add(lblTxtDesencriptar);
        add(scpTxtDesencriptar);
        add(btnTxtDesencriptar);
        add(btnLimpiar);
        add(lblTxtDesencriptado);
        add(scpTxtDesencriptado);
        setVisible(false);
    }
    private void limpiarCampos() {
        txtClaveCifrado.setText("");
        txaTxtDesencriptar.setText("");
        txaTxtDesencriptado.setText("");
    }
    
    private String validarCampos() {
        if (txtClaveCifrado.getText().isEmpty()) {
            return "Clave de cifrado vacia";
        } else if (txtClaveCifrado.getText().length() < 16) {
            return "Clave debe contener 16 caracteres";
        } else if (txtClaveCifrado.getText().length() > 16) {
            return "Clave no debe contener mas de 16 caracteres";
        } else if (txaTxtDesencriptar.getText().isEmpty()) {
            return "Ingrese texto a encriptar";
        }
        return "ok";
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String msg = validarCampos();
        if (evt.getSource() == btnTxtDesencriptar) {
            if (msg.compareTo("ok") == 0) {
                txaTxtDesencriptado.setText(new MEncriptacion().desencriptarAES(
                        txtClaveCifrado.getText(), txaTxtDesencriptar.getText()));
            } else {
                JOptionPane.showMessageDialog(this, msg, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (evt.getSource() == btnLimpiar) {
            limpiarCampos();
        }
    }
}
