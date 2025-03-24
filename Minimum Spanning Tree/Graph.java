public class Graph{
  private int N;  // number of vertices
  private int M[][];  // adjacency matrix

  public Graph(int N){
    this.N = N;
    M = new int[N][N];
  }

  public void InsertEdge(int v1, int v2, int weight, int direction){
    M[v1][v2] = weight;
    if (direction == 0) M[v2][v1] = weight;
  }

  public void printGraph(){
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++)
        System.out.print(M[i][j] + "  ");
      System.out.println();
    }
  }

    public boolean existsEdge(int v1, int v2){
      return (M[v1][v2]!=0);
    }

    public void popEdge(int v1, int v2){
      int p = M[v1][v2];
      M[v1][v2] = 0;
      if(M[v2][v1] == p) M[v2][v1] = 0;
    }

    public void DFS(int s){
      boolean[] visited = new boolean[N];
      DFSRecursive(s, visited);
    }

    public void DFSRecursive(int vertice, boolean [] visited){
      visited[vertice] = true;
      System.out.println("Visita: " + vertice);
      for(int i=0; i<N; i++){
        if(M[vertice][i]!=0 && !visited[i])
          DFSRecursive(i, visited);
      }
    }

    public void BFS(int s){
      Queue f = new Queue(N);
      int color[] = new int[N];  // 0 = white, 1 = grey, 2 = black
      int d[] = new int[N];    // distance
      int pr[] = new int[N];   // precedent
      int u;

      for(int i=0; i<N; i++){
        color[i] = 0;
        d[i] = +999999;  // infinite...
        pr[i] = -1; // nil
      }

      color[s] = 1;
      d[s] = 0;
      pr[s] = -1;
      f.push(s);

      while(!f.isEmpty()){
        u = f.pop();
        for(int v=0; v<N; v++){
          if(M[u][v]!=0 && color[v] == 0){
            color[v] = 1;  // grey
            d[v] = d[u] + M[u][v];
            pr[v] = u;
            f.push(v);
          }
        }
        color[u] = 2; // black
      }

      // debug
      for(int v=0; v<N; v++){
          System.out.println("vertex: " + v + " " + color[v] + " " + d[v] + " " + pr[v]);
      }
    }

    public void Dijkstra(int s){
      int D[] = new int[N];
      int P[] = new int[N];
      int C[] = new int[N];
      Queuepriority Q = new Queuepriority(N);
      int u;

      D[s] = 0;
      P[s] = -1;

      for(int i=0; i<N; i++)
        if(i!=s){
          D[i] = +999999;
          P[i] = -1;
          C[i] = 0;
        }

      for(int i=0; i<N; i++){
          Q.push(i, D);
      }

      while(!Q.isEmpty()){
        u = Q.pop();
        for(int z=0; z<N; z++){
          if(M[u][z]!=0 && C[z] != 1){
            if((D[u] + M[u][z]) < D[z]){
              D[z] = D[u] + M[u][z];
              P[z] = u;
            }
          }
        }
        C[u] = 1;
        Q.ordena(D);
      }
      //debug
      for(int v=0; v<N; v++){
          System.out.println("vertex: " + v + " " + D[v] + " " + P[v]);
      }
    }

}
