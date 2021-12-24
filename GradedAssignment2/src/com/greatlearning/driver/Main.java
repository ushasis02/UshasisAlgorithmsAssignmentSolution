package com.greatlearning.driver;
import java.util.Scanner;
import com.greatlearning.service.*;


public class Main {
   public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("enter no of companies:");
	  int noofcomp = sc.nextInt();
	  double shareprice[] = new double[noofcomp];
	  boolean pricecomparison[] = new boolean[noofcomp];
	  
	  getpriceandcomparison (shareprice, pricecomparison, noofcomp);
	  
	  int choice = 6;
	  while (choice!=0) {
		  printmenu();
		  choice = sc.nextInt();
		  switch (choice) { 
			  case 1:
				  ascendingorder(shareprice, noofcomp);
				  break;
			  case 2:
				  descendingorder (shareprice, noofcomp);
				  break;
			  case 3:
				  stockrose (pricecomparison, noofcomp);
				  break;
			  case 4:
		          stockdecline (pricecomparison, noofcomp);
		          break;
			  case 5: 
				  searchstock (shareprice, noofcomp);
				  break;
			  case 0:
				  break; 
			  default:
				  System.out.println("Please enter valid input");  				  
		  		}
	      } System.out.println("Exited Succesfully");
   }   
	        
    	public static void getpriceandcomparison (double[] price, boolean[] compare, int numb) {
			Scanner sc1 = new Scanner(System.in);	
			for (int i=0; i<numb; i++) {
	        		System.out.println("Enter Stock price of the company "+ (i+1));
	        		price [i] = sc1.nextDouble();
	        		System.out.println("Whether company's stock price rose today compared to yesterday?");
	        		compare [i] = sc1.nextBoolean();
	        	}
	        	
	        }

        public static void printmenu() {
    	   System.out.println("\n----------------------------------------------");
    	   System.out.println("Enter the operation that you want to perform");
    	   System.out.println("1. Display the companies stock prices in ascending order");
    	   System.out.println("2. Display the companies stock prices in descending order");
    	   System.out.println("3. Display the total no of companies for which stock prices rose today");
    	   System.out.println("4. Display the total no of companies for which stock prices declined today");
    	   System.out.println("5. Search a specific stock price");
    	   System.out.println("6. press 0 to exit");
    	   System.out.println("-----------------------------------------------");
       }

      public static void ascendingorder (double [] price, int numb) {
    	  MergeSortImplementation mergesortprice = new MergeSortImplementation();
    	  mergesortprice.sort (price, 0, numb-1);
    	  System.out.println("Stock prices in ascending order are : \n");
    	  for (int j=0; j<numb; j++)
    		  System.out.print(price[j] + "  ");
      }

      public static void descendingorder (double [] price, int numb) {
    	  MergeSortImplementation mergesortprice = new MergeSortImplementation();
    	  mergesortprice.sort (price, 0, numb-1);
    	  System.out.println("Stock prices in descending order are : \n");
    	  for (int k=numb-1; k>=0; k--)
    		  System.out.print(price[k] + "  ");
      }

      public static void stockrose (boolean [] comp, int numb) {
    	  int count =0;
    	  for (int l=0; l<numb; l++)
    		  if (comp[l] == true) count++; 
    	  System.out.println("Total no of companies whose stock price rose today :"+count);
    	  }
      
      public static void stockdecline (boolean [] comp, int numb) {
    	  int count =0;
    	  for (int l=0; l<numb; l++)
    		  if (comp[l] == false) count++; 
    	  System.out.println("Total no of companies whose stock price declined today :"+count);
    	  }
      
      public static void searchstock (double [] price, int numb) {
    	  Scanner sc2 = new Scanner (System.in);
    	  System.out.println("Enter the key value");
    	  double key = sc2.nextDouble();
    	  int flag =0;
    	  for (int i=0; i<numb; i++)
    		  if (price[i] == key) flag =i;  
    	  if (flag !=0)
    		  System.out.println("Stock of value " + key + " is present"); 
    	  else 
    		  System.out.println("Value not found");
       }
      
}
