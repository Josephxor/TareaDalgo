package uniandes.algorithms.CaminosMinimos;

import uniandes.EstructurasDatos.Graph;

import java.util.Arrays;

import uniandes.EstructurasDatos.Edge;

public class FloydWarschall implements CostosMinimos{

	@Override
	public void sort(int[][] sort) {


	}
	
	
	public void floydWarshall(int[][] sort) {
		 
        Integer v = sort.length;
		double[][] dist = new double[v][v];
        for (double[] row : dist)
            Arrays.fill(row, Double.POSITIVE_INFINITY);
 
        for (int[] w : sort)
            dist[w[0] - 1][w[1] - 1] = w[2];
 
        int[][] next = new int[v][v];
        
        for (int i = 0; i < next.length; i++) {
            for (int j = 0; j < next.length; j++)
                if (i != j)
                    next[i][j] = j + 1;
        }
 
        for (int k = 0; k < v; k++)
            for (int i = 0; i < v; i++)
                for (int j = 0; j < v; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
 
    }

}
