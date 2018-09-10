
import java.io.*;
import java.util.*;

public class A 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			PriorityQueue<Score> pq = new PriorityQueue<>();
			while(n-->0)
				pq.add(new Score(sc.next(), sc.nextInt(), sc.nextInt()));
			pw.println(pq.peek().name);
		}
		
		pw.flush();
		pw.close();
	}
	
	static class Score implements Comparable<Score>
	{
		String name;
		int prob, pen;
		
		public Score(String name, int prob, int pen)
		{
			this.name = name;
			this.prob = prob;
			this.pen = pen;
		}
		
		public int compareTo(Score s)
		{
			if(this.prob == s.prob)
				return this.pen - s.pen;
			return s.prob - this.prob;
		}
	}
}
