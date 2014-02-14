import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Paddle{
    private int xLeft;
    private int yTop;

    public final int THICKNESS = 10;
    public final int LENGTH = 60;
    public final int SPEED = 5;
    
    private int topBound;
    private int bottomBound;
    
    public Paddle(int x, int y, int top, int bottom){
        xLeft = x;
        yTop = y;
        topBound = top;
        bottomBound = bottom;
    }

    public int getTop()
    {
        return yTop;
    }

    public int getBottom()
    {
        return yTop + LENGTH;
    }
    
    public void draw(Graphics2D g2){
        Rectangle body = new Rectangle (xLeft, yTop, THICKNESS, LENGTH);
        g2.draw(body);
//        Rectangle body = new Rectangle (xLeft, yTop + 10, 60, 10);
//        Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft + 10, yTop + 20, 10, 10);
//        Ellipse2D.Double rearTire = new Ellipse2D.Double(xLeft + 40, yTop + 20, 10, 10);
//        
//        Point2D.Double r1 = new Point2D.Double(xLeft + 10, yTop+10);
//        Point2D.Double r2 = new Point2D.Double(xLeft + 20, yTop);
//        Point2D.Double r3 = new Point2D.Double(xLeft + 40, yTop);
//        Point2D.Double r4 = new Point2D.Double(xLeft + 50, yTop+10);
//        Line2D.Double frontWindsheild = new Line2D.Double(r1,r2);
//        Line2D.Double roofTop = new Line2D.Double(r2,r3);
//        Line2D.Double rearWindsheild = new Line2D.Double(r3,r4);
//        
//        g2.draw(body);
//        g2.draw(frontTire);
//        g2.draw(rearTire);
//        g2.draw(frontWindsheild);
//        g2.draw(roofTop);
//        g2.draw(rearWindsheild);
    }
    
    public void moveTo(int x, int y){
        xLeft = x;
        yTop = y;
        
        if(yTop < topBound)
        {
            yTop = topBound;
        }
        
        if(yTop > bottomBound - LENGTH)
        {
            yTop = bottomBound - LENGTH;
        }
    }

    
    public void moveUp()
    {
        moveTo(xLeft, yTop-SPEED);
    }
    
    public void moveDown()
    {
        moveTo(xLeft, yTop+SPEED);
    }
}