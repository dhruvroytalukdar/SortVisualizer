/*
Name:Dhruv Roy Talukdar
Description:This creates the JFrame for the GUI
*/

package sortvisualizer;

import javax.swing.JFrame;

class SwingDemo{
    
    private final int width = 780;
    private final int height = 600;
    
    public SwingDemo(){
        JFrame frame = new JFrame("Visualizer");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        frame.add(new MyPanel(width,height));
        frame.setVisible(true);
    }
}
