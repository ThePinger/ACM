//467A
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Accomodation
{

  public static int numRooms(ArrayList <Integer> rooms)
  {
    int c = 0 ;
    for(int i = 0 ; i < rooms.size() ; i++)
    {
      if(rooms.get(i+1) - rooms.get(i) >= 2)
        c++;
      i++;
    }
    return c;
  }

  public static void main(String[] args)throws IOException
  {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr, 16 * 1024);
    String[] line0 = br.readLine().split(" ");
    int a = Integer.parseInt(line0[0]);
    ArrayList<Integer> rooms = new ArrayList<Integer>();
    for(int i = 0 ; i < a ; i++)
    {
       String[] line1 = br.readLine().split(" ");
       rooms.add(Integer.parseInt(line1[0]));
       rooms.add(Integer.parseInt(line1[1]));
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(numRooms(rooms));
    pw.close();
  }
}
