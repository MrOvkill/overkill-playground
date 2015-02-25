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

/**
 * A simple utility for tracking times.
 * @author Samuel "MrOverkill" Meyers
 */
public class WindowTimer
{
    
    /**
     * How many milliseconds the window's been open.
     * Does not change.
     */
    private final long windowTime;
    
    /**
     * How many milliseconds since the last update.
     */
    private long updateTime;
    
    /**
     * How many milliseconds since the last asyncUpdate.
     */
    private long asyncUpdateTime;
    
    /**
     * How many milliseconds since the last frame.
     */
    private long frameTime;
    
    /**
     * Initialize the timers.
     */
    public WindowTimer()
    {
        this.windowTime = System.currentTimeMillis();
        this.updateTime = System.currentTimeMillis();
        this.asyncUpdateTime = System.currentTimeMillis();
        this.frameTime = System.currentTimeMillis();
    }
    
    /**
     * Get how long the window's been open.
     * @return long
     */
    public long getWindowTime()
    {
        return (System.currentTimeMillis() - this.windowTime);
    }
    
    /**
     * Get how long since the last update.
     * @return long
     */
    public long getUpdateTime()
    {
        return (System.currentTimeMillis() - this.updateTime);
    }
    
    /**
     * Update the update timer.
     */
    public void setUpdateTime()
    {
        this.updateTime = System.currentTimeMillis();
    }
    
    /**
     * Get how long since the last asyncUpdate.
     * @return long
     */
    public long getAsyncUpdateTime()
    {
        return (System.currentTimeMillis() - this.asyncUpdateTime);
    }
    
    /**
     * Update the asyncUpdate timer.
     */
    public void setAsyncUpdateTime()
    {
        this.asyncUpdateTime = System.currentTimeMillis();
    }
    
    /**
     * Get how long since the last frame.
     * @return long
     */
    public long getFrameTime()
    {
        return (System.currentTimeMillis() - this.frameTime);
    }
    
    /**
     * Update the frame timer.
     */
    public void setFrameTime()
    {
        this.frameTime = System.currentTimeMillis();
    }
    
}
