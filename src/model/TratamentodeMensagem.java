/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
/**
 *
 * @author Lais
 */
public class TratamentodeMensagem {
    
    private Socket socket;
    private ArrayList<PrintStream> clientes;
    
    public TratamentodeMensagem(Socket socket, ArrayList<PrintStream> clientes ){
        setSocket(socket);
        setClientes(clientes);
        Thread();
    }
    
    private void Thread(){
       Thread t = new Thread (new Runnable() {
          
           @Override
           public void run() {
                String mensagem = "";
                     try{
                        InputStreamReader irs = new InputStreamReader(socket.getInputStream());
                            BufferedReader br = new BufferedReader (irs);
                                 while((mensagem = br.readLine())!= null){
                                    enviarMensagem(mensagem);
                                }
        
                        }catch(IOException ex){
                           ex.printStackTrace();
                                              }
       }
     });
       t.start();
    }
       
    private void enviarMensagem(String mensagem){
        
        for(int a = 0; a < clientes.size(); a++ ){
            clientes.get(a).println(mensagem);
            clientes.get(a).flush();
        }
    }
    
    /**
     * @return the s
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param s the s to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
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
