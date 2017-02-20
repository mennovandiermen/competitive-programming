import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static class Node {
        int x, y, p;
        Node (int tx, int ty, int tp) {
            x = tx; y = ty; p = tp;
        }
    }

    private static int findPath(int a, int b, int n) {
        boolean done[][] = new boolean[n][n];
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0, 0));
        done[0][0] = true;
        Node nd;
        while((nd = q.poll()) != null) {
            if(nd.x == n-1 && nd.y == n-1) return nd.p;
                  
            if(nd.x + a < n && nd.y + b < n && !done[nd.x+a][nd.y+b]) {
                q.add(new Node((nd.x+a), (nd.y+b), (nd.p+1)));
                done[nd.x+a][nd.y+b] = true;
            }
            if(nd.x + a < n && nd.y - b >= 0 && !done[nd.x+a][nd.y-b]) {
                q.add(new Node((nd.x+a), (nd.y-b), (nd.p+1)));
                done[nd.x+a][nd.y-b] = true;
            }
            if(nd.x - a >= 0 && nd.y + b < n && !done[nd.x-a][nd.y+b]) {
                q.add(new Node((nd.x-a), (nd.y+b), (nd.p+1)));
                done[nd.x-a][nd.y+b] = true;
            }
            if(nd.x - a >= 0 && nd.y - b >= 0 && !done[nd.x-a][nd.y-b]) {
                q.add(new Node((nd.x-a), (nd.y-b), (nd.p+1)));
                done[nd.x-a][nd.y-b] = true;
            }
            if(nd.x + b < n && nd.y + a < n && !done[nd.x+b][nd.y+a]) {
                q.add(new Node((nd.x+b), (nd.y+a), (nd.p+1)));
                done[nd.x+b][nd.y+a] = true;
            }
            if(nd.x + b < n && nd.y - a >= 0 && !done[nd.x+b][nd.y-a]) {
                q.add(new Node((nd.x+b), (nd.y-a), (nd.p+1)));
                done[nd.x+b][nd.y-a] = true;
            }
            if(nd.x - b >= 0 && nd.y + a < n && !done[nd.x-b][nd.y+a]) {
                q.add(new Node((nd.x-b), (nd.y+a), (nd.p+1)));
                done[nd.x-b][nd.y+a] = true;
            }
            if(nd.x - b >= 0 && nd.y - a >= 0 && !done[nd.x-b][nd.y-a]) {
                q.add(new Node((nd.x-b), (nd.y-a), (nd.p+1)));
                done[nd.x-b][nd.y-a] = true;
            }
        }
        return -1;
    } 

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int a = 1; a < n; a++) {
            for (int b=1; b < n; b++) {
                int path = findPath(a, b, n);
                System.out.printf("%d ", path);
            }
        System.out.println();
        }
    }
}
