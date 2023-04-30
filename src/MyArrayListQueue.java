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
  public boolean isEmpty() {
    return this.size() == 0;
  }

  public T peek() throws NoSuchFieldException {
    isEmptyThrowException();
    return (T) myArrayList.get(0);
  }

  private void isEmptyThrowException() throws NoSuchFieldException {
    if (isEmpty()) {
      throw new NoSuchFieldException();
    }
  }

}
