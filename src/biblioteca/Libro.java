 

import java.util.ArrayList;
/**
 * Write a description of class Libro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Libro{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;
 
    
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    public int getEdicion(){
        return this.edicion;
    }
    public String getEditorial(){
        return this.editorial;
    }
    public int getAnio(){
        return this.anio;
    }
    public ArrayList<Prestamo> getPrestamos(){
        return this.prestamos;
    }
    
    public void addPrestamo(Prestamo p_prestamo){
        this.prestamos.add(p_prestamo);
    }
    
    public boolean prestado(){
        Prestamos ultimo = ultimoPrestamo();
        return ultimo != null && ultimo.getFechaDevolucion() == null;
    }
    
    public Prestamo ultimoPrestamo(){
        if(prestamos.isEmpty()){
            return null;
        }
        return prestamos.get(prestamos.size() - 1);
    }
    
    @Override
    public String toString(){
        return "Titulo: " + this.titulo;
    }
    
}
