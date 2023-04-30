public class MyArrayListQueue<T> {
  MyArrayList myArrayList = new <T>MyArrayList();


  public void enqueue(T element) {
    myArrayList.add(element);
  }
  public T dequeue() {
    return (T) myArrayList.remove(0);
  }
  public int size() {
    return myArrayList.size();
  }
}
