package gui.productos.medicamentos;
import gui.productos.frmProductos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gui.carrito.frmCarrito;
import negocio.animales.AnimalesNegocio;
import negocio.productos.ProductosNegocio;
import recursos.clases.Animales;
import recursos.clases.Productos;

public class frmMedicamentos {
    public JPanel jpaPrincipal;
    private JPanel jpaMedicamentos;
    private JButton btnAñadir;
    private JButton btnVerCarrito;
    private JButton btnAtras;
    private JPanel jpaSuperior;
    private JButton btnInformacion;
    private JRadioButton rbtGastroenteril;
    private JRadioButton rbtDipramida;
    private JRadioButton rbtNaxpet;
    private JRadioButton rbtAllerbay;
    private JRadioButton rbtGarrabaño;
    private JRadioButton rbtDrontal;
    private JPanel jpaIzquierdo;
    private JTextArea txtLista;
    public static JFrame frameCarrito= new JFrame("Carrito de Compras");
    DefaultTableModel modelo;
    public frmMedicamentos() {
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmProductos.frameMedicamentos.dispose();
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
        btnAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Nombre = "";
                    int Codigo = 0;
                    int Precio = 0;
                    String Datos ="";
                    if (rbtGastroenteril.isSelected()){
                        Nombre = "Gastroenteril";
                        Codigo = 123;
                        Precio = 200;
                        Productos medicamentos = new Productos();
                        medicamentos.setNombre(Nombre);
                        medicamentos.setCodigo(Codigo);
                        medicamentos.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(medicamentos);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtDipramida.isSelected()){
                        Nombre = "Dipramida";
                        Codigo = 124;
                        Precio = 300;
                        Productos medicamentos = new Productos();
                        medicamentos.setNombre(Nombre);
                        medicamentos.setCodigo(Codigo);
                        medicamentos.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(medicamentos);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtNaxpet.isSelected()){
                        Nombre = "Naxpet";
                        Codigo = 125;
                        Precio = 150;
                        Productos medicamentos = new Productos();
                        medicamentos.setNombre(Nombre);
                        medicamentos.setCodigo(Codigo);
                        medicamentos.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(medicamentos);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtAllerbay.isSelected()){
                        Nombre = "Allerbay";
                        Codigo = 126;
                        Precio = 400;
                        Productos medicamentos = new Productos();
                        medicamentos.setNombre(Nombre);
                        medicamentos.setCodigo(Codigo);
                        medicamentos.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(medicamentos);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtGarrabaño.isSelected()){
                        Nombre = "Garrabaño";
                        Codigo = 127;
                        Precio = 600;
                        Productos medicamentos = new Productos();
                        medicamentos.setNombre(Nombre);
                        medicamentos.setCodigo(Codigo);
                        medicamentos.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(medicamentos);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtDrontal.isSelected()){
                        Nombre = "Drontal";
                        Codigo = 128;
                        Precio = 800;
                        Productos medicamentos = new Productos();
                        medicamentos.setNombre(Nombre);
                        medicamentos.setCodigo(Codigo);
                        medicamentos.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(medicamentos);
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
        btnInformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = "";
                String Codigo = "";
                String Precio = "";
                String Datos ="";
                if (rbtGastroenteril.isSelected()){
                    Nombre = "Gastroenteril";
                    Codigo = "123";
                    Precio = "200 Lps.";
                    Datos = "Nombre: Gastroenteril\n Descripcion:Suspension oral para la diarrea\n Precio:200Lps";
                }
                if (rbtDipramida.isSelected()){
                    Nombre = "Dipramida";
                    Codigo = "124";
                    Precio = "300 Lps.";
                    Datos = "Nombre:Dipramida\n Descripcion:Solucion oral para el vomito\n Precio:300Lps";
                }
                if (rbtNaxpet.isSelected()){
                    Nombre = "Naxpet";
                    Codigo = "125";
                    Precio = "150 Lps.";
                    Datos = "Nombre: Naxpet\n Descripcion:Pastillas para las inflamaciones y condiciones dolorosas de los huesos\n Precio:150Lps";
                }
                if (rbtAllerbay.isSelected()){
                    Nombre = "Allerbay";
                    Codigo = "126";
                    Precio = "400 Lps.";
                    Datos = "Nombre: Allerbay\n Descripcion:Antialergico y Antinflamatorio\n Precio:400Lps";
                }
                if (rbtGarrabaño.isSelected()){
                    Nombre = "Garrabaño";
                    Codigo = "127";
                    Precio = "600 Lps.";
                    Datos = "Nombre: Garrabaño\n Descripcion:Solucion contra garrapatas, acaros, pulgas y piojos\n Precio:600Lps";
                }
                if (rbtDrontal.isSelected()){
                    Nombre = "Drontal";
                    Codigo = "128";
                    Precio = "800 Lps.";
                    Datos = "Nombre: Drontal\n Descripcion:Pastillas Desparasitante para perros y gatos \n Precio:800Lps";
                }
                txtLista.setText(Datos);
            }
        });
    }
    private void leerDatos() {
        try {
            List<Productos> listamedicamentos = new ProductosNegocio().Leer();
            modelo.setRowCount(0);
            for (Productos medicamentos: listamedicamentos) {
                Object[] registroLeido = {medicamentos.getNombre(),medicamentos.getPrecio(),medicamentos.getCodigo()};
                modelo.addRow(registroLeido);
            }
        }catch (Exception e){

        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana de Medicamentos");
        frame.setContentPane(new frmMedicamentos().jpaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
