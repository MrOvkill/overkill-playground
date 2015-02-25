
/*
 * The MIT License
 *
 * Copyright 2015 Samuel "MrOverkill" Meyers.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.epicknife.overkill.opengl.core;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.util.ArrayList;

import org.lwjgl.opengl.GLContext;

import com.epicknife.overkill.coreutil.Optional;

/**
 * The window handling class.
 * @author Samuel "MrOverkill" Meyers
 */
public class Window
{
    
    /**
     * The OpenGL context information.
     */
    private GLProfile profile;
    
    /**
     * The window's settings.
     */
    private WindowSettings settings;
    
    /**
     * The pointer to the window.
     */
    private long windowPointer;
    
    /**
     * Used to track update time.
     */
    private WindowTimer timer;
    
    /**
     * The Renderer list.
     */
    private final ArrayList<Renderer> renderers;
    
    /**
     * The UpdateHandler list.
     */
    private final ArrayList<UpdateHandler> handlers;
    
    /**
     * The Update Queue.
     */
    private final UpdateThread updateQueue;
    
    /**
     * Whether or not the window is open.
     */
    private boolean open;
    
    /**
     * Create a new Window with custom WindowSettings and GLProfile.
     * @param settings Optional\<WindowSettings\> The window's settings.
     * @param profile Optional\<GLProfile\> The OpenGL context information.
     */
    
    public Window (
            Optional<WindowSettings> settings, 
            Optional<GLProfile> profile
    )
    {
        
        this.settings = new WindowSettings();
        if(settings.hasObject())
        {
            this.settings = settings.getObject();
        }
        
        this.profile = GLProfile.GL10;
        if(profile.hasObject())
        {
            this.profile = profile.getObject();
        }
        
        this.renderers = new ArrayList<>();
        this.handlers = new ArrayList<>();
        
        this.timer = new WindowTimer();
        
        this.updateQueue = new UpdateThread();
        
        this.open = false;
    }
    
    /**
     * Create a new Window with default WindowSettings and GLProfile.
     */
    public Window()
    {
        this(
            new Optional(),
            new Optional()
        );
    }
    
    /**
     * Open and display the window.
     * Return true if it worked.
     * @return boolean
     */
    public boolean create()
    {
        
        if(this.open) { return false; }
        
        if ( glfwInit() != GL_TRUE )
        {
            return false;
        }
        
        glfwDefaultWindowHints();
        
        glfwWindowHint(GLFW_SAMPLES, this.settings.antialias);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, this.profile.major);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, this.profile.minor);
        
        if(this.profile.core)
        {
            glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
            glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        }
        
        glfwWindowHint(GLFW_VISIBLE, GL_TRUE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
        
        this.windowPointer = glfwCreateWindow(
                settings.width, settings.height, settings.title,
                NULL, NULL
        );
        
        if(this.windowPointer == NULL)
        {
            return false;
        }
        
        glfwMakeContextCurrent(this.windowPointer);
        glfwShowWindow(this.windowPointer);
        GLContext.createFromCurrent();
        
        this.updateQueue.start();
        
        this.open = true;
        
        return true;
    }
    
    /**
     * Update all the renderer handlers.
     * Update the keyboard.
     */
    public void update()
    {
        
        if(!this.open) { return; }
        
        for(Renderer render : renderers)
        {
            render.onUpdate(this.timer);
        }
        this.updateKeys();
        
    }
    
    public void asyncUpdate()
    {
        if(!this.open) { return; }
        
        
    }
    
    /**
     * Draw all the render handlers.
     * Update the display.
     */
    public void draw()
    {
        
        if(!this.open) { return; }
        
        for(Renderer render : renderers)
        {
            render.onDraw(this.timer);
        }
        this.updateDisplay();
        
    }
    
    /**
     * Update the display. ( glfwSwapBuffers )
     */
    public void updateDisplay()
    {
        
        if(!this.open) { return; }
        
        glfwSwapBuffers(this.windowPointer);
        
    }
    
    /**
     * Update the keyboard. ( glfwPollEvents )
     */
    public void updateKeys()
    {
        
        if(!this.open) { return; }
        
        glfwPollEvents();
    
    }
    
    /**
     * Check if the window should close. ( glfwWindowShouldClose )
     * Return whether or not the window should close.
     * @return boolean
     */
    public boolean shouldClose()
    {
        
        if(!this.open) { return false; }
        
        return (glfwWindowShouldClose(windowPointer) == GL_FALSE);
        
    }
    
    /**
     * Update the display.
     * Update the keyboard.
     * Check if the window should close.
     * Return whether or not the window should close.
     * @return boolean
     */
    public boolean updateWindow()
    {
        
        if(!this.open) { return false; }
        
        this.updateDisplay();
        this.updateKeys();
        return this.shouldClose();
        
    }
    
    /**
     * Returns the Window's timer.
     * @return WindowTimer
     */
    public WindowTimer getTimer()
    {
        
        if(!this.open) { return null; }
        
        return this.timer;
        
    }
    
    /**
     * Close this window.
     * @return boolean
     */
    public boolean close()
    {
        
        if(!this.open) { return false; }
        
        glfwDestroyWindow(this.windowPointer);
        
        return true;
        
    }
    
}
