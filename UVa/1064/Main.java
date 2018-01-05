//1064
//Network

import java.io.*;
import java.util.*;

public class Main
{

    static int[] order, msgSize;
    static int end, buffer, messages;
    static PacketInfo[] packets;
    static boolean[] added;
    static boolean[][] bytes;

    public static void orders(int i)
    {
        if(i == messages)
        {
            buffer = Math.min(buffer, bufferSize());
            return;
        }

        for(int j = 0; j < messages; j++)
        {
            if(!added[j])
            {
                added[j] = true;
                order[i] = j;
                orders(i + 1);
                added[j] = false;
            }
        }
    }

    public static int bufferSize()
    {
        int j = 1;
        int max = 0;
        int bufferSize = 0;
        int msg = order[0];
        int[] byteExpected = new int[messages];
        bytes = new boolean[messages][];
        for(int i = 0; i < messages; i++)
            bytes[i] = new boolean[msgSize[i]];

        for(PacketInfo x : packets)
        {
            for(int i = x.startByte; i <= x.endByte; i++)
                bytes[x.msgNumber][i] = true;
            
            bufferSize += (x.endByte - x.startByte + 1);
            if(x.msgNumber == msg)
            {
                if(x.startByte == byteExpected[x.msgNumber])
                {
                    for(int i = x.startByte; i <= bytes[x.msgNumber].length; i++)
                    {
                        if(i < bytes[x.msgNumber].length && bytes[x.msgNumber][i]) bufferSize--;
                        else
                        {
                            byteExpected[x.msgNumber] = i;
                            break;   
                        }
                    }

                    if(byteExpected[x.msgNumber] == msgSize[x.msgNumber])
                    {
                        if(j < order.length) msg = order[j++];
                        else break;
                        while(j <= order.length)
                        {
                            for(int i = 0; i < bytes[msg].length; i++)
                            {
                                if(i < bytes[msg].length && bytes[msg][i]) bufferSize--;
                                else
                                {
                                    byteExpected[msg] = i;
                                    break;   
                                }
                            }
                            if(byteExpected[msg] == msgSize[msg])
                                if(j < order.length) msg = order[j++];
                                else break;
                            else break;
                        }
                    }
                }
            }
            max = Math.max(max, bufferSize);           
        }
        return max;
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            messages = n;
            buffer = (int) 1e9;
            msgSize = new int[n];
            packets = new PacketInfo[m];
            order   = new int[n];
            added   = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                msgSize[i] = Integer.parseInt(st.nextToken());
            
            for(int i = 0; i < m; i++)
            {
                st = new StringTokenizer(br.readLine());
                int msgNumber = Integer.parseInt(st.nextToken()) - 1;
                int startByte = Integer.parseInt(st.nextToken()) - 1;
                int endByte   = Integer.parseInt(st.nextToken()) - 1;
                packets[i] = new PacketInfo(msgNumber, startByte, endByte);
            }
            orders(0);
            System.out.print("Case " + (t++) + ": " + buffer + "\n\n");
        }

        //System.out.print(sb);
    }

    static class PacketInfo
    {
        int msgNumber;
        int startByte;
        int endByte;

        public PacketInfo(int x, int y, int z)
        {
            this.msgNumber = x;
            this.startByte = y;
            this.endByte   = z;
        }
    }
}