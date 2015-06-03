package com.tenikkan.util;

public abstract class GameLoop implements Runnable
{
    private Thread thread;
    private boolean running = false;
    
    private double fpsFreq;
    private double fps;
    private double ups;
    
    private double fpsGoal;
    private double upsGoal;
    
    private Timer updateTimer;
    private Timer renderTimer;
    
    public GameLoop(double frames, double updates, double fpsFreq) 
    {
        updateTimer = new Timer();
        renderTimer = new Timer();
        
        this.fpsFreq = fpsFreq;
        
        ups = fps = 0;
        
        fpsGoal = frames;
        upsGoal = updates;
    }
    
public abstract void init();
    
    public abstract void update();
    
    public abstract void render();
    
    public abstract void end();
    
    public synchronized void start() 
    {
        if(running) return;
        
        running = true;
        thread = new Thread(this, "GameLoop");
        thread.start();
    }
    
    public synchronized void stop() 
    {
        if(!running) return;
        
        running = false;
        try 
        {
            thread.join();
        } catch(InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void run() 
    {
        init();
        
        long uTime = Timer.getTime();
        long rTime = Timer.getTime();
        double uSkip = Timer.SECOND / (double)upsGoal;
        double rSkip = Timer.SECOND / (double)fpsGoal;
        
        while(running) 
        {
            while(uTime < Timer.getTime()) 
            {
                update();
                updateTimer.tick();
                
                uTime += uSkip;
            }   
            
            if(rTime < Timer.getTime()) 
            {
                render();
                renderTimer.tick();
                
                rTime += rSkip;
            }
            
            if(updateTimer.getDeltaTime() >= fpsFreq * Timer.SECOND) 
            {
                ups = updateTimer.getTicksPerSecondRounded();
                fps = renderTimer.getTicksPerSecondRounded();
                updateTimer.reset();
                renderTimer.reset();
            } 
        }
        
        end();
    }
    
    public double getUpdatesPerSecond() 
    {
        return ups;
    }
    
    public double getFramesPerSecond() 
    {
        return fps;
    }
}
