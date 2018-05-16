//732
//Anagrams by Stack

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while(sc.hasNext())
        {
            char[] src = sc.next().toCharArray();
            char[] mod = sc.next().toCharArray();
            int[] freq = new int[95];
            int[] freqMod = new int[95];

            for(int i = 0; i < src.length; i++)
                freq[src[i] - '!']++;

            for(int i = 0; i < mod.length; i++)
                freqMod[mod[i] - '!']++;

            boolean flag = true;
            for(int i = 0; i < 26; i++)
                if(freq[i] != freqMod[i])
                    flag = false;

            if(!flag || src.length != mod.length)
            {
                pw.println('[');
                pw.println(']');
                continue;
            }

            TreeSet<String> set = new TreeSet<>();
            Queue<Stack<Character>> possible = new LinkedList<>();
            Queue<StringArr> possibleStrings = new LinkedList<>();
            Stack<Character> tmp = new Stack<>();
            tmp.push(src[0]);
            freq[src[0] - '!']--;
            possible.add(tmp);
            possibleStrings.add(new StringArr(freq, "i", 1, 0));

            while(!possible.isEmpty())
            {
                tmp = possible.poll();
                StringArr tmpArr = possibleStrings.poll();
                for(int i = tmpArr.startMod; i < mod.length; i++)
                {
                    if(tmp.isEmpty() && tmpArr.start != src.length)
                    {
                        tmp.push(src[tmpArr.start]);
                        tmpArr.curString += " i";
                        tmpArr.freq[src[tmpArr.start] - '!']--;
                        tmpArr.start++;
                    }
                    else
                    {
                        char cur = tmp.peek();
                        if(mod[i] == cur)
                        {
                            if(tmpArr.freq[cur - '!'] == 0 || tmpArr.start == src.length)
                            {
                                tmp.pop();
                                tmpArr.curString += " o";
                            }
                            else
                            {
                                Stack<Character> newStack = (Stack) tmp.clone();
                                newStack.push(src[tmpArr.start]);
                                possible.add(newStack);
                                int[] toBeAdded = tmpArr.freq.clone();
                                toBeAdded[src[tmpArr.start] - '!']--;
                                possibleStrings.add(new StringArr(toBeAdded, tmpArr.curString + " i", tmpArr.start + 1, i));
                                tmp.pop();
                                tmpArr.curString += " o";
                            }
                            i++;
                        }
                        else if(tmpArr.start != src.length)
                        {
                            tmp.push(src[tmpArr.start]);
                            tmpArr.curString += " i";
                            tmpArr.freq[src[tmpArr.start] - '!']--;
                            tmpArr.start++;
                        }
                        else break;
                    }
                    i--;
                }

                if(tmpArr.curString.length() == ((src.length * 2) + (src.length * 2) - 1))
                    set.add(tmpArr.curString);
            }

            pw.println('[');
            while(!set.isEmpty())
                pw.println(set.pollFirst());
            pw.println(']');
        }

        pw.flush();
        pw.close();
    }

    static class StringArr
    {
        int start, startMod;
        int[] freq;
        String curString;

        public StringArr(int[] freq, String curString, int start, int startMod)
        {
            this.freq = freq;
            this.curString = curString;
            this.start = start;
            this.startMod = startMod;
        }
    }
}