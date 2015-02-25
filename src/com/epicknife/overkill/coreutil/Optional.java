
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

package com.epicknife.overkill.coreutil;

/**
 * Handles optional parameters to functions/constructors.
 * Exists for back compatibility with old JRE/JDK.
 * @author Samuel "MrOverkill" Meyers
 * @param <T> 
 */
public class Optional < T >
{
    
    /**
     * The object we're keeping.
     * Could be null if hasObject is false.
     */
    private final T object;
    
    /**
     * Whether or not the object is null.
     */
    private final boolean hasObject;
    
    /**
     * If we have an object, save it and make hasObject true.
     * Otherwise, make hasObject false.
     * @param object 
     */
    public Optional(T object)
    {
        this.object = object;
        this.hasObject = (this.object != null);
    }
    
    /**
     * If we have no object.
     * Always sets hasObject to false.
     */
    public Optional()
    {
        this(null);
    }
    
    /**
     * Whether or not we have an object.
     * @return boolean
     */
    public boolean hasObject()
    {
        return this.hasObject;
    }
    
    /**
     * Get the object.
     * @return T
     */
    public T getObject()
    {
        return this.object;
    }
    
}
