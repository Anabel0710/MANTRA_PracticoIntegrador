import java.util.Calendar;
/**
 * Write a description of class Docente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Docente extends Socio{
   private String area;
   
   public Docente(int p_dniSocio, String p_nombre, String p_area){
       super(p_dniSocio, p_nombre, 5);
       this.setArea(p_area);
   }
   
   public String getArea(){
       return this.area;
   }
   
   public boolean esResponsable() {
    for (Prestamo p : this.getPrestamos()) { // Corregido Prestamo y getPrestamos
        if (p.getFechaDevolucion() == null) {
            if (p.vencido(Calendar.getInstance())) {
                return false;
            }
        } else {
            Calendar fVenc = (Calendar) p.getFechaRetiro().clone();
            fVenc.add(Calendar.DAY_OF_YEAR, this.getDiasPrestamo()); // DAY_OF_YEAR con guiones bajos
            if (p.getFechaDevolucion().after(fVenc)) {
                return false;
            }
        }
    }
    return true;
}
   
   public void cambiarDiasDePrestamo(int p_dias){
       setDiasPrestamo(getDiasPrestamo() + p_dias);
   }
   
   @Override
   public String soyDeLaClase(){
       return "Docente";
   }
}
