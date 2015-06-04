/**
 * 
 */
package com.tenikkan.ecs.game.graphics;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * @author Nicholas Hamilton
 *
 */
public class Display
{   
    private JFrame frame;
    private Canvas canvas;
    
    public Display(String title, int width, int height) 
    {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        canvas = new Canvas();
        canvas.setSize(width, height);
        
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
        
        canvas.createBufferStrategy(2);
    }
    
    public String getTitle() 
    {
        return frame.getTitle();
    }
    
    public void setTitle(String title) 
    {
        frame.setTitle(title);
    }
    
    public Graphics getGraphics() 
    {
        return canvas.getBufferStrategy().getDrawGraphics();
    }
    
    public void swapBuffers() 
    {
        canvas.getBufferStrategy().show();
    }
}
