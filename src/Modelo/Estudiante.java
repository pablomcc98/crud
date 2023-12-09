
package Modelo;


public class Estudiante {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getNota_promedio() {
        return nota_promedio;
    }

    public void setNota_promedio(float nota_promedio) {
        this.nota_promedio = nota_promedio;
    }
    private String nombre;
    private String apellido;
    private int edad;
    private float nota_promedio;
}
