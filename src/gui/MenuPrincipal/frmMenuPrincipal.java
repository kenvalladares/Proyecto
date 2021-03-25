package gui.MenuPrincipal;

import gui.animales.frmAnimales;
import gui.doctores.frmDoctores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmMenuPrincipal {
    public JPanel jpaPrincipal;
    public JButton btnAnimales;
    public JButton btnDoctores;
    public JPanel jpaMenu;
    private JLabel lvlImagenDoctor;
    private JLabel lvlImagenGato;
    private JLabel lvlImagenDoctora;
    private JLabel lvlImagenPerro;
    public static JFrame frameanimales = new JFrame("Registro de Animales");
    public static JFrame framedoctores = new JFrame("Registro de Doctores");
    public static JFrame framePrincipal = new JFrame("Menu Principal");
    public frmMenuPrincipal() {
        btnAnimales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameanimales.setContentPane(new frmAnimales().jpaAnimales);
                frameanimales.setResizable(false);
                frameanimales.pack();
                frameanimales.setLocationRelativeTo(null);
                frameanimales.setVisible(true);
            }
        });
        btnDoctores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framedoctores.setContentPane(new frmDoctores().jpaDoctores);
                framedoctores.setResizable(false);
                framedoctores.pack();
                framedoctores.setLocationRelativeTo(null);
                framedoctores.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {

        framePrincipal.setContentPane(new frmMenuPrincipal().jpaPrincipal);
        framePrincipal.setResizable(false);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.pack();
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setVisible(true);
    }
}
