 
package biblioteca;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 *Clase Prestamo
 * 
 * @author Lezcano Natalia Magali
 * @version 1
 */
public class Prestamo
{
  //se define los atributos
  private Calendar fechaRetiro;
  private Calendar fechaDevolucion;
  private Socio socio;
  private Libro libro;  
  
  public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
    this.setFechaRetiro(p_fechaRetiro);
    this.setSocio(p_socio);
    this.setLibro(p_libro);
    this.setFechaDevolucion(null); // Al iniciarse, aún no se devolvió
    }
    
  private void setFechaRetiro(Calendar p_fechaRetiro){
    this.fechaRetiro = p_fechaRetiro;
    }
    
  private void setSocio(Socio p_socio){
    this.socio = p_socio;
  }
    
  private void setLibro(Libro p_libro){ 
    this.libro = p_libro; 
  }
  
  private void setFechaDevolucion(Calendar p_fechaDevolucion){ 
    this.fechaDevolucion = p_fechaDevolucion; 
  }
  
  public Calendar getFechaRetiro(){ 
    return this.fechaRetiro; 
  }
 
  public Socio getSocio(){ 
    return this.socio; 
  }

  public Calendar getFechaDevolucion(){ 
    return this.fechaDevolucion; 
  }
  
  public Libro getLibro(){ 
    return this.libro; 
  }
  
  // Registra la fecha exacta de devolución del libro
  public void registrarFechaDevolucion(Calendar p_fecha) {
        this.setFechaDevolucion(p_fecha);
  }

  // Comprueba si la fecha pasada por parámetro supera la fecha límite de préstamo
   public boolean vencido(Calendar p_fecha) {
        Calendar fechaVencimiento = (Calendar) this.getFechaRetiro().clone();
        fechaVencimiento.add(Calendar.DATE, this.getSocio().getDiasPrestamo());
        return p_fecha.after(fechaVencimiento);
  }

  @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String devolucion = "";
        
        if (this.getFechaDevolucion() != null) {
            devolucion = formato.format(this.getFechaDevolucion().getTime());
        }

        return "Retiro: " + formato.format(this.getFechaRetiro().getTime())
                + " - Devolución: " + devolucion + "\n"
                + "Libro: " + this.getLibro().getTitulo() + "\n"
                + "Socio: " + this.getSocio().getNombre();
    }
}
