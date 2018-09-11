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
public class Order {
        public String NameClient;
        public String TypeOperation;
        public String TypeBumaga;
        public long Price;
        public long Count;
        public long Summa;
        
        public Order(String NameClient, String TypeOperation,String TypeBumaga, long Price, long Count,long Summa)
        {
            this.NameClient=NameClient;
            this.TypeOperation=TypeOperation;
            this.TypeBumaga=TypeBumaga;
            this.Price=Price;
            this.Count=Count;
            this.Summa=Summa;
        }
        public Order(){}
        public long GetCount(){return this.Count;}
        public long GetSumma(){return this.Summa;}
        public String GetName(){return this.NameClient;}
        public String GetBumaga(){return this.TypeBumaga;}
}
