package Gestor_de_Tareas.src;

import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.Book;
import java.net.*;
//import Gestor_de_Tareas.src.BlockNotas;

public class GestorTareas {

    public JFrame display;
    private static int mouseX, mouseY;

    public static void main(String[] args) {


        // ----< Interfaz >----

        JFrame display = new JFrame();
        display.setLayout(null);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setSize(330, 625);
        display.setUndecorated(true);
        display.getContentPane().setBackground(new Color(32, 32, 32)); 

        ImageIcon imagenIcon = new ImageIcon("/icons/BackgroundNOTAS3.jpg");

        Image imagenEscalada = imagenIcon.getImage().getScaledInstance(330, 625, Image.SCALE_SMOOTH);
        imagenIcon = new ImageIcon(imagenEscalada);

        // Crear un JLabel y agregar la imagen
        JLabel labelConImagen = new JLabel(imagenIcon);
        labelConImagen.setBounds(0, 100, 330, 625); // Establecer el tamaño y la posición

        // Añadir el JLabel al JFrame
        display.add(labelConImagen);

        // ----< Barra Titulo >----

        JPanel barraSuperior = new JPanel();
        barraSuperior.setBounds(10, 0, 300, 40);
        barraSuperior.setLayout(new BorderLayout());
        barraSuperior.setBackground(new Color(32, 32, 32));

        // Añadir funcionalidad de arrastre
        barraSuperior.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        barraSuperior.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;
                display.setLocation(x, y);
            }
        });

        // ----< Configuracion Tool Tip Botones >----

        UIManager.put("ToolTip.foreground", Color.WHITE);// Color de letra
        UIManager.put("ToolTip.font", new Font("Segoe UI", Font.PLAIN, 12)); // Cambia la fuente
        UIManager.put("ToolTip.border", BorderFactory.createEmptyBorder(7, 7, 7, 7));

        // ----> Boton Nota Nueva <----

        JButton buttonNotaNueva = new JButton("+");
        buttonNotaNueva.setBounds(0, 7, 50, 35);
        buttonNotaNueva.setFont(new Font("Constantia", Font.PLAIN, 30));
        buttonNotaNueva.setBackground(new Color(32, 32, 32));
        buttonNotaNueva.setForeground(new Color(144, 144, 144));
        buttonNotaNueva.setToolTipText("Nueva nota");
        buttonNotaNueva.setBorder(null);
        buttonNotaNueva.setBorderPainted(false);
        buttonNotaNueva.setFocusPainted(false);
        buttonNotaNueva.setContentAreaFilled(false);

        buttonNotaNueva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Gestor_de_Tareas.src.BlockNotas displayNuevNota = new Gestor_de_Tareas.src.BlockNotas();
                displayNuevNota.setVisible(true);
                display.setVisible(false);
            }
        });

        /*
         * buttonNotaNueva.addMouseListener(new MouseAdapter() {
         * 
         * @Override
         * public void mouseEntered(MouseEvent e) {
         * buttonNotaNueva.setBackground(new Color(64, 64, 64));
         * }
         * 
         * @Override
         * public void mouseExited(MouseEvent e) {
         * buttonNotaNueva.setBackground(new Color(32, 32, 32));
         * }
         * });
         */

        barraSuperior.add(buttonNotaNueva);

        // ----> Boton Minimizar <----

        JButton botonMinimizar = new JButton(" - ");
        botonMinimizar.setBackground(new Color(32, 32, 32));
        botonMinimizar.setForeground(new Color(144, 144, 144));
        botonMinimizar.setToolTipText("Minimizar ventana");
        botonMinimizar.setFont(new Font("Constantia", Font.PLAIN, 30));
        botonMinimizar.setFocusPainted(false);
        botonMinimizar.addActionListener(e -> display.setState(JFrame.ICONIFIED));
        botonMinimizar.setBounds(150, 0, 30, 30);
        botonMinimizar.setBorder(null);
        botonMinimizar.setFocusPainted(false);
        botonMinimizar.setContentAreaFilled(false);

        barraSuperior.add(botonMinimizar);

        // ----> Boton Cerrar <----

        JButton botonCerrar = new JButton("  X");
        botonCerrar.setBackground(new Color(32, 32, 32));
        // rgb(144, 144, 144)
        botonCerrar.setForeground(new Color(144, 144, 144));
        botonCerrar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
        botonCerrar.setBounds(100, 0, 30, 30);
        botonCerrar.setToolTipText("Cerrar ventana");
        UIManager.put("ToolTip.background", new Color(42, 42, 42));// Color de fondo
        // UIManager.put("ToolTip.bounds", 300, 303 ,3);
        botonCerrar.setFocusPainted(false);
        botonCerrar.setBorder(null);
        botonCerrar.addActionListener(e -> System.exit(0));

        barraSuperior.add(botonCerrar);

        // ----< Panel Boton Nueva Nota >----

        JPanel panelNuevaNota = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNuevaNota.setOpaque(false); // Fondo transparente
        panelNuevaNota.add(buttonNotaNueva);

        barraSuperior.add(panelNuevaNota, BorderLayout.WEST);

        // ----< Panel Botones Derecha >----

        JPanel panelMinimizar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelMinimizar.setOpaque(false); // Fondo transparente
        panelMinimizar.add(botonMinimizar);
        panelMinimizar.add(botonCerrar);

        barraSuperior.add(panelMinimizar, BorderLayout.EAST);

        display.add(barraSuperior, BorderLayout.NORTH);

        // ----< Titulo >----
        JLabel Notas_Rapidas = new JLabel("Notas rápidas", SwingConstants.LEFT);

        Notas_Rapidas.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Notas_Rapidas.setBounds(15, 40, 200, 25);
        Notas_Rapidas.setForeground(Color.WHITE);

        display.add(Notas_Rapidas);

        // ----< Barra de Busqueda >----

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField Barra_Busqueda = new JTextField("  Buscar...");
        Barra_Busqueda.setEditable(false);
        Barra_Busqueda.setBounds(15, 78, 298, 30);
        Barra_Busqueda.setFont(new Font("Arial", Font.PLAIN, 13));
        Barra_Busqueda.setForeground(new Color(180, 180, 180));
        Barra_Busqueda.setBackground(new Color(64, 64, 64));
        Barra_Busqueda.setBorder(null);

        /*//----> Accion Barra de Busqueda <----
        Barra_Busqueda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Barra_Busqueda.setEditable(true); // Habilitar edición
                Barra_Busqueda.setText(""); // Limpiar texto
                Barra_Busqueda.requestFocus(); // Restaurar el foco
            }
        });

        Barra_Busqueda.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                Barra_Busqueda.setEditable(false); // Deshabilitar edición
                if (Barra_Busqueda.getText().isEmpty()) {
                    Barra_Busqueda.setText("  Buscar..."); // Restaurar texto
                }
            }
        });*/

        /*
         * ImageIcon searchIcon = new ImageIcon(GestorTareas.class.getResource(
         * "C:\\Users\\carlo\\OneDrive\\Documentos\\Java\\Gestor_de_Tareas"));
         * JLabel iconSerch = new JLabel(searchIcon);
         * iconSerch.setPreferredSize(new Dimension(13, 13));
         * 
         * panel.add(iconSerch, BorderLayout.EAST);
         * panel.add(Barra_Busqueda, BorderLayout.CENTER);
         * 
         * display.add(panel);
         */
        display.add(Barra_Busqueda);

        // ----> Contenido Principal Ventana <----

        JPanel contenidoPrincipal = new JPanel();
        contenidoPrincipal.setBackground(new Color(32, 32, 32));
        contenidoPrincipal.setBounds(0, 118, 330, 300);
        display.add(contenidoPrincipal);
        // display.getWidth(), display.getHeight() -
        // 30

        display.setVisible(true);

    }

    public void setVisible(boolean b) {
        display.setVisible(true);
    }
}