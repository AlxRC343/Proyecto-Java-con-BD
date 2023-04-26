package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Modelo.ConsultaEmpleado;
import Modelo.Empleado;
import Vista.frmEmpleado;

/**
 *
 * @author edgar
 */
public class CtrlEmpleado implements ActionListener {

    private Empleado mod;
    private ConsultaEmpleado modE;
    private frmEmpleado frm;

    public CtrlEmpleado(Empleado mod, ConsultaEmpleado modE, frmEmpleado frm) {
        this.mod = mod;
        this.modE = modE;
        this.frm = frm;

        this.frm.btnBuscar.addActionListener((ActionListener) this);
        this.frm.btnEliminar.addActionListener((ActionListener) this);
        this.frm.btnNuevo.addActionListener((ActionListener) this);
        this.frm.btnActualizar.addActionListener((ActionListener) this);
    }

    public void iniciar() {
        frm.setTitle("Empleados");
        frm.setLocationRelativeTo(null);
        //frm.txtid.setVisible(false); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnNuevo) {
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellidoP(frm.txtApellidoP.getText());
            mod.setApellidoM(frm.txtApellidoM.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setRfc(frm.txtRFC.getText());
            mod.setPuesto(String.valueOf(frm.txtPuesto.getSelectedItem()));
            mod.setGrado(String.valueOf(frm.txtGrado.getSelectedItem()));
            mod.setEn(frm.txtEn.getText());
            mod.setTsangre(String.valueOf(frm.txtTSangre.getSelectedItem()));
            mod.setPadecimiento(frm.txtProcedimiento.getText());
            mod.setNempleado(Integer.parseInt(frm.txtNEmpleado.getText()));
            mod.setTelefono(Integer.parseInt(frm.txtNumero.getText()));
            if (modE.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar");
            }
        }

        if (e.getSource() == frm.btnActualizar) {
            mod.setNombre(frm.txtNombre.getText());
            mod.setApellidoP(frm.txtApellidoP.getText());
            mod.setApellidoM(frm.txtApellidoM.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setRfc(frm.txtRFC.getText());
            mod.setPuesto(String.valueOf(frm.txtPuesto.getSelectedItem()));
            mod.setGrado(String.valueOf(frm.txtGrado.getSelectedItem()));
            mod.setEn(frm.txtEn.getText());
             mod.setTsangre(String.valueOf(frm.txtTSangre.getSelectedItem()));
            mod.setPadecimiento(frm.txtProcedimiento.getText());
            mod.setNempleado(Integer.parseInt(frm.txtNEmpleado.getText()));
            mod.setTelefono(Integer.parseInt(frm.txtNumero.getText()));
            if (modE.actualizar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro modificado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");

            }
        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setNempleado(Integer.parseInt(frm.txtNEmpleado.getText()));

            if (modE.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");

            }
        }

        if (e.getSource() == frm.btnBuscar) {
            mod.setNempleado(Integer.parseInt(frm.txtNEmpleado.getText()));

            if (modE.buscar(mod)) {
                frm.txtNombre.setText(mod.getNombre());
                frm.txtApellidoP.setText(mod.getApellidoP());
                frm.txtApellidoM.setText(mod.getApellidoM());
                frm.txtDireccion.setText(mod.getApellidoM());
                frm.txtRFC.setText(mod.getRfc());
                frm.txtCurp.setText(mod.getCurp());
                frm.txtPuesto.setToolTipText(mod.getPuesto());
                frm.txtGrado.setToolTipText(mod.getGrado());
                frm.txtEn.setText(mod.getEn());
                frm.txtTSangre(String.valueOf(mod.getTsangre()));
                frm.txtProcedimiento.setText(mod.getPadecimiento());
                frm.txtNEmpleado.setText(String.valueOf(mod.getNempleado()));
                frm.txtNumero.setText(String.valueOf(mod.getTelefono()));
                frm.txtEmail.setText(mod.getEmail());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el resultado");

            }
        }
    }
}
