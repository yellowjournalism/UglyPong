import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Ball extends Ellipse2D.Double{
    private int startX;
    private int startY;
    private int diameter;

    //Ellipse2D.Double ball;
    
    private int xSpeed;
    private int ySpeed;
    
    private int topBound;
    private int bottomBound;
    
    private boolean inPlay;
    
    public Ball(int x, int y, int diameter, int top, int bottom){
        super(x,y,diameter, diameter);
        
        startX = x;
        startY = y;
        this.diameter = diameter;
        
        topBound = top;
        bottomBound = bottom;
        
    //        ball = new Ellipse2D.Double(xLeft, yTop, diameter, diameter);
        
        xSpeed = 2;
        ySpeed = 3;
        
        inPlay = true;
    }

    public void draw(Graphics2D g2){
        if(inPlay)
        {
            g2.draw(this);
            g2.draw(new Rectangle((int)x,(int)y, diameter, diameter));
        }
    }

    public void moveTo(int x, int y){
        setFrame(x, y, diameter, diameter);
        
        //        xLeft = x;
//        yTop = y;
//
//        if(yTop < topBound)
//        {
//            yTop = topBound;
//            ySpeed = -1 * ySpeed;
//        }
//        
//        if(yTop > bottomBound)
//        {
//            yTop = bottomBound;
//            ySpeed = -1 * ySpeed;
//        }
        

    }
    
//    public int getX()
//    {
//        return xLeft;
//    }
//    
//    public int getY()
//    {
//        return yTop;
//    }
    
    public int getDiameter()
    {
        return diameter;
    }
    
    public void flipXSpeed()
    {
        xSpeed = -1 * xSpeed;
    }
    
    public void update()
    {
        int x = (int)getX() + xSpeed;
        int y = (int)getY() + ySpeed;

        
        if(y < topBound)
        {
            y = topBound;
            ySpeed = -1 * ySpeed;
        }
        
        if(y > bottomBound - diameter)
        {
            y = bottomBound - diameter;
            ySpeed = -1 * ySpeed;
        }

        moveTo(x,y);
    }
    
    public void reset()
    {
        moveTo(startX,startY);
        xSpeed = 10;
        ySpeed = 10;
        goLive();
    }
    
    public void goDead()
    {
        inPlay = false;
    }
    
    public void goLive()
    {
        inPlay = true;
    }
}