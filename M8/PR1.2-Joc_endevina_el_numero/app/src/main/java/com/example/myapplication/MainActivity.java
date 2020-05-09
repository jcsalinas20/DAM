package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;

import static com.example.myapplication.Camera.CAMERE_REQUEST;
import static com.example.myapplication.Camera.photoURI;

public class MainActivity extends AppCompatActivity implements Serializable {
    private UserAdapter adapter;

    String filename = "record.txt";//nombre del fichero del ranking
    File file;//variable para guardar el fichero

    static int contadorIntentos = 1;// contador de numero de intentos
    static int numeroGenerado = (int) (Math.random() * 100 + 1);// Numero aleatorio que encontrar

    // Declaracion del EditText donde se introducira el nombre del usuario cuando se haya encontrado el numero aleatorio
    static EditText nombreUsuarioIntroducido;// nombre del usuario que se introduzca
    static TextView consolaMensajes;// Se mostraran los mensajes

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// XML del MainActivity

        leerArchivo(MainActivity.this);// metodo para leer el archivo

        // EditText para introducir un numero
        final EditText numeroIntroducido = findViewById(R.id.numeroIntroducido);

        // Boton para comprobar si el numero introducido es el correcto
        final Button btnComprobacion = findViewById(R.id.btnComprobacion);

//      TextView para mostrar los mensajes que se vayan poniendo
        consolaMensajes = findViewById(R.id.consolaMensajes);

        //Listener del boton comprobar.
        btnComprobacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Comprobacion que el texto no este vacio
                if (!numeroIntroducido.getText().toString().isEmpty()) {
                    // Comprobacion que el numero este dentro del rango de 1 a 100.
                    if (Integer.parseInt(numeroIntroducido.getText().toString()) > 0 && Integer.parseInt(numeroIntroducido.getText().toString()) < 101) {
                        // Comparacion si el numero aleatorio es igual a el numero introducido.
                        if (numeroGenerado == Integer.parseInt(numeroIntroducido.getText().toString())) {
                            consolaMensajes.setText(consolaMensajes.getText() + "\n" + numeroIntroducido.getText() + " es el numero aleatorio. \nLo has conseguido en " + contadorIntentos + " intentos.");// Le ponemos un mensaje en el TextView
                            numeroIntroducido.setText("");// Borramos el numero introducido
                            onCreateDialog(savedInstanceState).show();// Llamamos y mostramos el Dialog creado.
                        } else {
                            if (numeroGenerado > Integer.parseInt(numeroIntroducido.getText().toString())) {// si el numero introducido es mas grande que el numero aleatorio
                                Toast.makeText(MainActivity.this, "El numero aleatorio es mas grande que el introducido", Toast.LENGTH_SHORT).show();
                                consolaMensajes.setText(consolaMensajes.getText() + "\n" + numeroIntroducido.getText() + " es mas pequeño.");// Le ponemos un mensaje en el TextView
                            } else {
                                Toast.makeText(MainActivity.this, "El numero aleatorio es mas pequeño que el introducido", Toast.LENGTH_SHORT).show();
                                consolaMensajes.setText(consolaMensajes.getText() + "\n" + numeroIntroducido.getText() + " es mas grande.");// Le ponemos un mensaje en el TextView
                            }
                            numeroIntroducido.setText("");// Borramos el numero introducido
                            contadorIntentos++;// Sumamos 1 en el contador de intentos
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "El numero aleatorio es del 1 al 100", Toast.LENGTH_SHORT).show();// Le mostramos un mensaje con el Toast
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No has intoducido ningun numero", Toast.LENGTH_SHORT).show();// Le mostramos un mensaje con el Toast
                }
            }
        });

        final Button btnReiniciar = findViewById(R.id.btnReiniciar);// Boton para reiniciar el juego

//      Listener del boton reiniciar
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numeroGenerado = (int) (Math.random() * 100 + 1);// Numero aleatorio que encontrar
                consolaMensajes.setText("");// Limpia los mensajes anteriores
                contadorIntentos = 1;// Se reinicia el contador de intentos
            }
        });

        final Button btnRanking = findViewById(R.id.btnRanking);// Boton para mostrar el ranking
//      Boton para ver el ranking
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Declaramos un intent para pasar a la clase Ranking
                Intent intent = new Intent(MainActivity.this, Ranking.class);
                startActivity(intent);
            }
        });
    }

    //  Metodo para crear el Dialog
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View v = inflater.inflate(R.layout.activity_usuario, null);// Declaramos un View con un Inflter y el XML del Dialog
        nombreUsuarioIntroducido = v.findViewById(R.id.nombreUsuarioIntroducido);// Inizializamos el EditText que declaramos globalmente

        //Declaracion del boton
        builder.setView(v)
                .setPositiveButton(R.string.enviar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Comprobamos que no este vacio
                        if (!nombreUsuarioIntroducido.getText().toString().isEmpty()) {
                            Camera cam = new Camera();
                            cam.tomarFoto(MainActivity.this);// Llamar al metodo para hacer la foto
                        } else {
                            Toast.makeText(MainActivity.this, "Nombre de usuario no valido\nVuelve a presionar el boton Comprobar", Toast.LENGTH_SHORT).show();// Le mostramos un mensaje con el Toast
                        }
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    // Metodo para escribir el ranking en un archivo con objetos de User
    public void escribirArchivo(Context context) {
        try {
            file = new File(context.getFilesDir(), filename);// variable del archivo
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < adapter.listaUsers.size(); i++) {
                oos.writeObject(adapter.listaUsers.get(i));// esribir en el archivo con objetos
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo para leer el archivo del Ranking con objetos de User
    public void leerArchivo(Context context) {
        try {
            file = new File(context.getFilesDir(), filename);// variable del archivo
            if (!file.exists())// comprovacion de que no existe
                file.createNewFile();// creacion del archivo
            else {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Object auxiliar = ois.readObject();
                while (auxiliar != null) {
                    User users = (User) auxiliar;
                    adapter.listaUsers.add(users);// añadir el User al ArrayList de User
                    auxiliar = ois.readObject();
                }
                ois.close();
            }
        } catch (EOFException e) {
            System.err.println("NO HAY DATOS EN EL FICHERO.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // metodo para despues de hacer la foto
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERE_REQUEST && resultCode == RESULT_OK) {
            User u = new User(photoURI.toString(), nombreUsuarioIntroducido.getText().toString(), contadorIntentos);// creamos el objeto
            UserAdapter.listaUsers.add(u);// añadimos el objeto al ArrayList

            // ordenacion de los Users a partir del contador
            for (int i = 0; i < UserAdapter.listaUsers.size(); i++) {
                u.compareTo(UserAdapter.listaUsers.get(i));
            }
            Collections.sort(UserAdapter.listaUsers);

            // escribimos el nuevo User al archivo
            escribirArchivo(MainActivity.this);

            // intent para pasar a la clase Ranking
            Intent intent = new Intent(MainActivity.this, Ranking.class);
            startActivity(intent);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}