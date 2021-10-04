/*-/*
Student 1:
Name: Balaji Chandupatla
Student Number: A00245077

Student 2:
Name: Gaganpreet Kaur
Student Number: A00245156

Program Description: 
Program to 
1. Cipher a given string using Caeser Cipher method.
2. Return the average of an array of integers.
3. Check if a given element is present in the array.
4. Return the reverse of the array.

Example:

CASE 1 ->

INPUT: 
1. String Encryption  
2. Playing with Arrays
Choose between above two options: 1
Enter number of strings to encrypt: 2

Enter string no.1 to encrypt: apples
Enter a value to encrypt with: 5

Enter string no.2 to encrypt: fuuqjx
Enter a value to encrypt with: -5


OUTPUT:
The encrypted String of apples is: fuuqjx
Decrypting fuuqjx with -5...
apples
--------------------------------------------------------------------------------

The encrypted String of fuuqjx is: apples
Decrypting apples with --5...
fuuqjx
--------------------------------------------------------------------------------



CASE 2 -> 

INPUT:
1. String Encryption  
2. Playing with Arrays
Choose between above two options: 2
Enter number of arrays: 2

Enter the number of elements in array no.1: 5
Enter element 1: 1
Enter element 2: 2
Enter element 3: 3
Enter element 4: 4
Enter element 5: 5

OUTPUT:
The average of array no.1 is 3


Enter a value to search for: 2

Array no.1 contains 2
Reverse of array 1 is [5, 4, 3, 2, 1]
--------------------------------------------------------------------------------

INPUT:
Enter the number of elements in array no.2: 3
Enter element 1: 10
Enter element 2: 23
Enter element 3: 15

OUTPUT:
The average of array no.2 is 16


Enter a value to search for: 5 
Array no.2 does not contain 5

Reverse of array 2 is [15, 23, 10]
--------------------------------------------------------------------------------
*/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;


public class ArrayTools{
    static Scanner s = new Scanner(System.in);
    static Scanner ss = new Scanner(System.in);
    public static void main(String[] args) {
        // Requesting system to Choose between the two options mentioned below.
        
        System.out.println("1. String Encryption\n2. Playing with Arrays");
        System.out.print("Choose between above two options: ");
        int selectCategory = s.nextInt();
        switch(selectCategory) {
            case 1:
                // Reading number of strings which is used to encrypt multiple strings.
                System.out.print("Enter number of strings to encrypt: ");
                int stringNumber = s.nextInt();
                String[] stringInput = new String[stringNumber];
                Integer[] shiftInput = new Integer[stringNumber];
                for (int i=0;i<stringNumber;i++){

                    // Reading string to encrypt
                    System.out.print("\nEnter string no." + (i+1) + " to encrypt: ");
                    stringInput[i] = ss.nextLine();
                    // Reading shift value to encrypt the given string
                    System.out.print("Enter a value to encrypt with: ");
                    shiftInput[i] = s.nextInt();
        
                }
                for (int i=0;i<stringNumber;i++){
                    // Calling the method here which performs the main task
                    String[] resultString = caeserCipher(stringInput[i], shiftInput[i]);
                    System.out.println("\n\nThe encrypted String of " + stringInput[i] + " is: " + resultString[0]);
                    System.out.println("Decrypting " + resultString[0] + " with -" + shiftInput[i] + "...");
                    System.out.println(resultString[1]);
                    System.out.println("--------------------------------------------------------------------------------");
                }
                
            break;

            case 2:
                // Reading number to input multiple arrays.
                System.out.print("Enter number of arrays: ");
                int noOfArrays = s.nextInt();

                Integer[][] arrayOfArrays = new Integer[noOfArrays][];
                Integer[] arrayOfArraySize = new Integer[noOfArrays];

                for (int i=0;i<noOfArrays;i++){
                    // Reading number of elements that need to be inserted in the array dynamically.
                    System.out.print("\nEnter the number of elements in array no." + (i+1) + ": ");
                    arrayOfArraySize[i] = s.nextInt();
                    Integer[] inputArray = new Integer[arrayOfArraySize[i]];
            
                    for(int j=0;j<arrayOfArraySize[i];j++){
                        // Reading each value to store in the array.
                        System.out.print("Enter element " + (j+1) + ": ");
                        inputArray[j] = s.nextInt();
                    }
                    arrayOfArrays[i] = inputArray;

                    // Calling the arrayAvg() method to return the average of given array.
                    int resultAvg = arrayAvg(arrayOfArrays[i], arrayOfArraySize[i]);
                    System.out.println("\n\nThe average of array no." + (i+1) + " is " + resultAvg);

                    // Calling the arrayContains() method to check if the given search element is present in the array or not.
                    System.out.print("\n\nEnter a value to search for: ");
                    int searchElement = s.nextInt();
                    Boolean resultContains = arrayContains(arrayOfArrays[i], searchElement);
                    if (resultContains) System.out.print("\nArray no." + (i+1) + " contains " + searchElement);
                    else System.out.println("Array no." + (i+1) + " does not contain " + searchElement);

                    // Calling the arrayReverse() method to return the reverse of the given array.      
                    Integer[] reverseArray = arrayReverse(arrayOfArrays[i]);
                    System.out.println("\nReverse of array no." + (i+1) + " is " + Arrays.toString(reverseArray));
                    System.out.println("--------------------------------------------------------------------------------");
                }
            break;
        }
    }



    static String[] caeserCipher(String stringInput, Integer shiftInput){
        //This method is used to cipher a given string and return the encrypted string as well as decrypted string

        String stringEncrypt = "";
        String stringDecrypt = "";


        for (int j=0;j<stringInput.length();j++){
            // This snippet is used to encrypt each and every character of a String and concatenate it with the variable stringEncrypt
            stringEncrypt += (char)(stringInput.charAt(j) + shiftInput);
        } 

        for (int k=0;k<stringEncrypt.length();k++){
            // This snippet is used to decrypt each and every character of a String and concatenate it with the variable stringEncrypt
            stringDecrypt = stringDecrypt + (char)(stringEncrypt.charAt(k) - shiftInput);
        }

        String[] resultString = new String[] {stringEncrypt, stringDecrypt};
        return resultString;
    }




    static int arrayAvg(Integer[] inputArray, int arraySize){
        // This method returns the average of an array in integer form
        int resultAvg = 0;
        for(int i =0;i<arraySize;i++) resultAvg += inputArray[i];
        resultAvg /= arraySize;
        return resultAvg;
        
    }

    static Boolean arrayContains(Integer[] inputArray, int searchElement){
        // This method returns a boolean output to check if the given search element is present inthe array or not.
        if (Arrays.asList(inputArray).contains(searchElement)) return true;
        else return false;
    }

    static Integer[] arrayReverse(Integer[] inputArray){
        // This method returns the reverse of an array
        Collections.reverse(Arrays.asList(inputArray));
        return inputArray;
    }
}