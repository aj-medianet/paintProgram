import java.awt.event.*;
import javax.swing.*;

/**
 * @author andrewjoseph
 */

class CanvasPanel extends JPanel implements MouseListener, KeyListener, MouseMotionListener {
    public static CanvasPanel inst;
    private PaintPanel pp;
    private int startX, startY, endX, endY;
    private String button = "";
    private String str;
    private int xDrag, yDrag;
    
    CanvasPanel() {    
        pp = new PaintPanel();
        this.add(pp);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
    }
    
    public void setButton(String button) {
        this.button = button;

        if(this.button.equals("Clear")) {
            System.out.println("Clear");
            pp.clear();
            this.repaint();
        } 
    }
    
    public void draw() {
        
        if (this.startX > this.endX && !this.button.equals("Line")) {
        int tmpX = this.startX;
        this.startX = this.endX;
        this.endX = tmpX;
        }
        if (this.startY > this.endY && !this.button.equals("Line")) {
        int tmpY = this.startY;
        this.startY = this.endY;
        this.endY = tmpY;
        }
        
        
        int startX = this.startX;
        int startY = this.startY;
        int lengthX = this.endX - this.startX;
        int lengthY = this.endY - this.startY;

        switch (this.button) {
            case "Filled Rectangle":    
                System.out.println("Filled Rectangle");
                this.pp.drawFilledRectangle(startX, startY, lengthX, lengthY);
                break;
            case "Filled Oval":
                System.out.println("Filled Oval");
                this.pp.drawFilledOval(startX, startY, lengthX, lengthY);
                break;
            case "Empty Rectangle":
                System.out.println("Empty Rectangle");
                this.pp.drawEmptyRectangle(startX, startY, lengthX, lengthY);
                break;
            case "Empty Oval":
                System.out.println("Empty Oval");
                this.pp.drawEmptyOval(startX, startY, lengthX, lengthY);
                break;
            case "3D Rectangle":
                System.out.println("3D Rectangle");
                this.pp.drawThreeDRectangle(startX, startY, lengthX, lengthY);
                break;
            case "Line":
                System.out.println("Line");
                this.pp.lineDrawing(startX, startY, endX, endY);
                break;
                case "Spray Can":
                System.out.println("Spray Can");
                this.pp.sprayCan(startX, startY, ALLBITS, HEIGHT);
            default: 
                break;
        }
        this.repaint();
    }
    
    public void changeColor() {
        System.out.println("Change Color");
        pp.changeColor();
    }
    
    public void changeStroke() {
        System.out.println("Change Stroke");
        this.pp.changeStroke();
    }
    
    public static CanvasPanel getInstance() {
        if(inst == null) 
            inst = new CanvasPanel();
        return inst;
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void mousePressed(MouseEvent e) {
        this.startX = e.getX();
        this.startY = e.getY(); 
        System.out.println("sX: " + this.startX + ", sY: " + this.startY);
        
        //code for the text button to work
        str = "";
        requestFocus();
        
        //code for the drawFreehand button to work
        xDrag = startX;
        yDrag = startY;
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        this.endX = e.getX();
        this.endY = e.getY();
        System.out.println("eX: " + this.endX + ", eY: " + this.endY);
        
        if(!this.button.equals("Draw")) {
            this.draw();
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        //code for drawFreehand button
        if(this.button.equals("Draw")) { 
            this.pp.drawFreehand(xDrag, yDrag, e.getX(), e.getY());   
            xDrag = e.getX();
            yDrag = e.getY();
        }
        this.repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {}
    
    @Override
    public void keyPressed(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {
        if (this.button.equals("Text")) {
            char c = e.getKeyChar();
            str += Character.toString(c);       
            System.out.println(str);    //test print
            pp.drawText(str, startX, startY);
            this.repaint();
        }
    }
}
