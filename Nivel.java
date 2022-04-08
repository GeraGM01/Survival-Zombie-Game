import greenfoot.*;

public abstract class Nivel extends World
{
    String[] map;  //variable que guarda los caracteres para poder implementar los distintos objetos que se usaran como plataformas etc
    public static int score =0;  //Usamos una variable estatica para el conteo del score del jugador
    public Nivel()
    {
        super(800, 600, 1);
        setFields();
        for (int i=0; i<map.length; i++) for (int j=0; j<map[i].length(); j++)
            {
                int kind = "cbpwmdksf".indexOf(""+map[i].charAt(j));
                if (kind < 0) continue;
                Actor actor = null;
                if (kind == 0) actor = new David();
                if (kind == 1) actor = new Bloque();
                if (kind == 2) actor = new Bloque2();
                if (kind == 3) actor = new Bloque3();
                if (kind == 4) actor = new Zombie();
                if (kind == 5) actor = new Puerta();
                if (kind == 6) actor = new Llave();
                if (kind == 7) actor = new Score();
                if (kind == 8) actor = new BloqueConMovimiento();
                addObject(actor, 16+j*32, 16+i*32);
        }
        score=0; // En esta parte reseteamos el score luego de que el jugador pierde
    }
    
    
    public void act(){
        showText("Score: " + score, 70,70);  //Metodo que nos muestra en pantalla el score del jugador
    }
    public void setFields() {}

    public void nextLevel() {}
}