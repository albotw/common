package Game;

import Engine.IGame;
import Engine.Mesh;
import Engine.Window;

import static org.lwjgl.glfw.GLFW.*;

public class TestGame implements IGame {
    private int direction = 0;

    private float color = 0.0f;

    private final Renderer renderer;

    private Mesh mesh;

    public TestGame()
    {
        renderer = new Renderer();
    }

    @Override
    public void init() throws Exception
    {
        renderer.init();
        float[] positions = new float[]{
                -0.5f,  0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f,  0.5f, 0.0f,
        };
        float[] colours = new float[]{
                0.5f, 0.0f, 0.0f,
                0.0f, 0.5f, 0.0f,
                0.0f, 0.0f, 0.5f,
                0.0f, 0.5f, 0.5f,
        };
        int[] indices = new int[]{
                0, 1, 3, 3, 1, 2,
        };
        mesh = new Mesh(positions, colours, indices);
    }

    @Override
    public void input(Window window)
    {

    }

    @Override
    public void update(float interval)
    {

    }

    @Override
    public void render(Window window)
    {
        window.setClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        renderer.render(window, mesh);
    }

    @Override
    public void flush()
    {
        renderer.flush();
        mesh.flush();
    }
}
