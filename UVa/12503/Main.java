//12503
//Robot instructions
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
  static int pos;
  static ArrayList <String> inst;
  public static void makeMove(String s)
  {
    switch(s)
    {
      case "LEFT" : pos--;
                    inst.add(s);
                    break;
      case "RIGHT": pos++;
                    inst.add(s);
                    break;
    }
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ; i++)
    {
      int p = Integer.parseInt(br.readLine());
      inst = new ArrayList<String>();
      String[] s;
      pos = 0;
      for(int c = 0 ; c < p ; c++)
      {
        s = br.readLine().split(" ");
        if(s.length == 1)
          makeMove(s[0]);
        else
        {
          int tmp = Integer.parseInt(s[2]);
          makeMove(inst.get(tmp-1));
        }
      }
      System.out.println(pos);
    }
  }
}
