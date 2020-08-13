import java.util.Scanner;
import java.util.Arrays;

public class Lotto
{
	public static void main(String[] args)
	{
		//Declare variables for main
		int[] x = {};
		int type, rows, maxDigit = 0,length = 0;
		String name="";
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Java-lottery!");
		System.out.print("Please select type. (1)Lotto or (2)Vikinglotto: ");
		type = input.nextInt();
		switch(type) //The switch statement holds the definition of the different types of lottery
		{
			case 1:
				name = "Lotto";
				maxDigit = 34;
				length = 7;
				break;
			case 2:
				name = "Vikinglotto";
				maxDigit = 48;
				length = 6;
				break;
		}
		x = new int[length]; //Sets the correct length of the array x (lottery numbers)
		if(x.length != 0) //Verifies that x is not empty. If empty, the else-statement will print out an error
		{
			rows = readIn();
			System.out.println("You have chosen " + rows + " rows of "+name+".\n");
			draw(x,rows,maxDigit);
		}
		else
			System.out.println("Non-existing lottery type!");
	}
	static int readIn() //Method readIn() asks about number of rows and returns the integer.
	{
		Scanner input = new Scanner(System.in);
		int numRows;

		System.out.print("How many rows: ");
		numRows = input.nextInt();
		return numRows;
	}

	static void draw(int[] table,int row,int max)
	{
		int i,j,k, random;

		for(i = 0; i<row; i++) //Generates rows
		{
			for(j = 0; j<table.length; j++) //Generates numbers for each row
			{
				random = (int) ((Math.random()*max)+1);
				table[j] = random;
				for(k=0; k<j; k++) //Loops through the array and re-generates duplicate number
					if(random == table[k])
					{
						j--;
						break;
					}
			}
		table = bubbleSort(table); //Sorts the table before print
		print(table); //Prints!
		}
	}

	static int[] bubbleSort (int[] table) //Bubble sort function, checks for biggest number of an integer i and the integer above in array
	{
		int pass, i, max;
		for(pass=0; pass<table.length; pass++)
		{
			for(i=0; i < table.length-1; i++)
				{
					if(table[i] > table[i+1])
					{
						max = table[i];
						table[i] = table[i+1];
						table[i+1] = max;
					}
				}
		}
		return table;
	}

	static void print(int[] table) //Prints out rows with a tab between each number, and then a new line after each row
	{
		int i;
		for(i=0; i<table.length; i++)
			System.out.print(table[i] + "\t");
		System.out.println();
	}
}