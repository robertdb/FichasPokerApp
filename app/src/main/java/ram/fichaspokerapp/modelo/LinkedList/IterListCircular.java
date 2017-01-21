package ram.fichaspokerapp.modelo.LinkedList;

import java.util.Iterator;

/**
 * Created by Robert on 20/1/17.
 */

public class IterListCircular {

    private CircularLinkedList listCircular;
    private ListNode actual;
    private int index;

    public IterListCircular(CircularLinkedList list){

        listCircular = list;
        actual = listCircular.getFirst();
        index = 0;

    }

    private ListNode buscarActual(Object data){
        ListNode nodo;
        for (int i = 0; i < listCircular.size() ; i++) {
            if ((Object)listCircular.getNodeAt(i).data == data){
                return listCircular.getNodeAt(i);
            }
        }
        return null;
    }
    public IterListCircular(CircularLinkedList list, Object data){

        listCircular = list;
        actual = buscarActual(data);

    }

    public boolean hasNext() {
        return (listCircular.size() > 0);
    }

    public Object actual() {
        if(actual == null )
            throw new UnsupportedOperationException();
        return actual.data;
    }

    public Object next() {
        if(actual == null || actual.next == null)
            throw new UnsupportedOperationException();
        actual = actual.next;
        return actual.data;
    }


    public void removeActual() {
        if(listCircular.size() == 0)
            throw new UnsupportedOperationException();
        if(actual == listCircular.getFirst()){
            // si se borra el primero, el siguiente pasa a ser el primero.
            actual = listCircular.getFirst().next;
            listCircular.removeAtFirst();
        }else if(actual == listCircular.getLast()){
            // si se borra el ultimo, el actual es el primero.
            actual = listCircular.getFirst();
            listCircular.removeAtLast();
        }else{
                ListNode aux  = actual.next;
                listCircular.removeAt(listCircular.findPositionElement(actual.data));
                actual = aux;
        }
    }
}