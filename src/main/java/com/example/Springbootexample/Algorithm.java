package com.example.Springbootexample;

import java.util.HashMap;
import java.util.Map;

public class Algorithm {
    public static void main(String[] args) {
        reversString("timothy");


    }

    public static int mostFrequentBird(int[] sightings){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i< sightings.length; i++){
            int birdType = sightings[i];

            if (counts.containsKey(birdType)){
                counts.put(birdType, counts.get(birdType)+1);
            }else {
                counts.put(birdType, 1);
            }
        }
        int maxCount = 0;
        int maxBirdType = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()){
            int birdType = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount){
                maxCount = count;
                maxBirdType = birdType;
            }else if (count == maxCount){
                maxBirdType = Math.min(maxBirdType, birdType);
            }
        }

        return maxBirdType;
    }



    public static int countPairs(int[] arr, int k){
        int count = 0;
        Map<Integer, Integer> remainderFreq = new HashMap<>();

        for(int num : arr){
            int remainder = num % k;
            int complement = (k - remainder) % k;

            count = count + remainderFreq.getOrDefault(complement, 0);

            remainderFreq.put(remainder, remainderFreq
                    .getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public static void reversString(String str){

        char[] charArray = str.toCharArray();

        for (int i = charArray.length-1; i >= 0; i--){

            System.out.print(charArray[i]);
        }

    }

}
