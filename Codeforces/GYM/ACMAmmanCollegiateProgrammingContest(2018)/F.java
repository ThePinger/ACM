import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class F 
{
	static void cal(int x)
	{
		ArrayList<Integer>tmp=new ArrayList<>();
		for(int i=1;i*i<=x;i++)
		{
			if(x%i==0)
			{
				hs[x].add(i);
				if(x/i!=i)
					tmp.add(x/i);
			}
		}
		for(int i=tmp.size()-1;i>=0;i--)
			hs[x].add(tmp.get(i));
	}
	static ArrayList<Integer>[]hs;
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int t = Integer.parseInt(br.readLine());
		boolean f[]=new boolean[1000001];
		hs=new ArrayList[1000001];
		for(int i=0;i<1000001;i++)
			hs[i]=new ArrayList<>();
		while(t-->0)
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			HashSet<Integer>num=new HashSet<>();
			ArrayList<Integer> arr = new ArrayList<>();
			int[]a=new int[1000001];
			while(st.hasMoreTokens())
			{	
				int x=Integer.parseInt(st.nextToken());
				arr.add(x);
				num.add(x);
			}
			
			long sum = 0;
			for(int i = 0; i < n; i++)
				sum += arr.get(i);
			
			Collections.sort(arr);
			
			for(int i = 0; i < n; i++)
			{
				int x=arr.get(i);
				if(!f[x])
				{
					cal(x);
					f[x]=true;
				}
				if(a[x]==0)
				{	
					for(int z:hs[x])
						if(num.contains(z))
						{
							sum-=x;
							sum+=z;
							a[x]=z;
							break;
						}
					if(a[x]==0)
						a[x]=-1;
				}
				else if(a[x]!=-1)
				{
					sum-=x;
					sum+=a[x];
				}
			}
			
			pw.println(sum);
		}
		
		pw.flush();
		pw.close();
	}

}
