// Assignment #: 9
//         Name: Tianchen Mu
//    StudentID: 1215686342
//      Lecture: M/W 16:35-17:50
//  Description: The Assignment 9 is a program that reads in a sequence of integers
//               from standard input until 0 is read, and store them in an array (including 0). Then compute the
//               minimum number, count odd integers, compute the sum of numbers that are larger than the first number
//               in the array, and compute the largest even integer in the sequence using recursion. The program should
//               output the results of those calculations to standard output. The program will continue to read in
//               numbers until the number 0 is entered.


import java.io.*;

public class Assignment9 {

 // main: read the inputs, store the numbers, call other methods, print the results
 public static void main(String[] args) {
  InputStreamReader seq = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(seq);

  try {                           // initialize all the variables
   int[] numbers = new int[100]; // the array will be use to store the input int numbers
   int temp = 0;
   int count = 0;
   String line;

   do {                             // 0 also needs to be read in
    line = buf.readLine();
    temp = Integer.parseInt(line); // turn the input into int numbers
    numbers[count] = temp;
    count++;
   }
   while (line.equals("0") == false); // do first so the first item can be stored into the array

    // print out the results, call other methods
    System.out.println("The minimum number is " + findMin(numbers, 0, count-1)  +
            "\n" +
            "The count of odd integers in the sequence is " + countOddNumbers(numbers, 0, count-1) +
            "\n" +
            "The largest even integer in the sequence is " + computeLargestEven(numbers, 0, count-1) +
            "\n" +
            "The sum of numbers larger than the first is " + sumOfNumbersLargerThanFirst(numbers, 0, count-1, numbers[0]));

   seq.close();
   buf.close();  // close the stream reader and buffer reader
   }

   catch (IOException e) { // catch IOException
    e.printStackTrace();
   }
   catch (NumberFormatException e) { // catch exception: unable to turn the input string into integer
    e.printStackTrace();
   }
  }// end of the main method


 // 1. compute the minimum number with recursion
 public static int findMin(int[] numbers, int startIndex, int endIndex) {
  if (startIndex == numbers.length - 1) {  // only 1 item in the array, or found the minimal int
   return numbers[startIndex];
  }
  int result_findMin = findMin(numbers, startIndex + 1, endIndex); // move forward 1 index in the array
  if (numbers[startIndex] < result_findMin) { // recursion
   return numbers[startIndex];
  }
  else {
   return result_findMin;
  }
 }

 // 2. count odd integers with recursion
 public static int countOddNumbers(int[] elements, int startIndex, int endIndex){
  int countOdd = 0;
  if(startIndex >= endIndex){  // when there is only 1 number in the array. And the number 0 is an even number
   return 0;
  }
  int result_countOdd = countOddNumbers(elements, startIndex + 1, endIndex);
  if(elements[startIndex] % 2 != 0) // check if it's odd number
  {
   countOdd++;
  }
  return countOdd+result_countOdd; // always returned the entire result
 }

// 3. compute the largest even integer in the array using recursion
 public static int computeLargestEven(int[] elements, int startIndex, int endIndex){
  if (startIndex >= endIndex){
   return 0;
  }
  int result_MaxEven = computeLargestEven(elements, startIndex + 1, endIndex);
  if(elements[startIndex] % 2 != 0 || elements[startIndex] < result_MaxEven){  // OR operation, not return any odd number
   return result_MaxEven;
  }
  else if(elements[startIndex] % 2 == 0){ // when elements[startIndex] > result_MaxEven
   return elements[startIndex];
  }
  else {
   return result_MaxEven; // close the method, every case has a return
  }
 }

// 4. compute the sum of numbers that are larger than the first number in the array with recursion
 public static int sumOfNumbersLargerThanFirst(int[] elements, int startIndex, int endIndex, int firstNumber){
  if (startIndex >= endIndex){
   return 0;
  }
  int result_SumLargerThenFirst = sumOfNumbersLargerThanFirst(elements, startIndex + 1, endIndex, firstNumber);

  if(elements[startIndex] > firstNumber){
   result_SumLargerThenFirst = result_SumLargerThenFirst + elements[startIndex];
  }
  return result_SumLargerThenFirst; // always return
 }
}