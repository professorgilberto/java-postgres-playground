package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMeu {

    public static Connection getConnection() throws SQLException  {
        return (DriverManager.getConnection("jdbc:sqlite:banco.db"));   
    }





}