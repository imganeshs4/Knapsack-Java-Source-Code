import java.util.*;
import java.io.*;
import java.lang.*;

public class KnapsackFrac
{
  public static float weight[];
  public static float profit[];
  public static float capacity;
  public static int n;

  public static void knapsack()
  {
    float selected[]=new float[n];
    float TotalProfit=0;
    float TotalItem=0;
    float RemCap=capacity;                                                  /* Stores the remaining capacity of Knapsack */
    int i;

    for(i=0;i<n;i++)
      selected[i]=0;
 
    for(i=0;i<n;i++)
     {
        if(RemCap<weight[i])
           break;

        else
          {
             selected[i]=1;
             TotalProfit=TotalProfit+profit[i];
             TotalItem=TotalItem+selected[i];
             RemCap=RemCap-weight[i];
          }
     }

    if(i<n)
     {
        selected[i]=RemCap/weight[i];                                       /* Find the fraction of the object selected for Max Profit */
        TotalProfit=TotalProfit+(selected[i]*profit[i]);
        TotalItem=TotalItem+selected[i];
     }

     System.out.println("\nThe Selected Item and its Profit based on Profit/weight ratio : ");
     System.out.println("Item\tSelectedFrac\tProfit");
     for(i=0;i<n;i++)
       {
         if(selected[i]!=0)
           System.out.println((i+1)+"\t"+selected[i]+"\t\t"+(selected[i]*profit[i]));
       } 

     System.out.println("\nTotal Item selected : "+TotalItem);
     System.out.println("\nTotal Profit of Knapsack : "+TotalProfit);
        
  }

  public static void main(String args[])
  {
    int i,j;

    Scanner in=new Scanner(System.in);
    System.out.println("Enter the number of Items : ");
    n=in.nextInt();

    weight=new float[n];
    profit=new float[n];
    
    System.out.println("Enter the maximum capacity of the Knapsack : ");
    capacity=in.nextInt();

    for(i=0;i<n;i++)
     {
       System.out.println("Enter the Weight and Profit of Item"+(i+1)+" : ");
       weight[i]=in.nextInt();
       profit[i]=in.nextInt();
     }

    float ratio[]=new float[n];

    for(i=0;i<n;i++)
      ratio[i]=profit[i]/weight[i];

    for(i=0;i<n;i++)
     {
       for(j=0;j<n-i-1;j++)
        {
          if(ratio[j]<ratio[j+1])
            {
               float temp=ratio[j];
               ratio[j]=ratio[j+1];
               ratio[j+1]=temp;                                                      /* Sort in descending order based on
                                                                                          Profit/Weight ratio using Bubble Sort */
               temp=weight[j];
               weight[j]=weight[j+1];
               weight[j+1]=temp;

               temp=profit[j];
               profit[j]=profit[j+1];
               profit[j+1]=temp;

            }
        }
     }

    System.out.println("\nWeights and Profit after sorting based on Profit/Weight ratio : ");
    System.out.println("\nWeights\tProfit\tRatio");
    for(i=0;i<n;i++)
      System.out.println(weight[i]+"\t"+profit[i]+"\t"+ratio[i]);

    knapsack();
    
  }

}
