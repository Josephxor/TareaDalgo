package uniandes.EstructurasDatos;

public class Graph {

	
  
    public int V;

	public int E; 
    
    public Edge edge[]; 
    
    public Integer vertex[];
  
    // Creates a graph with V vertices and E edges 
    public Graph(int v, int e) 
    { 
        V = v; 
        E = e;  
    }
    
    public void addEdge(Edge ed)
    {
    	for(int i =0; i<E;i++) {
    		if(edge[i]==null)
    		{
    			edge[i]=ed;
    		}
    	}
    }
    
    public void addVertex(int ve)
    {
    	for(int i =0; i<V;i++)
    	{
    		if(vertex[i].equals(null))
    		{
    			vertex[i]=ve;
    		}
    	}
    }
    
    
}
