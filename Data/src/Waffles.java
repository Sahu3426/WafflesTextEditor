
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import jdk.nashorn.internal.objects.NativeDebug;

public class Waffles {

    
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        WafflesGui textEditor=new WafflesGui();
        textEditor.setTitle("Waffles Text Editor");
        
        textEditor.setBounds(0,0,700,480);
        
        textEditor.setVisible(true);
        textEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }    
}

