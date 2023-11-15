package cl.ucn.disc.poo.omegarho.model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;



import cl.ucn.disc.poo.omegarho.services.AjustesUsuario;

/**
 * The user class.
 *
 * @author 2AMC
 *
 */

public class User implements AjustesUsuario {
    /**
     *Nombre de usuario
     */
    private String nombreUser;

    /**
     * RUT
     */
    private String rut;

    /**
     *Nombre
     */
    private String nombre;

    /**
     * Edad
     */
    private int edad;

    /**
     * Descripcion del usuarui
     */
    private String descripcion;

    /**
     * Estado amoroso
     */
    private EstadoAmoroso estadoAmoroso;

    /**
     * Solicitudes enviadas
     */

    private List<SolicitudesEnviadas> solicitudesEnviadas;

    /**
     * Solicitudes recibidas
     */

    private List<SolicitudesRecibidas> solicitudesRecibidas;


    /**
     *
     * @param nombreUser
     * @param rut
     * @param nombre
     * @param edad
     * @param descripcion
     * @param estadoAmoroso
     */

    public User(String nombreUser, String rut, String nombre, int edad,String descripcion, EstadoAmoroso estadoAmoroso) {
        this.nombreUser = nombreUser;
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.estadoAmoroso = estadoAmoroso;
        this.solicitudesEnviadas = new ArrayList<>();
        this.solicitudesRecibidas = new ArrayList<>();
    }

    /**
     * Metodos getter y setter
     */


    public String getNombreUser(){return nombreUser;}
    public String getRut(){return rut;}
    public String getNombre(){return nombre;}
    public int getEdad(){return edad;}


    @Override
    public void cambiarDescripcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la nueva descripción:");
        String nuevaDescripcion = scanner.nextLine();
        this.descripcion = nuevaDescripcion;
        System.out.println("Descripción actualizada con éxito.");
    }

    @Override
    public void cambiarContrasenia() {
        Scanner scanner = new Scanner(System.in);

        // Verificar contraseña actual
        System.out.println("Ingresa tu contraseña actual:");
        String contrasenaActual = scanner.nextLine();
        if (!Base64Utils.encode(contrasenaActual).equals(this.contrasenaBase64)) {
            System.out.println("Contraseña actual incorrecta. No se puede cambiar la contraseña.");
            return;
        }

        // Cambiar contraseña
        System.out.println("Ingresa tu nueva contraseña:");
        String nuevaContrasena = scanner.nextLine();
        this.contrasenaBase64 = Base64Utils.encode(nuevaContrasena);

        System.out.println("Contraseña actualizada con éxito. Se cerrará la sesión por seguridad.");
        // Puedes implementar la lógica para cerrar la sesión aquí

    }

    @Override
    public void cambiarEdad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu nueva edad:");
        int nuevaEdad = scanner.nextInt();

        if (nuevaEdad > 0) {
            this.edad = nuevaEdad;
            System.out.println("Edad actualizada con éxito.");
        } else {
            System.out.println("La edad ingresada no es válida.");
        }

    }
}
