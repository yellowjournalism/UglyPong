import java.awt.*;
import java.awt.event.*;

public class PongController implements KeyListener
{
    private boolean p1up;
    private boolean p1down;
    private boolean p2up;
    private boolean p2down;
    
    
    public PongController()
    {
        p1up = false;
        p1down = false;
        p2up = false;
        p2down = false;
    }
    
    public boolean getP1up()
    {
        return p1up;
    }
    
    public boolean getP1down()
    {
        return p1down;
    }
    
    public boolean getP2up()
    {
        return p2up;
    }
    
    public boolean getP2down()
    {
        return p2down;
    }
    
    /** Handle the key pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode)
        {
            case 87:
//                System.out.println("pressed W");
                p1up = true;
                break;
            case 83:
//                System.out.println("pressed S");
                p1down = true;
                break;
            case 38:
//                System.out.println("pressed Up");
                p2up = true;
                break;
            case 40:
//                System.out.println("pressed Down");
                p2down = true;
                break;
                
                
        }
        
    }
    
    /** Handle the key released event from the text field. */
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode)
        {
            case 87:
//                System.out.println("released W");
                p1up = false;
                break;
            case 83:
//                System.out.println("released S");
                p1down = false;
                break;
            case 38:
//                System.out.println("released Up");
                p2up = false;
                break;
            case 40:
//                System.out.println("released Down");
                p2down = false;
                break;
                
                
        }
    }
    
    
    public void keyTyped(KeyEvent e) {
    }
    
    
}