/**
 * 
 */
package com.tenikkan.ecs.game.components;

import com.tenikkan.ecs.Component;

/**
 * @author Nicholas Hamilton
 *
 */
public class Position extends Component
{   
    public double x = 0f;
    public double y = 0f;
    
    public Position(double x, double y) 
    {
        this.x = x; 
        this.y = y;
    }
    
    public String toString() 
    {
        return "Position: {" + x + ", " + y + "}";
    }
}
