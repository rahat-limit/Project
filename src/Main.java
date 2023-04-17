import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
//    Firstly, you can add to List any type of Objects. Then, use each of various methods.
//    -------- Example:
//    MyArrayList list = new MyArrayList();
//    System.out.println("We already started, just enter input data: (For example:(Integer)). Also it works the same way to any type of Object.");
//    int input = scan.nextInt(); or String input = scan.nextLine();
//    list.add(input);
//    System.out.println(list.get(0));
//    -------- Example LinkedList:
    MyLinkedList linkedList = new MyLinkedList();
    System.out.println("We already started, just enter input data: (For example:(Integer)). Also it works the same way to any type of Object.");
    int input = scan.nextInt();// or String input = scan.nextLine();
    linkedList.add(input);
    System.out.println(linkedList.contains(12));

//    -------- Options:
//    list.get(index);
//    list.size();
//    list.contains(Object);
//    list.add(Object);
//    list.addAt(Object, index);
//    list.remove(Object);
//    list.remove(index);
//    list.clear();
//    list.indexOf(Object);
//    list.lastIndexOf(Object);
//    list.sort();
  }
}
