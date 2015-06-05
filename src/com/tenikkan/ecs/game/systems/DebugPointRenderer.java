/**
 * 
 */
package com.tenikkan.ecs.game.systems;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import com.tenikkan.ecs.Entity;
import com.tenikkan.ecs.EntitySystem;
import com.tenikkan.ecs.game.components.Position;
import com.tenikkan.ecs.game.graphics.Display;

/**
 * @author Nicholas Hamilton
 *
 */
public class DebugPointRenderer extends EntitySystem
{   
    private Display display;
    
    public DebugPointRenderer(Display display) 
    {
        super(Position.class);
        this.display = display;
    }
    
    public void process(List<Entity> entities)
    {
        Graphics g = display.getGraphics();
        
        for(Entity e : entities) 
        {
            Position pos = e.get(Position.class);
            
            g.setColor(Color.BLUE);
            
            int radius = 10;
            
            int x = (int)(pos.x);
            int y = (int)(pos.y);
            
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }
        
        g.dispose();
    }
}
