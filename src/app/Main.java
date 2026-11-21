package app;

import javax.swing.JOptionPane;
import estructuras.List;
import sedes.Sede;

public class Main {
    public static void main(String[] args) {
        List sede = new List();
        String menu[] = {"Añadir sede", "ToString", "Salir"};
        String option, nombreSede, tipoSede;

        do {
            option = (String)JOptionPane.showInputDialog(null, "Seleccione:", 
                   "Menu", 1, null, menu, menu[0]);
            switch (option) {
                case "Añadir sede" ->
                {
                   nombreSede = JOptionPane.showInputDialog("Digite nombre de la sede");
                   tipoSede = JOptionPane.showInputDialog("Digite tipo de sede");
                   Sede nw = new Sede(nombreSede, tipoSede);
                   sede.AddFirst(nw);
                }

                case "ToString" ->
                {
                    JOptionPane.showMessageDialog(null, sede.toString());
                }
            }
        } while (!option.equals("Salir"));
    }

}
