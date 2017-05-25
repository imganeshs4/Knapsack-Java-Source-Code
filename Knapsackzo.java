import java.util.*;
import java.io.*;
import java.lang.*;

public class Knapsackzo
{
  public static int weight[];
  public static int profit[];
  public static int value[][];
  public static int capacity;
  public static int n;
 
  public static int max(int a,int b)
  {
     return (a>b)? a:b;
  }

  public static void knapsack()
  {
    int i,w;
    value=new int[10][10];
    
    for(i=0;i<=n;i++)
      {
        for(w=0;w<=capacity;w++)
         {

           if(i==0 || w==0)                                                         /* Intial value as 0 for i=0 & w=0 */
             value[i][w]=0;                                               
 
           else if(weight[i]>w)                                              
             value[i][w]=value[i-1][w];

           else if(weight[i]<=w)                                               
             value[i][w]=max(value[i-1][w],(value[i-1][w-weight[i]]+profit[i]));
           
         }
      }
    
     System.out.println("The Knapsack Resultant Matrix : ");
     for(i=0;i<=n;i++)
       {
         System.out.println();
         for(w=0;w<=capacity;w++)
         {
           System.out.print(value[i][w]+"\t");
         }
       }

     int selected[]=new int[10];                                                     /* To obtain the item selected for optimal solution */

     for(i=1;i<=n;i++)
       selected[i]=0;
 
     i=n;                                                                            /* Initialize i to number or objects */
     w=capacity;                                                                     /* Intialize w to Maxcapacity of Knapsack */

     while(i!=0 && w!=0)
      {
        if(value[i][w]!=value[i-1][w])
          {
            selected[i]=1;
            w=w-weight[i];
          }
        i--;
      }

     System.out.println("\n\nThe items selected and its Profit for Max optimum solution are : ");
     System.out.println("Item\tProfit");
     for(i=1;i<=n;i++)
       {
         if(selected[i]==1)
          {
            System.out.println(i+"\t"+profit[i]);
          }
       }
     
     System.out.println("\nThe Max Profit from Knapsack : "+value[n][capacity]);    /*The last value of Resultant matrix*/
  }

  public static void main(String args[])
  {

    Scanner in=new Scanner(System.in);
    System.out.println("Enter the number of Items : ");
    n=in.nextInt();

    weight=new int[10];
    profit=new int[10];
    
    System.out.println("Enter the maximum capacity of the Knapsack : ");
    capacity=in.nextInt();

    for(int i=1;i<=n;i++)
     {
       System.out.println("Enter the Weight and Profit of Item"+i+" : ");
       weight[i]=in.nextInt();
       profit[i]=in.nextInt();
     }

     knapsack();
  }

}
