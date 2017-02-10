import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 *
 * @author andrewjoseph
 */
public class ButtonPanel extends JPanel implements ActionListener {
    public static ButtonPanel inst;
    private JButton clear;
    private JButton text;
    private JButton filledRectangle;
    private JButton filledOval;
    private JButton rectangle;
    private JButton oval;
    private JButton threeDRectangle;
    private JButton line;
    private JButton draw;
    private JButton sprayCan;
    private JButton changeColor;
    private JButton changeStroke;
    

    ButtonPanel() {  
        //makes the buttons
        clear = new JButton();
        text = new JButton();
        filledRectangle = new JButton();
        filledOval = new JButton();
        rectangle = new JButton();
        oval = new JButton();
        threeDRectangle = new JButton();
        line = new JButton();
        draw = new JButton();
        sprayCan = new JButton();
        changeColor = new JButton();
        changeStroke = new JButton();
        
        //gives them functionality
        clear.setActionCommand("Clear");
        text.setActionCommand("Text");
        filledRectangle.setActionCommand("Filled Rectangle");
        filledOval.setActionCommand("Filled Oval");
        rectangle.setActionCommand("Empty Rectangle");
        oval.setActionCommand("Empty Oval");
        threeDRectangle.setActionCommand("3D Rectangle");
        line.setActionCommand("Line");
        draw.setActionCommand("Draw");
        sprayCan.setActionCommand("Spray Can");
        changeColor.setActionCommand("Change Color");
        changeStroke.setActionCommand("Change Stroke");
        

        //adds an icon to each button
        ImageIcon clearIcon = new ImageIcon("Icons/trash.png");
        ImageIcon textIcon = new ImageIcon("Icons/text.png");
        ImageIcon filledRectangleIcon = new ImageIcon("Icons/filledRectangle.png");
        ImageIcon filledOvalIcon = new ImageIcon("Icons/circle.png");
        ImageIcon rectangleIcon = new ImageIcon("Icons/rectangle.png");
        ImageIcon ovalIcon = new ImageIcon("Icons/emptyCircle.png");
        ImageIcon threeDRectangleIcon = new ImageIcon("Icons/3dRectangle.png");
        ImageIcon lineIcon = new ImageIcon("Icons/line.png");
        ImageIcon drawIcon = new ImageIcon("Icons/pencil.png");
        ImageIcon sprayCanIcon = new ImageIcon("Icons/spray.png");
        ImageIcon changeColorIcon = new ImageIcon("Icons/color.png");
        ImageIcon changeStrokeIcon = new ImageIcon("Icons/stroke.png");
        //graphic to use when you hover over a button
        ImageIcon rollover = new ImageIcon("Icons/foot.png");
        
        //sets the icons on the buttons
        clear.setIcon(clearIcon);
        text.setIcon(textIcon);
        filledRectangle.setIcon(filledRectangleIcon);
        filledOval.setIcon(filledOvalIcon);
        rectangle.setIcon(rectangleIcon);
        oval.setIcon(ovalIcon);
        threeDRectangle.setIcon(threeDRectangleIcon);
        line.setIcon(lineIcon);
        draw.setIcon(drawIcon);
        sprayCan.setIcon(sprayCanIcon);
        changeColor.setIcon(changeColorIcon);
        changeStroke.setIcon(changeStrokeIcon);
        
        //makes the graphic pop up when you roll over a button
        clear.setRolloverEnabled(true);
        clear.setRolloverIcon(rollover);
        text.setRolloverEnabled(true);
        text.setRolloverIcon(rollover);
        filledRectangle.setRolloverEnabled(true);
        filledRectangle.setRolloverIcon(rollover);
        filledOval.setRolloverEnabled(true);
        filledOval.setRolloverIcon(rollover);
        rectangle.setRolloverEnabled(true);
        rectangle.setRolloverIcon(rollover);
        oval.setRolloverEnabled(true);
        oval.setRolloverIcon(rollover);
        threeDRectangle.setRolloverEnabled(true);
        threeDRectangle.setRolloverIcon(rollover);
        line.setRolloverEnabled(true);
        line.setRolloverIcon(rollover);
        draw.setRolloverEnabled(true);
        draw.setRolloverIcon(rollover);
        sprayCan.setRolloverEnabled(true);
        sprayCan.setRolloverIcon(rollover);
        changeColor.setRolloverEnabled(true);
        changeColor.setRolloverIcon(rollover);
        changeStroke.setRolloverEnabled(true);
        changeStroke.setRolloverIcon(rollover);
        
        //makes the button clickable/functional
        clear.addActionListener(this);
        text.addActionListener(this);
        filledRectangle.addActionListener(this);
        filledOval.addActionListener(this);
        rectangle.addActionListener(this);
        oval.addActionListener(this);
        threeDRectangle.addActionListener(this);
        line.addActionListener(this);
        draw.addActionListener(this);
        sprayCan.addActionListener(this);
        changeColor.addActionListener(this);
        changeStroke.addActionListener(this);
        
        //sets the layout of the buttons
        setLayout(new GridLayout(12, 1));
        
        //adds the buttons to the JFrame
        add(clear);
        add(text);
        add(filledRectangle);
        add(filledOval);
        add(rectangle);
        add(oval);
        add(threeDRectangle);
        add(line);   
        add(draw);
        add(sprayCan);
        add(changeColor);
        add(changeStroke);        
    }
    
    public static ButtonPanel getInstance() {
        if(inst == null)
            inst = new ButtonPanel();
        return inst;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        CanvasPanel canvas = CanvasPanel.getInstance();
        
        //switch lets you change color and stroke without having a mouse event 
        switch (ae.getActionCommand()) {
            case "Change Color":
                canvas.changeColor();
                break;
            case "Change Stroke":
                canvas.changeStroke();  
                break;
            default:
                canvas.setButton(ae.getActionCommand());
                break;
        }
    } 
}
    

