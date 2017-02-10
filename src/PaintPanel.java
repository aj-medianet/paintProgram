
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * @author andrewjoseph
 */
public class PaintPanel extends JPanel {

    private BufferedImage grid;
    private Graphics2D gc;
    private Color newColor;
    private int newStroke;
    JTextField textField;
    JTextArea textArea;
    
    PaintPanel() {
        
    }

    @Override
    public void paintComponent(Graphics g) {           
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(grid == null) {
            int w = this.getWidth();
            int h = this.getHeight();
            grid = (BufferedImage)(this.createImage(w,h));
            gc = grid.createGraphics();
        }
        g2.drawImage(grid, null, 0, 0);
    }
    
    public void drawText(String str, int startX, int startY) {
        gc.getColor();
        Font font = new Font("Serif", Font.PLAIN, 24);
        gc.setFont(font);
        gc.drawString(str, startX, startY);
    }

    public void drawFilledRectangle(int startX, int startY, int lengthX, int lengthY) {      
        gc.getColor();
        gc.fill(new Rectangle2D.Double(startX, startY, lengthX, lengthY));   
    }

    public void drawFilledOval(int startX, int startY, int lengthX, int lengthY) {
        gc.getColor();
        gc.fill(new Ellipse2D.Float(startX, startY, lengthX, lengthY)); 
    }

    public void drawEmptyRectangle(int startX, int startY, int lengthX, int lengthY) {
        gc.getColor();
        gc.drawRect(startX, startY, lengthX, lengthY);
    }

    public void drawEmptyOval(int startX, int startY, int lengthX, int lengthY) {
        gc.getColor();
        gc.drawOval(startX, startY, lengthX, lengthY);
    }
    
    public void drawThreeDRectangle(int startX, int startY, int lengthX, int lengthY) {
        gc.getColor();
        int size = 50;
        
        gc.drawRect(startX, startY, lengthX, lengthY);
        gc.drawRect(startX + size, startY + size, lengthX, lengthY);
        
        gc.drawLine(startX, startY, startX + size, startY + size);
        gc.drawLine(startX + lengthX, startY + lengthY, startX + lengthX + size, startY + lengthY + size);
        gc.drawLine(startX + lengthX, startY, startX + lengthX + size, startY + size);
        gc.drawLine(startX, startY + lengthY, startX + size, startY + lengthY + size);
    }

    public void lineDrawing(int startX, int startY, int endX, int endY) {
        gc.getColor();
        gc.drawLine(startX, startY, endX, endY);
    }
    
    public void drawFreehand(int startX, int startY, int endX, int endY) {
        gc.getColor();
        gc.drawLine(startX, startY, endX, endY);
    }
    
    public void sprayCan(int x, int y, int SMALL_OFFSET, int BIG_OFFSET) {
        int tempx = 0;
        int tempy = 0;
        
        for (int i=0; i<35; i++){
            // use static final ints now
            tempx = (x + (int) Math.round(2*SMALL_OFFSET*(Math.random() -0.5)));
            tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt(
                    (SMALL_OFFSET * SMALL_OFFSET) - ((x - tempx) * (x - tempx)))));
            gc.drawLine(tempx, tempy, tempx, tempy);
	}
		
	for (int i=0; i<12; i++){
            tempx = (x + (int) Math.round(2*BIG_OFFSET*(Math.random() -0.5)));
            tempy = (y + (int) ( ((Math.random()-0.5)*2) * Math.sqrt(
                    (BIG_OFFSET * BIG_OFFSET) - ((x - tempx) * (x - tempx)))));
            gc.drawLine(tempx, tempy, tempx, tempy);
        }	
    }
    
    public void changeColor() {
        newColor = JColorChooser.showDialog(null, "Change Color", gc.getColor());
        
        if (newColor != null)
            gc.setColor(newColor);
    }
    
    public void changeStroke() {
        JFrame frame = new JFrame("Input Dialog Box");

        int tmp = 0;
        try {
        tmp = Integer.parseInt( JOptionPane.showInputDialog(frame, "Set your stroke to a number between 1 and 20"));
        } catch (HeadlessException | NumberFormatException e) {}
        
        if(tmp >= 1 && tmp <= 20) {
            newStroke = tmp;
            gc.setStroke(new BasicStroke(newStroke));
        }
    }

    public void clear() {
        this.grid = null;
    }

    
}
