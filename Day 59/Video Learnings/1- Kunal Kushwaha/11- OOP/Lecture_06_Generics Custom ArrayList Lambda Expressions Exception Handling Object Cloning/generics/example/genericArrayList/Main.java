package example.genericArrayList;


public class Main{
    public static void main(String[] args) {
        CustomGenArrayList<Integer> list = new CustomGenArrayList<>();
        for(int i=0; i<=12; i++){
            list.add(i*2);
        }
        System.out.println(list);

        CustomGenArrayList<String> list2 = new CustomGenArrayList<>();
        list2.add("Me");
        list2.add("You");

        System.out.println(list2);



    }
}