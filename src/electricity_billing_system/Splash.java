package electricity_billing_system;

//Swing has JFrame class
import javax.swing.*;

//AWT
import java.awt.*;

// As multiple inheritance is not allowed we can't extend thread so we use implements
public class Splash extends JFrame implements Runnable {
    // We have used MultiThreading function to slow down the aperance of the image using sleep function
    Thread t;
    
    //Constructor...As soon as object is created frame should be displayed
    Splash() {
        
        //To set image on frame
        //ClassLOader.getSystemResource....To take img from comp
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        
        //To scale the img...we use Image class...In AWT package
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        //In JLabel we can't pass image we can pass only ImageIcon 
        JLabel image = new JLabel(i3);
        
        //To place img component on frame...But can't pass img directly without JLabel
        add(image);
        
        //As by default Visibility of frame is hidden
        setVisible(true);
        
        int x = 1;
        
        //To increase img from small to large
        for (int i = 2; i < 600; i+=4, x+=1) {
            setSize(i + x, i);                             // Length,Breadth
            setLocation(700 - ((i + x)/2), 400 - (i/2));        // To set location of (From left , From above)
            try {
                //sleep function stops the function for 5 secs
                Thread.sleep(5);
            } catch (Exception e) {
                
                //To print entire stack
                e.printStackTrace();
            }
        }
        
            
    // To implement run method we create a thread class object
        t = new Thread(this);
        
        //Calling start method....which internally calls run method
        t.start();
        
        setVisible(true);
    }
    
    //Runnable interface has run aws abstract method so we need to override it
    public void run() {
        try {
            
            //To hold the Frame for 7 seconds
            Thread.sleep(7000);
            
            //To hide frame
            setVisible(false);
            
            // login frame
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
