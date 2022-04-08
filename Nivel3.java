import greenfoot.Greenfoot;

public class Nivel3 extends Nivel
{
    public void setFields()
    {    
        map = new String[] { "s                        ",
                             "                         ",
                             "                         ",
                             "      bbbb               ",
                             "                         ",
                             "    m                    ",
                             "                         ",
                             "              gggggg     ",
                             "                         ",
                             "                         ",
                             "   gggggggb          m   ",
                             "                         ",
                             "                         ",
                             "      bbb       gggggggg ",
                             "                         ",
                             "                         ",
                             "   ggggpp   c            ",
                             "  k                 d    ",
                             "bbbbbbbbbbbbbbbbbbbbbbbbb" };
                     
    }
    
    public void nextLevel()
    {
        Greenfoot.setWorld(new Nivel4());
    }
}