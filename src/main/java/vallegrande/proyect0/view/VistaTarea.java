package vallegrande.proyect0.view;

import javax.swing.*;
import java.awt.*;

public class VistaTarea extends JFrame {

    public JTextField txtTarea = new JTextField(20);
    public JButton btnAgregar = new JButton("Agregar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnCompletar = new JButton("Marcar como completada");

    public DefaultListModel<String> modeloLista = new DefaultListModel<>();
    public JList<String> listaTareas = new JList<>(modeloLista);

    public JLabel lblContador = new JLabel("Total: 0");
    public DefaultSingleSelectionModel listaTarea;

    public VistaTarea() {
        setTitle("Gestor de Tareas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Estilo visual
        UIManager.put("Button.background", Color.CYAN);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel superior = new JPanel();
        superior.add(txtTarea);
        superior.add(btnAgregar);

        JScrollPane centro = new JScrollPane(listaTareas);

        JPanel inferior = new JPanel();
        inferior.add(btnEliminar);
        inferior.add(btnCompletar);
        inferior.add(lblContador);

        panel.add(superior, BorderLayout.NORTH);
        panel.add(centro, BorderLayout.CENTER);
        panel.add(inferior, BorderLayout.SOUTH);

        add(panel);
    }
}