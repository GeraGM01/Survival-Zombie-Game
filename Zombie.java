import greenfoot.*;


public class Zombie extends Enemigo
{
    int frame = 0;
    private int animationCount;
    private int vSpeed = 0;
    private int acceleration = 2;
    private int spriteHeight = getImage().getHeight();
    private int spriteWidth = getImage().getWidth();
    private int lookForGroundDistance = (int)spriteHeight/2;
    private int lookForEdge = (int)spriteWidth/2;
    
    private int speed = 1;
    
    GreenfootImage monster1l = new GreenfootImage("monster1l.png");
    GreenfootImage monster2l = new GreenfootImage("monster2l.png");
    GreenfootImage monster3l = new GreenfootImage("monster3l.png");
    
    GreenfootImage monster1r = new GreenfootImage("monster1r.png");
    GreenfootImage monster2r = new GreenfootImage("monster2r.png");
    GreenfootImage monster3r = new GreenfootImage("monster3r.png");
    
    public void act() 
    {
        tryToGetPlayer();
        checkFall();
        checkEdge();
        move();
        setAnimation();
        animationCount ++;
        checkRightWalls();
        checkLeftWalls();
    }    
    
    // Metodo que sirve para poder minimizar un poco la animacion, si el contador de la animacion es divisible entre 4 realentiza el movimiento
    public void setAnimation()
    {
    if(speed<0)
        {
            if(animationCount % 4 == 0)
            animateLeft();
        }
        else
        {
            if(animationCount % 4 == 0)
            animateRight();
        }
    }
   
    // Metodo que sirve para checar si el zombie toca el borde del mundo, en caso de que se cumpla la condicion, va a invertir el movimiento del zombie 
    public void checkEdge()
    {
    if(getX() < 10 || getX() > getWorld().getWidth() - 10)
        {
            speed *= -1;
        }
    }   
    
    public void move()
    {
        Actor ground = getOneObjectAtOffset(lookForEdge, lookForGroundDistance, Platform.class);
        if(ground == null)
        {
            speed *= -1; // Invierte la direccion
            lookForEdge *= -1;
        }
        else
        {
            move(speed);
        }
    }
    
    public void animateLeft()
    {
        if(frame == 0)
        {
            setImage(monster1l);
        }
        if(frame == 1)
        {
            setImage(monster2l);
        }
        if(frame == 2)
        {
            setImage(monster3l);
        }
        frame++;
    }
    
        public void animateRight()
    {
        if(frame == 0)
        {
            setImage(monster1r);
        }
        if(frame == 1)
        {
            setImage(monster2r);
        }
        if(frame == 2)
        {
            setImage(monster3r);
        }
        frame++;
    }
    
        public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        
    }
    
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        if(ground == null)
        {
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }
    
    public boolean checkRightWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        Actor rightWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(rightWall == null)
        {
            return false;
        }
        else
        {
            stopByRightWall(rightWall);
            return true;
        }
    }

    public void stopByRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - 5, getY());
        speed *= -1;

    }

    public boolean checkLeftWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/-2);
        Actor leftWall = getOneObjectAtOffset(xDistance, 0, Platform.class);
        if(leftWall == null)
        {
            return false;
        }
        else
        {
            stopByLeftWall(leftWall);
            return true;
        }
    }

    public void stopByLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int newX = leftWall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + 5, getY());
        speed *= -1;

    }

    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }
    
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    
    public void tryToGetPlayer()
    {
        if (canSee(David.class) )
        {
            get(David.class);
            //Si se le quiere poner musica de game over aqui debe ir la funcion 
            Greenfoot.stop();
        }
    }
     
}
