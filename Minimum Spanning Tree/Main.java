public class Main {
    public static void main(String args[]){
    
  //path that will follow
      int CPE[]={8, 9, 11, 16, 19, 22 , 25};
      
      Graph g = new Graph(26);
      
  //graph construction
      g.InsertEdge(0, 1, 1, 0);
      g.InsertEdge(0, 2, 3, 0);
      g.InsertEdge(0, 7, 1, 0);
      g.InsertEdge(1, 2, 3, 0);
      g.InsertEdge(1, 3, 11, 0);
      g.InsertEdge(2, 6, 1, 0);
      g.InsertEdge(3, 4, 5, 0);
      g.InsertEdge(3, 5, 3, 0);
      g.InsertEdge(3, 25, 7, 0);
      g.InsertEdge(4, 5, 3, 0);
      g.InsertEdge(4, 23, 7, 0);
      g.InsertEdge(4, 20, 5, 0);
      g.InsertEdge(4, 24, 11, 0);
      g.InsertEdge(5, 6, 1, 0);
      g.InsertEdge(5, 23, 3, 0);
      g.InsertEdge(6, 23, 3, 0);
      g.InsertEdge(6, 10, 11, 0);
      g.InsertEdge(7, 9, 5, 0);
      g.InsertEdge(7, 8, 7, 0);
      g.InsertEdge(8, 9, 7, 0);
      g.InsertEdge(8, 12, 5, 0);
      g.InsertEdge(9, 10, 7, 0);
      g.InsertEdge(10, 12, 5, 0);
      g.InsertEdge(10, 11, 7, 0);
      g.InsertEdge(10, 23, 3, 0);
      g.InsertEdge(11, 13, 5, 0);
      g.InsertEdge(11, 14, 7, 0);
      g.InsertEdge(11, 23, 7, 0);
      g.InsertEdge(12, 13, 7, 0);
      g.InsertEdge(12, 22, 3, 0);
      g.InsertEdge(13, 22, 5, 0);
      g.InsertEdge(13, 15, 7, 0);
      g.InsertEdge(14, 23, 5, 0);
      g.InsertEdge(14, 20, 7, 0);
      g.InsertEdge(14, 16, 5, 0);
      g.InsertEdge(15, 16, 5, 0);
      g.InsertEdge(15, 17, 5, 0);
      g.InsertEdge(16, 17, 5, 0);
      g.InsertEdge(16, 18, 5, 0);
      g.InsertEdge(16, 19, 5, 0);
      g.InsertEdge(17, 18, 5, 0);
      g.InsertEdge(18, 19, 3, 0);
      g.InsertEdge(19, 20, 7, 0);
      g.InsertEdge(19, 24, 11, 0);
      g.InsertEdge(20, 23, 7, 0);
      g.InsertEdge(20, 24, 7, 0);
      g.InsertEdge(24, 25, 11, 0);
  
    
      System.out.println("Breadth-First Search:");
      g.BFS(6, CPE);
      System.out.println("Depth-First Search:");
      g.DFS(6, CPE);
      Queue C = new Queue(50);
      System.out.println("Minimum Spanning Tree:");
      MST(CPE, g, 6, 7, 0, C);
      
    }
    public static void MST(int V[], Graph g, int c, int h, int d, Fila C){
      if(c==25){
        V[6]=6;
        Queue F= g.Dijkstra(25,V);
        System.out.print("Path : ");
        F.show();
        d+=F.popEnd();
        while(!F.isEmpty()){
          C.push(F.popEnd());
        }
        System.out.println("Final Minimum Spanning Tree : ");
        C.showN();
        System.out.println("max distance: ");
        System.out.println(d);
        return;    
      }
      Fila F = g.Dijkstra(c,V);
      System.out.print("Path : ");
      F.show();
      int o=F.pop();
      
      for(int i=0; i<h; i++){
        if(V[i]==o){
          V[i]=9999999;
        }
        
      }
      
      d+=F.popEnd();
      while(!F.isEmpty()){
        C.push(F.popEnd());
      }
      
      MST( V, g, o, h, d, C);
    }
  
  }