import java.util.ArrayList;
import java.util.Calendar;
/**
 * Representa una biblioteca que administra libros, socios y prestamos.
 * 
 * @author Rocio Anabel Gonzalez, Rodriguez Mercedes Antonella y Gomez Matias.
 * @version 1.0
 */
public class Biblioteca{
    private String nombre;
    private ArrayList<Socio> socios;
    private ArrayList<Libro> libros;
    
    /**
     * Constructor de Biblioteca
     * @param p_nombre nombre de la biblioteca 
     */
    public Biblioteca(String p_nombre){
        this.setNombre(p_nombre);
        this.setSocios (new ArrayList<Socio>());
        this.setLibros(new ArrayList<Libro>());
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public ArrayList<Socio> getSocios(){
        return this.socios;
    }
    public ArrayList<Libro> getLibros(){
        return this.libros;
    }

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setSocios(ArrayList<Socio> p_socios){
        this.socios = p_socios;
    }

    private void setLibros(ArrayList<Libro> p_libros){
        this.libros = p_libros;
    }

    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        Libro nuevo = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        this.getLibros().add(nuevo);
    }
    
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        Estudiante est = new Estudiante(p_dniSocio, p_nombre, p_carrera);
        this.getSocios().add(est);
    }

    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area) {
        Docente doc = new Docente(p_dniSocio, p_nombre, p_area);
        this.getSocios().add(doc);
    }
    
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        if(p_socio.puedePedir() && !p_libro.prestado()){
            Prestamo prestamo = new Prestamo(p_fechaRetiro, p_socio, p_libro);
            p_socio.addPrestamo(prestamo);
            p_libro.addPrestamo(prestamo);
            return true;
        }
        return false;
    }
    
    public void devolverLibro(Libro p_libro) throws LibroNoPrestadoException{
        if(!p_libro.prestado()){
            throw new LibroNoPrestadoException("El libro " + p_libro.getTitulo() + 
                         "No se puede devolver ya que se encuentra en la biblioteca");
        }
        Prestamo unPrestamo = p_libro.ultimoPrestamo();
        unPrestamo.registrarFechaDevolucion(Calendar.getInstance());
    }
    
    public int cantidadDeSociosPorTipo(String p_objeto){
        int cantidad = 0;
        for(Socio s : this.getSocios()){
            if(s.soyDeLaClase().equalsIgnoreCase(p_objeto)){
                cantidad++;
            }
        }
        return cantidad;
    }
    
    public ArrayList<Prestamo> prestamosVencidos(){
        ArrayList<Prestamo> vencidos = new ArrayList<Prestamo>();
        Calendar hoy = Calendar.getInstance();
        for(Libro l : this.getLibros()){
            if(l.prestado()){
                Prestamo u = l.ultimoPrestamo();
                if(u.vencido(hoy)){
                    vencidos.add(u);
                }
            }
        }
        return vencidos;
    }
    
    public ArrayList<Docente> docentesResponsables() {
        ArrayList<Docente> responsables = new ArrayList<Docente>();
        for (Socio s : this.getSocios()) {
            if (s instanceof Docente) {
                Docente d = (Docente) s;
                if (d.esResponsable()) {
                    responsables.add(d);
                }
            }
        }
        return responsables;
    }
    
    public String quienTieneElLibro(Libro p_libro) throws LibroNoPrestadoException {
        if (!p_libro.prestado()) {
            throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
        }
        return p_libro.ultimoPrestamo().getSocio().getNombre();
    }

    public Socio buscarSocio(int p_dni) {
        for (Socio s : this.getSocios()) {
            if (s.getDniSocio() == p_dni) {
                return s;
            }
        }
        return null;
    }

    public String listaDeSocios() {
        String listado = "";
        for (Socio s : this.getSocios()) {
            listado += s.toString() + "\n";
        }
        return listado;
    }

    public String listaDeLibros() {
        String listado = "";
        for (Libro l : this.getLibros()) {
            listado += l.toString() + "\n";
        }
        return listado;
    }
}
    /**
     * Emite la lista de títulos de libros SIN TÍTULOS REPETIDOS.
     */
    public String listaDeTitulos() {
        ArrayList<String> titulosUnicos = new ArrayList<String>();

        for (Libro unLibro : this.getLibros()) {
            String titulo = unLibro.getTitulo();
            if (!titulosUnicos.contains(titulo)) {
                titulosUnicos.add(titulo);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("--- Lista de Títulos de la Biblioteca ---\n");
        int index = 1;
        for (String titulo : titulosUnicos) {
            sb.append(index).append(") ").append(titulo).append("\n");
            index++;
        }
        return sb.toString();
    }

    /**
     * Emite el reporte de docentes responsables según Formato 3.
     */
    public String listaDeDocentesResponsables() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Docentes Responsables: \n");

        for (Docente doc : this.docentesResponsables()) {
            sb.append("* ").append(doc.toString()).append("\n");
        }
        return sb.toString();
    }
