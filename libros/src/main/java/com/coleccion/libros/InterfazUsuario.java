package com.coleccion.libros;

import javax.swing.*;
import java.awt.*;

public class InterfazUsuario extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel panelLibros;
    private JPanel panelAutores;
    private JPanel panelEstadisticas;

    public InterfazUsuario() {
        setTitle("Catálogo de Libros");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        // Crear los paneles para cada pestaña
        panelLibros = new JPanel(new BorderLayout());
        panelAutores = new JPanel(new BorderLayout());
        panelEstadisticas = new JPanel(new BorderLayout());

        // Agregar paneles a las pestañas
        tabbedPane.addTab("Libros", panelLibros);
        tabbedPane.addTab("Autores", panelAutores);
        tabbedPane.addTab("Estadísticas", panelEstadisticas);

        // Agregar el JTabbedPane al JFrame
        add(tabbedPane);

        // Configurar contenido de cada pestaña
        configurarPanelLibros();
        configurarPanelAutores();
        configurarPanelEstadisticas();
    }

    private void configurarPanelLibros() {
        JTextArea areaLibros = new JTextArea();
        panelLibros.add(new JScrollPane(areaLibros), BorderLayout.CENTER);
        // Agregar lógica para mostrar los libros
    }

    private void configurarPanelAutores() {
        JTextArea areaAutores = new JTextArea();
        panelAutores.add(new JScrollPane(areaAutores), BorderLayout.CENTER);
        // Agregar lógica para mostrar los autores
    }

    private void configurarPanelEstadisticas() {
        JTextArea areaEstadisticas = new JTextArea();
        panelEstadisticas.add(new JScrollPane(areaEstadisticas), BorderLayout.CENTER);
        // Agregar lógica para mostrar estadísticas
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazUsuario app = new InterfazUsuario();
            app.setVisible(true);
        });
    }
}


