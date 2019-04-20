package uniandes.algorithms.CaminosMinimos;

import uniandes.EstructurasDatos.Edge;
import uniandes.EstructurasDatos.Graph;

public class Dijkstra implements CostosMinimos{

	private int V;
	private Graph rta;


	//Método desde el cual voy a llamar n veces al método Dijkstra, cambiando su src
	public void sort(int[][] sort) {
		V = sort.length;
		rta = new Graph(V,V);
		for(int i = 0; i<V;i++)
		{
			Dijkstra(sort,i);
		}


	}
	/**
	 * Metodo que sirve para encontrar la distancia minima a  uno de los vertices que no han sido marcados
	 * @param dist 
	 * @param sptSet
	 * @return
	 */
	public int menorPeso(int dist[], Boolean sptSet[]) 
	{ 
		// Inicializo el valor minimo en infinito
		int peso = Integer.MAX_VALUE, menor=-1; 

		for (int v = 0; v < V; v++) 
			if (sptSet[v] == false && dist[v] <= peso) 
			{ 
				peso = dist[v]; 
				menor = v; 
			} 

		return menor; 
	} 
	public void Dijkstra(int[][] graph, Integer src)
	{
		//Va a guardar la menor distancia entre src y el vertice i
		int dist[] = new int[V]; 

		// en la posicion i sera true si el vertice esta incluido en la solucion
		Boolean solu[] = new Boolean[V]; 

		// Inicializo todas las distancias en infinito y solucion en falso
		for (int i = 0; i < V; i++) 
		{ 
			dist[i] = Integer.MAX_VALUE; 
			solu[i] = false; 
		} 

		// Distancia de el vertice solucion a si mismo es siempre cero
		dist[src] = 0; 

		// Desde aca encuentro el camino minimo a todos los vertices
		for (int count = 0; count < V-1; count++) 
		{ 
			//Cojo el vertice con menor peso, entre los que ya existen
			int u = menorPeso(dist, solu); 

			// El vertice que acabe de coger lo marco
			solu[u] = true; 

			// Ahora actualizo los valores de los vertices adyacentes al vertice que cogi 
			for (int v = 0; v < V; v++) 

				// Update dist[v] only if is not in sptSet, there is an 
				// edge from u to v, and total weight of path from src to 
				// v through u is smaller than current value of dist[v] 
				if (!solu[v] && graph[u][v]!=0 && graph[u][v]!=-1 && dist[u] != Integer.MAX_VALUE && 
				dist[u]+graph[u][v] < dist[v]) {
					
					dist[v] = dist[u] + graph[u][v];
					Edge ag = new Edge(u, v, graph[u][v]);
					rta.addEdge(ag);

				} 
		} 
	}


}
