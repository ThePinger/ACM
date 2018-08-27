import java.util.*;

public class MUH
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer>[] arr = new ArrayList[2001];
		for(int i = 0; i < arr.length; i++)
			arr[i] = new ArrayList<>();
		
		int idx = 1;
		for(int i = 0; i < n; i++)
			arr[sc.nextInt()].add(idx++);
		
		int two = 0;
		int three = 0;
		for(int i = 0; i < arr.length; i++)
			if(arr[i].size() == 2)
				two++;
			else if(arr[i].size() > 2)
				three++;
		
		if(three > 0)
		{
			StringBuilder fir = new StringBuilder();
			StringBuilder tw = new StringBuilder();
			StringBuilder thr = new StringBuilder();
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i].size() > 2)
				{
					fir.append(arr[i].get(0)).append(" ");
					fir.append(arr[i].get(1)).append(" ");
					fir.append(arr[i].get(2)).append(" ");
					tw.append(arr[i].get(1)).append(" ");
					tw.append(arr[i].get(0)).append(" ");
					tw.append(arr[i].get(2)).append(" ");
					thr.append(arr[i].get(1)).append(" ");
					thr.append(arr[i].get(2)).append(" ");
					thr.append(arr[i].get(0)).append(" ");
					for(int j = 3; j < arr[i].size(); j++)
					{
						fir.append(arr[i].get(j)).append(" ");
						tw.append(arr[i].get(j)).append(" ");
						thr.append(arr[i].get(j)).append(" ");
					}
				}
				else
				{
					for(int j = 0; j < arr[i].size(); j++)
					{
						fir.append(arr[i].get(j)).append(" ");
						tw.append(arr[i].get(j)).append(" ");
						thr.append(arr[i].get(j)).append(" ");
					}
				}
			}
			System.out.println("YES");
			System.out.println(fir);
			System.out.println(tw);
			System.out.println(thr);
		}
		else if(two > 1)
		{
			int count = 0;
			StringBuilder fir = new StringBuilder();
			StringBuilder tw = new StringBuilder();
			StringBuilder thr = new StringBuilder();
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i].size() > 1)
				{
					if(count > 0)
					{
						fir.append(arr[i].get(0)).append(" ");
						fir.append(arr[i].get(1)).append(" ");
						tw.append(arr[i].get(0)).append(" ");
						tw.append(arr[i].get(1)).append(" ");
						thr.append(arr[i].get(1)).append(" ");
						thr.append(arr[i].get(0)).append(" ");
					}
					else
					{
						fir.append(arr[i].get(0)).append(" ");
						fir.append(arr[i].get(1)).append(" ");
						tw.append(arr[i].get(1)).append(" ");
						tw.append(arr[i].get(0)).append(" ");
						thr.append(arr[i].get(0)).append(" ");
						thr.append(arr[i].get(1)).append(" ");
					}
					
					count++;
				}
				else
				{
					for(int j = 0; j < arr[i].size(); j++)
					{
						fir.append(arr[i].get(j)).append(" ");
						tw.append(arr[i].get(j)).append(" ");
						thr.append(arr[i].get(j)).append(" ");
					}
				}
			}
			System.out.println("YES");
			System.out.println(fir);
			System.out.println(tw);
			System.out.println(thr);
		}
		else
			System.out.println("NO");			
	}
}