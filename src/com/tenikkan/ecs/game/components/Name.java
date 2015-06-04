/**
 * 
 */
package com.tenikkan.ecs.game.components;

import com.tenikkan.ecs.Component;

/**
 * @author Nicholas Hamilton
 *
 */
public class Name extends Component
{   
    public String name;
    
    public Name(String n) 
    {
        name = n;
    }
    
    public String toString() 
    {
        return "Name: \"" + name + "\"";
    }
}
