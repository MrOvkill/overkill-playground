
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

public class GLProfile
{
    
    public static final GLProfile GL10 = new GLProfile (
            1, 0, false
    );
    
    public static final GLProfile GL11 = new GLProfile (
            1, 1, false
    );
    
    public static final GLProfile GL21 = new GLProfile (
            2, 1, false
    );
    
    public static final GLProfile GL30 = new GLProfile (
            3, 0, true
    );
    
    public static final GLProfile GL30Back = new GLProfile (
            3, 0, false
    );
    
    public static final GLProfile GL32 = new GLProfile (
            3, 2, true
    );
    
    public static final GLProfile GL32Back = new GLProfile (
            3, 2, false
    );
    
    public static final GLProfile GL40 = new GLProfile (
            4, 0, true
    );
    
    public static final GLProfile GL42 = new GLProfile (
            4, 2, true
    );
    
    public static final GLProfile GL45 = new GLProfile (
            4, 5, true
    );
    
    public int major;
    public int minor;
    public boolean core;
    
    public GLProfile(int major, int minor, boolean core)
    {
        this.major = major;
        this.minor = minor;
        this.core = core;
    }
    
}
