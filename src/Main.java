public class Main {
  public static void main(String[] args) {
    MyArrayList list = new MyArrayList<String>();
    list.add("1");
    list.add("2");
    list.add("3");
//    list.remove("3");
//    list.clear();
    System.out.println(list.indexOf("2"));
  }
}
