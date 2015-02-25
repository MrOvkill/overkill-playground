
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

package com.epicknife.overkill.opengl.core.test;

import com.epicknife.overkill.coreutil.Optional;
import com.epicknife.overkill.opengl.core.GLProfile;
import com.epicknife.overkill.opengl.core.Window;
import com.epicknife.overkill.opengl.core.WindowSettings;

/**
 * A simple demo.
 * Opens up an 800x600 window with OpenGL 2.1
 * @author Samuel "MrOverkill" Meyers
 */
public class WindowTest
{
    
    /**
     * The entry point for WindowTest.
     * @param args 
     */
    public static void main(String[] args)
    {
        
        // We only care about width and height.
        WindowSettings settings = new WindowSettings(
            new Optional(800),
            new Optional(600),
            new Optional(),
            new Optional(),
            new Optional()
        );
        
        // The Window itself.
        // 800x600
        // OpenGL 2.1
        Window window = new Window(
            new Optional(settings),
            new Optional(GLProfile.GL21)
        );
        
        // Create the display.
        window.create();
        
        // Update as long as the window doesn't want to close.
        while(window.updateWindow())
        {
            
        }
        
        // Close the window.
        window.close();
        
        // We need to exit.
        System.exit(0);
    }
    
}