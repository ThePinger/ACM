import java.io.*;
import java.util.*;

public class Main2
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    String s=br.readLine();
    char t=s.charAt(s.length()-1);
    //s=s.substring(0,s.length());
    if(t=='?')
      System.out.println(7);
    else{
      String[] sa=s.split(" ");
      boolean f=false;
      for(int i=0;i<sa.length;i++){
        if(sa[i].equals("Sussu") || sa[i].equals("Sussu!") || sa[i].equals("Sussu.")){
         f=true;
      }
    }
      if(f)
      System.out.println("AI SUSSU!");
      else
      System.out.println("O cara é bom!");
    }
  }
}
