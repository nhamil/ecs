/**
 * 
 */
package com.tenikkan.ecs.game.components;

import com.tenikkan.ecs.Component;

/**
 * @author Nicholas Hamilton
 *
 */
public class Velocity extends Component
{   
    public double dx = 0f;
    public double dy = 0f;
    
    public Velocity(double x, double y) 
    {
        this.dx = x; 
        this.dy = y;
    }
    
    public String toString() 
    {
        return "Velocity: {" + dx + ", " + dy + "}";
    }
}
