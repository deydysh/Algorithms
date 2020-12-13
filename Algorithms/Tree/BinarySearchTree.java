package Tree;

public class BinarySearchTree {

    Node root;

    private Node addRecursive (Node current, int value) {
        if (current == null) return new Node(value); //Нашли нужную позицию, создаем лист
        if (value <= current.value) current.left = addRecursive(current.left, value); //Рекурсивно ищем слева
        if (value > current.value) current.right = addRecursive(current.right, value); //Рекурсивно ищем справа
        return current; //Возвращаемся из рекурсии (лист создан)
    }

    public void add (int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive (Node current, int value) {
        if (current == null) return false; //Лист не найден
        if (current.value == value) return true; //Лист найден
        return value < current.value ?
            containsNodeRecursive(current.left, value) :
            containsNodeRecursive(current.right, value); //Рекурсивно вызываем поиск для левого/правого поддерева
    }
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }
    private Node deleteRecursive(Node current, int value) {
        if (current == null) return null; //Узел не найден
        if (value == current.value) { //Узел найден
            if (current.left == null && current.right == null) return null; //Лист
            if (current.left == null) return current.right; //У узла только правый потомок
            if (current.right == null) return current.left; //У узла только левый потомок
            //Следущий код для узла с двумя потомками
            int smallestValue = findSmallestValue(current.right); //Ищем следующее минимальное значение большее, чем удаляемое
            current.value = smallestValue; // Присваем новое значение узлу
            current.right = deleteRecursive(current.right, smallestValue); //Удаляем лист, чье значение мы использовали для удаляемого узла
            return current; //Выход из рекурсии
        }
        if (value < current.value) current.left = deleteRecursive(current.left, value); //Рекурсивное удаление для левого поддерева
        if (value > current.value) current.right = deleteRecursive(current.right, value); //Рекурсивное удаление для правого поддерева
        return current; //Возвращение из рекурсии
    }
    private int findSmallestValue (Node current) {
        return current.left == null ? current.value : findSmallestValue(current.left);
    }
    public void delete (int value){
        root = deleteRecursive(root, value);
    }
}
