import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class J 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Node[] arr = new Node[n];
		for(int i = 0; i < n; i++)
			arr[i] = new Node(Integer.parseInt(st.nextToken()));
		
		for(int i = 1; i < n; i++)
		{
			arr[i - 1].right = arr[i];
			arr[i].left = arr[i - 1];
		}
		
		Node cur = arr[p - 1];
		int q = Integer.parseInt(br.readLine());
		while(q-->0)
		{
			st = new StringTokenizer(br.readLine());
			String move = st.nextToken();
			if(move.equals("moveLeft"))
			{
				if(cur.left != null)
					cur = cur.left;
			}
			else if(move.equals("moveRight"))
			{
				if(cur.right != null)
					cur = cur.right;
			}
			else if(move.equals("insertLeft"))
			{
				Node tmp = new Node(Integer.parseInt(st.nextToken()));
				tmp.right = cur;
				tmp.left = cur.left;
				if(cur.left != null)
					cur.left.right = tmp;
				cur.left = tmp;
			}
			else if(move.equals("insertRight"))
			{
				Node tmp = new Node(Integer.parseInt(st.nextToken()));
				tmp.left = cur;
				tmp.right = cur.right;
				if(cur.right != null)
					cur.right.left = tmp;
				cur.right = tmp;
			}
			else pw.println(cur.val);
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Node
	{
		int val;
		Node left, right;
		
		public Node(int val)
		{
			this.val = val;
		}
	}
}
