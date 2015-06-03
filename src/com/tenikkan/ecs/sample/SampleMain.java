/**
 * 
 */
package com.tenikkan.ecs.sample;

import com.tenikkan.ecs.ECS;
import com.tenikkan.ecs.Entity;
import com.tenikkan.util.GameLoop;

/**
 * @author Nicholas Hamilton
 *
 */
public class SampleMain
{   
    public static void main(String args[]) 
    {
        gameLoopTest();
//        ecsTest();
    }
    
    public static void gameLoopTest() 
    {
        GameLoop loop = new SampleGameLoop();
        
        loop.start();
    }
    
    public static void ecsTest() 
    {
        ECS ecs = new ECS();
        
        new EntityPrintingSystem();
        new MovementSystem();
        
        Entity e = ecs.createEntity();
        e.add(new Name("My Entity"));
        e.add(new Position(3.4f, 1.0f));
        e.add(new Velocity(-1.2f, 0.7f));
        
        System.out.println(e.toFullString());
        System.out.println();
        
        e = ecs.createEntity();
        e.add(new Name("The Other Entity"));
        
        System.out.println(e.toFullString());
        System.out.println();
        
        e = ecs.createEntity(); 
        e.add(new Position(1.8f, -2.1f));
        
        System.out.println(e.toFullString());
        System.out.println();
        
        ecs.updateAll();
    }
}
