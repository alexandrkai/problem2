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
public class Orders {
    
    public static final String[] Types=new String[]{"A","B","C","D"}; 
    public static ArrayList<Order> Values;
    
    public static ArrayList<Order> ReadDataFromFile(String NameFile) 
        {
            try 
        {
            File file = new File(NameFile);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            Values=new ArrayList<Order>();
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] masstr=line.split("\t");
                Order o=new Order(
                        masstr[0],
                        masstr[1],
                        masstr[2],
                        Long.parseLong(masstr[3]),
                        Long.parseLong(masstr[4]),
                                0);
                Values.add(o);
                /*o.NameClient=masstr[0];
                o.TypeOperation=masstr[1];
                o.TypeBumaga=masstr[2];
                o.Price=Long.parseLong(masstr[3]);
                o.Count=Long.parseLong(masstr[4]);
                */
                if(o.TypeOperation.equals("b"))
                {
                    o.Summa=o.Price*o.Count*(-1);
                }
                else
                {
                    o.Summa=o.Price*o.Count;
                    o.Count=-1*o.Count;
                }
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            
        } catch (IOException e) { Values=null;
        }
            return Values;
        } 
}
