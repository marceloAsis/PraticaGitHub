package Servicios;

import Modelos.Taxi;
import Repositorios.Taxi_Repositorio;

import java.util.Scanner;

public class GestionTaxi{

    Taxi_Repositorio taxiRepositorio=new Taxi_Repositorio();

    public GestionTaxi(){}

    //************************************METODO LISTAR************************
    public void listar(){
        taxiRepositorio.listar().forEach(System.out::println);
    }
    //************************************METODO AGREGAR************************
    public void agregar(Scanner scan){

        Taxi taxi=new Taxi();
        String seguir="s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("INGRESE MARCA DEL VEHICULO: ");
            taxi.setMarca(scan.next());

            System.out.println("INGRESE MODELO DE VEHICULO: ");
            taxi.setModelo(scan.next());

            System.out.println("INGRESE TIPO DE COMBUSTIBLE: ");
            taxi.setTipoCombustible(scan.next());

            System.out.println("INGRESE PATENTE: ");
            taxi.setPatente(scan.next());

            System.out.println("INGRESE PRECIO BAJADA-BANDERA: ");
            try {
                taxi.setBajadaBandera(scan.nextInt());

            }catch (RuntimeException e){
                System.out.println("ERROR, ingrese un numero: ");
                scan.nextLine();
            }

            System.out.println("INGRESE PRECIO X KM: ");
            try {
                taxi.setPrecioXKM(scan.next());
            }catch (RuntimeException e){
                System.out.println("ERROR, ingrese un numero: ");
                scan.nextLine();
            }

            if(taxiRepositorio.existe(taxi)){
                System.out.println("ERROR, patente agregada no esta disponible.");
            }else {
                taxiRepositorio.agregar(taxi);
                System.out.println("El nuevo tai se abrego correctamente.");
            }
            System.out.println("¿Desea agregar otro taxi? s/n");
            seguir=scan.next();
        }
    }
    //************************************METODO ELIMINAR************************
    public void eliminar(Scanner scan){

        Taxi taxi=new Taxi();
        String seguir="s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("INGRESE PATENTE DE TAXI A ELIMINAR: ");
            taxi.setPatente(scan.next());

            if(!taxiRepositorio.existe(taxi)){
                System.out.println("ERROR, la patente ingresada no existe");
            }else {
                taxiRepositorio.eliminar(taxi);
                System.out.println("El taxi se elimino correctamente");
            }

            System.out.println("¿DESEA ELMINAR OTRO TAXI? s/n");
            seguir=scan.next();
        }
    }
    //************************************METODO MODIFICAR************************
    public void modificar(Scanner scan){

        Taxi taxi=new Taxi();
        String seguir="s";

        while (seguir.equalsIgnoreCase("s")){

            System.out.println("INGRESE PATENTE DE TAXI A MODIFICAR: ");
            taxi.setPatente(scan.next());

            if(!taxiRepositorio.existe(taxi)){
                System.out.println("ERROR, la patente que ingreso no existe.");
            }else {
                System.out.println("INGRESE LA MARCA DEL VEHICULO.");
                taxi.setMarca(scan.next());

                System.out.println("INGRESE MODELO DEL VEHICULO: ");
                taxi.setModelo(scan.next());

                System.out.println("INGRESE TIPO-COMBUSTIBLE: ");
                taxi.setTipoCombustible(scan.next());

                System.out.println("INGRESE PRECIO BAJADA-BANDERA: ");
                try {
                    taxi.setBajadaBandera(scan.nextInt());
                }catch (RuntimeException e){
                    System.out.println("ERROR, ingrese un numero por favor: ");
                    scan.nextLine();
                }

                System.out.println("INGRESE PRECIO X KM.");
                try {
                    taxi.setPrecioXKM(scan.nextInt());
                }catch (RuntimeException e){
                    System.out.println("ERROR, ingrese numero por favro: ");
                    scan.nextLine();
                }

                taxiRepositorio.modificar(taxi);
                System.out.println("EL TAXI SE MODIFICO CORRECTAMENTE");
            }
            System.out.println("¿DESEA MODIFICAR OTRO TAXI? s/n");
            seguir=scan.next();
        }
    }
}
