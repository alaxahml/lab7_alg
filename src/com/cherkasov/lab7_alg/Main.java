package com.cherkasov.lab7_alg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int from,to,size;
        List<List<Integer>> distances = new ArrayList<>();
        List<List<Integer>> pathes = new ArrayList<>();
        System.out.print("size: ");
         size = in.nextInt();

        for(int i = 0;i < size;++i){
            pathes.add(new ArrayList<>());
            for(int j = 0;j < size;++j){
                pathes.get(i).add(j);
            }

        }
        for(int i = 0;i < size;++i){
            distances.add(new ArrayList<>());
            for(int j = 0;j < size;++j){
                distances.get(i).add(0);
            }
        }
        for(int i = 0;i < size;++i){
            distances.add(new ArrayList<>());
            distances.get(i).set(i,-1);
        }
        for(int i = 0;i < size;++i){
            for(int j = 0;j < i;++j){
                System.out.println("distance "+ i+"-"+j+": ");
                int temp = in.nextInt();
                distances.get(i).set(j,temp);
                distances.get(j).set(i,temp);
            }
        }
        for(int blocked = 0;blocked < size;++blocked){
            for(int i = 0;i < size;++i){
                for (int j = 0;j < size;++j){
                    if(j == blocked || i == blocked){
                        continue;
                    }
                    if (distances.get(i).get(j) > distances.get(i).get(blocked) + distances.get(blocked).get(j)){
                        distances.get(i).set(j,distances.get(i).get(blocked) + distances.get(blocked).get(j));
                        pathes.get(i).set(j,blocked);
                    }
                }
            }
        }

        System.out.println("from: ");
        from = in.nextInt();
        System.out.println("to: ");
        to = in.nextInt();

        int temp1 = from;
        System.out.println(temp1);
        while(temp1 != to){
            System.out.println("then ");
            temp1 = pathes.get(temp1).get(to);
            System.out.println(temp1);
        }




    }
}
