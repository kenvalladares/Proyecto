package gui.animales;

import gui.MenuPrincipal.frmMenuPrincipal;
import negocio.animales.AnimalesNegocio;
import recursos.clases.Animales;
import gui.tienda.frmTienda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
public class frmAnimales {
    public JPanel jpaAnimales;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JTextField txtNombre;
    private JTextField txtRaza;
    private JTextField txtTamaño;
    private JTextField txtFechaNacimiento;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JTable tblDatos;
    private JLabel lvlNombre;
    private JLabel lvlRaza;
    private JLabel lvlTamaño;
    private JLabel lvlFechaNacimiento;
    private JButton btnListar;
    private JButton btnTienda;
    private JButton atrasButton;
    private JLabel lvlTipo;
    private JTextField txtTipo;
    private JScrollPane sclPanDatos;
    private JButton btnAtras;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;
    public static JFrame frameanimales = new JFrame("Registro de Animales");
    public static JFrame frameTienda = new JFrame("Tienda");

    public frmAnimales() {
    iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Animales animales = new Animales();
                    animales.setNombre(txtNombre.getText());
                    animales.setRaza(txtRaza.getText());
                    animales.setTamaño(txtTamaño.getText());
                    animales.setFechaNacimiento(ConvertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    animales.setTipo(txtTipo.getText());
                    String respuesta = new AnimalesNegocio().Insertar(animales);
                    if (!respuesta.contains("Error")){
                        JOptionPane.showMessageDialog(null,"Guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                    }
                    else
                        throw new Exception(respuesta);

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtFechaNacimiento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >='0')&&(c<='9') || (c == KeyEvent.VK_BACK_SPACE)||(c== KeyEvent.VK_DELETE) ||(c== KeyEvent.VK_SLASH)))
                {
                    JOptionPane.showMessageDialog(null,"Porfavor Ingrese una fecha correcta");
                    e.consume();
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Animales animales = new Animales();
                    animales.setRaza(txtRaza.getText());
                    animales.setNombre(txtNombre.getText());
                    animales.setTamaño(txtTamaño.getText());
                    animales.setFechaNacimiento(ConvertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    animales.setTipo(txtTipo.getText());
                    new AnimalesNegocio().Actualizar(animales);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Animales animales = new Animales();
                    animales.setRaza(txtRaza.getText());
                    animales.setNombre(txtNombre.getText());
                    animales.setNombre(txtTamaño.getText());
                    animales.setFechaNacimiento(ConvertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    animales.setTipo(txtTipo.getText());
                    new AnimalesNegocio().Eliminar(animales);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Animales animalBuscar = new Animales();
                    animalBuscar.setNombre(txtRaza.getText());
                    List<Animales> listaAnimales = new AnimalesNegocio().Buscar(animalBuscar);
                    modelo.setRowCount(0);
                    for (Animales animal: listaAnimales) {
                        Object[] registroLeido = {animal.getRaza(), animal.getNombre(),animal.getTamaño(),sdf.format(animal.getFechaNacimiento()), animal.getTipo()};
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtRaza.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtNombre.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtTamaño.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtFechaNacimiento.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                txtTipo.setText(modelo.getValueAt(filaSeleccionada,4).toString());
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMenuPrincipal.frameanimales.dispose();
            }
        });
        btnTienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameTienda.setContentPane(new frmTienda().jpaTienda);
                frameTienda.setResizable(false);
                frameTienda.pack();
                frameTienda.setLocationRelativeTo(null);
                frameTienda.setVisible(true);
            }
        });
    }
    private void leerDatos() {
        try {
            List<Animales> listaAnimales = new AnimalesNegocio().Leer();
            modelo.setRowCount(0);
            for (Animales animales: listaAnimales) {
                Object[] registroLeido = {animales.getRaza(),animales.getNombre(), animales.getTamaño(), sdf.format(animales.getFechaNacimiento()),animales.getTipo()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){

        }
    }
    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Raza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Tipo");
        leerDatos();
    }
    private Date ConvertirFormatoTextoFecha(String textoFecha){
        Date fecha = null;
        try {
            fecha =sdf.parse(textoFecha);

        }catch (ParseException pe){
            JOptionPane.showMessageDialog(null, pe.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }


    public static void main(String[] args) {
        frameanimales.setContentPane(new frmAnimales().jpaAnimales);
        frameanimales.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameanimales.pack();
        frameanimales.setVisible(true);
    }
}
