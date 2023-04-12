public class MyArrayList<T> implements MyList {
  private T[] arr;
  private int size;

  MyArrayList() {
    this.arr = (T[]) new Object[5];
    this.size = 0;
  }
//  Essential Methods
  @Override
  public Object get(int index) {
    /**
     * Method get that provide exact item of array by index.
     * @return Object
     */
    isExist(index);
    return arr[index];
  }

  @Override
  public int size() {
    /**
     * Method size that return length of array.
     * @return int.
     */
    return size;
  }

  @Override
  public boolean contains(Object o) {
    /**
     * Method contains that define is object exist in array.
     * @return boolean value.
     */
    if (arr.length == 0) return false;
    for (int i = 0; i < size; i++) {
      if (arr[i].equals(o)) return true;
    }
    return false;
  }

  @Override
  public void add(Object item) {
    /**
     * Method add that add to array one object.
     */
    if(size == arr.length){
      increaseBuffer();
    }
    arr[size++] = (T)item;
  }

  @Override
  public void addAt(Object item, int index) {
    /**
     * Method addAt that add to aray one object at exact index.
     */
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
    /**
     * Method remove that remove one object from array.
     * @return boolean value.
     */
    if (!contains(item)) return false;
    if (indexOf(item) >= 0) {
      remove(indexOf(item));
      return true;
    }
    return false;
  }

  @Override
  public Object remove(int index) {
    /**
     * Method removeAt that remove one oject from array by index.
     * @return removed object.
     */
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
    /**
     * Method clear that clear array and array size.
     */
    this.arr = (T[]) new Object[5];
    this.size = 0;
  }

  @Override
  public int indexOf(Object o) {
    /**
     * Method indexOf that returns the position of the first occurrence of specified character(s) in a string.
     * @return int.
     */
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
    /**
     * Method lastIndexOf that return the position of the last occurrence of specified character(s) in a string.
     * @return int.
     */
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
    /**
     * Method sort that sort elements of a collection.
     */
    for(int i = 0; i < size; i++) {
      for (int d = i; d < size; d++) {
        if ((int) arr[d] < (int) arr[i]) {
          T item = arr[i];
          arr[i] = arr[d];
          arr[d] = item;
        }
      }
    }
  }
//  Optional Methods

  public void increaseBuffer(){
    /**
     * Method increaseBuffer that increase stack memory.
     * @param newArr is new Array with more memory.
     */
    T[] newArr = (T[]) new Object[arr.length*2];
    for(int i=0; i< arr.length; i++){
      newArr[i]=arr[i];
    }
    arr = newArr;
  }


  private void isExist(int index) {
    /**
     * Method isExist that check is element by index is exist or no.
     */
    if (arr[index] == null) {
      throw new IndexOutOfBoundsException();
    }
  }
}
