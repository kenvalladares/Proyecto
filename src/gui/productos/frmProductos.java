package gui.productos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.tienda.frmTienda;
import gui.productos.accesorios.frmAccesorios;
import gui.productos.medicamentos.frmMedicamentos;
public class frmProductos {
    public JPanel jpaPrincipal;
    private JPanel jpaMenuProductos;
    private JButton btnMedicamentos;
    private JButton btnAccesorios;
    private JButton btnAtras;
    private JLabel lvlImagenMedicamentos;
    private JLabel lvlImagenAccesorios;
    public static JFrame frameMedicamentos= new JFrame("Medicamentos");
    public static JFrame frameAccesorios = new JFrame("Accesorios");
    public static JFrame frameProductos = new JFrame("Ventana de Productos");
    public frmProductos() {
        btnMedicamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMedicamentos.setContentPane(new frmMedicamentos().jpaPrincipal);
                frameMedicamentos.setResizable(false);
                frameMedicamentos.pack();
                frameMedicamentos.setLocationRelativeTo(null);
                frameMedicamentos.setVisible(true);

            }
        });
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmTienda.frameProductos.dispose();
            }
        });
        btnAccesorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frameAccesorios.setContentPane(new frmAccesorios().jpaPrincipal);
                frameAccesorios.setResizable(false);
                frameAccesorios.pack();
                frameAccesorios.setLocationRelativeTo(null);
                frameAccesorios.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        frameProductos.setContentPane(new frmProductos().jpaPrincipal);
        frameProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameProductos.pack();
        frameProductos.setVisible(true);
    }
}
