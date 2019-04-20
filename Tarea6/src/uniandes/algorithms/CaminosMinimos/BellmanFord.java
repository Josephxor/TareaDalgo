package uniandes.algorithms.CaminosMinimos;

import uniandes.EstructurasDatos.Edge;
import uniandes.EstructurasDatos.Graph;

/**
 * Algoritmo BellmanFord para caminos de costos mínimos
 * @author Joseph Ortiz - Juan Sebastian Vaca
 */

public class BellmanFord implements CostosMinimos {
	
	
	public Graph rta;
	//Acá tomo la matriz que me da el usuario y llamo al método que la convierte en grafo
	//Por cada vertice del grafo llamo una vez al método bellman ford
	public void sort(int[][] sort) {
		
		Graph nu = matrixToGraph(sort);
		
		rta = new Graph(nu.V, nu.V);
		
		for(int i = 0; i<nu.V;i++)
		{
			Integer no = nu.vertex[i];
			BellmanFord(nu, no);
		}
	}

	/**
	 * 
	 * @param graph
	 * @param src 
	 */
	public void BellmanFord(Graph graph, int src)
	{	
		//Representa el número de vértices y ejes
		Integer V = graph.V, E = graph.E; 
		//Representa la distancia entre los vértices
		int dist[] = new int[V]; 

		// Paso 1: Inicializo la distancia de todos los vertices como infinito
		for (int i=0; i<V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[src] = 0; 

		// Paso 2:
		// El camino más corto desde el vertice src hasta cualquier otro vertice
		// tiene al menos V-1 ejes
		for (int i=1; i<V; ++i) 
		{ 
			for (int j=0; j<E; ++j) 
			{ 
				//Ubicado en el eje j pido de donde a donde va y su peso
				int u = graph.edge[j].src; 
				int v = graph.edge[j].dest; 
				int weight = graph.edge[j].weight; 
				
				//Si el valor desde src no es infinito 
				//La distancia hasta el vertice más el peso es menor, cambio
				if (dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]) {
					
					dist[v]=dist[u]+weight;
					Edge nu = new Edge(u, v, weight);
					rta.addEdge(nu);
				}
			} 
		} 

		// Step 3: Miro que no hallan ciclos negativos, si el valor es menor, es un ciclo negativo 
		for (int j=0; j<E; ++j) 
		{ 
			int u = graph.edge[j].src; 
			int v = graph.edge[j].dest; 
			int weight = graph.edge[j].weight; 
			
			if (dist[u] != Integer.MAX_VALUE && dist[u]+weight < dist[v]) 
				System.out.println("El grafo contiene un ciclo negativo"); 
		}
	}
	
	/**
	 * Método encargado de convertir una matriz en un grafo
	 * @param matrix Matriz que representa el peso de ir desde un vertice i hasta un vertice j
	 * @return Retorna un grafo con los vertices y ejes definidos
	 */
	public Graph matrixToGraph(int[][] matrix) {

		Graph ne = new Graph(matrix[0].length, matrix.length );

		for(int i= 0; i< matrix[0].length; i ++)
		{
			ne.addVertex(i);
			
			for(int j= 0; j< matrix.length; j++)
			{
				if(matrix[i][j]!=-1)
				{
					Edge ed = new Edge(i,j,matrix[i][j]);
					ne.addEdge(ed);
				}
			}
		}
		return ne;
	}

}
