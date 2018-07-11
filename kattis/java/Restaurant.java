package edu.usd.codeclub.contest.fall.week2;

import java.io.*;
import java.util.*;

public class Restaurant {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int orders = Integer.parseInt(read.readLine());
			if(orders == 0) break;
			int p1 = 0, p2 = 0;
			for(int i=0; i<orders; i++) {
				String[] line = read.readLine().split(" ");
				int plates = Integer.parseInt(line[1]);
				switch(line[0]) {
					case "DROP":
						p2 += plates;
						System.out.println("DROP 2 "+plates);
						break;
					case "TAKE":
						if(p1 > 0) {
							if(p1 >= plates) {
								System.out.println("TAKE 1 "+plates);
								p1 -= plates;
							} else {
								System.out.println("TAKE 1 "+p1);
								plates -= p1; p1=0;
								System.out.println("MOVE 2->1 "+p2);
								p1 += p2;
								p2 = 0;
								System.out.println("TAKE 1 "+plates);
								p1 -= plates;
							}	
						} else {
							System.out.println("MOVE 2->1 "+p2);
							p1 += p2; p2 = 0;
							System.out.println("TAKE 1 "+plates);
							p1 -= plates;
						}
						break;
				}
			}
			System.out.println();
		}
	}
}
