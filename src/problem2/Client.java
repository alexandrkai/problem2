/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

/**
 *
 * @author Александр
 */
public class Client {
      String NameClient;
        long Balance;
        long CountA;
        long CountB;
        long CountC;
        long CountD;
        
        public Client(String NameClient, long Balance, long CountA, long CountB, long CountC, long CountD)
        {
            this.NameClient=NameClient;
            this.Balance=Balance;
            this.CountA=CountA;
            this.CountB=CountB;
            this.CountC=CountC;
            this.CountD=CountD;
        }
        public Client(){}
}

