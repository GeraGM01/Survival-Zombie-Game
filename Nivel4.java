import greenfoot.Greenfoot;

public class Nivel4 extends Nivel
{
    public void setFields()
    {    
        map = new String[] { "s                        ",
                             "                      k  ",
                             "       m             f   ",
                             "      bbbb    m    m     ",
                             "          bbbbbbbbbb     ",
                             "     b                   ",
                             "    b  ff       m   m    ",
                             "   b           gggggg    ",
                             "  b        f             ",
                             " b          m  md        ",
                             "            ppppp     m  ",
                             "                     w   ",
                             "       c        m w      ",
                             "      bbb        w       ",
                             " m               w       ",
                             "wwww           w         ",
                             "  m      m         m    m",
                             "bbbbbbbbbbbbbbbbbbbbbbbbb",
                             "bbbbbbbbbbbbbbbbbbbbbbbbb" };
    }
    
    public void nextLevel()
    {
        Greenfoot.stop();  // Como ya es el ultimo nivel, con esta funcion de greenfoot detenemos el juego
    }
}