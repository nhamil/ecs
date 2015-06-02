/**
 * 
 */
package com.tenikkan.ecs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nicholas Hamilton
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class ECS
{   
    private List<Entity> entities;
    private HashMap<Class, HashMap<Integer, Component>> db;
    private UIDGenerator uidGen;
    
    private List<EntitySystem> systems;
    
    public ECS() 
    {
        db = new HashMap<Class, HashMap<Integer, Component>>();
        
        systems = new ArrayList<EntitySystem>();
        
        entities = new ArrayList<Entity>();
        
        uidGen = new UIDGenerator();
        
        Entity.setECS(this);
        EntitySystem.setECS(this);
    }
    
    public void update() 
    {
        for(EntitySystem es : systems) 
        {
            es.update();
        }
    }
    
    public void addEntitySystem(EntitySystem es) 
    {
        systems.add(es);
        es.addEntities(entities);
    }
    
    public int generateUID() 
    { 
        return uidGen.nextUID(); 
    }
    
    public Entity createEntity() 
    {
        Entity e = new Entity(generateUID());
        entities.add(e);
        return e;
    }
    
    public void refreshEntity(Entity e) 
    {
        for(EntitySystem es : systems) 
        {
            es.refreshEntity(e);
        }
    }
    
    public <T extends Component> void registerComponent(Class<T> type) 
    {
        if(db.get(type) != null) 
            throw new RuntimeException("Type " + type + " is already registered");
        
        db.put(type, new HashMap<Integer, Component>());
    }
    
    public <T extends Component> boolean containsComponent(Entity e, Class<T> type) 
    {
        return getComponent(e, type) != null;
    }
    
    public <T extends Component> T getComponent(Entity e, Class<T> type) 
    {
        HashMap<Integer, ? extends Component> tmpStore = db.get(type);
        
        if(tmpStore == null) 
            throw new RuntimeException("No store for type " + type);
        
        T comp = (T)tmpStore.get(e.getID());
        
        return comp;
    }
    
    public void addComponent(Entity e, Component c) 
    {
        HashMap<Integer, Component> tmpStore = db.get(c.getClass());
        
        if(tmpStore == null) 
            throw new RuntimeException("No store for type " + c.getClass());
        
        tmpStore.put(e.getID(), c);
    }
    
    public <T extends Component> void removeComponent(Entity e, Class<T> type) 
    {
        HashMap<Integer, Component> tmpStore = db.get(type);
        
        if(tmpStore == null) 
            throw new RuntimeException("No store for type " + type);
        
        tmpStore.remove(e.getID());
    }
    
    public List<Component> getAllComponents(Entity e) 
    {
        List<Component> comps = new ArrayList<Component>();
        
        Iterator<Class> types = db.keySet().iterator();
        while(types.hasNext()) 
        {
            Component c = getComponent(e, types.next());
            if(c != null) 
                comps.add(c);
        }
        
        return comps;
    }
}
