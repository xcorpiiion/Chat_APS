/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cliente.Cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import servidor.Servidor;

/**
 *
 * @author Laís
 */
public class ServidorController {
     
     public static void main (String[] args){
         Servidor server = new Servidor(5000);
         server.rodarServer();
     }
     
     public void threadServidor(Socket socket, Cliente cliente){
       Thread thread = new Thread (new Runnable() {
           @Override
           public void run() {
                String mensagem = "";
                     try{
                        InputStreamReader irs = new InputStreamReader(socket.getInputStream());
                        BufferedReader br = new BufferedReader (irs);
                        while((mensagem = br.readLine())!= null){
                            cliente.enviarMensagem(mensagem);
                            }
        
                        }catch(IOException ex){
                           ex.printStackTrace();
                                              }
       }
     });
       thread.start();
    }
}
