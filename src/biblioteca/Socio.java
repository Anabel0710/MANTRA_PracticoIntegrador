 
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Write a description of class Socio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public abstract class Socio{
   private int dniSocio;
   private String nombre;
   private int diasPrestamo;
   private ArrayList<Prestamo> prestamos;
   
   public Socio (int p_dniSocio, String p_nombre, int p_diasPrestamo){
       this.setDniSocio(p_dniSocio);
       this.setNombre(p_nombre);
       this.setDiasPrestamo(p_diasPrestamo);
       this.setPrestamos = new ArrayList<Prestamo>();
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
   
   public ArrayList<Prestamo> getPrestamos(){
       return this.prestamos;
   }
   
   protected void setDiasPrestamo(int p_dias){
       this.diasPrestamo = p_dias;
   }
   
   public boolean agregarPrestamo(Prestamo p_prestamo) {
      return this.getPrestamos().add(p_prestamo);
}
   public boolean addPrestamo(Prestamo p_prestamo) {
      return this.agregarPrestamo(p_prestamo);
}
   
   public int cantLibrosPrestados(){
       int cant = 0;
       for(Prestamo p : prestamos){
           if(p.getFechaDevolucion() == null){
               cant ++;
           }
       }
       return cant;
   }
   
   public boolean puedePedir() {
        Calendar hoy = Calendar.getInstance();
        for (Prestamo p : prestamos) {
            if (p.vencido(hoy)) {
                return false;
            }
        }
        return true;
    }
   
   public abstract String soyDeLaClase();

    @Override
    public String toString() {
        return "D.N.I.: " + dniSocio + " || " + nombre + " (" + soyDeLaClase() + ") || Libros Prestados: " + cantLibrosPrestados();
    }

      
}
