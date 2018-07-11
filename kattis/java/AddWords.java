package edu.usd.codeclub.contest.fall.week2;

import java.io.*;
import java.util.*;

public class AddWords {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> words = new HashMap<String, Integer>(2002);
		Map<Integer, String> nums = new HashMap<Integer, String>(2002);
		
		String line;
		while((line = read.readLine()) != null) {
			String[] operands = line.split(" ");
			String cmd = operands[0];
			switch(cmd) {
			case "def":
				String name = operands[1]; Integer num = Integer.parseInt(operands[2]);
				words.remove(name); words.put(name, num); 
				nums.remove(num); nums.put(num, name);
				break;
			case "calc":
				try {
					int sum = words.get(operands[1]);
					for(int i = 2; i<operands.length; i += 2) {
						switch(operands[i]) {
						case "-":
							sum -= words.get(operands[i+1]);
							break;
						case "+":
							sum += words.get(operands[i+1]);
							break;
						case "=":
							if(nums.get(sum) == null) throw new Exception();
							System.out.println(line.substring(cmd.length()).trim() + " " + nums.get(sum));
							break;
						}
					}
				} catch(Exception e) {
					System.out.println(line.substring(cmd.length()) + " unknown");
				}
				break;
			case "clear":
				words.clear(); nums.clear();
				break;
			}
		}
	}
}
