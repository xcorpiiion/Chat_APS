/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//import static javax.swing.JOptionPane.PLAIN_MESSAGE;
//import static javax.swing.JOptionPane.showInputDialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import static javax.swing.JOptionPane.*;
import model.Usuario;
import view.Chat;
import view.Inicio;

/**
 *
 * @author Lais
 */
public class ClienteController {
    
    private Socket socket;
    private Chat chat;
    
    public static void main(String[] args){
        
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
    }
    
    public void iniciarConexao(Chat chat){
        try{
            socket = new Socket("127.0.0.1",5000);
        }
        catch(IOException exp){
            showMessageDialog(null, "Servidor não conectado", "", ERROR_MESSAGE);
            System.exit(0);
        }
        Thread();
        setChat(chat);
        getChat().setSocket(socket); //função temporária até a implementação do Banco de dados
    }
    
    private void Thread(){
        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                
                //essa parte será alterada na implementação do Banco de Dados
                try{
                   InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                   BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        
                   String mensagem;
                   while ((mensagem = bufferedReader.readLine()) != null){
                             chat.mensagens(mensagem);
                    }
                }catch(IOException ex){
                    showMessageDialog (null, "Erro na conexão com o servidor", "", ERROR_MESSAGE);
                    
                
            }
            }
        
            
        });
        thread.start();
    }

    /**
     * @return the chat
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * @param chat the chat to set
     */
    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
