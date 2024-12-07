package Gestor_de_Tareas.src;

// Importaciones necesarias para manejar la interfaz gráfica y eventos
import java.io.*;
import java.nio.file.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
//import Gestor_de_Tareas.src.icons;
import Gestor_de_Tareas.src.GestorTareas;

// Definición de la clase principal BlockNotas que crea un bloc de notas con opciones de formato de texto
public class BlockNotas {

    // Declaración de componentes principales y variables de estado para el formato
    // de texto
    private JFrame display;
    private int mouseX, mouseY;
    private boolean isBold = false;
    private boolean isItalic = false;
    private boolean isSubrayado = false;
    private boolean isTachado = false;

    // Constructor de la clase, inicializa y configura la ventana y componentes de
    // la interfaz
    public BlockNotas() {
        // imagenIcon añadirIcon = new
        // ImageIcon("C:\\Users\\carlo\\OneDrive\\Documentos\\Java\\Gestor_de_Tareas\\src\\icons\\Añadir.png");

        // Configuración inicial de la ventana principal (JFrame)
        display = new JFrame("Block de Notas");
        display.setSize(400, 300);
        display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        display.setLocationRelativeTo(null);
        display.setUndecorated(true); // Quita la barra superior predeterminada

        // ----< Barra Superior >----
        JPanel barraSuperior = new JPanel();
        barraSuperior.setLayout(new BorderLayout());
        barraSuperior.setBackground(new Color(230, 185, 5));
        barraSuperior.setPreferredSize(new Dimension(400, 30)); // Ajusta la altura de la barra superior

        // ----< Boton Cerrar >---
        JButton botonSalir = new JButton("X");
        botonSalir.setBackground(new Color(230, 185, 5));
        botonSalir.setForeground(new Color(51, 51, 51));
        botonSalir.setToolTipText("Cerrar ventana");
        botonSalir.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
        botonSalir.setFocusPainted(false);
        botonSalir.setBorder(null);
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.dispose(); // Cierra la ventana
            }
        });

        // ----< Boton Añadir >----
        JButton botonAñadir = new JButton("+");
        // botonAñadir.setIcon(añadirIcon);
        botonAñadir.setBackground(new Color(230, 185, 5));
        botonAñadir.setForeground(new Color(51, 51, 51));
        botonAñadir.setToolTipText("Nueva nota");
        botonAñadir.setFont(new Font("Constantia", Font.PLAIN, 25));
        botonAñadir.setFocusPainted(false);
        botonAñadir.setBorder(null);



        // ----< Menu Ventana >----
        JDialog secondaryWindow = new JDialog(display, "Ventana Secundaria", true);
        secondaryWindow.setSize(400, 400);
        secondaryWindow.setLayout(null);
        secondaryWindow.setUndecorated(true); // Quita la barra superior predeterminada
        secondaryWindow.setBackground(new Color(230, 185, 5));

        // ----< Panel de Salir >----
        JPanel panelSalir = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelSalir.setBounds(0, 160, 400, 240);
        panelSalir.setOpaque(false); // Fondo transparente
        panelSalir.setOpaque(true);
        panelSalir.setBackground(new Color(51, 51, 51));// rgb(51, 51, 51)
        secondaryWindow.add(panelSalir);

        // ----> Boton Amarillo <----
        JButton botonAmarillo = new JButton();
        botonAmarillo.setBounds(0, 0, 57, 60);
        botonAmarillo.setBackground(new Color(236, 203, 19));
        botonAmarillo.setBorder(null);
        botonAmarillo.setToolTipText("Amarillo");
        botonAmarillo.setFocusPainted(true);
        secondaryWindow.add(botonAmarillo);

        // ----> Boton Verde <----
        JButton botonVerde = new JButton();
        botonVerde.setBounds(57, 0, 57, 60);
        botonVerde.setBackground(new Color(112, 223, 90));
        botonVerde.setBorder(null);
        botonVerde.setToolTipText("Verde");
        botonVerde.setFocusPainted(true);
        secondaryWindow.add(botonVerde);

        // ----> Boton Rosa <----
        JButton botonRosa = new JButton();
        botonRosa.setBounds(114, 0, 57, 60);
        botonRosa.setBackground(new Color(255, 162, 232));
        botonRosa.setBorder(null);
        botonRosa.setToolTipText("Rosa");
        botonRosa.setFocusPainted(true);
        secondaryWindow.add(botonRosa);

        // ----> Boton Purpura <----
        JButton botonPurpura = new JButton();
        botonPurpura.setBounds(171, 0, 57, 60);
        botonPurpura.setBackground(new Color(209, 123, 255));
        botonPurpura.setBorder(null);
        botonPurpura.setToolTipText("Púrpura");
        botonPurpura.setFocusPainted(true);
        secondaryWindow.add(botonPurpura);

        // ----> Boton Azul <----
        JButton botonAzul = new JButton();
        botonAzul.setBounds(228, 0, 57, 60);
        botonAzul.setBackground(new Color(100, 215, 246));
        botonAzul.setBorder(null);
        botonAzul.setToolTipText("Azul");
        botonAzul.setFocusPainted(true);
        secondaryWindow.add(botonAzul);

        // ----> Boton Gris <----
        JButton botonGris = new JButton();
        botonGris.setBounds(285, 0, 57, 60);
        botonGris.setBackground(new Color(182, 182, 182));
        botonGris.setBorder(null);
        botonGris.setToolTipText("Gris");
        botonGris.setFocusPainted(true);
        secondaryWindow.add(botonGris);

        // ----> Boton Carboncillo <----
        JButton botonCarboncillo = new JButton();
        botonCarboncillo.setBounds(342, 0, 58, 60); 
        botonCarboncillo.setBackground(new Color(81, 81, 81));
        botonCarboncillo.setBorder(null);
        botonCarboncillo.setToolTipText("Carboncillo");
        botonCarboncillo.setFocusPainted(true);
        secondaryWindow.add(botonCarboncillo);

        // ----> Boton Lista de Notas <----
        JButton botonListaDeNotas = new JButton("   ☰    Lista de notas");
        botonListaDeNotas.setForeground(Color.WHITE);
        botonListaDeNotas.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        botonListaDeNotas.setHorizontalAlignment(JButton.LEFT);
        botonListaDeNotas.setBounds(0, 60, 400, 50);
        botonListaDeNotas.setBackground(new Color(71, 71, 71));
        botonListaDeNotas.setBorder(null);
        botonListaDeNotas.setToolTipText("Lista de notas");
        botonListaDeNotas.setFocusPainted(true);
        secondaryWindow.add(botonListaDeNotas);

        botonListaDeNotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // Accion para mostrar la ventana de lista de notas
                Gestor_de_Tareas.src.GestorTareas displayListaNotas = new Gestor_de_Tareas.src.GestorTareas();
                displayListaNotas.setVisible(true);
                display.setVisible(false);
            }
        });

        // ----> Boton Eliminar nota <----
        JButton botonEliminaNota = new JButton("   🗑    Eliminar nota");
        botonEliminaNota.setForeground(Color.WHITE);
        botonEliminaNota.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
        botonEliminaNota.setHorizontalAlignment(JButton.LEFT);
        botonEliminaNota.setBounds(0, 110, 400, 50);
        botonEliminaNota.setBackground(new Color(71, 71, 71));
        botonEliminaNota.setBorder(null);
        botonEliminaNota.setToolTipText("Eliminar nota");
        botonEliminaNota.setFocusPainted(true);
        secondaryWindow.add(botonEliminaNota);

        // FUNCIONES CAMBIO DE COLOR CURSOR

        // Boton Amarillo
        botonAmarillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonAmarillo.setBackground(new Color(213, 183, 17)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonAmarillo.setBackground(new Color(236, 203, 19)); // Color original
            }
        });
        // Boton Verde
        botonVerde.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonVerde.setBackground(new Color(101, 201, 81)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonVerde.setBackground(new Color(112, 223, 90)); // Color original
            }
        });
        // Boton Rosa
        botonRosa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonRosa.setBackground(new Color(230, 146, 209)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonRosa.setBackground(new Color(255, 162, 232)); // Color original
            }
        });
        // Boton Purpura
        botonPurpura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonPurpura.setBackground(new Color(189, 111, 230)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonPurpura.setBackground(new Color(209, 123, 255)); // Color original
            }
        });
        // Boton Azul
        botonAzul.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonAzul.setBackground(new Color(80, 203, 197)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonAzul.setBackground(new Color(100, 215, 246)); // Color original
            }
        });
        // Boton Gris
        botonGris.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonGris.setBackground(new Color(162, 162, 162)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonGris.setBackground(new Color(182, 182, 182)); // Color original
            }
        });
        // Boton Carboncillo
        botonCarboncillo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonCarboncillo.setBackground(new Color(101, 101, 101)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonCarboncillo.setBackground(new Color(81, 81, 81)); // Color original
            }
        });
        // Boton Lista de Notas
        botonListaDeNotas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonListaDeNotas.setBackground(new Color(86, 86, 86)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonListaDeNotas.setBackground(new Color(71, 71, 71)); // Color original
            }
        });
        // Boton Eliminar nota
        botonEliminaNota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar a un tono más oscuro
                botonEliminaNota.setBackground(new Color(86, 86, 86)); // Color más oscuro +25%
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el color original
                botonEliminaNota.setBackground(new Color(71, 71, 71)); // Color original
            }
        });

        // ----< Boton Menu >----
        JButton botonMenu = new JButton("•••");
        botonMenu.setBackground(new Color(230, 185, 5));
        botonMenu.setForeground(new Color(51, 51, 51));
        botonMenu.setToolTipText("Menú");
        botonMenu.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
        botonMenu.setFocusPainted(false);
        botonMenu.setBorder(null);
        botonMenu.setBounds(100, 0, 30, 30);
        botonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la posición de la ventana principal
                Point location = display.getLocationOnScreen();

                // Calcular la posición de la ventana secundaria (pegada al lado derecho)
                int x = location.x; // Mantén la posición horizontal igual que la ventana principal
                int y = location.y; // Parte superior de la ventana principal

                // Pocisionar y mostrar la ventana secundaria
                secondaryWindow.setSize(400, 268); // Misma anchura que la ventana principal, altura de 150px
                secondaryWindow.setLocation(x, y);
                secondaryWindow.setVisible(true);
            }
        });

        // Accion cerrar JDialog
        panelSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                secondaryWindow.setVisible(false); // Cerrar ventana
            }
        });

        // ----< Panel de Boton Salir >----
        JPanel panelBotonSalir = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonSalir.setOpaque(false); // Fondo transparente
        panelBotonSalir.add(botonSalir);

        barraSuperior.add(panelBotonSalir, BorderLayout.EAST);

        // ----< Panel de Boton Añadir >----
        JPanel panelBotonAñadir = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBotonAñadir.setOpaque(false); // Fondo transparente
        panelBotonAñadir.add(botonAñadir);

        barraSuperior.add(panelBotonAñadir, BorderLayout.WEST);

        // ----< Panel de Boton Menu >----
        JPanel panelBotonMenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonMenu.setOpaque(false); // Fondo transparente
        panelBotonMenu.add(botonMenu);

        barraSuperior.add(panelBotonMenu, BorderLayout.CENTER);

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

        display.add(barraSuperior, BorderLayout.NORTH);

        // ----< Contenido >----
        JPanel contenido = new JPanel();
        contenido.setBackground(new Color(51, 51, 51));
        contenido.setLayout(new BorderLayout());

        display.add(contenido, BorderLayout.CENTER);

        // ----< Escribir >----
        JTextPane txtEscribir = new JTextPane();
        txtEscribir.setCaretColor(Color.WHITE);
        txtEscribir.setSelectionColor(new Color(230, 185, 5, 165));
        txtEscribir.setSelectedTextColor(Color.WHITE);
        txtEscribir.setFont(new Font("Arial", Font.PLAIN, 16));
        txtEscribir.setForeground(Color.WHITE);
        txtEscribir.setBackground(new Color(51, 51, 51));
        
        UIManager.put("OptionPane.background", new Color(51, 51, 51));
        UIManager.put("Panel.background", new Color(51, 51, 51));
        //UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Button.background", new Color(230, 185, 5));

        botonAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la posición de la ventana principal
                Point location = display.getLocationOnScreen();
        
                // Crear un JDialog para pedir el nombre de la nota
                JDialog dialog = new JDialog(display, "Nombre de la Nota", true);
                dialog.setUndecorated(true); // Quita la barra superior predeterminada
                dialog.setSize(400, 268);
                dialog.setLayout(new BorderLayout());
        
                // Posicionar el diálogo según la posición de la ventana principal
                int x = location.x; // Al lado derecho de la ventana principal
                int y = location.y; // Parte superior de la ventana principal
                dialog.setLocation(x, y);

                // Panel para cerrar el diálogo
                JPanel panelSalir2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                panelSalir2.setBounds(0, 160, 400, 240);
                panelSalir2.setOpaque(false); // Fondo transparente
                panelSalir2.setOpaque(true);
                panelSalir2.setBackground(new Color(51, 51, 51));// rgb(51, 51, 51)
                dialog.add(panelSalir2);
        
                // Crear componentes para el diálogo
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Organización vertical
        
                JLabel etiqueta = new JLabel("Introduce el nombre de la nota");
                etiqueta.setForeground(Color.WHITE);
                etiqueta.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
                etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel
        
                JTextField campoTexto = new JTextField();
                campoTexto.setMaximumSize(new Dimension(250, 25)); // Tamaño reducido para el JTextField
                campoTexto.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JTextField
                campoTexto.setHorizontalAlignment(JTextField.CENTER); // Centrar el texto del JTextField
        
                JButton botonAceptar = new JButton("    Aceptar    ");
                botonAceptar.setBackground(new Color(71, 71, 71));
                botonAceptar.setForeground(Color.WHITE);
                botonAceptar.setBorder(null);
                botonAceptar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        botonAceptar.setBackground(new Color(86, 86, 86)); // Color más oscuro +25%
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        botonAceptar.setBackground(new Color(71, 71, 71)); // Color original
                        
                    }
                });
                
                JButton botonCancelar = new JButton("    Cancelar    ");
                botonCancelar.setBackground(new Color(71, 71, 71));
                botonCancelar.setForeground(Color.WHITE);
                botonCancelar.setBorder(null);
                botonCancelar.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        botonCancelar.setBackground(new Color(86, 86, 86)); // Color más oscuro +25%
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        botonCancelar.setBackground(new Color(71, 71, 71)); // Color original
                        
                    }
                });
        
                // Ajustar tamaño de los botones
                Dimension buttonSize = new Dimension(200, 30); // Ancho 200, Alto 30
                botonAceptar.setPreferredSize(buttonSize);
                botonCancelar.setPreferredSize(buttonSize);
        
                // Panel para los botones
                JPanel panelBotones = new JPanel();
                panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0)); // Espaciado entre botones
                panelBotones.add(botonAceptar);
                panelBotones.add(botonCancelar);
        
                // Agregar componentes al panel principal
                panel.add(Box.createVerticalStrut(10)); // Espacio superior
                panel.add(etiqueta);
                panel.add(Box.createVerticalStrut(10)); // Espacio entre etiqueta y campo de texto
                panel.add(campoTexto);
                panel.add(Box.createVerticalStrut(10)); // Espacio entre campo de texto y botones
                panel.add(panelBotones);
        
                dialog.add(panel);
        
                final String[] nombreNota = {null};
        
                // Acción para el botón "Aceptar"
                botonAceptar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String texto = campoTexto.getText().trim();
                        if (!texto.isEmpty()) {
                            nombreNota[0] = texto;
                            dialog.dispose(); // Cerrar el diálogo
                        } else {
                            JOptionPane.showMessageDialog(dialog, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
        
                // Acción para el botón "Cancelar"
                botonCancelar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose(); // Cerrar el diálogo
                    }
                });
                
                // Accion cerrar JDialog
                panelSalir2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        dialog.setVisible(false); // Cerrar ventana
                    }
                });

                // Mostrar el diálogo
                dialog.setVisible(true);
        
                // Verificar si se ingresó un nombre de nota
                if (nombreNota[0] != null) {
                    String textoNota = txtEscribir.getText();
        
                    // Escribir en el archivo
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreNota[0] + ".txt"))) {
                        writer.write(textoNota);
                        writer.newLine();
                        JOptionPane.showMessageDialog(null, "Nota guardada", "Nota guardada", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al guardar nota", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se guardó la nota", "Cancelado", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
        
        

        // ----< Opciones >----
        JPanel Obsiones = new JPanel();
        Obsiones.setSize(400, 50);
        Obsiones.setBackground(new Color(51, 51, 51));
        Obsiones.setLayout(new FlowLayout(FlowLayout.LEFT));

        display.add(Obsiones, BorderLayout.SOUTH);

        // ----> Negrilla Opciones <----
        JButton Negrilla = new JButton("    B    ");
        Negrilla.setForeground(new Color(187, 187, 187));
        Negrilla.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
        Negrilla.setFocusPainted(false);
        Negrilla.setBackground(new Color(51, 51, 51));
        Negrilla.setBounds(0, 0, 50, 50);
        Negrilla.setToolTipText("Negrita");
        Negrilla.setBorder(null);

        Obsiones.add(Negrilla);

        // Crear el documento estilizado
        StyledDocument docNegrilla = txtEscribir.getStyledDocument();

        // Definir el estilo normal
        Style normalStyle = docNegrilla.addStyle("Normal", null);
        StyleConstants.setFontFamily(normalStyle, "Arial");
        StyleConstants.setFontSize(normalStyle, 16);
        StyleConstants.setBold(normalStyle, false);

        // Definir el estilo negrita
        Style boldStyle = docNegrilla.addStyle("Bold", null);
        StyleConstants.setFontFamily(boldStyle, "Arial");
        StyleConstants.setFontSize(boldStyle, 16);
        StyleConstants.setBold(boldStyle, true);

        // ----> Acción Boton Negrilla <----
        Negrilla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isBold) {
                    txtEscribir.setCharacterAttributes(boldStyle, false);
                } else {
                    txtEscribir.setCharacterAttributes(normalStyle, false);
                }
                isBold = !isBold;
                txtEscribir.requestFocus();
            }
        });

        // ----> Cursiva Opciones <----
        JButton Cursiva = new JButton("    I    ");
        Cursiva.setForeground(new Color(187, 187, 187));
        Cursiva.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
        Cursiva.setBackground(new Color(51, 51, 51));
        Cursiva.setBounds(0, 0, 50, 50);
        Cursiva.setToolTipText("Cursiva");
        Cursiva.setBorder(null);

        Obsiones.add(Cursiva);

        // Crear el documento estilizado
        StyledDocument docCursiva = txtEscribir.getStyledDocument();

        // Definir el estilo cursiva
        Style italicStyle = docCursiva.addStyle("Italic", null);
        StyleConstants.setFontFamily(italicStyle, "Arial");
        StyleConstants.setFontSize(italicStyle, 16);
        StyleConstants.setItalic(italicStyle, true);

        // ----> Acción Boton Cursiva <----
        Cursiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isItalic) {
                    txtEscribir.setCharacterAttributes(italicStyle, false);
                } else {
                    txtEscribir.setCharacterAttributes(normalStyle, false);
                }
                isItalic = !isItalic;
                txtEscribir.requestFocus();
            }
        });

        // ----> Subrayado Opciones <----
        JButton Subrayado = new JButton("    U    ");
        Subrayado.setForeground(new Color(187, 187, 187));
        Subrayado.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
        Subrayado.setBackground(new Color(51, 51, 51));
        Subrayado.setBounds(0, 0, 50, 50);
        Subrayado.setToolTipText("Subrayado");
        Subrayado.setBorder(null);

        Obsiones.add(Subrayado);

        // Crear el documento estilizado
        StyledDocument docSubrayado = txtEscribir.getStyledDocument();

        // Definir el estilo subrayado
        Style subrayadoStyle = docSubrayado.addStyle("Subrayado", null);
        StyleConstants.setFontFamily(subrayadoStyle, "Arial");
        StyleConstants.setFontSize(subrayadoStyle, 16);
        StyleConstants.setUnderline(subrayadoStyle, true);

        // ----> Acción Boton Subrayado <----
        Subrayado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSubrayado) {
                    txtEscribir.setCharacterAttributes(subrayadoStyle, false);
                } else {
                    txtEscribir.setCharacterAttributes(normalStyle, false);
                }
                isSubrayado = !isSubrayado;
                txtEscribir.requestFocus();
            }
        });

        // ----> Tachado Opciones <----
        JButton Tachado = new JButton("    T    ");
        Tachado.setForeground(new Color(187, 187, 187));
        Tachado.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
        Tachado.setBackground(new Color(51, 51, 51));
        Tachado.setBounds(0, 0, 50, 50);
        Tachado.setToolTipText("Tachado");
        Tachado.setBorder(null);

        Obsiones.add(Tachado);

        // Crear el documento estilizado
        StyledDocument docTachado = txtEscribir.getStyledDocument();

        // Definir el estilo tachado
        Style tachadoStyle = docTachado.addStyle("Tachado", null);
        StyleConstants.setFontFamily(tachadoStyle, "Arial");
        StyleConstants.setFontSize(tachadoStyle, 16);
        StyleConstants.setForeground(tachadoStyle, new Color(213, 183, 17)); // Color por defecto

        // ----> Acción Boton Tachado <----
        Tachado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTachado) {
                    txtEscribir.setCharacterAttributes(tachadoStyle, false);
                } else {
                    txtEscribir.setCharacterAttributes(normalStyle, true);
                }
                isTachado = !isTachado;
                txtEscribir.requestFocus();
            }
        });

        // FUNCIONES CAMBIO DE COLOR TACHADO

        // Botón para cambiar a color amarillo
        botonAmarillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyleConstants.setForeground(tachadoStyle, new Color(213, 183, 17)); // Cambia el color a amarillo
                // Si el texto está tachado, aplica el nuevo estilo
                if (isTachado) {
                    int start = txtEscribir.getSelectionStart();
                    int end = txtEscribir.getSelectionEnd();
                    if (start != end) { // Verifica que hay texto seleccionado
                        txtEscribir.setCharacterAttributes(tachadoStyle, false);
                    }
                }
            }
        });

        // Botón para cambiar a color verde
        botonVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyleConstants.setForeground(tachadoStyle, new Color(101, 201, 81)); // Cambia el color a verde
                // Si el texto está tachado, aplica el nuevo estilo
                if (isTachado) {
                    int start = txtEscribir.getSelectionStart();
                    int end = txtEscribir.getSelectionEnd();
                    if (start != end) { // Verifica que hay texto seleccionado
                        txtEscribir.setCharacterAttributes(tachadoStyle, false);
                    }
                }
            }
        });

        // Botón para cambiar a color rosa
        botonRosa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyleConstants.setForeground(tachadoStyle, new Color(230, 146, 209)); // Cambia el color a rosa
                // Si el texto está tachado, aplica el nuevo estilo
                if (isTachado) {
                    int start = txtEscribir.getSelectionStart();
                    int end = txtEscribir.getSelectionEnd();
                    if (start != end) { // Verifica que hay texto seleccionado
                        txtEscribir.setCharacterAttributes(tachadoStyle, false);
                    }
                }
            }
        });

        // Botón para cambiar a color purpura
        botonPurpura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyleConstants.setForeground(tachadoStyle, new Color(189, 111, 230)); // Cambia el color a purpura
                // Si el texto está tachado, aplica el nuevo estilo
                if (isTachado) {
                    int start = txtEscribir.getSelectionStart();
                    int end = txtEscribir.getSelectionEnd();
                    if (start != end) { // Verifica que hay texto seleccionado
                        txtEscribir.setCharacterAttributes(tachadoStyle, false);
                    }
                }
            }
        });

        // Botón para cambiar a color azul
        botonAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyleConstants.setForeground(tachadoStyle, new Color(80, 203, 197)); // Cambia el color a azul
                // Si el texto está tachado, aplica el nuevo estilo
                if (isTachado) {
                    int start = txtEscribir.getSelectionStart();
                    int end = txtEscribir.getSelectionEnd();
                    if (start != end) { // Verifica que hay texto seleccionado
                        txtEscribir.setCharacterAttributes(tachadoStyle, false);
                    }
                }
            }
        });

        botonGris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyleConstants.setForeground(tachadoStyle, new Color(162, 162, 162)); // Cambia el color a gris
                // Si el texto está tachado, aplica el nuevo estilo
                if (isTachado) {
                    int start = txtEscribir.getSelectionStart();
                    int end = txtEscribir.getSelectionEnd();
                    if (start != end) { // Verifica que hay texto seleccionado
                        txtEscribir.setCharacterAttributes(tachadoStyle, false);
                    }
                }
            }
        });

        botonCarboncillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyleConstants.setForeground(tachadoStyle, new Color(101, 101, 101)); // Cambia el color a carboncillo
                // Si el texto está tachado, aplica el nuevo estilo
                if (isTachado) {
                    int start = txtEscribir.getSelectionStart();
                    int end = txtEscribir.getSelectionEnd();
                    if (start != end) { // Verifica que hay texto seleccionado
                        txtEscribir.setCharacterAttributes(tachadoStyle, false);
                    }
                }
            }
        });

        // Configuración del scroll en el área de texto
        JScrollPane scrollPane = new JScrollPane(txtEscribir);
        scrollPane.setBackground(Color.RED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Personalización del scrollbar (barras de desplazamiento)
        UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.RED));
        UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(Color.BLUE));
        UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(Color.GREEN));
        UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(Color.YELLOW));
        UIManager.put("ScrollBar.track", new ColorUIResource(Color.LIGHT_GRAY));
        UIManager.put("ScrollBar.trackHighlight", new ColorUIResource(Color.DARK_GRAY));

        // Aplicar la personalización
        SwingUtilities.updateComponentTreeUI(scrollPane);

        contenido.add(scrollPane, BorderLayout.CENTER);

        // Hacer visible la ventana principal
        display.setVisible(true);
    }

    // Método para hacer visible la ventana desde fuera de la clase
    public void setVisible(boolean b) {
        display.setVisible(b);
    }
}