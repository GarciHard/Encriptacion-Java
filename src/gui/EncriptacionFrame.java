package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Hecho con <3 por:
 * @author GarciHard
 */
public class EncriptacionFrame extends JFrame implements ActionListener{
    
    private EncriptarPanel pnlEncriptar;
    private DesencriptarPanel pnlDesencriptar;
    
    private JButton btnEncriptar;
    private JButton btnDesencriptar;
    private JLabel lblTitulo;
    private JPanel pnlBackground;
    
    public EncriptacionFrame() {
        initFrame();
    }
    
    private void initFrame() {
        setTitle("Encriptación RSA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
                
        pnlBackground = new JPanel(null);
        pnlBackground.setSize(getWidth(), getHeight());
        pnlBackground.setBackground(new Color(255,255,255));
        
        lblTitulo = new JLabel("Encriptación con algoritmo RSA");
        lblTitulo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
        lblTitulo.setForeground(new Color(0,0,0));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        lblTitulo.setSize(new Dimension(getWidth(), 50));
        lblTitulo.setLocation(0, 0);

        btnEncriptar = new JButton("Encriptar");
        btnEncriptar.setBackground(new Color(64,  224, 208));
        btnEncriptar.setContentAreaFilled(false);
        btnEncriptar.setOpaque(true);
        btnEncriptar.setFocusPainted(false);
        btnEncriptar.setBorderPainted(false);
        btnEncriptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnEncriptar.setForeground(new Color(0,0,0));
        btnEncriptar.setHorizontalAlignment(JLabel.CENTER);
        btnEncriptar.setSize(new Dimension(200, 50));
        btnEncriptar.setLocation(25, 75);
        btnEncriptar.addActionListener(this);

        btnDesencriptar = new JButton("Desencriptar");
        btnDesencriptar.setBackground(new Color(186,  85,  211));
        btnDesencriptar.setContentAreaFilled(false);
        btnDesencriptar.setOpaque(true);
        btnDesencriptar.setFocusPainted(false);
        btnDesencriptar.setBorderPainted(false);
        btnDesencriptar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnDesencriptar.setForeground(new Color(0, 0, 0));
        btnDesencriptar.setHorizontalAlignment(JLabel.CENTER);
        btnDesencriptar.setSize(new Dimension(200, 50));
        btnDesencriptar.setLocation(250, 75);
        btnDesencriptar.addActionListener(this);
        
        pnlBackground.add(lblTitulo);
        pnlBackground.add(btnEncriptar);
        pnlBackground.add(btnDesencriptar);
        pnlBackground.add(pnlEncriptar = new EncriptarPanel());
        pnlBackground.add(pnlDesencriptar = new DesencriptarPanel());

        add(pnlBackground);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == btnEncriptar) {
            pnlEncriptar.setVisible(true);
            pnlDesencriptar.setVisible(false);
        }
        if (evt.getSource() == btnDesencriptar) {
            pnlDesencriptar.setVisible(true);
            pnlEncriptar.setVisible(false);
        }
    }   
}
