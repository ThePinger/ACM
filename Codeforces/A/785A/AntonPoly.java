//Anton and polyhedrons
import java.io.*;

public class AntonPoly
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    long sum = 0 ;
    for(long i = 0 ; i < n ; i++)
    {
      String s = br.readLine();
      switch(s)
      {
        case "Tetrahedron" : sum += 4; break;
        case "Cube"        : sum += 6; break;
        case "Octahedron"  : sum += 8; break;
        case "Dodecahedron": sum += 12; break;
        case "Icosahedron" : sum += 20; break;
      }
    }
    System.out.println(sum);
  }
}
