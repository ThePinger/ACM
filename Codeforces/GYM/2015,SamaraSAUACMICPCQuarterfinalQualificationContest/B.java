import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class B {

	
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		char[][]s=new char[n][m];
		PrintWriter pw = new PrintWriter(System.out);
		TreeMap<String, Integer>tm=new TreeMap<>();
		for(int i=0;i<n;i++)
		{
			String s1=br.readLine();
			s[i]=s1.toCharArray();
			int o=0;
			for(int j=0;j<m;j++)
			{
				if(s[i][j]=='1')
					o++;
			}
			if(o>=8 && o<=15)
				tm.put(s1, tm.getOrDefault(s1, 0)+1);
		}
		
	
		String ans = "";
		int max = 0;
		
		if(tm.isEmpty())
		{
			for(int i = 0; i < 8; i++)
				{pw.print(1);}
			for(int i=0;i<m-8;i++)
				{pw.print(0);}
			pw.close();
			return;
		}
		
		for(java.util.Map.Entry<String, Integer> e:tm.entrySet())
		{
			int maxtmp=e.getValue();
			if(maxtmp>max)
			{
				max=maxtmp;
				ans=e.getKey();
			}
		}
		pw.println(ans);
		pw.close();
	}
	
}