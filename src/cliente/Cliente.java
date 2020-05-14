package cliente;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * 
 */
public class Cliente {
    
    private ArrayList<PrintStream> clientes;
    
    public Cliente(){
    }
    
    public Cliente(ArrayList<PrintStream> clientes){
        setClientes(clientes);
    }
    
    public void enviarMensagem(String mensagem){
        
        for(int a = 0; a < getClientes().size(); a++ ){
            getClientes().get(a).println(mensagem);
            getClientes().get(a).flush();
        }
    }    
    
    //@return the clientes
    public ArrayList<PrintStream> getClientes() {
        return clientes;
    }
    
    //@param clientes the clientes to set
    public void setClientes(ArrayList<PrintStream> clientes) {
        this.clientes = clientes;
    }
    
}
