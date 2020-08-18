package Game;

import Engine.Mesh;
import Engine.Shader;
import Engine.Utils;
import Engine.Window;
import org.lwjgl.system.MemoryUtil;

import java.nio.FloatBuffer;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class Renderer {
    private int vboID;
    private int vaoID;

    private Shader shader;

    public Renderer()
    {

    }

    public void init() throws Exception
    {
        shader = new Shader();
        shader.createFragmentShader(Utils.loadResource("shaders/fragment.glsl"));
        shader.createVertexShader(Utils.loadResource("shaders/vertex.glsl"));

        shader.link();
    }

    public void render(Window window, Mesh mesh)
    {
        clear();
        shader.bind();
        glBindVertexArray(mesh.getVaoID());
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
        glDrawElements(GL_TRIANGLES, mesh.getVertexCount(), GL_UNSIGNED_INT, 0);
        glBindVertexArray(0);
        shader.unbind();
    }

    public void flush()
    {
        if (shader != null)
        {
            shader.flush();
        }

        glDisableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glDeleteBuffers(vboID);

        glBindVertexArray(0);
        glDeleteVertexArrays(vaoID);
    }

    public void clear()
    {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
}
