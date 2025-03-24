public class Queue{
  private int[] vector;
  private int end;

  
  public Queue(int tam){
    vector = new int[tam];
    end = -1;
  }

  public void push(int valor){
    if(end == vector.length-1)
      System.out.println("Full Queue!");
    else{
      end++;
      vector[end]=valor;
    }
  }

  public int pop(){
    int aux = vector[0];
    if(end>=0){
      for(int i=0; i<end; i++)
        vector[i] = vector[i+1];
      end--;
      return aux;
    } else{
      System.out.println("Empty Queue!");
      return -99999;
    }
  }

  public boolean isFull(){
    return (end == vector.length-1);
  }

  public boolean isEmpty(){
    return (end == -1);
  }
}
