package Repositorios;

import Modelos.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Cliente_Repositorio implements Interface_Repo<Cliente>{

    private final File archivo_Json=new File("O:\\UTN\\2023\\lab-progra 3\\Finales y Parciales(praticas lab3)\\Praticas de Parciales y Finales\\PraticaGit_PildorasInformaticas\\src\\main\\java\\Archivos\\clientes.json");
    private final ObjectMapper mapper=new ObjectMapper();
    private ArrayList<Cliente>clientes;
    //CONSTRUCTOR
    public Cliente_Repositorio(){}

//*************************************METODO CARGAR***************
    @Override
    public void cargar(){
        try {
            CollectionType collectionType=mapper.getTypeFactory().constructCollectionType(ArrayList.class,Cliente.class);
            this.clientes=mapper.readValue(archivo_Json,collectionType);
        }catch ( IOException e){
            this.clientes=new ArrayList<>();
        }
    }
    //*************************************METODO GUARDAR***************
    @Override
    public void guardar() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo_Json, this.clientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //*************************************METODO LISTAR***************
    @Override
    public ArrayList<Cliente> listar(){
     cargar();
        return this.clientes;
    }
    //*************************************METODO AGREGAR***************
    @Override
    public void agregar(Cliente...clientes){
        cargar();
        this.clientes.addAll(Arrays.asList(clientes));
        guardar();
    }
    //*************************************METODO ELIMINAR***************
    @Override
    public void eliminar(Cliente...cliente){
        cargar();
        this.clientes.remove(cliente);
        guardar();
    }
    //*************************************METODO MODIFICAR***************
    @Override
    public void modificar(Cliente cliente){
        cargar();
        for(Cliente c:this.clientes){
            if(c.equals(cliente)){
                int index=clientes.indexOf(c);
                clientes.set(index,cliente);
                break;
            }
        }
        guardar();

    }
    //***********************************METODO EXISTE***********
    public boolean existe(Cliente cliente) {
        cargar();
        if (this.clientes.contains(cliente)){
        return true;
        }
    }


}
