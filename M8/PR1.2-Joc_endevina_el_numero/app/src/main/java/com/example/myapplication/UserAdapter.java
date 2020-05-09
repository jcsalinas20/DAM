package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class UserAdapter extends ArrayAdapter<User> {

    private Context mContext;
    static ArrayList<User> listaUsers = new ArrayList<User>();// ArrayList para guardar los Users

    /*********CONSTRUCTOR*********/
    public UserAdapter(@NonNull Context context, ArrayList<User> list) {
        super(context, 0, list);
        mContext = context;
        listaUsers = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_user_adapter, parent, false);

        User perfilUsuario = listaUsers.get(position);

        ImageView imagen = (ImageView) listItem.findViewById(R.id.imageView_fotoPerfil);
        Uri foto = Uri.parse(perfilUsuario.getFotoPerfil());
        imagen.setImageURI(foto);// foto del user

        TextView nombreUser = (TextView) listItem.findViewById(R.id.textView_user);
        nombreUser.setText(perfilUsuario.getNombre());// nombre del user

        TextView contadorIntentos = (TextView) listItem.findViewById(R.id.textView_contador);
        contadorIntentos.setText(perfilUsuario.getContador() + " intentos");// intentos del user

        return listItem;
    }
}