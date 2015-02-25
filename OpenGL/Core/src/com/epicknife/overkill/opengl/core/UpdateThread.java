
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

import com.epicknife.overkill.coreutil.Time;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A utility class that runs when a window starts.
 * @author Samuel "MrOverkill" Meyers
 */
public class UpdateThread extends Thread
{
    
    /**
     * The list of registered update handlers.
     */
    public LinkedBlockingQueue<UpdateHandler> updates;
    
    /**
     * The basic constructor.
     */
    public UpdateThread()
    {
        this.updates = new LinkedBlockingQueue<>();
    }
    
    /**
     * Runs in a new Thread
     */
    @Override
    public void run()
    {
        while(true)
        {
            
            while(updates.isEmpty())
            {
                Time.safeSleep(500);
            }
            
            UpdateHandler handler;
            while((handler = updates.poll()) != null)
            {
                handler.onUpdate();
            }
            
        }
    }
    
}