import greenfoot.*;

public class Disparo extends Actor
{
    Nivel thisGame;
    
    public void act() 
    {
        killZombie();
    }    
    /**
     * Metodo que sirve para remover el la bala en caso de que choque con alguna de las plataformas
     */
    public void remover()
    {
       Actor Bloque3 = getOneIntersectingObject(Platform.class);
       if(getX() <=1 || getX() >= getWorld().getWidth() -1)
       {
           getWorld().removeObject(this);
        }
        else if(Bloque3 != null)
        {
            getWorld().removeObject(this);
        }
    }
    /**
     * Se usa el siguiente metodo para saber si el jugador esta disparando
     */
    public boolean amIshot(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        return actor !=null;
    }
    /**
     * Se usa la siguiente clase para saber si el jugador ha tocado algun zombie y si es asi remueve el objeto de la clase actor
     */
    
    public void kill(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0,0, clss);
        if(actor != null)
        {
            getWorld().removeObject(actor);
        }
    }
    /**
     * Mismo caso que el metodo de arriba solo que en este metodo verifica si el jugador le disparo al zombie, en caso de cumplirse
     * el zombie se muere y aumenta el score y remueve al zombie
     */
    public void killZombie()
    {
        if(amIshot(Enemigo.class))
        {
            kill(Enemigo.class);
            thisGame.score = thisGame.score + 10;  // lleva el conteo del score cada que la bala toca al zombie y aumenta 10 puntos
            getWorld().removeObject(this);  
        }
        else
        {
            remover();
        }
    }
}
