/**
 * 
 */
package com.tenikkan.ecs;

import java.util.List;

/**
 * @author Nicholas Hamilton
 *
 */
public class Entity
{   
    private static ECS ecs;
    
    private int id;
    
    public Entity(int id) 
    {
        this.id = id;
    }
    
    public int getID() { return id; }
    
    public <T extends Component> T get(Class<T> type) 
    {
        return ecs.getComponent(this, type);
    }
    
    public void refresh() 
    {
        ecs.refreshEntity(this);
    }
    
    public void add(Component c) 
    {
        ecs.addComponent(this, c);
        refresh();
    }
    
    public <T extends Component> void remove(Class<T> type) 
    {
        ecs.removeComponent(this, type);
        refresh();
    }
    
    public String toString() 
    {
        return "id@" + String.format("%01x", id);
    }
    
    public String toFullString() 
    {
        String str = "Entity " + toString() + " { \n";
        
        List<Component> comps = ecs.getAllComponents(this);
        for(Component c : comps) 
        {
            str += "  " + c + "; \n";
        }
        str += "}";
        
        return str;
    }
    
    @Override
    public int hashCode() 
    {
        return id;
    }
    
    public static void setECS(ECS ecs) 
    {
        Entity.ecs = ecs;
    }
}
