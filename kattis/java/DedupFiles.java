package edu.usd.codeclub.contest.fall.week2;

import java.io.*;

public class DedupFiles {
	
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int files = Integer.parseInt(read.readLine());
			if(files == 0) break;
			int uniques =0, coll = 0;
			String[] data = new String[files];
			byte[] hash = new byte[files];
			
			for(int i = 0; i<files; i++) {
				data[i] = read.readLine();
				hash[i] = hash(data[i]);
			}
			
			for(int i = 0; i < files; i++) {
				boolean unique = true;
				for(int j=i+1; j<files; j++) {
					if(Byte.compare(hash[j], hash[i]) == 0) {
						if(data[i].equals(data[j])) {
							unique = false;
							continue;
						} else {
							coll++;
						}
					}
				}
				if(unique) uniques++;
			}
			System.out.println(uniques + " " + coll);
		}
	}
	
	private static byte hash(String str) {
		byte[] bytes = str.getBytes();
		byte current = 0;
		for(byte b: bytes) {
			current ^= b;
		}
		return current;
	}
}