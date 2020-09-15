package Engine;

public interface IGame {

    void init() throws Exception;

    void input(Window window);

    void update(float interval);

    void render(Window window);

    void flush();
}