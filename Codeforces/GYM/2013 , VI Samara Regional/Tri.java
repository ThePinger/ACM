import java.util.*;

public class Tri
{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int x1 = s.nextInt();
    int y1 = s.nextInt();
    int x2 = s.nextInt();
    int y2 = s.nextInt();
    int x3 = s.nextInt();
    int y3 = s.nextInt();
    double a = (Math.pow(x1-x2 , 2) + Math.pow(y1-y2 , 2));
    double b = (Math.pow(x1-x3 , 2) + Math.pow(y1-y3 , 2));
    double c = (Math.pow(x3-x2 , 2) + Math.pow(y3-y2 , 2));
    x1 = s.nextInt();
    y1 = s.nextInt();
    x2 = s.nextInt();
    y2 = s.nextInt();
    x3 = s.nextInt();
    y3 = s.nextInt();
    double a2 = (Math.pow(x1-x2 , 2) + Math.pow(y1-y2 , 2));
    double b2 = (Math.pow(x1-x3 , 2) + Math.pow(y1-y3 , 2));
    double c2 = (Math.pow(x3-x2 , 2) + Math.pow(y3-y2 , 2));
    int cc=0;
    if(a/a2==b/b2 && b/b2==c/c2){
      cc++;
    }
    if(a/a2==b/c2 && b/c2==c/b2){
      cc++;
    }
    if(a/b2==b/c2 && b/c2==c/a2){
      cc++;
    }
    if(a/b2==b/a2 && b/a2==c/c2){
      cc++;
    }
    if(a/c2==b/a2 && b/a2==c/b2){cc++;}
if(a/c2==b/b2 && b/b2==c/a2){cc++;}
if(cc>0)
System.out.print("YES");
else
System.out.println("NO");


  }
}
