package example.customArrayList;

public class Main {
    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(20);
        System.out.println(list.get(0));
        list.remove();
        list.add(200);
        System.out.println(list);
    }
}
