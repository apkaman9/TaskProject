package com.example.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String tweet=sc.nextLine();
		Map<String, Integer> tweetCount=new LinkedHashMap<>();
		String[] tweetWords=tweet.split("\\s");
		for(String word:tweetWords) {
			if(word.startsWith("#")) {
				int count=0;
				if(tweetCount.containsKey(word)) {
					count=tweetCount.get(word);
				}
				count++;
				tweetCount.put(word, count);
			}
		}
		Map<String, Integer> sortedTweetCount=sortByValue(tweetCount);
		List<String> topTweets=new ArrayList<>(sortedTweetCount.keySet());
		for(int i=0;i<10&&i<topTweets.size();i++) {
			System.out.println(topTweets.get(i));
		}
		
		sc.close();

	}
	
	public static Map<String, Integer> sortByValue(Map<String, Integer> hm) 
    { 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        Map<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

}
