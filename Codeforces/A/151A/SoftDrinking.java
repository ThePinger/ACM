//151A
//Soft Drinking

import java.util.*;

public class SoftDrinking
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        int bottles = sc.nextInt();    
        int milliliters = sc.nextInt();    
        int limes = sc.nextInt();    
        int slices = sc.nextInt();    
        int grams = sc.nextInt();    
        int nl = sc.nextInt();    
        int np = sc.nextInt();
        
        int litersNeed = (bottles * milliliters) / nl;
        int totalLime  = limes * slices;
        int saltNeed   = grams / np;

        System.out.println(Math.min(litersNeed, Math.min(totalLime, saltNeed)) / n);
    }
}