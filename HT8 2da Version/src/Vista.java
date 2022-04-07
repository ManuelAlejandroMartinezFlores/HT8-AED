/**
 * @author Lourdes Saavedra
 * @author Manuel Martinez
 * 
 * Vista.
 * Interactua con el usuario.
 * 
 */

import java.util.Scanner;

public class Vista {
    
    Scanner scn;

    /**
     * Constructor
     */
    Vista(){
        scn = new Scanner(System.in);
    }

    /**
     * Obtiene el path de archivo
     * @return path
     */
    public String getPath(){
        mostrarMsg("\nIngrese path del archivo de pacientes\n");
        return scn.nextLine();
    }

    /**
     * Obtiene el paciente medio
     */
    public void getPaciente(){
        mostrarMsg("\nPresione enter para obtener siguiente paciente\n");
        scn.nextLine();
    }

    /**
     * Muestra un mensaje
     * @param msg a mostrar
     */
    public void mostrarMsg(String msg){
        System.out.println(msg);
    }
}
