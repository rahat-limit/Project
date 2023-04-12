public class MyArrayList<T> implements MyList {
  private T[] arr;
  private int size;

  MyArrayList() {
    this.arr = (T[]) new Object[5];
    this.size = 0;
  }

  public void increaseBuffer(){
    T[] newArr = (T[]) new Object[arr.length*2];
    for(int i=0; i< arr.length; i++){
      newArr[i]=arr[i];
    }
    arr = newArr;
  }

  @Override
  public Object get(int index) {
    isExist(index);
    return arr[index];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public void add(Object item) {
    if(size == arr.length){
      increaseBuffer();
    }
    arr[size++] = (T)item;
  }

  @Override
  public void addAt(Object item, int index) {

  }

  @Override
  public boolean remove(Object item) {
    return false;
  }

  @Override
  public Object remove(int index) {
    return null;
  }

  @Override
  public void clear() {

  }



  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public void sort() {

  }

  private void isExist(int index) {
    if (arr[index] == null) {
      throw new IndexOutOfBoundsException();
    }
  }
}
