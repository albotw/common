package Engine;

public class Engine implements Runnable{
    private final Thread gameThread;
    private Window window;
    private IGame game;

    public static final int TARGET_FPS = 60;

    public Engine(String windowTitle, int width, int height, boolean vSync, IGame game)
    {
        gameThread = new Thread(this, "GAME_THREAD");
        window = new Window(width, height, windowTitle, vSync);
        this.game = game;
    }

    public void start()
    {
        gameThread.start();
    }

    public void run()
    {
        try{
            init();
            gameLoop();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void init() throws Exception
    {
        window.init();
        game.init();
        System.out.println("--- fin initialisation ---");
    }

    public void gameLoop()
    {
        System.out.println("--- game loop ---");
        boolean running = true;
        while(running && !window.windowShouldClose())
        {
            game.input(window);
            game.update(TARGET_FPS);
            game.render(window);
            window.update();
        }
    }
}
