public class priorityQueue{
  private int N;
  private int v[];
  private int end;

  public priorityQueue(int tam){
      N = tam;
      v = new int[tam];
      end = -1;
  }

  public void sort(int [] D){
    int temp;
    // bubble sort
    for(int i=1; i<end; i++){
      for(int j=0; j<end; j++){
        if(D[v[j]] > D[v[j+1]]){
          temp = v[j];
          v[j] = v[j+1];
          v[j+1] = temp;
        }
      }
    }
  }

  public void push(int vt, int [] D){
    if((end+1) < N){
        end++;
        v[end] = vt;
        sort(D);
    }
    else
      System.out.println("priorityQueue::push => Attempt to insert into Full Queue!");
  }

  public int pop(){
    int value;
    if(end>-1){
      value = v[0];
      for(int i=0; i<end; i++){
        v[i] = v[i+1];
      }
      end--;
    }
    else{
      System.out.println("priorityQueue::pop => Empty Queue Removal Attempt!");
      value = -999999;
    }
    return value;
  }

  public boolean isEmpty(){
    if(end>-1) return false;
    else return true;
  }

  public boolean isFull(){
    if(end<N-1) return false;
    else return true;
  }
}
