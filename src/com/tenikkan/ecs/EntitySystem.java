/**
 * 
 */
package com.tenikkan.ecs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas Hamilton
 *
 */
public abstract class EntitySystem
{   
    private static ECS ecs;
    
    private List<Integer> ids;
    private List<Class<? extends Component>> require;
    
    @SafeVarargs
    public EntitySystem(Class<? extends Component>... requirements) 
    {
        require = new ArrayList<Class<? extends Component>>();
        for(Class<? extends Component> c : requirements) 
            require.add(c);
        
        ids = new ArrayList<Integer>();
        
        ecs.addEntitySystem(this);
    }
    
    public void update() 
    {
        process(getEntities());
    }
    
    public abstract void process(List<Entity> entities);
    
    public List<Entity> getEntities() 
    {
        List<Entity> entities = new ArrayList<Entity>();
        for(int id : ids) 
        {
            entities.add(new Entity(id));
        }
        return entities;
    }
    
    public void addEntities(List<Entity> entities) 
    {
        for(Entity e : entities) 
            addEntity(e);
    }
    
    public void addEntity(Entity e) 
    {
        int id = e.getID();
        if(!contains(e) && canUse(e)) ids.add(id);
    }
    
    public void refreshEntity(Entity e) 
    {
        if(!contains(e)) 
        {
            if(canUse(e)) addEntity(e);
            return;
        } 
        else if(!canUse(e)) removeEntity(e);
    }
    
    public void removeEntity(Entity e) 
    {
        int id = e.getID();
        for(int i = 0; i < ids.size(); i++) 
            if(ids.get(i) == id) ids.remove(i);
    }
    
    public boolean canUse(Entity e) 
    {
        for(Class<? extends Component> type : require) 
        {
            if(e.get(type) == null) return false;
        }
        return true;
    }
    
    public boolean contains(Entity e) 
    {
        int id = e.getID();
        for(int i : ids)
            if(i == id) 
                return true;
        return false;
    }
    
    public static void setECS(ECS ecs) 
    {
        EntitySystem.ecs = ecs;
    }
}
