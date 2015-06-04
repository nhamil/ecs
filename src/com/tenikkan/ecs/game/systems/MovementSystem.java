/**
 * 
 */
package com.tenikkan.ecs.game.systems;

import java.util.List;

import com.tenikkan.ecs.Entity;
import com.tenikkan.ecs.EntitySystem;
import com.tenikkan.ecs.game.components.Position;
import com.tenikkan.ecs.game.components.Velocity;

/**
 * @author Nicholas Hamilton
 *
 */
public class MovementSystem extends EntitySystem
{   
    public MovementSystem() 
    {
        super(Position.class, Velocity.class);
    }
    
    public void process(List<Entity> entities) 
    {
        for(Entity e : entities) 
        {
            Position pos = e.get(Position.class);
            Velocity vel = e.get(Velocity.class);
            pos.x += vel.dx;
            pos.y += vel.dy;
        }
    }
}
