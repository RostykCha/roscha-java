package knowledge.roschajava.collections;

import java.util.*;

public class CollectionsBase {

    public static void main(String[] args) {
    }

    void queueMethods(){
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("b");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println("\n");

        ArrayDeque<String> deQueue = new ArrayDeque<>();
        deQueue.add("a");
        deQueue.add("b");
        deQueue.add("c");
        deQueue.add("d");
        deQueue.add("b");

        System.out.println(deQueue.peek());
        System.out.println(deQueue.pop());
        System.out.println(deQueue.peek());
    }

    void setMethods(){
        List<String> list = List.of("D", "A", "B", "C", "A");

        Set<String> set = Set.copyOf(list);
        System.out.println(set);

        HashSet<String> hashSet = new HashSet<>(list);
        System.out.println(hashSet);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println(linkedHashSet);

        TreeSet<String> treeSet = new TreeSet<>(list);
        System.out.println(treeSet);
    }

    void linkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("dfs");
        linkedList.add("dfssd");


        linkedList.getFirst();
        linkedList.getLast();
    }

    void arrayMethods() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.trimToSize();
        arrayList.ensureCapacity(1);
    }

    void listActions() {
        List<String> list = new ArrayList<>();
        list.add("sd");
        list.add("sds");
        list.add(0, "sd");
        list.set(0, "setedB");
        list.remove(0);

        System.out.println(list.indexOf("sds"));
        System.out.println(list.subList(0, 2));
    }

    void collectionActions() {
        Collection<String> collection = new ArrayList<>();
        collection.add("s");
        Collections.addAll(collection, "sd", "sad", "sdasd");
        collection.clear();
    }

    void iterateCustomCollection() {
        CustomList<String> list = new CustomList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            var current = iterator.next();
            System.out.println(current);
        }
    }

    void classMethods() {
        Animal dog2 = new Dog();
        dog2.eat();

        Dog dog = new Dog();
        dog.bark();
        dog.eat();
    }
}
