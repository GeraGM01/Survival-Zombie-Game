import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemigo extends Actor
{
    int score=0;
    /**
     * Act - do whatever the BadGuys wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }   
    
    /**
     * Uso la siguiente funcion para saber si el jugador esta tocando algun objeto, retorna verdadero si es asi
     * de lo contrario, no hara nada este metodo
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
    /**
     * Try to grab an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public void get(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }  
     /**
     * Metodo getter para la puntuacion que despues será llamado por la clase Score para poner la puntuacion en pantalla
     */
    public int getScore()
    {    
        return score;
    }
}
