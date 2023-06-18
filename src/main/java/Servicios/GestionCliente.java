package Servicios;

import Modelos.Cliente;
import Repositorios.Cliente_Repositorio;

import java.util.Scanner;

public class GestionCliente {

    Cliente_Repositorio clienteRepositorio=Cliente_Repositorio();

    public GestionCliente(){}
    //*********************************METODO LISTAR************
    public void listar(){
        clienteRepositorio.listar().forEach(System.out::println);
    }
    //*********************************METODO AGREGAR************
    public void agregar(Scanner scan){

        Cliente cliente=new Cliente();
        String sequir="s";

        while (sequir.equalsIgnoreCase("s")){}

            System.out.println("Ingrese nombre: ");
            cliente.setNombre(scan.next());
            System.out.println("INGRESE APELLIDO: ");
            cliente.setApellido(scan.next());
            System.out.println("INGRESE TELEFONO: ");
            cliente.getTelefono(scan.next());
            System.out.println("INGRESE DIRECCION: ");
            cliente.getDireccion(scan.next());

            if(clienteRepositorio.existe(cliente)) {
                System.out.println("ERROR, EL NUMERO INGRESADO NO ESTA DISPONIBLE");
            }else {
                clienteRepositorio.agregar(cliente);
                System.out.println("EL NUEVO CLIENTE SE HA AGREGADO CORRECTAMENTE");
            }
            System.out.println("¿DESEA AGREGAR OTRO CLIENTE?s/n");
            sequir=scan.next();
        }
     //******************************METODO ELIMINAR**************
    public void eliminar(Scanner scan){

        Cliente cliente=new Cliente();
        String seguir="s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("INGRESE EL NUMERO DE TELEFONO DEL CLIENTE QUE DESEA ELIMINAR: ");
            cliente.setTelefono(scan.next());

            if(!clienteRepositorio.existe(cliente)){
                System.out.println("ERROR, NUMERO DE TELEFONO INGRESADO NO EXISTE.");
            }else {
                clienteRepositorio.eliminar(cliente);
                System.out.println("EL CLINTE SE ELIMINO CORECTAMENTE");
            }
            System.out.println("¿DESEA ELIMINAR OTRO CLIENTE?");
            seguir=scan.next();
        }
    }
}
