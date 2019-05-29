public class MinMax {
  public static double minMaxAverage(int[] numbers) {
    // TODO: write code to find min and max as specified in the handout
    // replace the following code with your implementation
    int c=0;
    int[] max; //Stores an array of max between two numbers
    int[] min; //Stores an array of min between two numbers
    int myMin = 0; //Initial minimum
    int myMax = 5; //Initial maximum
    if(numbers.length%2==0) { //If number of numbers is even
      max = new int[numbers.length/2]; //Let length of max array be half of the initial array
      min = new int[numbers.length/2]; //Let length of min array be half of the initial array
      for (int i = 0; i < numbers.length; i += 2) {
        if (numbers[i] > numbers[i + 1]) { //Check which number is bigger between two numbers and store it in min and max array
          max[c] = numbers[i];
          min[c] = numbers[i + 1];
        }
        else{
          max[c] = numbers[i+1];
          min[c] = numbers[i ];
        }
        c++;         //counter
      }
    }
    else{                //If number of numbers is even
      max = new int[numbers.length/2+1]; //Let length of max array be half+1 of the initial array
      min = new int[numbers.length/2+1]; //Let length of min array be half+1 of the initial array
      for (int i = 0; i < numbers.length-1; i += 2) {
        if (numbers[i] > numbers[i + 1]) { //Check which number is bigger between two numbers and store it in min and max array
          max[c] = numbers[i];
          min[c] = numbers[i + 1];
        }
        else{
          max[c] = numbers[i+1];
          min[c] = numbers[i];
        }
        c++;       //counter
      }
      max[max.length-1]=numbers[numbers.length-1]; //For odd assigning the last number to max
      min[min.length-1]=numbers[numbers.length-1]; //For odd assigning the last number to min
    }
    myMax=max[0];
    for(int i=0;i<max.length;i++){
      if(max[i]>myMax){ //Finds the maximum number in the array max
        myMax=max[i];


      }
    }
    myMin=min[0];
    for(int i=0;i<min.length;i++){
      if(min[i]<myMin){ //Finds the minimum number in the array min
        myMin=min[i];


      }
    }
    return (myMin + myMax)/2.0; //Returns the average of min and max number
  }
}
