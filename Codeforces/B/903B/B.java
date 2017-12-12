
import java.util.*;

public class B
{
  public static void main(String[] args)
  {
      Scanner sc = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();
      int vovaHealth = sc.nextInt();
      int vovaAttack = sc.nextInt();
      int healing    = sc.nextInt();
      int monsterHealth = sc.nextInt();
      int monsterAttack = sc.nextInt();
      int lines = 0;

      while(monsterHealth > 0)
      {
        if(vovaAttack >= monsterHealth){ sb.append("STRIKE" + "\n"); monsterHealth -= vovaAttack;}
        else if(vovaHealth <= monsterAttack){ sb.append("HEAL" + "\n"); vovaHealth += healing;}
        else{sb.append("STRIKE" + "\n"); monsterHealth -= vovaAttack;}
        vovaHealth -= monsterAttack;
        lines++;
      }

      System.out.println(lines);
      System.out.print(sb);

  }
}
