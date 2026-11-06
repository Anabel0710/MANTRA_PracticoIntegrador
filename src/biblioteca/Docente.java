import java.util.Calendar;
/**
 * Write a description of class Docente here.
 * 
 * @author (canario nahiara) 
 * @version (05/11/2026)
 */
public class Docente extends Socio
{
    private String area;
    
    public Docente(int p_dniSocio, String p_nombre, String p_area){
        super(p_dniSocio, p_nombre,5);
        this.setArea(p_area);
        
        }
     public String getArea() {
        return this.area;
    }
     public void setArea(String p_area) {
         this.area = p_area;
    }
    public boolean esResponsable() {
        for (Prestamo p : this.getPrestamos()) {

            if (p.getFechaDevolucion() == null) {

                if (p.vencido(Calendar.getInstance())) {
                    return false;
                }

            } else {

                Calendar fechaVencimiento =
                    (Calendar) p.getFechaRetiro().clone();

                fechaVencimiento.add(
                    Calendar.DAY_OF_YEAR,
                    this.getDiasPrestamo()
                );

                if (p.getFechaDevolucion().after(fechaVencimiento)) {
                    return false;
                }
            }
        }

        return true;
    }
     public void cambiarDiasDePrestamo(int p_dias) {
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }
    @Override
    public boolean puedePedir() {
    return super.puedePedir();
    }
    
    @Override
    public String soyDeLaClase() {
        return "Docente";
    }
}
