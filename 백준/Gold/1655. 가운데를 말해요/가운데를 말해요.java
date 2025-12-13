import java.util.*;

import javax.print.StreamPrintService;

import java.io.*;


public class Main{  

    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;

        int n= Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ= new PriorityQueue<>();
        PriorityQueue<Integer> maxQ= new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            int temp= Integer.parseInt(br.readLine());
            if(i%2==0){
                maxQ.add(temp);
            }   
            else{
                minQ.add(temp);
            }

            if(minQ.size()!=0){
                int front = maxQ.peek();
                int back = minQ.peek();
                if(front>back){
                    minQ.remove();
                    maxQ.remove();
                    maxQ.add(back);
                    minQ.add(front);
                }       
            }
            System.out.println(maxQ.peek());

        }



    }
}

/*
 * 1 -> 
 * 1 5 -> 
 * 1 2 5 -> 
 * 1 2 5 10 ->  
 * -99 1 2 5 10 -> 2 = 5/2
 * -99 1 2 5 7 10
 * -99 1 2 5 5 7 10
 * 
 */