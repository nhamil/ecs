/**
 * 
 */
package com.tenikkan.ecs;

/**
 * @author Nicholas Hamilton
 *
 */
public class UIDGenerator
{   
    private int nextID;
    
    public UIDGenerator() 
    {
        nextID = 0;
    }
    
    public int nextUID() { return nextID++; }
}
