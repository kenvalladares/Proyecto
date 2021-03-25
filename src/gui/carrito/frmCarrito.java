package gui.carrito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.PreparedStatement;
import java.util.List;
import gui.factura.frmFactura;
import gui.productos.accesorios.frmAccesorios;
import gui.productos.medicamentos.frmMedicamentos;
import gui.servicios.frmServicios;
import gui.productos.frmProductos;
import gui.MenuPrincipal.frmMenuPrincipal;
import gui.tienda.frmTienda;
import negocio.animales.AnimalesNegocio;
import negocio.productos.ProductosNegocio;
import recursos.clases.Animales;
import recursos.clases.Productos;


public class frmCarrito {
    public static JFrame frameFactura = new JFrame("Factura");
    public JPanel jpaPrincipal;
    private JButton btnAtras;
    private JButton btnPagar;
    private JPanel jpaInferior;
    private JPanel jpaSuperior;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JTextArea txtTotalPagar;
    private JLabel lvlTotalPagar;
    private JButton btnEliminarProducto;
    DefaultTableModel modelo;
    private String NombreE;
    private String CodigoE;
    private String PrecioE;
    private int Total;
    public frmCarrito() {
        iniciar();
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAccesorios.frameCarrito.dispose();
                frmMedicamentos.frameCarrito.dispose();
                frmServicios.frameCarrito.dispose();
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameFactura.setContentPane(new frmFactura().jpaPrincipal);
                frameFactura.setResizable(false);
                frameFactura.pack();
                frameFactura.setLocationRelativeTo(null);
                frameFactura.setVisible(true);
            }
        });

        tblDatos.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {


            }
        });
    }
    private void leerDatos() {
        try {
            List<Productos> listaproductos = new ProductosNegocio().Leer();
            modelo.setRowCount(0);
            for (Productos productos: listaproductos) {
                Object[] registroLeido = {productos.getNombre(),productos.getPrecio(),productos.getCodigo()};
                Total = Total+productos.getPrecio();
                txtTotalPagar.setText(String.valueOf(Total));
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){

        }
    }
    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Codigo");
        leerDatos();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carrito de Compras");
        frame.setContentPane(new frmCarrito().jpaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
