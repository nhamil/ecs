/**
 * 
 */
package com.tenikkan.ecs.game.components;

import com.tenikkan.ecs.Component;

/**
 * @author Nicholas Hamilton
 *
 */
public class RenderType extends Component
{   
    public static final Type NULL = new Type(0, "null");
    public static final Type PLAYER = new Type(1, "player");
    public static final Type BASIC_ENEMY = new Type(2, "basic_enemy");
    
    public Type type;
    
    public RenderType(Type type) 
    {
        this.type = type;
    }
    
    public String toString() 
    {
        return "RenderType: \"" + type.name + "\"";
    }
    
    public static class Type 
    {
        public final String name;
        public final int value;
        
        public Type(int value, String name) 
        {
            this.name = name;
            this.value = value;
        }
    }
}
