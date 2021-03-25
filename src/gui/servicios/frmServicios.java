package gui.servicios;
import gui.tienda.frmTienda;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import gui.carrito.frmCarrito;
import negocio.productos.ProductosNegocio;
import recursos.clases.Productos;

public class frmServicios {
    public JPanel jpaPrincipal;
    private JPanel jpaServicios;
    private JButton btnAñadir;
    private JButton btnVerCarrito;
    private JButton btnAtras;
    private JPanel jpaSuperior;
    private JButton btnInformacion;
    private JPanel jpaIzquierdo;
    private JRadioButton rbtBaño;
    private JRadioButton rbtLavadoOrejas;
    private JRadioButton rbtCorteUñas;
    private JRadioButton rbtCastracion;
    private JRadioButton rbtCirugia;
    private JRadioButton rbtVacunacion;
    private JTextArea txaLista;
    DefaultTableModel modelo;
    public static JFrame frameCarrito= new JFrame("Carrito de Compras");
    public frmServicios() {
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmTienda.frameServicios.dispose();
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
                String Nombre = " ";
                String Codigo = " ";
                String Precio = " ";
                String Datos  = " ";
                int cont = 0;
                if (rbtBaño.isSelected()){
                    Nombre = "Baño básico para perro y gato";
                    Codigo = "567";
                    Precio = "300 Lps.";
                    Datos = "Nombre: Baño básico para perro o gato\n Código:567\n Precio:300Lps";
                }
                if (rbtLavadoOrejas.isSelected()){
                    Nombre = "Lavado de orejas";
                    Codigo = "568";
                    Precio = "200 Lps.";
                    Datos = "Nombre: Lavado de orejas para perro o gato\n Código:568\n Precio:200Lps";
                }
                if (rbtCorteUñas.isSelected()){
                    Nombre = "Corte de uñas para perro o gato";
                    Codigo = "569";
                    Precio = "350 Lps";
                    Datos = "Nombre: Corte de uñas para perro o gato\n Codigo:569\n Precio:350Lps";
                }
                if (rbtCastracion.isSelected()){
                    Nombre = "Castración a su perro o gato";
                    Codigo = "578";
                    Precio = "700 Lps.";
                    Datos = "Nombre: Extirpación o inutilización de los órganos genitales del animal\n Codigo:0985\n Precio:700Lps";
                }
                if (rbtCirugia.isSelected()){
                    Nombre = "Cirugia Animal";
                    Codigo = "579";
                    Precio = "12000 Lps.";
                    Datos = "Nombre: Cirugía para animal\n Codigo:579\n Precio:12000Lps";
                }
                if (rbtVacunacion.isSelected()){
                    Nombre = "Vacuna y desparasitación a su mascota";
                    Codigo = "589";
                    Precio = "700 Lps.";
                    Datos = "Nombre: Aplicación de vacuna y desparasitantes\n Codigo:0982\n Precio:99Lps";
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
                    if (rbtBaño.isSelected()){
                        Nombre = "Baño";
                        Codigo = 567;
                        Precio = 300;
                        Productos servicios = new Productos();
                        servicios.setNombre(Nombre);
                        servicios.setCodigo(Codigo);
                        servicios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(servicios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtLavadoOrejas.isSelected()){
                        Nombre = "Lavado de Orejas";
                        Codigo = 568;
                        Precio = 200;
                        Productos servicios = new Productos();
                        servicios.setNombre(Nombre);
                        servicios.setCodigo(Codigo);
                        servicios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(servicios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtCorteUñas.isSelected()){
                        Nombre = "Corte de Uñas";
                        Codigo = 569;
                        Precio = 350;
                        Productos servicios = new Productos();
                        servicios.setNombre(Nombre);
                        servicios.setCodigo(Codigo);
                        servicios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(servicios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtCastracion.isSelected()){
                        Nombre = "Castracion";
                        Codigo = 578;
                        Precio = 700;
                        Productos servicios = new Productos();
                        servicios.setNombre(Nombre);
                        servicios.setCodigo(Codigo);
                        servicios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(servicios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtCirugia.isSelected()){
                        Nombre = "Cirugia";
                        Codigo = 579;
                        Precio = 12000;
                        Productos servicios = new Productos();
                        servicios.setNombre(Nombre);
                        servicios.setCodigo(Codigo);
                        servicios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(servicios);
                        if (!respuesta.contains("Error")){
                            JOptionPane.showMessageDialog(null,"Añadido Exitosamente","Exito",JOptionPane.INFORMATION_MESSAGE);
                            leerDatos();
                        }else
                            throw new Exception(respuesta);
                    }
                    if (rbtVacunacion.isSelected()){
                        Nombre = "Vacunacion";
                        Codigo = 589;
                        Precio = 700;
                        Productos servicios = new Productos();
                        servicios.setNombre(Nombre);
                        servicios.setCodigo(Codigo);
                        servicios.setPrecio(Precio);
                        String respuesta = new ProductosNegocio().Insertar(servicios);
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
            List<Productos> listaservicios = new ProductosNegocio().Leer();
            modelo.setRowCount(0);
            for (Productos servicios: listaservicios) {
                Object[] registroLeido = {servicios.getNombre(),servicios.getPrecio(),servicios.getCodigo()};
                modelo.addRow(registroLeido);
            }
        }catch (Exception e){

        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana de Servicios");
        frame.setContentPane(new frmServicios().jpaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
