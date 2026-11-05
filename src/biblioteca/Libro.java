import java.util.ArrayList;
/**
 * clase que modela los datos de un libro y su ficha de préstamos
 * 
 * @author Lafuente
 * @version 4/11/26
 */

public class Libro {
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;
    
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList<Prestamo> p_prestamos) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }

    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }

    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }

    private void setEdicion(int p_edicion) {
        this.edicion = p_edicion;
    }

    private void setEditorial(String p_editorial) {
        this.editorial = p_editorial;
    }

    private void setAnio(int p_anio) {
        this.anio = p_anio;
    }

    private void setPrestamos(ArrayList<Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getEdicion() {
        return this.edicion;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public int getAnio() {
        return this.anio;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }

    public boolean addPrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().add(p_prestamo);
    }

    public boolean removePrestamo(Prestamo p_prestamo) {
        return this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * retorna el último préstamo realizado del libro
     */
    public Prestamo ultimoPrestamo() {
        if (this.getPrestamos().isEmpty()) {
            return null;
        } else {
            return this.getPrestamos().get(this.getPrestamos().size() - 1);
        }
    }
    
    /**
     * devuelve true si el libro se encuentra prestado actualmente 
     * (el último préstamo no tiene fecha de devolución registrada (es null))
     */
    public boolean prestado() {
        boolean estaPrestado = false;
        if (!this.getPrestamos().isEmpty()) {
            Prestamo ultimo = this.ultimoPrestamo();
            if (ultimo != null && ultimo.getFechaDevolucion() == null) {
                estaPrestado = true;
            }
        }
        return estaPrestado;
    }

    /**
     * devuelve el formato de String requerido por la consigna
     */
    public String toString() {
        return "Titulo: " + this.getTitulo();
    }
}

}
