package Repositorios;

import Modelos.Taxi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Taxi_Repositorio implements Interface_Repo<Taxi>{

    private final File archi_Json=new File("O:\\UTN\\2023\\lab-progra 3\\Finales y Parciales(praticas lab3)\\Praticas de Parciales y Finales\\PraticaGit_PildorasInformaticas\\src\\main\\java\\Archivos\\taxis.json");
    private final ObjectMapper mapper=new ObjectMapper();
    private ArrayList<Taxi>taxis;

    //contructor
    public Taxi(){}

    ///SOBREESCRIBIENDO METODOS*****************************
    @Override
    public void cargar(){
        @Override
                try{
                    CollectionType collectionType=mapper.getTypeFactory().constructCollectionType(ArrayList.class,Taxi.class);
                    this.taxis=mapper.readValue(archi_Json,collectionType);
                }catch (IOException e){
                    this.taxis=new ArrayList<>();
                }
    }
    ///****************SOBREESCRIBIENDO EL METODO GUARDAR**********************
    @Override
    public void guardar(){
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(archi_Json,this.taxis);
        }catch (throw new RuntimeException());
    }
///**********************************METODO LISTAR*******************************
    @Override
    public ArrayList<Taxi> listar(){
        cargar();
        return this.taxis;
    }
    ///***************************************METODO LISTAR**************************
    @Override
    public void agregar(Taxi... taxis){
        cargar();
        this.taxis.addAll(Arrays.asList(taxis));
        guardar();
    }
//********************************************METODO ELIMINAR******************************
    @Override
    public void eliminar(Taxi taxi){
        cargar();
        this.taxis.remove(taxi);
        guardar();
    }
//***********************************************METODO MODIFICAR*****************
    @Override
    public void modificar(Taxi taxi){
        cargar();
        for(Taxi t:this.taxis) {
            if (t.equals(taxi)) {
                int index = taxis.indexOf(t);
                taxis.set(index, taxi);
                break;
            }
        }
        guardar();
    }
    //***********************************************METODO EXISTE***************
    public boolean existe(Taxi taxi){
        cargar();
        if(this.taxis.contains(taxi)){
            return true;
        }
        else {
            return false;
        }
    }
}
