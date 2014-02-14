import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class PongComponent extends JComponent{
    
    Rectangle outBorder;
    Rectangle inBorder;
    
    Paddle p1;
    Paddle p2;
    
    Ball theBall;
    
    PongController pongControl;
    
    final int PLAYWIDTH = 500;
    final int PLAYHEIGHT = 500;
    final int BORDER_OFFSET = 5;
    
    final int PADDLE_WIDTH = 10;
    final int PADDLE_HEIGHT = 60;
    
    
    
    
    
    public PongComponent(PongController pongControl)
    {
        super();
        
        this.pongControl = pongControl;
        
        setPreferredSize(new Dimension(PLAYWIDTH + BORDER_OFFSET*2,PLAYHEIGHT + BORDER_OFFSET*2));
        setSize(new Dimension(PLAYWIDTH + BORDER_OFFSET*2 ,PLAYHEIGHT + BORDER_OFFSET*2));
        
        
        outBorder = new Rectangle(0,0,PLAYWIDTH,PLAYHEIGHT);
        inBorder = new Rectangle(BORDER_OFFSET,BORDER_OFFSET,PLAYWIDTH-BORDER_OFFSET*2,PLAYHEIGHT-BORDER_OFFSET*2);
        
        //Create Game Objects
        p1 = new Paddle(BORDER_OFFSET,
                        BORDER_OFFSET,
                        BORDER_OFFSET,
                        PLAYHEIGHT - BORDER_OFFSET);
        
        p2 = new Paddle(PLAYWIDTH - BORDER_OFFSET - PADDLE_WIDTH,
                        PLAYHEIGHT - BORDER_OFFSET - PADDLE_HEIGHT - 125,
                        BORDER_OFFSET,
                        PLAYHEIGHT - BORDER_OFFSET);
        
        theBall = new Ball(PLAYWIDTH/2,
                           PLAYHEIGHT/2,
                           10,
                           BORDER_OFFSET,
                           PLAYHEIGHT - BORDER_OFFSET);
        
        
        setFocusOnClick(); //helper
        
    }
    
    private void setFocusOnClick()
    {
        //Make sure it gets focus on click
        class FocusMouse implements MouseListener{
            public void mouseEntered(MouseEvent e)
            {
                
            }
            public void mouseExited(MouseEvent e)
            {
                
            }
            public void mouseClicked(MouseEvent e)
            {
                requestFocusInWindow();
            }
            public void mouseReleased(MouseEvent e)
            {
                
            }
            public void mousePressed(MouseEvent e)
            {
                
            }
        }
        FocusMouse fm = new FocusMouse();
        addMouseListener(fm);
    }
    
    
    //Paint override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.draw(outBorder);
        g2.draw(inBorder);

        p1.draw(g2);
        p2.draw(g2);
        
        theBall.draw(g2);
    }
    
    
    
    public void newGame()
    {
        p1.moveTo(BORDER_OFFSET,BORDER_OFFSET);
        p2.moveTo(PLAYWIDTH - BORDER_OFFSET - PADDLE_WIDTH,
                  PLAYHEIGHT - BORDER_OFFSET - PADDLE_HEIGHT - 125);
        theBall.reset();
        theBall.goLive();
        repaint();
    }
 
     // Tick Tock!!!
    public void tick()
    {
        if(pongControl.getP1up() && !pongControl.getP1down())
        {
            p1.moveUp();
        }
        if(!pongControl.getP1up() && pongControl.getP1down())
        {
            p1.moveDown();
        }
        if(pongControl.getP2up() && !pongControl.getP2down())
        {
            p2.moveUp();
        }
        if(!pongControl.getP2up() && pongControl.getP2down())
        {
            p2.moveDown();
        }
        
        theBall.update();
        
        //Collision detection
        //---------------------------
        if(theBall.getX() <= BORDER_OFFSET + PADDLE_WIDTH ) //in range of left paddle
        {
            if(theBall.getY() > p1.getTop() && theBall.getY() < p1.getBottom())
            {
                theBall.flipXSpeed();   
            }
            else if(theBall.getX() <= BORDER_OFFSET)
            {
                theBall.goDead();
            }
            
        }
        
        //in range of right paddle
        else if(theBall.getX() >= PLAYWIDTH - BORDER_OFFSET - PADDLE_WIDTH - theBall.getDiameter()) 
        {
            if(theBall.getY() > p2.getTop() && theBall.getY() < p2.getBottom()) //if within paddle
            {
                theBall.flipXSpeed();
            }
            else if(theBall.getX() >= PLAYWIDTH - BORDER_OFFSET - theBall.getDiameter())
            {
                theBall.goDead();
            }
        }
        
        repaint();
    }
    
    

}