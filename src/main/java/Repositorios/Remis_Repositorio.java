package Repositorios;

import Modelos.Remis;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Remis_Repositorio implements Interface_Repo<Remis>{

    private final File archivo_Json=new File("O:\\UTN\\2023\\lab-progra 3\\Finales y Parciales(praticas lab3)\\Praticas de Parciales y Finales\\PraticaGit_PildorasInformaticas\\src\\main\\java\\Archivos\\remises.json");
    private final ObjectMapper mapper=new ObjectMapper();
    private ArrayList<Remis>remis;

    ///CONSTRUCTOR
    public Remis_Repositorio(){}

    ///*********************************METODO CARGAR*****************
    @Override
    public void cargar(){
        try {
            CollectionType collectionType=mapper.getTypeFactory().constructCollectionType(ArrayList.class,Remis.class);
            this.remis=mapper.readValue(archivo_Json,collectionType);
        }catch (IOException e){
            this.remis=new ArrayList<>();
        }
    }
    ///*********************************METODO GURADAR*****************
    @Override
    public void guardar(){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo_Json,this.remis);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    ///*********************************METODO LISTAR*****************
    @Override
    public ArrayList<Remis> listar(){
        cargar();
        return this.remis;
    }
    ///*********************************METODO AGREGAR*****************
    @Override
    public void agregar(Remis... remis) {
     cargar();
     this.remis.addAll(Arrays.asList(remis));
     guardar();
    }
    ///*********************************METODO ELIMINAR*****************
    @Override
    public void eliminar(Remis... remis){
        cargar();
        this.remis.remove(remis);
        guardar();
    }
    ///*********************************METODO MODIFICAR*****************
    @Override
    public void modificar(Remis objeto) {
        cargar();
        for(Remis r:this.remis){
            if(r.equals(remis)){
                int index=remis.indexOf(r);
            }
        }
        guardar();
    }
    //************************************METODO EXISTE***************************
    public boolean existe(Remis remis){
        cargar();
        if(this.remis.contains(remis)){
            return true;
        }
        else {
            return false;
        }
    }
}
