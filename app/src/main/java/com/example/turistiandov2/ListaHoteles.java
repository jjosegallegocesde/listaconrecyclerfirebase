package com.example.turistiandov2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.turistiandov2.adaptadores.AdaptadorHotel;
import com.example.turistiandov2.moldes.MoldeHotel;

import java.util.ArrayList;

public class ListaHoteles extends AppCompatActivity {

    ArrayList<MoldeHotel> hoteles = new ArrayList<>();
    RecyclerView listadinamica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_hoteles);

        listadinamica=findViewById(R.id.listaHotelesDinamica);
        listadinamica.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        crearListaHoteles();
        AdaptadorHotel adaptadorHotel= new AdaptadorHotel(hoteles);
        listadinamica.setAdapter(adaptadorHotel);

    }

    public void crearListaHoteles(){

        hoteles.add(new MoldeHotel("Hotel1","$15000","3225962363",R.drawable.hoteluno));
        hoteles.add(new MoldeHotel("Hotel2","$15000","3225962363",R.drawable.hoteldos));
        hoteles.add(new MoldeHotel("Hotel3","$15000","3225962363",R.drawable.hoteltres));
        hoteles.add(new MoldeHotel("Hotel4","$15000","3225962363",R.drawable.hotelcuatro));
        hoteles.add(new MoldeHotel("Hotel5","$15000","3225962363",R.drawable.hotelcinco));



    }

}