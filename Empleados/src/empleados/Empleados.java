package empleados;

import Controlador.CtrlEmpleado;
import Modelo.ConsultaEmpleado;
import Modelo.Empleado;
import Vista.frmEmpleado;

public class Empleados {

    public static void main(String[] args) {
        Empleado mod = new Empleado();
        ConsultaEmpleado modE = new ConsultaEmpleado();
        frmEmpleado frm = new frmEmpleado();
        CtrlEmpleado ctrl = new CtrlEmpleado(mod, modE, frm);
        ctrl.iniciar();
        frm.setVisible(true);
     
        
    }
}