package edu.usd.codeclub.contest.fall.week2;

import java.io.*;
import java.util.*;

public class MovieStack {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(read.readLine());
		for(int c=0; c<cases; c++) {
			String[] mr = read.readLine().split(" ");
			String[] a = read.readLine().split(" ");
			int m = Integer.parseInt(mr[0]), r = Integer.parseInt(mr[1]);
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int n = 0; n<m; n++) list.add(n+1);
			String out = "";
			for(int i=0; i<a.length; i++) {
				int ai = Integer.parseInt(a[i]);
				int idx = list.indexOf(ai);
				out += idx+" ";
				list.add(0, list.remove(idx));
			}
			System.out.println(out.trim());
		}
	}
}
