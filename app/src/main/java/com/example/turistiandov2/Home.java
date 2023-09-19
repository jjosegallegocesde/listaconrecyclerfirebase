package com.example.turistiandov2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Locale;

public class Home extends AppCompatActivity {

    //ZONA DE LOS ATRIBUTOS
    Button botonHoteles;
    Button botonRestaurantes;
    Button botonTurismo;

    TextView nombreCliente;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String nombre=getIntent().getStringExtra("nombre");

        botonHoteles=findViewById(R.id.botonhoteles);
        botonRestaurantes=findViewById(R.id.botonrestaurantes);
        botonTurismo=findViewById(R.id.botonsitios);
        nombreCliente=findViewById(R.id.usuario);

        //Uniendo el texto del PUTEXTRA con el TEXTVIEW
        // Verificar la conexión a Internet
        if (isConnectedToInternet(this)) {
            // El emulador está conectado a Internet
            Toast.makeText(this, "Conectado a Internet", Toast.LENGTH_SHORT).show();
        } else {
            // El emulador no está conectado a Internet
            Toast.makeText(this, "Sin conexión a Internet", Toast.LENGTH_SHORT).show();
        }


        // Obtener datos de Firestore (reemplaza 'tu_coleccion' y 'tu_documento' con los valores correctos)
        // Obtener datos de Firestore
        db.collection("prouebas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            StringBuilder result = new StringBuilder();
                            for (DocumentSnapshot document : task.getResult()) {
                                try {
                                    String data = document.getString("nombre"); // Cambia "nombre" por el nombre del campo en tu documento
                                    if (data != null) {
                                        result.append("Nombre: ").append(data).append("\n");
                                        Toast.makeText(Home.this, data, Toast.LENGTH_SHORT).show();
                                    } else {
                                        // El campo "nombre" es nulo en este documento
                                        Log.e("Firestore", "Campo 'nombre' nulo en el documento");
                                    }
                                } catch (Exception e) {
                                    // Captura cualquier excepción que pueda ocurrir al obtener el campo "nombre"
                                    Log.e("Firestore", "Error al obtener 'nombre': " + e.getMessage());
                                }
                            }

                            //dataTextView.setText(result.toString());
                        } else {
                            // Maneja la excepción general que puede ocurrir al obtener los documentos
                            Exception exception = task.getException();
                            if (exception != null) {
                                Log.e("Firestore", "Error al obtener documentos: " + exception.getMessage());
                            }
                            Toast.makeText(Home.this, "Error al obtener datos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });




        //detectando eventos
        botonHoteles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHoteles=new Intent(Home.this,HotelesHome.class);
                startActivity(intentHoteles);
            }
        });




    }

    // Método para verificar la conexión a Internet
    private boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }


    public void cambiarIdioma(String idioma){

        //configurar el lenguaje del telefono
        Locale lenguaje=new Locale(idioma);
        Locale.setDefault(lenguaje);

        //Configuramos globalmente el telefono
        Configuration configuracionTelefono=getResources().getConfiguration();
        configuracionTelefono.locale=lenguaje;

        //Ejecutamos la configuracion
        getBaseContext().getResources().updateConfiguration(configuracionTelefono,getBaseContext().getResources().getDisplayMetrics());

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int itemSeleccionado=item.getItemId();
        switch (itemSeleccionado){

            case(R.id.opcion1):
                this.cambiarIdioma("en");
                Intent intentIngles=new Intent(Home.this,Home.class);
                startActivity(intentIngles);
                break;
            case(R.id.opcion2):
                this.cambiarIdioma("es");
                Intent intentEspanol=new Intent(Home.this,Home.class);
                startActivity(intentEspanol);
                break;
            case(R.id.opcion3):

                break;
            case(R.id.opcion4):

                Intent intent = new Intent(Home.this,Acerca.class);
                startActivity(intent);

                break;

        }

        return super.onOptionsItemSelected(item);
    }



}