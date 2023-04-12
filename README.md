# Second Assignment Documentation
Welcome to my respository, which I created due to ADS lessons. Here you can easily find some tasks with their explanations. Hope you like it🤙
## Main File Main.java [(source)](https://github.com/rahat-limit/lab-2/blob/master/src/Main.java/)
**All tasks in lab-2 works the same way. All you neede to follow uncomment Example lines and start project**
## ✖️ MyArrayList [(source)](https://github.com/rahat-limit/lab-2/blob/master/src/MyArrayList.java)
### Method GET:
Method get that provide exact item of array by index.
### Explanation:
Firstly, check by method isExist is object in array. Then, return item of array by index.
### Solution:
```java
  @Override
  public Object get(int index) {
    isExist(index);
    return arr[index];
  }
```
### Method SIZE:
Method size that return length of array.
### Explanation:
Simply return size of array.
### Solution:
```java
  @Override
  public int size() {
    return size;
  }
```
### Method CONTAINS:
Method contains that define is object exist in array.
### Explanation:
Firstly, condition to check is array empty or not, after it goes through loop to define equal to given Object element. Then return Boolean value.
### Solution:
```java
  @Override
  public boolean contains(Object o) {
    if (arr.length == 0) return false;
    for (int i = 0; i < size; i++) {
      if (arr[i].equals(o)) return true;
    }
    return false;
  }
```
### Method ADD:
Method add that add to array one object.
### Explanation:
Condition to check is free space in array, otherwise increase memory by method increaseBuffer. Then add to next element item. 
### Solution:
```java
  @Override
  public void add(Object item) {
    if(size == arr.length){
      increaseBuffer();
    }
    arr[size++] = (T)item;
  }

```
### Method ADDAT:
 Method addAt that add to aray one object at exact index.
### Explanation:
Condition to check is index relevant to array by method isExist. Condition to check is free space in array, otherwise increase memory by method increaseBuffer. Then by loop we replace each element by -1, from index to array length. 
### Solution:
```java
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
```
### Method REMOVE:
 Method remove that remove one object from array.
### Explanation:
Condition to check is item relevant to array by method contains. Then by indexOf we check is first occurence is >= 0. Then remove element and return true.
### Solution:
```java
  @Override
  public boolean remove(Object item) {
    if (!contains(item)) return false;
    if (indexOf(item) >= 0) {
      remove(indexOf(item));
      return true;
    }
    return false;
  }
```
### Method REMOVE:
Method removeAt that remove one oject from array by index.
### Explanation:
Condition to check is index relevant to array by method isExist. Then go through loop to replace each element from index to length of array. Finaly, remove and return element.  
### Solution:
```java
  @Override
  public Object remove(int index) {
    isExist(index);
    T item = arr[index];
    for(int i = index + 1; i <= size; i++) {
      arr[i-1] = arr[i];
    }
    size--;
    return item;
  }
```
### Method CLEAR:
Method clear that clear array and array size.
### Explanation:
Simply clear array or replace our array with new empty data.
### Solution:
```java
  @Override
  public void clear(){
    this.arr = (T[]) new Object[5];
    this.size = 0;
  }
```
### Method INDEXOF:
Method indexOf that returns the position of the first occurrence of specified character(s) in a string.
### Explanation:
Check by method contains is object in array list. Then by loop check eaual items to return index, otherwise return -1.
### Solution:
```java
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
```
### Method LASTINDEXOF:
Method lastIndexOf that return the position of the last occurrence of specified character(s) in a string.
### Explanation:
Check by method contains is object in array list. Then by loop check equal items and i > index, to equal index = 1, then to return index. 
### Solution:
```java
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
```
### Method SORT:
Method sort that sort elements of a collection.
### Explanation:
We use nested loops, to check by conditions in order to swap elements with places, to get right sorted list.
### Solution:
```java
  @Override
  public void sort() {
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
```
