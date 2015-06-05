/**
 * 
 */
package com.tenikkan.ecs.game;

import java.awt.Color;
import java.awt.Graphics;

import com.tenikkan.ecs.ECS;
import com.tenikkan.ecs.Entity;
import com.tenikkan.ecs.EntitySystem;
import com.tenikkan.ecs.game.components.*;
import com.tenikkan.ecs.game.graphics.Display;
import com.tenikkan.ecs.game.systems.*;
import com.tenikkan.util.GameLoop;

/**
 * @author Nicholas Hamilton
 *
 */
public class DemoGame extends GameLoop
{   
    private static final String TITLE = "Demo Game";
    
    private ECS ecs;
    
    private EntitySystem movementSystem;
    private EntitySystem entityReaderSystem;
    private EntitySystem boundsSystem;
    
    private EntitySystem pointRenderer;
    private EntitySystem entityRenderer;
    
    private Display display;
    
    public DemoGame() 
    {
        super(60, 60, 0.5);
    }
    
    public void init() 
    {
        ecs = new ECS();
        
        display = new Display(TITLE, 800, 600);
        
        initSystems();
        addSystems();
        
        addEntities();
    }
    
    private void initSystems() 
    {
        movementSystem = new MovementSystem();
        entityReaderSystem = new DebugEntityReader();
        boundsSystem = new BoundsSystem(0, 600, 0, 800);
        
        pointRenderer = new DebugPointRenderer(display);
        entityRenderer = new BasicEntityRenderer(display);
    }
    
    private void addSystems() 
    {
        ecs.addEntitySystem(movementSystem);
        ecs.addEntitySystem(entityReaderSystem);
        ecs.addEntitySystem(boundsSystem);
        
        ecs.addEntitySystem(pointRenderer);
        ecs.addEntitySystem(entityRenderer);
    }
    
    private void addEntities() 
    {
        Entity e = ecs.createEntity();
        e.add(new Name("Player"));
        e.add(new Position(20.0, 10.0));
        e.add(new Velocity(0.5, 0.5));
        e.add(new RenderType(RenderType.PLAYER));
        
        e = ecs.createEntity();
        e.add(new Name("Obstacle"));
        e.add(new Position(210.0, 370.0));
        e.add(new RenderType(RenderType.BASIC_ENEMY));
    }
    
    public void update() 
    {
        display.setTitle(TITLE + " (" + getFramesPerSecond() + " frames, " + getUpdatesPerSecond() + " updates)");
        
        movementSystem.update();
        boundsSystem.update();
    }
    
    public void render() 
    {
        Graphics g = display.getGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        
        entityRenderer.update();
        
        g.dispose();
        display.swapBuffers();
    }
    
    public void end() 
    {
        
    }
    
    public static void main(String args[]) 
    {
        GameLoop game = new DemoGame();
        game.start();
    }
}
