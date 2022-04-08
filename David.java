import greenfoot.*;

public class David extends Actor
{
    private int vSpeed = 0;
    private int acceleration = 1;
    private boolean jumping;
    private int jumpStrength = 16;
    private int speed = 3;
    int world = 0;
    private boolean banderaLlave = false;
    private int direction = 1; // si es un 1 la direccion sera hacia la derecha, si es un -1 la direccion sera hacia la izquierda
    private int shootingCounter = 20; // Retrasa el disparo
    Nivel thisGame;

    private GreenfootImage run1r = new GreenfootImage("run1r.png");
    private GreenfootImage run2r = new GreenfootImage("run2r.png");
    private GreenfootImage run3r = new GreenfootImage("run3r.png");
    private GreenfootImage run4r = new GreenfootImage("run4r.png");
    private GreenfootImage run1l = new GreenfootImage("run1l.png");
    private GreenfootImage run2l = new GreenfootImage("run2l.png");
    private GreenfootImage run3l = new GreenfootImage("run3l.png");
    private GreenfootImage run4l = new GreenfootImage("run4l.png");
    private int frame = 1;
    private int animationCounter = 0;

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();
        checkFall();
        shooting();
        platformAbove();
        checkRightWalls();
        checkLeftWalls();
        grab();
        exit();
        shootingCounter --;
        animationCounter++;

    }   

    public void checkKey()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            direction = 1;
            moveRight();
        }
        if(Greenfoot.isKeyDown("a"))
        {
            direction = -1;
            moveLeft();
        }
        if(Greenfoot.isKeyDown("w") && jumping == false)
        {
            jump();
        }
    }
    /**
     * Metodo que sirve para disparar en cualquier direccion ya sea izquierda o derecha  
     */
    public boolean shooting()
    {
        if(Greenfoot.isKeyDown("space") && shootingCounter <= 0 && direction ==1)
        {
            getWorld().addObject(new DisparoDerecha(), getX(), getY());
            shootingCounter =20;;
            return true;
        }
        if(Greenfoot.isKeyDown("space") && shootingCounter <= 0 && direction ==-1)
        {
            getWorld().addObject(new DisparoIzquierda(), getX(), getY());
            shootingCounter = 20;
            return true;
        }
        return false;
    }

    public void moveRight()
    {
        setLocation(getX()+speed, getY());
        if(animationCounter % 4 == 0)
        {
            animateRight();
        }
    }

    public void animateRight()
    {
        if(frame == 1)
        {
            setImage(run1r);
        }
        else if(frame == 2)
        {
            setImage(run2r);
        }
        else if(frame == 3)
        {
            setImage(run3r);
        }
        else if(frame == 4)
        {
            setImage(run4r);
            frame = 1;
            return;
        }
        frame++;
    }

    public void moveLeft()
    {
        setLocation(getX()-speed, getY());
        if(animationCounter %4 == 0)
        {
            animateLeft();
        }
    }

    public void animateLeft()
    {
        if(frame == 1)
        {
            setImage(run1l);
        }
        else if(frame == 2)
        {
            setImage(run2l);
        }
        else if(frame == 3)
        {
            setImage(run3l);
        }
        else if(frame == 4)
        {
            setImage(run4l);
            frame = 1;
            return;
        }
        frame++;
    }

    public boolean platformAbove()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Platform.class);
        if(ceiling != null)
        {
            vSpeed = 1;
            bopHead(ceiling);
            return true;
        }
        else
        {
            return false;
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
    //Metodo para verificar la colision del jugador con la pared
    public void stopByLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int newX = leftWall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + 5, getY());
    }
    //Metodo para verificar la colision del jugador
    public void bopHead(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }

    public void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <=9)
        {
            vSpeed = vSpeed + acceleration;
        }
        jumping = true;
    }

    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        jumping = false;
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

    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    /**
     * Metodo para poder agarrar la llave, es de tipo void y si se toma el objeto de la clase llave
     * se cambia la bandera a un verdadero y aumenta el score 30 puntos  
     */
    public void grab()
    {
        if (canSee(Llave.class) )
        {
            get(Llave.class);
            banderaLlave = true;
            //score = score + 30;
            //Greenfoot.playSound("keyfound.wav");
        }
    }
    //Metodo para verificar si el jugador tiene la llave, en caso de que se cumpla esta condicion finaliza el nivel actual y se avanza al otro nivel
    public void exit()
    {
        if (canSee(Puerta.class) && banderaLlave == true) ((Nivel)getWorld()).nextLevel();
    }

     /**
     * Si encontramos un objeto de la clase llave devuelve un verdadero
     * en caso contrario nos devolvera un falso
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
}
