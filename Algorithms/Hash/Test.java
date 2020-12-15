package Hash;

public class Test {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.insert(111111, "name1");
        map.insert(222000, "name2");
        map.insert(222100, "name3");
        map.insert(222101, "name4");
        map.insert(222102, "name5");
        map.insert(222103, "name6");
        map.insert(222104, "name7");
        System.out.println(map);
        map.insert(111112, "name8");
        map.insert(222400, "name9");
        System.out.println(map);
    }
}
