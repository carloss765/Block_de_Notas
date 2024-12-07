//package Gestor_de_Tareas.src;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Gestor_de_Tareas.src.VentanaMenu;

public class VentanaMenu extends JFrame{
    public void VentanaMenu(){

        // ----< Manu Ventana >----
        setTitle("Ventana Menu"); 
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //display.setUndecorated(true); // Quita la barra superior predeterminada
        


        setVisible(true);
    }

}
