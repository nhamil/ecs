/**
 * 
 */
package com.tenikkan.ecs.game.systems;

import java.util.List;

import com.tenikkan.ecs.Entity;
import com.tenikkan.ecs.EntitySystem;

/**
 * @author Nicholas Hamilton
 *
 */
public class DebugEntityReader extends EntitySystem
{
    public DebugEntityReader() 
    {
        super();
    }
    
    public void process(List<Entity> entities)
    {
        System.out.println("Entities");
        System.out.println();
        
        for(Entity e : entities) 
        {
            System.out.println(e.toFullString());
            System.out.println();
        }
    }
    
}
