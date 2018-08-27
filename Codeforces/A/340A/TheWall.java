import java.io.*;
import java.util.*;

public class TheWall 
{
	
    public static int gcd(int n, int m)
    {
        return m == 0 ? n : gcd(m, n % m);
    }

    public static int lcm(int n, int m)
    {
        return n * (m / gcd(n, m));
    }
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int lcm = lcm(x, y);
		int count = b / lcm;
		count -= a / lcm;
		if(a % lcm == 0) count++;
		
		pw.println(count);
		pw.flush();
		pw.close();
	}

}