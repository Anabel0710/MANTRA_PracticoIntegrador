
/**
 * Write a description of class Estudiante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estudiante extends Socio{
   private String carrera;
   
   public Estudiante(int p_dniSocio, String p_nombre, String p_carrera){
       super(p_dniSocio, p_nombre, 20);
       this.setCarrera(p_carrera);
   }

   private void setCarrera(String p_carrera) {
    this.carrera = p_carrera;
   }
   
   public String getCarrera(){
       return this.carrera;
   }
   
   public boolean puedePedir(){
       return super.puedePedir() && cantLibrosPrestados() < 3;
   }
   
   @Override
   public String soyDeLaClase(){
       return "Estudiante";
   }
   
}
