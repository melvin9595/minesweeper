
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
    private Random generator = new Random();
 //  Coordinates b = new Coordinates(3,2);
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
            JFrame myFrame = (JFrame) c;
            GridPanel myPanel = (GridPanel) myFrame.getContentPane().getComponent(0);
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            myPanel.mouseDownGridX = myPanel.getGridX(x, y);
            myPanel.mouseDownGridY = myPanel.getGridY(x, y);
            myPanel.repaint();
            break;
        case 3:        //Right mouse button
        	Component d = e.getComponent();
            while (!(d instanceof JFrame)) {
                d = d.getParent();
                if (d == null) {
                    return;
                }
            }
            JFrame Right_Click_Event_Frame = (JFrame) d;
           GridPanel my_Panel = (GridPanel) Right_Click_Event_Frame.getContentPane().getComponent(0);
            Insets my_Insets = Right_Click_Event_Frame.getInsets();
            int x_1 = my_Insets.left;
            int y_1 = my_Insets.top;
            e.translatePoint(-x_1, -y_1);
            int small_x = e.getX();
            int small_y = e.getY();
            my_Panel.x = small_x;
            my_Panel.y = small_y;
            my_Panel.mouseDownGridX = my_Panel.getGridX(small_x, small_y);
            my_Panel.mouseDownGridY = my_Panel.getGridY(small_x, small_y);
            my_Panel.repaint();
            break;
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
            JFrame myFrame = (JFrame)c;
           GridPanel myPanel = (GridPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            int gridX = myPanel.getGridX(x, y);
            int gridY = myPanel.getGridY(x, y);
            if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
                //Had pressed outside
                //Do nothing
            } else {
                if ((gridX == -1) || (gridY == -1)) {
                    //Is releasing outside
                    //Do nothing
                } else {
                            //On the grid other than on the left column and on the top row:
                            Color newColor = null;
                            switch (generator.nextInt(1)) {
                            case 0:
                                newColor = Color.BLACK;
                                break;
                  
                            }
                            myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
                            myPanel.repaint();
               
                }
                    }
                
            
            myPanel.repaint();
            break;
        case 3:        //Right mouse button
        	 Component d = e.getComponent();
             while (!(d instanceof JFrame)) {
                 d = d.getParent();
                 if (d == null) {
                     return;
                 }
             }
             JFrame Right_Click_Event_Frame = (JFrame)d;
            GridPanel my_Panel = (GridPanel) Right_Click_Event_Frame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
             Insets my_Insets = Right_Click_Event_Frame.getInsets();
             int x_1 = my_Insets.left;
             int y_1 = my_Insets.top;
             e.translatePoint(-x_1, -y_1);
             int small_x = e.getX();
             int small_y = e.getY();
             my_Panel.x = small_x;
             my_Panel.y = small_y;
             int grid_X = my_Panel.getGridX(small_x, small_y);
             int grid_Y = my_Panel.getGridY(small_x, small_y);
             if ((my_Panel.mouseDownGridX == -1) || (my_Panel.mouseDownGridY == -1)) {
                 //Had pressed outside
                 //Do nothing
             } else {
                 if ((grid_X == -1) || (grid_Y == -1)) {
                     //Is releasing outside
                     //Do nothing
                 } else {
                             
                             Color newColor = null;
                             switch (generator.nextInt(1)) {
                             case 0:
                                 newColor = Color.RED;
                                 break;
                   
                             }
                             my_Panel.colorArray[my_Panel.mouseDownGridX][my_Panel.mouseDownGridY] = newColor;
                             my_Panel.repaint();
                
                 }
                     }
                 
             
             my_Panel.repaint();
        	
        	
            break;
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
}
