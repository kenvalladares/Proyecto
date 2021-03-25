package gui.tienda;
import gui.animales.frmAnimales;
import gui.doctores.frmDoctores;
import gui.productos.frmProductos;
import gui.MenuPrincipal.frmMenuPrincipal;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.servicios.frmServicios;

public class frmTienda {
    public JPanel jpaTienda;
    public JPanel jpaMenuTienda;
    private JButton btnProductos;
    private JButton btnServicios;
    private JButton btnAtras;
    private JLabel lvlImagenProducto;
    private JLabel lvlImagenServicios;
    public static JFrame frameTienda = new JFrame("Tienda");
    public static JFrame frameProductos = new JFrame("Registro de Productos");
    public static JFrame frameServicios = new JFrame("Registro de Servicios");
    public frmTienda() {
        btnProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameProductos.setContentPane(new frmProductos().jpaPrincipal);
                frameProductos.setResizable(false);
                frameProductos.pack();
                frameProductos.setLocationRelativeTo(null);
                frameProductos.setVisible(true);
            }
        });

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAnimales.frameTienda.dispose();

            }
        });
        btnServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameServicios.setContentPane(new frmServicios().jpaPrincipal);
                frameServicios.setResizable(false);
                frameServicios.pack();
                frameServicios.setLocationRelativeTo(null);
                frameServicios.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        frameTienda.setContentPane(new frmTienda().jpaTienda);
        frameTienda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTienda.pack();
        frameTienda.setVisible(true);
    }
}
