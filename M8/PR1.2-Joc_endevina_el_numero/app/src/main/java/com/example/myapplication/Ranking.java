package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Ranking extends AppCompatActivity {
    private ListView listView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);// XML de la clase Ranking
        setTitle("Ranking");

        listView = (ListView) findViewById(R.id.lista);// lista de usuarios

        adapter = new UserAdapter(this, UserAdapter.listaUsers);
        listView.setAdapter(adapter);
        int[] colors = {0, 0xFF3AAD4B, 0};// color de la linea
        listView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        listView.setDividerHeight(3);// altura de la linea

        // Declaramos un boton para que nos lleve al MainActivity y volver a jugar
        final Button btnVolverAJuagar = findViewById(R.id.btnVolverJugar);

        // Listener del boton volver a jugar
        btnVolverAJuagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.numeroGenerado = (int) (Math.random() * 5 + 1);
                MainActivity.contadorIntentos = 1;// Reiniciamos el contador de intentos a 1
                MainActivity.consolaMensajes.setText("");
                // Declaramos un intent para pasar a la clase MainActivity
                finish();
            }
        });

        // Listner del ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ranking.this, adapter.listaUsers.get(position).getNombre() + " esta en el puesto nº" + (position + 1), Toast.LENGTH_SHORT).show();// Le mostramos un mensaje con el Toast
            }
        });
    }

}