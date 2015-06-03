package com.tenikkan.util;


public class Timer
{
    public static final long SECOND = 1000000000L;
    
    private long lastTime;
    private int numTicks;
    
    public Timer() 
    {
        reset();
    }
    
    public double getTicksPerSecond() 
    {
        return (double)getTicks() * SECOND / getDeltaTime();
    }
    
    public double getTicksPerSecondRounded() 
    {
        return (int)(getTicksPerSecond() * 100 + 0.5) / 100D;
    }
    
    public void tick() 
    {
        numTicks++;
    }
    
    public void reset() 
    {
        resetTime();
        resetTicks();
    }
    
    public void resetTime() 
    {
        lastTime = getTime();
    }
    
    public void resetTicks() 
    {
        numTicks = 0;
    }
    
    public int getTicks() 
    {
        return numTicks;
    }
    
    public long getDeltaTime() 
    {
        return getTime() - lastTime;
    }
    
    public static long getTime() 
    {
        return System.nanoTime(); 
    }
}
