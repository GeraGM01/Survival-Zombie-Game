import greenfoot.Greenfoot;

public class Nivel1 extends Nivel
{
    //  Mapa:
    //      b = bloque        m = Zombie         f = BloqueConMovimiento
    //      p = Bloque2     k = Llave             w = Bloque 3
    //      c = Jugador    d = Puerta            s = score
    public void setFields()
    {
        map = new String[] { "{                       ",
                             "                 d      ",
                             "        wwwwwwwwwww     ",
                             "    m                   ",
                             "   www                  ",
                             "        k m             ",
                             "       wwwww            ",
                             "                        ",
                             "             ff       m ",
                             "                    pppp",
                             "                        ",
                             "               pppp     ",
                             "                        ",
                             "       m                ",
                             "   pppppppppp      ff   ",
                             "                        ",
                             "                        ",
                             "   m    m      m     c  ",
                             "bbbbbbbbbbbbbbbbbbbbbbbbb"};
    }
    /**
     * Metodo que sirve para cambiar de nivel 
     */
    public void nextLevel()
    {
        Greenfoot.setWorld(new Nivel2());
    }
}