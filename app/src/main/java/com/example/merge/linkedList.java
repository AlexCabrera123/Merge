package com.example.merge;

import android.util.Log;
//Instanciar la clase linkedList con sus métodos
public class linkedList {
//El nodo head es el primer nodo de la lista que se va a ordenar
    node head = null;

//Método para agregar elementos a la lista enlazada
    void push(int new_data)
    {
        //Se asigna un nuevo nodo
        node new_node = new node(new_data);

        //vincular la lista anterior al nuevo nodo
        new_node.next = head;

        // Se actualiza el nodo head para señalar el nuevo nodo //
        head = new_node;
    }

    //Método para imprimir la lista enlazada
    void printList(node headref)
    {
        while (headref != null) {
            Log.i("log",headref.val + " ");
            headref = headref.next;
        }
    }

    //Método para ordenar la lista
    node mergeSort(node h)
    {
        // Casos base por si se tiene sólo 1 elemento
        if (h == null || h.next == null) {
            return h;
        }

        //Se consigue el medio de la lista
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;

        //Se establece el siguiente nodo de en medio en nulo
        middle.next = null;

        //Se aplica el método en la lista de la izquierda
        node left = mergeSort(h);

        //Se aplica el método en la lista de la derecha
        node right = mergeSort(nextofmiddle);

        // Se combinan las listas de la izquierda y derecha con el método sortedmerge
        node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    //El método sortedMerge se utiliza para combinar las listas enlazadas ya ordenadas y fusionarlas en una sola
    node sortedMerge(node a, node b)
    {
        node result = null;
        /* Casos base por si sólo se tiene 1 elemento */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Se escoge el nodo a o el b para ordenar las listas*/
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    //Método para obtener el nodo de en medio de la lista enlazada
    public static node getMiddle(node head)
    {
        if (head == null)
            return head;

        node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
