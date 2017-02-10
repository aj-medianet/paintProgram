import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author andrewjoseph
 */
class SplishSplash extends JWindow {
    final int WAITTIME = 5000;  //sets how long the splashscreen will stay up
    
    public SplishSplash(Frame f) {
        super(f);
        JLabel l = new JLabel();
        ImageIcon logo = new ImageIcon("Images/charlotte.jpg");
        l.setIcon(logo);
        
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2), screenSize.height/2 - (labelSize.height/2));   
        addMouseListener(new MouseAdapter() {               
            @Override
            public void mousePressed(MouseEvent e) {            
                setVisible(false);                
                dispose();              
            }           
        });    
        final int pause = WAITTIME;       
        final Runnable closerRunner = new Runnable() {                      
            public void run() {                 
                setVisible(false);          
                dispose();       
            }         
        };  
        Runnable waitRunner = new Runnable() {              
            @Override
            public void run() {              
                try {          
                    Thread.sleep(pause);           
                    SwingUtilities.invokeAndWait(closerRunner);                
                }                 
                catch(Exception e) {                     
                    e.printStackTrace();
                            // can catch InvocationTargetException
                            // can catch InterruptedException          
                }            
            }        
        };   
        setVisible(true);       
        Thread splashThread = new Thread(waitRunner, "SplashThread"); 
        splashThread.start();
    }
}

