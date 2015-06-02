/**
 * 
 */
package com.tenikkan.ecs.sample;

import java.util.List;

import com.tenikkan.ecs.Entity;
import com.tenikkan.ecs.EntitySystem;

/**
 * @author Nicholas Hamilton
 *
 */
public class EntityPrintingSystem extends EntitySystem
{
    public EntityPrintingSystem() 
    {
        super(Name.class);
    }
    
    public void process(List<Entity> entities)
    {
        System.out.println("Entities that have a name:");
        
        for(Entity e : entities) 
        {
            if(e.get(Name.class) == null) System.err.println(e.toFullString() + " no name");
            System.out.println(e + ": " + e.get(Name.class).name);
        }
    }   
}
