import java.util.EmptyStackException;

public class MyLinkedListStack<T> {

  MyLinkedList myLinkedList = new <T>MyLinkedList();

  public void push(T element) {
    myLinkedList.add(element);
  }
  public T pop() {
    isEmptyThrowException();
    return (T) myLinkedList.remove(0);
  }
  public T peek() {
    isEmptyThrowException();
    return (T) myLinkedList.get(0);
  }
  public boolean isEmpty() {
    return this.size() == 0;
  }
  public int size() {
    return myLinkedList.size();
  }
  private void isEmptyThrowException() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
  }

}
