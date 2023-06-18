package Servicios;

import Modelos.Remis;
import Repositorios.Remis_Repositorio;

import java.util.Scanner;

public class GestionRemis{

    Remis_Repositorio remisRepositorio=new Remis_Repositorio();

    ///CONSTRUCTOR
    public GestionRemis(){}

    //*******************************METODO LISTAR*******************************************
    public void listar(Scanner scan){
        remisRepositorio.listar().forEach(System.out::println);
    }
    //******************************METODO AGREGAR********************************************
    public void agregar(Scanner scan){

        Remis remis=new Remis();
        String seguir="s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("INGRESE MARCA DE VEHICULO: ");
            remis.setMarca(scan.next());

            System.out.println("INGRESE MODELO VEHICULO: ");
            remis.setModelo(scan.next());

            System.out.println("INGRESE TIPO DE COMBUSTIBLE: ");
            remis.setTipoCombustible(scan.next());

            System.out.println("INGRESE PATENTE: ");
            remis.setPatente(scan.next());

            System.out.println("INGRESE TARIFA POR CUADRA: ");
            try {

            }catch (RuntimeException e){
                System.out.println("ERROR, USTED DEBE INGRESAR UN NUMERO VALIDO. REPITA ACCION: ");
                scan.nextLine();
            }else{
                if(remisRepositorio.existe(remis)){
                    System.out.println("ERROR AL AGREGAR, LA PANTENTE QUE INGRESO NO ESTA DISPONIBLE");
                }
                System.out.println("El nuevo remis se agrego correctamente");
            }
            System.out.println("DESEA AGREGAR OTRO REMIS? S/N");
            seguir=scan.next();
        }
    }
    //*********************************METODO ELIMINAR*****************************************
    public void eliminar(Scanner scanner){

        Remis remis=new Remis();
        String seguir="s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("INGRESE LA PATENTE DEL REMIS QUE DESEA ELIMINAR: ");
            remis.setPatente(scanner.next());

            if(!remisRepositorio.existe(remis)){
                System.out.println("ERROR, AL ELIMINAR LA PATENTE QUE INGRESO NO EXISTE");
            }else {
                remisRepositorio.eliminar(remis);
                System.out.println("EL REMIS SE ELIMINO CORECTAMENTE");
            }
            System.out.println("¿DESEA ELIMINAR OTRO REMIS? S/N");
            seguir=scanner.next();
        }
    }
    //***********************************METODO MODIFICAR***************************************
    public void modificar(Scanner scan){

        Remis remis=new Remis();
        String seguir="s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("INGRESE PATENTE DE REMIS A MODIFICAR: ");
            remis.setPatente(scan.next());
            if(!remisRepositorio.existe(remis)) {
                System.out.println("ERROR, patente ingresada no existe.");
            }else {
                System.out.println("INGRES LA MARCA DEL VEHICULO.");
                remis.getMarca(scan.next());

                System.out.println("INGRESE MODELO DEL COMBUSTIBLE.");
                remis.setModelo(scan.next());

                System.out.println("INGRESE TIPO DE COMBUSTIBLE: ");
                remis.setTipoCombustible(scan.next());

                System.out.println("INGRESE TARIFA POR CUADRA: ");
                try {
                    remis.setTarifaXCuadra(scan.nextInt());
                }catch (RuntimeException e){
                    System.out.println("ERROR, ingrese un numero por favor: ");
                    scan.nextLine();
                }
                remisRepositorio.modificar(remis);
                System.out.println("EL REMIS SE MODIFICO CORRECTAMENTE");
            }
            System.out.println("¿DESEA MODIFICAR OTRO REMIS? s/n");
            seguir=scan.next();
        }
    }
}
