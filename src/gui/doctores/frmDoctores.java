package gui.doctores;
import gui.MenuPrincipal.frmMenuPrincipal;
import negocio.animales.AnimalesNegocio;
import negocio.doctores.DoctoresNegocio;
import recursos.clases.Animales;
import recursos.clases.Doctores;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmDoctores {
    public JPanel jpaDoctores;
    private JTextField txtDNI;
    private JTextField txtNombre;
    private JTextField txtFechaNacimiento;
    private JTextField txtEspecialidad;
    private JPanel jpaIzquierdo;
    private JPanel jpaDerecho;
    private JPanel jpaSuperior;
    private JPanel jpaInferior;
    private JLabel lvlDNI;
    private JLabel lvlNombre;
    private JLabel lvlFechaNacimiento;
    private JLabel lvlEspecialidad;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnAtras;
    private JTable tblDatos;
    private JScrollPane sclPanDatos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;
    public frmDoctores() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Doctores doctores = new Doctores();
                    doctores.setDNI(Long.parseLong (txtDNI.getText()));
                    doctores.setNombre(txtNombre.getText());
;                   doctores.setEspecialidad(txtEspecialidad.getText());
                    doctores.setFechaNacimiento(ConvertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    String respuesta = new DoctoresNegocio().Insertar(doctores);
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
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtDNI.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtNombre.setText(modelo.getValueAt(filaSeleccionada,1).toString());
                txtFechaNacimiento.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtEspecialidad.setText(modelo.getValueAt(filaSeleccionada,3).toString());
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doctores doctores = new Doctores();
                    doctores.setDNI(Long.parseLong (txtDNI.getText()));
                    doctores.setNombre(txtNombre.getText());
                    doctores.setFechaNacimiento(ConvertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    doctores.setEspecialidad(txtEspecialidad.getText());
                    new DoctoresNegocio().Actualizar(doctores);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doctores doctores = new Doctores();
                    doctores.setDNI(Long.parseLong (txtDNI.getText()));
                    doctores.setNombre(txtNombre.getText());
                    doctores.setFechaNacimiento(ConvertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    doctores.setEspecialidad(txtEspecialidad.getText());
                    new DoctoresNegocio().Eliminar(doctores);
                    leerDatos();
                }catch (Exception ex){
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doctores doctorBuscar = new Doctores();
                    doctorBuscar.setNombre(txtDNI.getText());
                    List<Doctores> listaDoctores = new DoctoresNegocio().Buscar(doctorBuscar);
                    modelo.setRowCount(0);
                    for (Doctores doctor: listaDoctores) {
                        Object[] registroLeido = {doctor.getDNI(), doctor.getNombre(), sdf.format(doctor.getFechaNacimiento()), doctor.getEspecialidad()};
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMenuPrincipal.framedoctores.dispose();
            }
        });
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
    private void leerDatos() {
        try {
            List<Doctores> listaDoctores = new DoctoresNegocio().Leer();
            modelo.setRowCount(0);
            for (Doctores doctores: listaDoctores) {
                Object[] registroLeido = {doctores.getDNI(),doctores.getNombre(), sdf.format(doctores.getFechaNacimiento()),doctores.getEspecialidad()};
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        }catch (Exception e){

        }
    }
    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Especialidad");
        leerDatos();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("frmDoctores");
        frame.setContentPane(new frmDoctores().jpaDoctores);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
