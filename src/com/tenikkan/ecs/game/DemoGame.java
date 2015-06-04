/**
 * 
 */
package com.tenikkan.ecs.game;

import java.awt.Color;
import java.awt.Graphics;

import com.tenikkan.ecs.ECS;
import com.tenikkan.ecs.Entity;
import com.tenikkan.ecs.EntitySystem;
import com.tenikkan.ecs.game.components.Name;
import com.tenikkan.ecs.game.components.Position;
import com.tenikkan.ecs.game.components.Velocity;
import com.tenikkan.ecs.game.graphics.Display;
import com.tenikkan.ecs.game.systems.DebugEntityReader;
import com.tenikkan.ecs.game.systems.DebugPointRenderer;
import com.tenikkan.ecs.game.systems.MovementSystem;
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
    private EntitySystem entityReader;
    
    private EntitySystem pointRenderer;
    
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
        entityReader = new DebugEntityReader();
        
        pointRenderer = new DebugPointRenderer(display);
    }
    
    private void addSystems() 
    {
        ecs.addEntitySystem(movementSystem);
        ecs.addEntitySystem(entityReader);
        ecs.addEntitySystem(pointRenderer);
    }
    
    private void addEntities() 
    {
        Entity e = ecs.createEntity();
        e.add(new Name("Moving Entity"));
        e.add(new Position(2.0, 1.0));
        e.add(new Velocity(0.05, 0.05));
        
        e = ecs.createEntity();
        e.add(new Name("Stationary Entity"));
        e.add(new Position(21.0, 37.0));
    }
    
    public void update() 
    {
        display.setTitle(TITLE + " (" + getFramesPerSecond() + " frames, " + getUpdatesPerSecond() + " updates)");
        
        movementSystem.update();
        entityReader.update();
    }
    
    public void render() 
    {
        Graphics g = display.getGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        
        pointRenderer.update();
        
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
