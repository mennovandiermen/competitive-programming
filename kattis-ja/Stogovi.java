package edu.usd.codeclub.contest.fall.week2;

import java.io.*;
import java.util.*;

public class Stogovi {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(read.readLine());
		Stack<Integer>[] stacks = new Stack[n+1];
		stacks[0] = new Stack<Integer>();
		for(int i=1; i<= n; i++) {
			String[] step = read.readLine().split(" ");
			
			int v = Integer.parseInt(step[1]);
			if(stacks[v] == null) stacks[i] = new Stack<Integer>();
			else stacks[i] = (Stack<Integer>) stacks[v].clone();
			switch(step[0]) {
				case "a":
					stacks[i].push(i);
					break;
				case "b":
					System.out.println(stacks[i].pop());
					break;
				case "c":
					System.out.println(compareStacks(stacks[i], stacks[Integer.parseInt(step[2])]));
					break;
			}
		}
	}
	
	private static int compareStacks(Stack<Integer> v, Stack<Integer> w) {
		Set<Integer> set = new TreeSet<Integer>();
		Integer[] vi = v.toArray(new Integer[v.size()]);
		Arrays.sort(vi);
		for(Integer wi: w) {
			if(Arrays.binarySearch(vi, wi) >= 0) set.add(wi);
		}
		return set.size();
	}
}