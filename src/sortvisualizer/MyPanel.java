package sortvisualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

class MyPanel extends JPanel implements ActionListener{
    Insets ins;
    Random rand;
    int[] array = new int[100];
    
    MyPanel(int w,int h){
        setSize(w, h);
        initialize();
        setLayout(null);
        JButton button = new JButton("Sort");
        button.setBounds(getWidth()/2-35,getHeight()-90,70,25);
        button.addActionListener(this);
        add(button);
    }
 
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int x=30;
        int gap=0;
        g.setColor(Color.BLACK);
        for(int i=0;i<100;i++){
            g.fillRect(x, 10, 5, array[i]);
            gap=7;
            x+=gap;
        }
    }
    
    public void sort(){
        for(int i=0;i<99;i++){
            for(int j=i+1;j<100;j++){
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        repaint();
    }
    
    private void initialize(){
        rand = new Random();
        int i=0;
        ins = getInsets();
        //int width = getWidth();
        int height = getHeight();
        System.out.println(height);
        while(i!=100){
            int temp = rand.nextInt(height);
            //System.out.println(temp);
            if(temp<20)continue;
            else if(temp>height-100)continue;
            array[i++]=temp;
        }
    }
    
    public void sleepThread(){
        SwingWorker sw = new SwingWorker(){
            @Override
            protected Object doInBackground() throws Exception {
                for(int i=0;i<99;i++){
                    for(int j=i+1;j<100;j++){
                        if(array[i]>array[j]){
                            int temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                            repaint();
                            Thread.sleep(5);
                        }
                    }
                }
                return "Finished";
            }   
            
            @Override
            protected void done(){
                
            }
        };
        sw.execute();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        sleepThread();
    }
}