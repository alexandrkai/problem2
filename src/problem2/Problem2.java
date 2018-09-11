/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.util.Pair;

/**
 *
 * @author Александр
 */
public class Problem2 {

    static String NameClientFile = null;
    static String NameOrdersFile = null;
    static String CurrentDirectory = null;
    static String ResultFile = null;


    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        if(args.length==0) 
        {
            System.out.print("Не заданы параметры для программы!");
            return;
        }
        if(args.length<2)
        {
            System.out.print("Не все заданы параметры для программы!");
            return;
        }
        if(CheckFile(args[0])) NameClientFile=args[0];
        if(CheckFile(args[1])) NameOrdersFile=args[1];
        ResultFile="result.txt";
        ReadData();
        SaveData();
    }
    //начитываем данные по клиентам и их операциям
    static void ReadData()
    {
        Clients.ReadDataFromFile(NameClientFile);
        Orders.ReadDataFromFile(NameOrdersFile);
    }
    //сохраняем данные в файле
    static void SaveData() 
    {
        PrintWriter out;
        try 
        {
        //PrintWriter обеспечит возможности записи в файл
        out = new PrintWriter(ResultFile);
        
        long count=0;
        long summa=0;
        for(Client client:Clients.Values)
        {
            String text=client.NameClient;
            summa=Orders.Values.stream().filter((s)->s.NameClient.equals(client.NameClient)).mapToLong((s)->s.Summa).sum();
            client.Balance+=summa;
            text+="\t"+client.Balance;
            for(String NameBumaga:Orders.Types)
            {
                count=Orders.Values.stream().filter((s)->s.NameClient.equals(client.NameClient) && s.TypeBumaga.equals(NameBumaga)).mapToLong((s)->s.Count).sum();
                switch(NameBumaga)
                {
                    case "A":
                        count+=client.CountA;
                        break;
                    case "B":
                        count+=client.CountB;
                        break;
                    case "C":
                        count+=client.CountC;
                        break;
                    case "D":
                        count+=client.CountD;
                        break;
                }
                text+="\t"+count;
            }
            //Записываем текст у файл
            out.println(text);
            System.out.println(text); //для отладки
        }
            //После чего мы должны закрыть файл
            //Иначе файл не запишется
            out.close();
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Problem2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static boolean CheckFile(String FileName)
    {
        boolean result=false;
        File file = new File(FileName);
        if(file.exists()&&file.isFile()) result=true;
        return result;
    }
    
    static void SaveData1()
    {
        Function<Order, List<Object>> compositeKey = order -> Arrays.<Object>asList(order.GetName(), order.GetBumaga());
        Map<Object, List<Order>> map =Orders.Values.stream().collect(Collectors.groupingBy(compositeKey, Collectors.toList()));
    }
}
