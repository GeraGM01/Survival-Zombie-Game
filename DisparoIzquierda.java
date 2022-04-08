import greenfoot.*;

public class DisparoIzquierda extends Disparo
{
    private int shootingSpeed = 8;
    
    public void act() 
    {
        setLocation(getX() - shootingSpeed, getY());
        killZombie();
    }    
}