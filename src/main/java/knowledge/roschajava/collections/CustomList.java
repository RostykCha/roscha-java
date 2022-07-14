package knowledge.roschajava.collections;

import java.util.Iterator;

public class CustomList <T> implements Iterable<T>{
    public T[] items = (T[]) new Object[10];
    private  int count;

    public  void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T>{
        CustomList<T> list;
        private int index;


        public ListIterator(CustomList<T> list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index< list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
