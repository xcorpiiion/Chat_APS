/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import servidor.Servidor;

/**
 *
 * @author VITOR
 */
public class ServidorController {
     public static void main (String[] args){
         Servidor server = new Servidor(5000);
         server.rodarServer();
     }
}
