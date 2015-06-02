/**
 * 
 */
package com.tenikkan.ecs.sample;

import com.tenikkan.ecs.Component;

/**
 * @author Nicholas Hamilton
 *
 */
public class Position extends Component
{   
    public float x = 0f;
    public float y = 0f;
    
    public Position(float x, float y) 
    {
        this.x = x; 
        this.y = y;
    }
    
    public String toString() 
    {
        return "Position: {" + x + ", " + y + "}";
    }
}
