 
package biblioteca;
import java.util.Calendar;
import java.text.SimpleDateFormat;


/**
 * Clase que representa la transacción de un préstamo individual de un libro a un socio.
 * Asienta la fecha de retiro, la fecha de devolución y colabora con el Libro y el Socio involucrados.
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

 /**
     * Constructor explícito de la clase Prestamo.
     * Asigna la fecha de retiro, el socio y el libro. La fecha de devolución
     * se inicia explícitamente en null indicando que el libro aún no fue devuelto.
     * 
     * @param p_fechaRetiro Fecha en que se retira el libro de la biblioteca.
     * @param p_socio       Socio que solicita el préstamo.
     * @param p_libro       Libro retirado.
     */
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
  
  /**
     * Registra la fecha efectiva de devolución del libro.
     * 
     * @param p_fecha Instancia de Calendar con la fecha de devolución.
     */
  public void registrarFechaDevolucion(Calendar p_fecha) {
        this.setFechaDevolucion(p_fecha);
  }

  /**
     * Comprueba si el préstamo se encuentra vencido a la fecha enviada como parámetro.
     * Calcula el vencimiento sumando los días autorizados del socio a la fecha de retiro.
     * 
     * @param p_fecha Fecha de evaluación.
     * @return true si p_fecha supera la fecha límite del préstamo; false en caso contrario.
     */
   public boolean vencido(Calendar p_fecha) {
        Calendar fechaVencimiento = (Calendar) this.getFechaRetiro().clone();
        fechaVencimiento.add(Calendar.DATE, this.getSocio().getDiasPrestamo());
        return p_fecha.after(fechaVencimiento);
  }

  /**
     * Retorna el detalle multilínea del préstamo formateado según las especificaciones del TP7.
     * Utiliza SimpleDateFormat para formatear las fechas en yyyy/MM/dd.
     * 
     * @return Cadena con fecha de retiro, devolución, título del libro y nombre del socio.
     */
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
