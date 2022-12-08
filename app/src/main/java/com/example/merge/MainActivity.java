package com.example.merge;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciamos la lista enlazada
        linkedList li = new linkedList();

        //Agregamos elementos a la lista de forma desordenada
        li.push(3);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
        li.push(9);
        li.push(40);

        //Se manda llamar el método para ordenar la lista
        li.head = li.mergeSort(li.head);

        //Se imprime la lista enlazada ya ordenada por el método merge-sort
        Log.i("log","LISTA ENLAZADA ORDENADA:");
        li.printList(li.head);
    }
}





