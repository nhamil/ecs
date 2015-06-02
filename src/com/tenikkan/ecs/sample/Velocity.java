/**
 * 
 */
package com.tenikkan.ecs.sample;

import com.tenikkan.ecs.Component;

/**
 * @author Nicholas Hamilton
 *
 */
public class Velocity extends Component
{   
    public float dx = 0f;
    public float dy = 0f;
    
    public Velocity(float x, float y) 
    {
        this.dx = x; 
        this.dy = y;
    }
    
    public String toString() 
    {
        return "Velocity: {" + dx + ", " + dy + "}";
    }
}
