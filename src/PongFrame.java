

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class PongFrame extends JFrame
{
    
    static final String newline = System.getProperty("line.separator");

    
    Timer timer;
    PongController pongControl;
    PongComponent pongComp;
    
    boolean paused;
    
    
    public PongFrame() {
        super("Pong");
        addComponentsToPane();
        
        paused = false;
    }
    
    
    private void addComponentsToPane() {
        
        
        pongControl = new PongController();
        
        final JButton pauseBtn = new JButton("Pause/Unpause");
        final JButton stepBtn = new JButton("Step");
        final JButton blutton = new JButton("Reset");
        
        pongComp = new PongComponent(pongControl);
        pongComp.addKeyListener(pongControl);
        
        JPanel panel = new JPanel();
        panel.add(pauseBtn);
        panel.add(stepBtn);
        panel.add(blutton);
        panel.add(pongComp);
        this.add(panel);
//        getContentPane().add(panel);
    
        //Default focus to the game window
        this.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                pongComp.requestFocusInWindow();
            }
        });
        
               
        //reset button
        class NewGameListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                pongComp.newGame();
                pongComp.requestFocusInWindow();
            }
        }
        blutton.addActionListener(new NewGameListener());
        
        
        //------- Game Timer --------
        
        class GameListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                pongComp.tick();
            }
        }
        
        ActionListener gListener = new GameListener();
        
        timer = new Timer(10, gListener);
        timer.start();
        //-----------------------
        
        
        
        //pause button
        class PauseListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                if(!paused)
                {
                    timer.stop();
                }
                else
                {
                    timer.start();
                }
                paused = !paused;
                pongComp.requestFocusInWindow();
            }
        }
        pauseBtn.addActionListener(new PauseListener());
        
        
        //step button
        class StepListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                pongComp.tick();
                pongComp.requestFocusInWindow();
            }
        }
        stepBtn.addActionListener(new StepListener());

        
        
    }
    

  

}
