public class Main {
  public static void main(String[] args) {
    MyArrayList list = new MyArrayList<String>();
    list.add(3);
    list.add(1);
    list.add(2);
//    list.remove("3");
    list.sort();
    System.out.println(list.get(0));
  }
}
