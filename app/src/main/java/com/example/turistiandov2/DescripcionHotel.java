package com.example.turistiandov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.turistiandov2.moldes.MoldeHotel;

public class DescripcionHotel extends AppCompatActivity {

    MoldeHotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_hotel);

        hotel=(MoldeHotel)getIntent().getSerializableExtra("datoshotel");
        Toast.makeText(this, hotel.getNombre(), Toast.LENGTH_LONG).show();


        //fotoEmpleado.setImageResource(trabajador.getFotoTrabajador());
        //nombre.setText(trabajador.getNombreTrabajador());


    }
}