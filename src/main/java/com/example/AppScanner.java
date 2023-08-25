package com.example;

import java.util.Scanner;

public class AppScanner{
  public static void main(String[] args) {
    Cliente cliente = new Cliente();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o nome");
    cliente.setNome(scanner.nextLine());
    System.out.println("nome "+cliente.getNome());
    scanner.close();
  


 

  }




}