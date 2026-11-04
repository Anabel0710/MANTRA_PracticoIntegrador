import java.util.Calendar;
/**
 * Write a description of class Prestamo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prestamo{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;
    
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        this.fechaDevolucion = null;
    }
    
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    public Socio getSocio(){
        return this.socio;
    }
    public Libro getLibro(){
        return this.libro;
    }
    
    public void registrarFechaDevolucion(Calendar p_fecha) {
        this.setFechaDevolucion(p_fecha);
    }
    
    public boolean vencido(Calendar p_fecha){
        if(this.fechaDevolucion != null){
            return false;
        }
        Calendar fechaVencimiento = (Calendar) this.fechaRetiro.clone();
        fechaVencimiento.add(Calendar.DAY_OF_YEAR, this.socio.getDiasPrestamo());
        return p_fecha.after(fechaVencimiento);
    }
    
    
}
