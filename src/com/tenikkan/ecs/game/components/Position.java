/**
 * 
 */
package com.tenikkan.ecs.game.components;

import java.text.DecimalFormat;

import com.tenikkan.ecs.Component;

/**
 * @author Nicholas Hamilton
 *
 */
public class Position extends Component
{   
    private static DecimalFormat fmt = new DecimalFormat("0.00");
    
    public double x = 0f;
    public double y = 0f;
    
    public Position(double x, double y) 
    {
        this.x = x; 
        this.y = y;
    }
    
    public String toString() 
    {
        return "Position: {" + fmt.format(x) + ", " + fmt.format(y) + "}";
    }
}
