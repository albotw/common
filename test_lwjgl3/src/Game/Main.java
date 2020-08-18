package Game;

import Engine.Engine;
import Engine.IGame;

public class Main {

    public static void main(String[] args)
    {
        try{
            boolean vSync = true;
            IGame game = new TestGame();
            Engine engine = new Engine("TEST", 640, 480, vSync, game);
            engine.start();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
