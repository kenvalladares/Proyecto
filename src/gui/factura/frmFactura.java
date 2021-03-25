package gui.factura;
import gui.carrito.frmCarrito;
import gui.animales.frmAnimales;
import gui.doctores.frmDoctores;
import gui.MenuPrincipal.frmMenuPrincipal;
import gui.productos.medicamentos.frmMedicamentos;
import gui.productos.accesorios.frmAccesorios;
import gui.productos.frmProductos;
import gui.tienda.frmTienda;
import negocio.animales.AnimalesNegocio;
import negocio.productos.ProductosNegocio;
import recursos.clases.Animales;
import recursos.clases.Productos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class frmFactura {
    public static JFrame frameMenuPrincipal = new JFrame("Menu Principal");
    public  JPanel jpaPrincipal;
    private JRadioButton rbtTarjetaCredito;
    private JRadioButton rbtTarjetaDebito;
    private JRadioButton rbtEfectivo;
    private JTextArea txaLista;
    private JButton btnPagar;
    private JButton btnSalir;
    private JButton MenuPrincipal;

    public frmFactura() {
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info="";
                if (rbtTarjetaCredito.isSelected()){
                     info="Metodo de pago seleccionado: Tarjeta de Credito";
                }
                if (rbtTarjetaDebito.isSelected()){
                    info="Metodo de pago seleccionado: Tarjeta de Debito";
                }
                if (rbtEfectivo.isSelected()){
                    info="Metodo de pago seleccionado: Efectivo";
                }
                txaLista.setText(info);
                JOptionPane.showMessageDialog(null,"Pago Realizado con Exito","Exito",JOptionPane.INFORMATION_MESSAGE);
                try {
                    List<Productos> listaproductos = new ProductosNegocio().Leer();
                    for (Productos productose: listaproductos) {
                        Object[] registroLeido = {productose.getNombre(),productose.getPrecio(),productose.getCodigo()};
                        new ProductosNegocio().Eliminar(productose);
                    }
                }catch (Exception ex){
                }

            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        MenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
    }
public static void cerrar(){
    frmMenuPrincipal.framePrincipal.dispose();
    frmCarrito.frameFactura.dispose();
    frmMenuPrincipal.framePrincipal.dispose();
    frmMenuPrincipal.frameanimales.dispose();
    frmProductos.frameProductos.dispose();
    frmProductos.frameMedicamentos.dispose();
    frmProductos.frameAccesorios.dispose();
    frmAccesorios.frameCarrito.dispose();
    frmMedicamentos.frameCarrito.dispose();
    frmAnimales.frameanimales.dispose();
    frmAnimales.frameTienda.dispose();
    frmTienda.frameProductos.dispose();
    frameMenuPrincipal.setContentPane(new frmMenuPrincipal().jpaPrincipal);
    frameMenuPrincipal.setResizable(false);
    frameMenuPrincipal.pack();
    frameMenuPrincipal.setLocationRelativeTo(null);
    frameMenuPrincipal.setVisible(true);
}
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana de Factura");
        frame.setContentPane(new frmFactura().jpaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
