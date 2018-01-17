//11341
//Term Strategy

import java.text.DecimalFormat;
import java.util.*;

public class Main 
{
    static int courses, hours;
    static double[][] grade, memo;

    public static double dp(int course, int hour)
    {
        if(course == courses)
        {
            if(hour <= hours)
                return 0;
            return -1e9;
        }

        if(hour >= hours)
            return -1e9;

        if(memo[course][hour] != -1)
            return memo[course][hour];

        double ans = -1e9;
        for(int i = 0; i < hours; i++)
            if(grade[course][i] > 4)
                ans = Math.max(ans, grade[course][i] + dp(course + 1, hour + i + 1));

        return memo[course][hour] = ans;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        
        while(t-->0)
        {
            courses = sc.nextInt();
            hours   = sc.nextInt();
            grade = new double[courses][hours];
            for(int i = 0; i < courses; i++)
                for(int j = 0; j < hours; j++)
                    grade[i][j] = sc.nextInt();

            memo = new double[courses][hours];
            for(double[] xx : memo)
                Arrays.fill(xx, -1);

            double ans = dp(0, 0);
            if(ans < 0)
                sb.append("Peter, you shouldn't have played billiard that much.\n");
            else
            {
                DecimalFormat df = new DecimalFormat("#0.00");
                sb.append("Maximal possible average mark - " + df.format(Math.round(100.0 * ans / courses) / 100.0) + ".\n");
            }
        }
        System.out.print(sb);
    }
}
