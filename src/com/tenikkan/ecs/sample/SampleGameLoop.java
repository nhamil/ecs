package com.tenikkan.ecs.sample;

import com.tenikkan.ecs.*;
import com.tenikkan.util.*;

public class SampleGameLoop extends GameLoop
{
    private ECS ecs;
    
    private EntitySystem movementSystem;
    private Entity entity;
    
    public SampleGameLoop() 
    {
        super(60, 20, 0.25);
    }
    
    public void init() 
    {
        ecs = new ECS();
        
        movementSystem = new MovementSystem();
        
        ecs.addEntitySystem(movementSystem);
        
        entity = ecs.createEntity();
        entity.add(new Position(0.2, 0.0));
        entity.add(new Velocity(0.1, 0.2));
    }
    
    public void update() 
    {
        movementSystem.update();
        
        System.out.println(entity.toFullString());
    }
    
    public void render() 
    {
        
    }
    
    public void end() 
    {
        
    }
}
