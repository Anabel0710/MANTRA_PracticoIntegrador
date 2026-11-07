package biblioteca 
import java.util.ArrayList;
import java.util.Calendar;

/**
 * TP N 7 Clase Abstracta Socio
 * 
 * @author Lezcano Magali
 * @version 1
 */
public abstract  class Socio
{
    // se define los atributos de socio
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos; 
    
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos = new ArrayList<Prestamo>();
    }
    
    private void setDniSocio(int p_dniSocio){
     this.dniSocio= p_dniSocio;
    }
    
    private void setNombre(String p_nombre){
     this.nombre= p_nombre;
    }
    
    protected void setDiasPrestamo(int p_diasPrestamo){
     this.diasPrestamo= p_diasPrestamo;
    }
    
    private void setPrestamos (ArrayList <Prestamo> p_prestamos){
      this.prestamos = p_prestamos;
    }
    
    public int getDniSocio(){
      return this.dniSocio;
    }
    
    public String getNombre(){
      return this.nombre;
    }
    
    public int getDiasPrestamo(){
      return this.diasPrestamo;
    }
    
    public ArrayList <Prestamo> getPrestamos(){
      return this.prestamos;
    }
    
    //Gestion de la coleccion 
    
    public void agregarPrestamo(Prestamo p_prestamo){
      this.getPrestamos().add(p_prestamo);
    }
    
    public void quitarPrestamo(Prestamo p_prestamo){
      this.getPrestamos().remove(p_prestamo);
    }
    
    // Retorna la cantidad de libros que tiene actualmente en su poder (no devueltos)
    public int cantLibrosPrestados() {
        int contador = 0;
        for (Prestamo prestamo : this.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null) {
                contador++;
            }
        }
        return contador;
    }

    // Verifica si el socio no tiene ningún préstamo vencido al día de hoy
    public boolean puedePedir() {
        Calendar hoy = Calendar.getInstance();
        for (Prestamo prestamo : this.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null && prestamo.vencido(hoy)) {
                return false; // Tiene al menos un préstamo vencido
            }
        }
        return true;
    }

    // Método abstracto que implementarán las subclases
    public abstract String soyDeLaClase();

    @Override
    public String toString() {
        return "D.N.I.: " + this.getDniSocio() + " || " + this.getNombre() + 
               " (" + this.soyDeLaClase() + ") || Libros Prestados: " + this.cantLibrosPrestados();
    }
}
