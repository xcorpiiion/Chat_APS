/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//import static javax.swing.JOptionPane.PLAIN_MESSAGE;
//import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.*;
import view.Chat;

/**
 *
 * @author Lais
 */
public class ClienteController {
    
    public static void main(String[] args){
        
        String nome = showInputDialog(null, "Digite o seu nome:", "", PLAIN_MESSAGE);
        Chat chat = new Chat(nome);
        chat.setVisible(true);
    }
    
}
