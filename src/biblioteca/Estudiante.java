
/**
 * Write a description of class Estudiante here.
 * 
 * @author (canario nahiara) 
 * @version (05/11/2026)
 */
public class Estudiante extends Socio
{
  private String carrera;
  
  public Estudiante(int p_dniSocio, String p_nombre, String p_carrera){
      super(p_dniSocio, p_nombre, 20);
      this.setCarrera(p_carrera);
      
  }
  public String getCarrera() {
        return this.carrera;
    }
    private void setCarrera(String p_carrera) {
        this.carrera = p_carrera;
  }
   @Override
    public boolean puedePedir() {
        return super.puedePedir()
            && this.cantLibrosPrestados() <= 3;
    }
     @Override
    public String soyDeLaClase() {
        return "Estudiante";
    }
}
