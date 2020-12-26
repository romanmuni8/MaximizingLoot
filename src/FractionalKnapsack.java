import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        int i = values.length;
        int bestLoot;
        while(capacity>0){
            bestLoot = BestItem(values, weights);
            if(bestLoot==-1){
                return Math.round(value*10000)/10000.0d;
            }
            if( weights[bestLoot]<=capacity){
                value+=values[bestLoot];
                capacity -=weights[bestLoot];
                weights[bestLoot] =0;
                values[bestLoot]= 0;

            }else{
                double perPound = (double)values[bestLoot]/(double)weights[bestLoot];
                double newValue = capacity*perPound;
                value += newValue;
                capacity=0;

                weights[bestLoot]-=capacity;
                values [bestLoot]-=newValue;
            }

        }
        //write your code here

        return Math.round(value*10000)/10000.0d;
    }
    //this method will return the best item in terms of its value per weight
    private static int BestItem(int []values, int [] weights ){
        double maxValuePerWeight = 0;
        int bestItem = -1;
        for( int i =0; i<values.length;i ++){
            if( weights[i]!= 0 && ((double)values[i]/(double)weights[i])>maxValuePerWeight){
             bestItem = i;
             maxValuePerWeight = (double)values[i]/(double)weights[i];
            }
        }

        return bestItem;
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 