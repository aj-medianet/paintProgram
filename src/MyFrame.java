import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author andrewjoseph
 */
class MyFrame extends JFrame {
   public static MyFrame inst;
   JMenuBar menuBar;
   JMenu menu;
   JMenuItem about, save, quit, redo, undo;

   
   MyFrame() {
       super("Paint");
       
       menuBar = new JMenuBar();   //adds instance menuBar

       JMenu file = new JMenu("File");     
       JMenu edit = new JMenu("Edit");
       JMenu choices = new JMenu("Choices");
       JMenu help = new JMenu("Help");
       
       
       //adds items to the menuBar
       menuBar.add(file);
       menuBar.add(edit);
       menuBar.add(choices);
       menuBar.add(help);
       
       //adds the about popup to the help drop down
       about = new JMenuItem("About");
       about.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){ about(); }
       });
       help.add(about);
       
       //addsJMenuItems to file
       save = new JMenuItem("Save");
       quit = new JMenuItem("Quit");
       
       save.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){ save(); }

           private void save() {
               
           }
           });
       
       quit.addActionListener(new ActionListener(){
            @Override
          public void actionPerformed(ActionEvent evt){ quit(); }

           private void quit() {
               System.exit(0);
           }   
       });
       
       file.add(save);
       file.add(quit);
       
       //JMenuItems inside of the edit pulldown
       redo = new JMenuItem("Redo");
       undo = new JMenuItem("Undo");
       
       edit.add(redo);
       edit.add(undo);
       
       

       //adds stuff to the JFrame and makes it visibles
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.getContentPane().add(ButtonPanel.getInstance(), BorderLayout.WEST);
       this.getContentPane().add(CanvasPanel.getInstance(), BorderLayout.CENTER);
       this.setSize(800,500);
       this.setJMenuBar(menuBar);   //adds menuBar to frame
       this.setVisible(true);
   }
   
   private void about() {
       Frame f = new Frame();
       SplishSplash splash = new SplishSplash(f);
   }
   
   public static MyFrame getInstance() {
        if(inst == null)
            inst = new MyFrame();
        
        return inst;
    } 
}