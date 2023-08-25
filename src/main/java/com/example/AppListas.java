package com.example;

import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.LinkedList;
//import util.List;

public class AppListas {
    public static void main(String[] args) {
        //Cliente[] vetorClientes = new Cliente[5];
        List<Cliente> listaClientes = new ArrayList<>();

        var cliente1= new Cliente();
        cliente1.setNome("asdasdfasd");
        var cliente2= new Cliente();
        cliente2.setNome("asdasgfgsdfasd");
        
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);      
        
        for (var x:listaClientes){
            System.out.println(x);



        }

        listaClientes.remove(0);


    }
}
