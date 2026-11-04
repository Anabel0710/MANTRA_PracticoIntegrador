/**
 * Excepción para indicar que un libro no se encuentra prestado.
 * 
 * @author Gomez Matias
 * @version 1.0
 */
public class LibroNoPrestadoException extends Exception {
    public LibroNoPrestadoException() {
        super("El libro no se encuentra prestado.");
    }

    public LibroNoPrestadoException(String p_mensaje) {
        super(p_mensaje);
    }
}
