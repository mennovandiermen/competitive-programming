/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kattis;

import java.io.*;
import java.util.*;

/**
 *
 * @author Menno.VanDiermen
 */
public class VirtualFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int cases = Integer.parseInt(read.readLine());
        Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        for(int i=0; i<cases; i++) {
            int lines = Integer.parseInt(read.readLine());
            
            for(int j=0; j<lines; j++) {
                String[] friends = read.readLine().split(" ");
                HashSet<String> f0 = map.get(friends[0]); 
                if(f0 == null) map.put(friends[0], new HashSet());
                map.get(friends[0]).add(friends[1]);
                
                HashSet<String> f1 = map.get(friends[1]); 
                if(f1 == null) map.put(friends[1], new HashSet());
                map.get(friends[1]).add(friends[0]);
                
                HashSet<String> out = new HashSet<String>(map.get(friends[0]));
                for(String f: map.get(friends[0])) {
                    out.addAll(map.get(f));
                }
                System.out.println(out.size());
            }
        }
    }
}
