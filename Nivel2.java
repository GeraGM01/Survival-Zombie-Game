import greenfoot.Greenfoot;

public class Nivel2 extends Nivel
{
    public void setFields()
    {
        map = new String[] { "s                        ",
                             "                         ",
                             "         k               ",
                             "         f               ",
                             "                 m    dm ",
                             "           wwwwwwwww  bb ",
                             "m   m   m                ",
                             "wwwwwwwwww               ",
                             "                         ",
                             "                         ",
                             "     m   ffff       m    ",
                             "                  bbbb   ",
                             "          m   bbbbb      ",
                             "    b   bbbbbbb      f   ",
                             "                         ",
                             "   m                     ",
                             "  bbbbb       c          ",
                             "m      m              m  ",
                             "ppppppppppppppppppppppppp" };
    }
    
    public void nextLevel()
    {
        Greenfoot.setWorld(new Nivel3());
    }
}