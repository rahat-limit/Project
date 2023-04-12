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
    if (arr.length == 0) return false;
    for (int i = 0; i < size; i++) {
      if (arr[i].equals(o)) return true;
    }
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
    isExist(index);
    if (size == arr.length) {
      increaseBuffer();
    }
    for(int i = size; i>index; i--) {
      arr[i] = arr[i-1];
    }
    size++;
    arr[index] = (T) item;
  }

  @Override
  public boolean remove(Object item) {
    if (!contains(item)) return false;
    if (indexOf(item) >= 0) {
      remove(indexOf(item));
      return true;
    }
    return false;
  }

  @Override
  public Object remove(int index) {
    isExist(index);
    T item = arr[index];
    // item - removed element
    for(int i = index + 1; i <= size; i++) {
      arr[i-1] = arr[i];
    }
    size--;
    return item;
  }

  @Override
  public void clear(){
    this.arr = (T[]) new Object[5];
    this.size = 0;
  }

  @Override
  public int indexOf(Object o) {
    if (!contains(o)) return -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals((T) o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    if (!contains(o)) return -1;
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals((T) o) && i > index){
        index = i;
      }
    }
    return index;
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
