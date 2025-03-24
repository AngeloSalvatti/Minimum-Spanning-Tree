public class Node{
  private int vertex;
  private int weight;
  private Node next;

  public void setvertex(int v){
    vertex = v;
  }

  public int getvertex(){
    return vertex;
  }

  public void setweight(int p){
    weight = p;
  }

  public int getweight(){
    return weight;
  }

  public void setNext(Node n){
    next = n;
  }

  public Node getNext(){
    return next;
  }

  public Node(int v, int p){
    vertex = v;
    weight = p;
    next = null;
  }

  public void push(int v, int p){
    if(next==null)
      next = new Node(v, p);
    else
      next.push(v, p);
  }

  public void printGraph(){
    System.out.print("[" + vertex + ", " + weight + "] - ");
    if(next!=null)
      next.printGraph();
  }

  public boolean existsEdge(int v2){
      if(vertex == v2)
        return true;
      else
        if(next!=null)
          return next.existsEdge(v2);
        else
          return false;
  }
}
