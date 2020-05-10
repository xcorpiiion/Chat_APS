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
    
    private Socket s;
    private ArrayList<PrintStream> clientes;
    
    public TratamentodeMensagem(Socket s, ArrayList<PrintStream> clientes ){
        setS(s);
        setClientes(clientes);
        Thread();
    }
    
    private void Thread(){
       Thread t = new Thread (new Runnable() {
          
           @Override
           public void run() {
                String mensagem = "";
                     try{
                        InputStreamReader irs = new InputStreamReader(s.getInputStream());
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
    public Socket getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(Socket s) {
        this.s = s;
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
