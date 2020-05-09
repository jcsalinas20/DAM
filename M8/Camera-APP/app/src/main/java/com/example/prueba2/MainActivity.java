package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    String fichero = "foto.txt";
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.imageView);

        String rutaFoto = recogerRutaFoto();// regoger la ruta del fichero
        if(rutaFoto != null){// comprobar que no sea nulo
            Toast.makeText(this, rutaFoto, Toast.LENGTH_SHORT).show();//Mostrar ruta foto
            img.setImageURI(FileProvider.getUriForFile(this, "com.example.prueba2", new File(rutaFoto)));// Mostrar la ruta
            rotarImagen(rutaFoto);// rotar imagen (solo para el mobil fisico)
        } else {
            Toast.makeText(this, "Se ha cancelado la operacion.", Toast.LENGTH_SHORT).show();
        }

        // Permisos de la camera y storege
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }
    }

    String currentPhotoPath;// varible para guardar la ruta de la imagen.

    // Creacion de la ruta de la imagen
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        currentPhotoPath = image.getAbsolutePath();// guardar ruta en variable
        return image;
    }

    static final int REQUEST_TAKE_PHOTO = 2;
    public void tomarFoto(View view) {
        final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.prueba2",
                        photoFile);
                guardarRutaEnFichero(photoFile.getAbsolutePath());// Guardar ruta en el fichero
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    static final int CAMERE_REQUEST = 2;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERE_REQUEST && resultCode == RESULT_OK) {
            File photoFile = new File(currentPhotoPath);
            Uri photoURI = FileProvider.getUriForFile(this,
                    "com.example.prueba2",
                    photoFile);// Crear URI
            img.setImageURI(photoURI);// Mostrar la imagen en ImageView
            rotarImagen(currentPhotoPath);// Metodo para rotar la imagen
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    // Metodo para rotar la imagen dependiendo la posicion en la que lo haga(solo funciona en dispositivos fisicos)
    private void rotarImagen(String rutaImagen){
        try {
            ExifInterface exif = new ExifInterface(rutaImagen);
            int rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (rotation) {
                case 6:
                    img.setRotation(90);
                    break;
                case 3:
                    img.setRotation(180);
                    break;
                case 1:
                    img.setRotation(0);
                    break;
                case 8:
                    img.setRotation(-90);
                    break;
            }
        } catch (IOException e){}
    }

    // Guardar la ruta en el fichero
    public void guardarRutaEnFichero(String ruta){
        try{
            File file = new File(getFilesDir(), fichero);
            PrintStream ps = new PrintStream(file);
            ps.println(ruta);
            ps.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    // Metodo para recoger la ruta del fichero
    private String recogerRutaFoto(){
        try{
            File file = new File(getFilesDir(), fichero);
            if (file.exists()) {
                Scanner lector = new Scanner(file);
                String archivo = lector.nextLine();
                lector.close();
                return archivo;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
