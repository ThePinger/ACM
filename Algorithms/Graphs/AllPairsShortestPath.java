
public class AllPairsShortestPath
{

    static int n;
    static int[][] adjMat;

    public static void floydWarshall()
    {
        //When no edge between i,j then adjMat[i][j] = INF 
        for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
    }
}