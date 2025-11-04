package org.graphics.renders;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL41;

import static org.lwjgl.glfw.GLFW.glfwSwapInterval;


public class Window {
    private long window;
    private final int width;
    private final int height;
    private final String title;
    private Renderer renderer;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void run() {
        init();
        loop();
        cleanup();
    }

    private void init() {

        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Грешка при инициализация на GLFW!");
        }

        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 4);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 1);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GLFW.GLFW_TRUE);

        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (window == 0) {
            throw new RuntimeException("Неуспешно създаване на прозорец!");
        }

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GL41.glViewport(0, 0, width, height);
        GL41.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        glfwSwapInterval(1);

        renderer = new Renderer();
        renderer.init();
    }

    private void loop() {
        while (!GLFW.glfwWindowShouldClose(window)) {
            GL41.glClear(GL41.GL_COLOR_BUFFER_BIT);

            renderer.render();

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }
    }

    private void cleanup() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }
}