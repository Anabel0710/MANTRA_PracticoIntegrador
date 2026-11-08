package biblioteca; 
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase abstracta que representa la entidad general de un Socio en la biblioteca.
 * Actúa como superclase para las subclases concretas Estudiante y Docente,
 * centralizando el estado y comportamiento común de la ficha de préstamos.
 * 
 * @author Lezcano Natalia Magali
 * @version 1.3
 */
public abstract  class Socio
{
    // se define los atributos de socio
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList<Prestamo> prestamos; 


    /**
     * Constructor principal de la clase Socio.
     * Inicializa los atributos del socio e instancia la colección genérica de préstamos.
     * 
     * @param p_dniSocio    Número de D.N.I. del socio.
     * @param p_nombre      Nombre y apellido del socio.
     * @param p_diasPrestamo Cantidad inicial de días permitidos para préstamos.
     */
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

    /**
     * Establece los días límite de préstamo para el socio.
     * Posee visibilidad protected para permitir que la subclase Docente
     * incremente los días asignados al ser calificado como responsable.
     * 
     * @param p_diasPrestamo Días asignados de préstamo.
     */
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

    /**
     * Asienta un nuevo préstamo en la ficha de préstamos del socio.
     * 
     * @param p_prestamo Instancia de Prestamo a incorporar.
     */
    public void agregarPrestamo(Prestamo p_prestamo){
      this.getPrestamos().add(p_prestamo);
    }

     /**
     * Remueve un préstamo existente de la ficha del socio.
     * 
     * @param p_prestamo Instancia de Prestamo a remover.
     */
    public void quitarPrestamo(Prestamo p_prestamo){
      this.getPrestamos().remove(p_prestamo);
    }
    
   /**
     * Retorna la cantidad de libros que el socio tiene actualmente en su poder (no devueltos).
     * 
     * @return Cantidad de libros con fechaDevolucion == null.
     */
    public int cantLibrosPrestados() {
        int contador = 0;
        for (Prestamo prestamo : this.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Evalúa si el socio está habilitado para solicitar nuevos préstamos.
     * Un socio puede pedir siempre que no posea ningún préstamo vencido a la fecha actual.
     * 
     * @return true si no tiene préstamos vencidos; false en caso contrario.
     */
    public boolean puedePedir() {
        Calendar hoy = Calendar.getInstance();
        for (Prestamo prestamo : this.getPrestamos()) {
            if (prestamo.getFechaDevolucion() == null && prestamo.vencido(hoy)) {
                return false; // Tiene al menos un préstamo vencido
            }
        }
        return true;
    }

   /**
     * Método abstracto que retorna la denominación del tipo de socio ("Estudiante" o "Docente").
     * 
     * @return Cadena con el nombre de la subclase concreta.
     */
    public abstract String soyDeLaClase();

   /**
     * Retorna la representación en texto del estado del socio según el Formato 1.
     * Ejemplo: D.N.I.: 14524782 || Juan Perez (Docente) || Libros Prestados: 6
     * 
     * @return Cadena formateada con DNI, nombre, tipo y préstamos activos.
     */
    @Override
    public String toString() {
        return "D.N.I.: " + this.getDniSocio() + " || " + this.getNombre() + 
               " (" + this.soyDeLaClase() + ") || Libros Prestados: " + this.cantLibrosPrestados();
    }
}
