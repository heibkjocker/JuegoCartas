package juegocartas;

import javax.swing.JPanel;

/**
 *
 * @author Cristian Quintero
 */
public class Jugador {

    private int TOTAL_CARTAS = 10;
    private Carta[] cartas;
    private GrupoCarta[] grupos;
    private NombreCarta[] nombres;

    public void repartir() {
        //Instanciar el vector de cartas
        cartas = new Carta[TOTAL_CARTAS];
        //instanciar las cartas
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta();
        }

    }

    public void mostrar(JPanel pnl) {
        //Limpiar panel
        pnl.removeAll();
        //mostrar cada carta
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i].mostrar(10 + i * 50, 10, pnl);
        }
        //refrescar el objeto de despliegue
        pnl.repaint();

    }

    public void obtenerGrupos() {
        grupos = null;
        nombres = null;

        if (cartas != null) {
            int[] contadores = new int[13];
            //Se cuentan las cartas por el nombre
            for (Carta c : cartas) {
                contadores[c.obtenerNombre().ordinal()]++;
            }
            //Se cuentan los grupos hallados
            int totalGrupos = 0;
            for (int c : contadores) {
                if (c >= 2) {
                    totalGrupos++;
                }
            }
            if (totalGrupos > 0) {
                //Hallar los grupos
                grupos = new GrupoCarta[totalGrupos];
                nombres = new NombreCarta[totalGrupos];
                int pGrupo = 0;
                for (int i = 0; i < contadores.length; i++) {
                    if (contadores[i] >= 2) {
                        grupos[pGrupo] = GrupoCarta.values()[contadores[i]];
                        nombres[pGrupo] = NombreCarta.values()[i];
                        pGrupo++;
                    }
                }
            }
        }
    }

    public String obtenerMensajeGrupos() {
        if (grupos != null) {
            String mensaje = "Los grupos encontrados fueron : \n";
            for (int i = 0; i < grupos.length; i++) {
                mensaje += grupos[i].name() + " de " + nombres[i].name() + "\n";
            }
            return mensaje;
        }
        return "No hay grupos";
    }
}
