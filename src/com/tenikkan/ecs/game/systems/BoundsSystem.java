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
public class BoundsSystem extends EntitySystem
{
    private float yMax, yMin, xMin, xMax;
    
    public BoundsSystem(float yMin, float yMax, float xMin, float xMax) 
    {
        super(Position.class, Velocity.class);
        this.yMin = yMin;
        this.yMax = yMax;
        this.xMin = xMin;
        this.xMax = xMax;
    }
    
    public void process(List<Entity> entities)
    {
        for(Entity e : entities) 
        {
            Position pos = e.get(Position.class);
            if(pos.y < yMin) pos.y = yMin;
            if(pos.y > yMax) pos.y = yMax;
            
            if(pos.x < xMin) pos.x = xMin;
            if(pos.x > xMax) pos.x = xMax;
        }
    }
    
}
