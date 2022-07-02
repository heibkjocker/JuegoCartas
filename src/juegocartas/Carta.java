package juegocartas;

import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Cristian Quintero
 */
public class Carta {

    private int indice;
    Random r = new Random();

    //Metodo constructor
    public Carta() {
        indice = r.nextInt(52) + 1;
    }

    public void mostrar(int x, int y, JPanel pnl) {
        String nombreArchivo = "/cartas/CARTA" + String.valueOf(indice) + ".gif";

        //Cargar la imagen
        ImageIcon imgCarta = new ImageIcon(getClass().getResource(nombreArchivo));
        //Instanciar un objeto para desplegar imagenes
        JLabel lblCarta = new JLabel(imgCarta);
        //Definir la ubicacion del objeto de despliegue y sus dimensiones
        lblCarta.setBounds(x, y, imgCarta.getIconWidth(), imgCarta.getIconHeight());
        //Agregar el objeto de despliegue al contenedor de despliegue
        pnl.add(lblCarta);

    }

    public Pinta obtenerPinta() {
        //devolver la pinta dependiendo del rango en el que esta el indice
        if(indice <=13){
            return Pinta.TREBOL;
        }
        else if(indice <=26){
            return Pinta.PICA;
        }
        else if(indice <= 39){
            return Pinta.CORAZON;
        }
        else{
            return Pinta.DIAMANTE;
        }
    }
    
    public NombreCarta obtenerNombre(){
        int n = indice % 13;
        if (n==0){
            n=12;
        }
        else {
            n--;
        }
        return NombreCarta.values()[n];
    }
    
    public int obtenerIndice(){
        return indice;
    }
}
