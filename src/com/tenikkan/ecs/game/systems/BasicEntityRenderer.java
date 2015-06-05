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
import com.tenikkan.ecs.game.components.RenderType;
import com.tenikkan.ecs.game.graphics.Display;

/**
 * @author Nicholas Hamilton
 *
 */
public class BasicEntityRenderer extends EntitySystem
{
    private Display display;
    
    public BasicEntityRenderer(Display display) 
    {
        super(Position.class, RenderType.class);
        this.display = display;
    }
    
    public void process(List<Entity> entities)
    {
        Graphics g = display.getGraphics();
        
        for(Entity e : entities) 
        {
            Position pos = e.get(Position.class);
            RenderType render = e.get(RenderType.class);
            
            int value = render.type.value;
            
            if(value == RenderType.PLAYER.value) 
                drawPlayer(g, pos);
            else if(value == RenderType.BASIC_ENEMY.value) 
                drawBasicEnemy(g, pos);
        }
        
        g.dispose();
    }
    
    private void drawBasicEnemy(Graphics g, Position pos) 
    {
        g.setColor(Color.RED);
        
        int radius = 10;
        
        int x = (int)(pos.x);
        int y = (int)(pos.y);
        
        g.fillRect(x - radius, y - radius, radius * 2, radius * 2);
    }
    
    private void drawPlayer(Graphics g, Position pos) 
    {
        g.setColor(Color.GREEN);
        
        int radius = 10;
        
        int x = (int)(pos.x);
        int y = (int)(pos.y);
        
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
