package vallegrande.proyect0;

import vallegrande.proyect0.controller.ControladorTareas;
import vallegrande.proyect0.view.VistaTarea;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaTarea vista = new VistaTarea();
            new ControladorTareas(vista);
            vista.setVisible(true);
        });
    }
}