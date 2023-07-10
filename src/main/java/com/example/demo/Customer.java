package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
@SpringBootApplication
public class Customer {

        private String name, surname;
        private int ID, telephone;

       public Customer(String name, String surname, int ID, int telephone){
            this.ID = ID;
            this.name = name;
            this.surname = surname;
            this.telephone = telephone;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getSurname () {
            return surname;
        }

        public void setSurname (String surname){
            this.surname = surname;
        }

        public int getID () {
            return ID;
        }

        public void setID ( int ID){
            this.ID = ID;
        }

        public int getTelephone () {
            return telephone;
        }

        public void setTelephone ( int telephone){
            this.telephone = telephone;
        }

    public static void main(String[] args)throws SQLException {
        SpringApplication.run(Customer.class, args);


            try {
                Class.forName("org.postgresql.Driver");

                Connection connection = null;

                //  "jdbc:postgresql://nazwahosta:port/nazwabazy","uzytkownik", "haslo"
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres","postgres", "mojehaslo");

                connection.close();

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
                System.out.append("Nie masz sterownika");
            }
            catch (SQLException e )
            {
                e.printStackTrace();
                System.out.append("Zle dane");
            }
        }

}
