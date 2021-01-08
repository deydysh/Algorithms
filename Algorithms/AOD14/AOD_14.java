package AOD14;

import java.util.*;

public class AOD_14 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String string = in.nextLine();
        int value;
        String key;
        for (int i = 0; i < string.length(); i++) {
            key = "" + string.charAt(i);
            if (map.containsKey(key)) {
                value = map.get(key) + 1; // получение значения по ключу те частоту
                map.put(key, value);
            } else {
                map.put(key, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new
                ArrayList<>(map.entrySet());
        List<Element> q = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            q.add(new Element(list.get(i).getValue(),
                    list.get(i).getKey()));
        }
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Element one = (Element) o1;
                Element two = (Element) o2;
                return one.p - two.p;
            }
        };
        Collections.sort(q, comparator);
        int dl = list.size();
        Element buffer1;
        Element buffer2;
        if (list.size() == 1) {
            System.out.println(1 + " " + string.length());
            System.out.println(string.charAt(0) + ": " + "0");
            String simplecode = "";
            for (int i = 0; i < string.length(); i++) {
                simplecode += "0";
            }
            System.out.println(simplecode);
        } else {
            do {
                buffer1 = extractMin(q);
                buffer2 = extractMin(q);
// добавляем элемент с именем сум двух мин элементов и приоритетом сум двух мин элементов
                insertElement(q, new Element(buffer1.p + buffer2.p,
                        buffer1.v + buffer2.v, buffer1,
                        buffer2));

            } while (q.size() > 1);
// получаем код 'a'
            Map<String, String> dictionary = new HashMap<>();
            String[] halfresult = new String[q.get(0).v.length()];
            for (int i = 0; i < q.get(0).v.length(); i++) {
                String code = "";
                String symbol = "" + q.get(0).v.charAt(i);
                Element buffCoding = q.get(0);
                while ((buffCoding.leftchild != null) &&
                        (buffCoding.rightchild != null)) {
                    if (buffCoding.leftchild.v.contains(symbol)) {
                        code += "0";
                        buffCoding = buffCoding.leftchild;
                    } else if (buffCoding.rightchild.v.contains(symbol)) {
                        code += "1";

                        buffCoding = buffCoding.rightchild;

                    }
                }
                dictionary.put(symbol, code);
                halfresult[i] = (symbol + ": " + code);
            }
            String resultCode = "";
            for (int i = 0; i < string.length(); i++) {
                key = "" + string.charAt(i);
                resultCode += dictionary.get(key);
            }
            System.out.println(list.size() + " " + resultCode.length());
            for (int i = 0; i < halfresult.length; i++) {
                System.out.println(halfresult[i]);
            }
            System.out.println(resultCode);
        }
    }
    public static class Element {
        int p;
        String v;
        Element leftchild = null;
        Element rightchild = null;
        public Element(int p, String v) {
            this.p = p;
            this.v = v;
        }
        public Element(int p, String v, Element leftchild, Element
                rightchild) {
            this.p = p;
            this.v = v;
            this.leftchild = leftchild;
            this.rightchild = rightchild;
        }
    }

    public static Element extractMin(List<Element> q) {
        Element buffer = q.get(0);
        for (int i = 1; i < q.size(); i++) {
            q.set(i - 1, q.get(i));
        }
        q.remove(q.size() - 1);
        return buffer;
    }
    public static void insertElement(List<Element> q, Element el) {
        if (q.size() == 0) {
            q.add(el);
            return;
        }
        for (int i = q.size() - 1; i >= 0; i--) {
            if (el.p >= q.get(i).p) {
                q.add(i + 1, el);
                break;
            }
        }
    }
}
