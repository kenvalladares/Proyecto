package gui.productos.accesorios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gui.productos.frmProductos;
import gui.productos.medicamentos.frmMedicamentos;
import gui.carrito.frmCarrito;
import negocio.animales.AnimalesNegocio;
import negocio.productos.ProductosNegocio;
import recursos.clases.Animales;
import recursos.clases.Productos;

public class frmAccesorios {
    public JPanel jpaPrincipal;
    private JPanel jpaMenuAccesorios;
    private JButton btnAñadir;
    private JButton btnVerCarrito;
    private JButton btnAtras;
    private JPanel jpaSuperior;
    private JButton btnInformacion;
    private JRadioButton rbtCorrea;
    private JRadioButton rbtCepillo;
    private JRadioButton rbtCollar;
    private JRadioButton rbtCamisa;
    private JRadioButton rbtHueso;
    private JRadioButton rbtPlato;
    private JTextArea txaLista;
    DefaultTableModel modelo;
    public static JFrame frameCarrito= new JFrame("Carrito de Compras");
    public frmAccesorios() {
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmProductos.frameAccesorios.dispose();
            }
        });
        btnVerCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCarrito.setContentPane(new frmCarrito().jpaPrincipal);
                frameCarrito.setResizable(false);
                frameCarrito.pack();
                frameCarrito.setLocationRelativeTo(null);
                frameCarrito.setVisible(true);
            }
        });
        btnInformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = "";
                String Codigo = "";
                String Precio = "";
                String Datos ="";
                if (rbtCorrea.isSelected()){
                    Nombre = "Correa para perro o gato";
                    Codigo = "0987";
                    Precio = "150 Lps.";

                    Datos = "Nombre: Correa para perro o gato\n Codigo:0987\n Precio:150Lps";
                }
                if (rbtCepillo.isSelected()){
                    Nombre = "Cepillo para peinar";
                    Codigo = "0986";
                    Precio = "99 Lps.";

                    Datos = "Nombre: Cepillo para peinar\n Codigo:0986\n Precio:99Lps";
                }
                if (rbtCollar.isSelected()){
                    Nombre = "Collar con nombre estampado";
                    Codigo = "0985";
                    Precio = "300 Lps.";

                    Datos = "Nombre: Collar con nombre estampado\n Codigo:0985\n Precio:300Lps";
                }
                if (rbtCamisa.isSelected()){
                    Nombre = "Camisa de colores";
                    Codigo = "0984";
                    Precio = "120 Lps.";

                    Datos = "Nombre: Camisa de colores\n Codigo:0985\n Precio:120Lps";
                }
                if (rbtHueso.isSelected()){
                    Nombre = "Hueso de juguete";
                    Codigo = "0983";
                    Precio = "145 Lps.";

                    Datos = "Nombre: Hueso de juguete\n Codigo:0983\n Precio:145Lps";
                }
                if (rbtPlato.isSelected()){
                    Nombre = "Plato doble para comida y agua";
                    Codigo = "0982";
                    Precio = "400 Lps.";

                    Datos = "Nombre: Plato doble para comida y agua\n Codigo:0982\n Precio:99Lps";
                }
                txaLista.setText(Datos);
            }
        });
        btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String Nombre = "";
                    int Codigo = 0;
                    int Precio = 0;
                    String Datos ="";
                    if (rbtCorrea.isSelected()){
                        Nombre = "Correa";
                        Codigo = 987;
                        Precio = 150;
                        Productos accesorios = new Productos();
                        accesorios.setNombre(Nombre);
                        accesorios.setCodigo(Codigo);
                        accesorios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(accesorios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtCepillo.isSelected()){
                        Nombre = "Cepillo";
                        Codigo = 986;
                        Precio = 99;
                        Productos accesorios = new Productos();
                        accesorios.setNombre(Nombre);
                        accesorios.setCodigo(Codigo);
                        accesorios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(accesorios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtCollar.isSelected()){
                        Nombre = "Collar";
                        Codigo = 985;
                        Precio = 300;
                        Productos accesorios = new Productos();
                        accesorios.setNombre(Nombre);
                        accesorios.setCodigo(Codigo);
                        accesorios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(accesorios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtCamisa.isSelected()){
                        Nombre = "Camisa";
                        Codigo = 984;
                        Precio = 120;
                        Productos accesorios = new Productos();
                        accesorios.setNombre(Nombre);
                        accesorios.setCodigo(Codigo);
                        accesorios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(accesorios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtHueso.isSelected()){
                        Nombre = "Hueso";
                        Codigo = 983;
                        Precio = 145;
                        Productos accesorios = new Productos();
                        accesorios.setNombre(Nombre);
                        accesorios.setCodigo(Codigo);
                        accesorios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(accesorios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtPlato.isSelected()){
                        Nombre = "Plato";
                        Codigo = 982;
                        Precio = 400;
                        Productos accesorios = new Productos();
                        accesorios.setNombre(Nombre);
                        accesorios.setCodigo(Codigo);
                        accesorios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(accesorios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
    private void leerDatos() {
        try {
            List<Productos> listaaccesorios = new ProductosNegocio().Leer();
            modelo.setRowCount(0);
            for (Productos accesorios: listaaccesorios) {
                Object[] registroLeido = {accesorios.getNombre(),accesorios.getPrecio(),accesorios.getCodigo()};
                modelo.addRow(registroLeido);
            }
        }catch (Exception e){

        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana de Accesorios");
        frame.setContentPane(new frmAccesorios().jpaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
