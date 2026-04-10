package vallegrande.proyect0.controller;

import vallegrande.proyect0.model.Tarea;
import vallegrande.proyect0.view.VistaTarea;

import javax.swing.*;
import java.util.ArrayList;

public class ControladorTareas {

    private VistaTarea vista;
    private ArrayList<Tarea> lista = new ArrayList<>();

    public ControladorTareas(VistaTarea vista) {
        this.vista = vista;
        eventos();
    }

    private void eventos() {

        vista.btnAgregar.addActionListener(e -> agregarTarea());
        vista.btnEliminar.addActionListener(e -> eliminarTarea());
        vista.btnCompletar.addActionListener(e -> completarTarea());
    }

    private void agregarTarea() {
        String texto = vista.txtTarea.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puedes agregar tareas vacías");
            return;
        }

        Tarea tarea = new Tarea(texto);
        lista.add(tarea);

        vista.modeloLista.addElement(tarea.toString());

        vista.txtTarea.setText("");

        actualizarContador();

        JOptionPane.showMessageDialog(null, "Tarea agregada");
    }

    private void eliminarTarea() {
        int index = vista.listaTarea.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una tarea");
            return;
        }

        lista.remove(index);
        vista.modeloLista.remove(index);

        actualizarContador();

        JOptionPane.showMessageDialog(null, "Tarea eliminada");
    }

    private void completarTarea() {
        int index = vista.listaTareas.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una tarea");
            return;
        }

        Tarea tarea = lista.get(index);
        tarea.setCompletada(true);

        vista.modeloLista.set(index, tarea.toString());

        JOptionPane.showMessageDialog(null, "Tarea completada ✔");
    }

    private void actualizarContador() {
        vista.lblContador.setText("Total: " + lista.size());
    }
}