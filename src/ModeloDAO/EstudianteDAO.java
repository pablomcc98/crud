
package ModeloDAO;

import Config.Conexion;
import Interfaces.CrudService;
import Modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDAO implements CrudService<Estudiante>{
    
    private final String GUARDAR_Estudiante = "INSERT INTO estudiantes (nombre, apellido, edad, nota_promedio) values (?,?,?,?)";
    private final String LISTAR_Estudiante = "SELECT * from estudiantes";
    private final String ELIMINAR_Estudiante = "UPDATE estudiantes SET eliminar=false  WHERE Id=?";
    private final String EDITAR_Estudiante = "UPDATE estudiantes SET nombre=? WHERE Id=?";
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    

    @Override
    public boolean add(Estudiante estudiante) {
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(GUARDAR_Estudiante);
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getApellido());
            ps.setInt(4, estudiante.getEdad());
            ps.setFloat(5, estudiante.getNota_promedio());
            
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List listar() {
        ArrayList<Estudiante> list = new ArrayList<>();
        
         try {
            con = cn.Conectar();
            ps = con.prepareStatement(LISTAR_Estudiante);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getNString("apellido"));
                estudiante.setEdad(rs.getInt("edad"));
                estudiante.setNota_promedio(rs.getFloat("nota_promedio"));
                
                list.add(estudiante);
                
                System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4));   
            }
        } catch (SQLException e) {
             System.out.println(e);
        }
        return list;
        
    }

    @Override
    public Estudiante list(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean edit(Estudiante estudiante) {
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(EDITAR_Estudiante);

            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setInt(3, estudiante.getEdad());
            ps.setFloat(4, estudiante.getNota_promedio());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        
    }

    @Override
    public boolean eliminar(int id) {
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(ELIMINAR_Estudiante);

            ps.setInt(1, id);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        EstudianteDAO ud = new EstudianteDAO();
        ud.listar();
    }
    
}
