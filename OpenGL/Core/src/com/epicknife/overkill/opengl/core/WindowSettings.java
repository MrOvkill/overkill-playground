
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

import com.epicknife.overkill.coreutil.Optional;

/**
 * The settings used by a Window.
 * @author Samuel "MrOverkill" Meyers
 */
public class WindowSettings
{
    
    /**
     * How wide, in pixels, the window is.
     */
    public int width;
    
    /**
     * How tall, in pixels, the window is.
     */
    public int height;
    
    /**
     * The window's title.
     */
    public String title;
    
    /**
     * Whether to make the window full-screen.
     */
    public boolean fullscreen;
    
    /**
     * How much anti-aliasing to do.
     */
    public int antialias;
    
    /**
     * Create a new WindowSettings with custom options.
     * @param width Optional\<Integer\> How wide, in pixels, the window is.
     * @param height Optional\<Integer\> How tall, in pixels, the window is.
     * @param title Optional\<String\> The window's title.
     * @param fullscreen Optional\<Boolean\> Whether to make the window full-screen.
     * @param antialias Optional\<Integer\> How much anti-aliasing to do.
     */
    public WindowSettings (
            Optional<Integer> width, 
            Optional<Integer> height, 
            Optional<String> title, 
            Optional<Boolean> fullscreen,
            Optional<Integer> antialias
    )
    {
        
        this.width = 100;
        if(width.hasObject())
        {
            this.width = width.getObject();
        }
        
        this.height = 100;
        if(height.hasObject())
        {
            this.height = height.getObject();
        }
        
        this.title = "Window";
        if(title.hasObject())
        {
            this.title = title.getObject();
        }
        
        this.fullscreen = false;
        if(fullscreen.hasObject())
        {
            this.fullscreen = fullscreen.getObject();
        }
        
        this.antialias = 0;
        if(antialias.hasObject())
        {
            this.antialias = antialias.getObject();
        }
        
    }
    
    /**
     * Create a new WindowSettings with the default options.
     */
    public WindowSettings()
    {
        this(
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional()
            );
    }
    
}