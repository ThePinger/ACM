import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class L
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		int[] cumm = new int[100001];
		int[] primes = new int[]{2, 3, 5, 7, 11, 13};
		
		for(int i = 1; i < cumm.length; i++)
		{
			int tmp = Integer.bitCount(i);
			boolean flag = false;
			for(int j = 0; j < primes.length; j++)
				if(primes[j] == tmp)
					flag = true;
			
			if(flag) cumm[i]++;
			cumm[i] += cumm[i - 1];
		}
		
		while(t-->0)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			pw.println(cumm[r] - cumm[Math.max(0, l - 1)]);
		}
		
		pw.flush();
		pw.close();
	}
}