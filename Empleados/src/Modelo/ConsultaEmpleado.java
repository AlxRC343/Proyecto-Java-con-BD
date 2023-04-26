package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultaEmpleado extends Conexion {

    public boolean registrar(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO empleados(nombre,apellidoP,apellidoM,direccion,rfc,curp,puesto,grado,en,tsangre,padecimiento,nempleado,telefono)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellidoP());
            ps.setString(3, emp.getApellidoM());
            ps.setString(4, emp.getDireccion());
            ps.setString(5, emp.getRfc());
            ps.setString(6, emp.getCurp());
            ps.setString(7, emp.getPuesto());
            ps.setString(8, emp.getGrado());
            ps.setString(9, emp.getEn());
            ps.setString(10, emp.getTsangre());
            ps.setString(11, emp.getPadecimiento());
            ps.setInt(12, emp.getNempleado());
            ps.setInt(13, emp.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }

    public boolean actualizar(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE empleados SET nombre=?, apellidoP=?,apellidoM=?, direccion=? ,rfc=?, curp=?,puesto=?, grado=?,en=?, tsangre=?, padecimiento=?,telefono=? WHERE nempleado=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellidoP());
            ps.setString(3, emp.getApellidoM());
            ps.setString(4, emp.getDireccion());
            ps.setString(5, emp.getRfc());
            ps.setString(6, emp.getCurp());
            ps.setString(7, emp.getPuesto());
            ps.setString(8, emp.getGrado());
            ps.setString(9, emp.getEn());
            ps.setString(10, emp.getTsangre());
            ps.setString(11, emp.getPadecimiento());
            ps.setInt(12, emp.getNempleado());
            ps.setInt(13, emp.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }

    public boolean eliminar(Empleado emp) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM empleados WHERE nempleado=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getNempleado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
    }

    public boolean buscar(Empleado emp) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM empleados WHERE nombre=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setNombre(rs.getString("nombre"));
                emp.setApellidoP(rs.getString("apellidoP"));
                emp.setApellidoM(rs.getString("apellidoM"));
                emp.setDireccion(rs.getString("apellidoP"));
                emp.setRfc(rs.getString("rfc"));
                emp.setCurp(rs.getString("curp"));
                emp.setPuesto(rs.getString("´puesto"));
                emp.setGrado(rs.getString("grado"));
                emp.setEn(rs.getString("en"));
                emp.setTsangre(rs.getString("apellidoP"));
                emp.setPadecimiento(rs.getString("rfc"));
                emp.setNempleado(Integer.parseInt(rs.getString("nempleado")));     
            }
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
        return buscar(emp);

    }
}
