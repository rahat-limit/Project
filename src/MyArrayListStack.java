import java.util.EmptyStackException;

public class MyArrayListStack<T> {
  MyArrayList myArrayList = new <T>MyArrayList();
  public void push(T element) {
    myArrayList.add(element);
  }
  public boolean isEmpty() {
    return this.size() == 0;
  }
  public int size() {
    return myArrayList.size();
  }
  public T pop() {
    isEmptyThrowException();
    return (T) myArrayList.remove(0);
  }
  public T peek() {
    isEmptyThrowException();
    return (T) myArrayList.get(0);
  }

  private void isEmptyThrowException() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
  }
}
