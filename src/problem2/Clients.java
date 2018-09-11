/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Александр
 */
public class Clients {
    
    public static ArrayList<Client> Values;
    
    public static ArrayList<Client> ReadDataFromFile(String NameFile)
        {
            try 
        {
            File file = new File(NameFile);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            Values=new ArrayList<Client>();
            
            while (line != null) {
                String[] masstr=line.split("\t");
                Client c=new Client(masstr[0], 
                        Long.parseLong(masstr[1]),
                        Long.parseLong(masstr[2]),
                        Long.parseLong(masstr[3]),
                        Long.parseLong(masstr[4]),
                        Long.parseLong(masstr[5]));
                Values.add(c);
                /*
                c.NameClient=masstr[0];
                c.Balance=Long.parseLong(masstr[1]);
                c.CountA=Long.parseLong(masstr[2]);
                c.CountB=Long.parseLong(masstr[3]);
                c.CountC=Long.parseLong(masstr[4]);
                c.CountD=Long.parseLong(masstr[5]);
                */
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } 
            catch (FileNotFoundException e) 
            {  Values=null;} 
            catch (IOException e) 
            { Values=null;    }
            return Values;
        }
}
