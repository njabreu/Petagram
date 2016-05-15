package com.example.nelson.petagram;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FillMascotaList();
        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        //--Activar toolbar
        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        agregarFAB();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager grid = new GridLayoutManager(this,2);
        listaMascotas.setLayoutManager(llm);

       inicializarAdaptador();

        ImageButton btnTop5 = (ImageButton)findViewById(R.id.btnTop5);
        btnTop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListaMascotas.class);
                startActivity(intent);
            }
        });


    }

    //para agregar el floating action button
    public void agregarFAB()
    {
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fabMiActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Abrir la Cámara", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ///Inicializa el adaptador para el recyclerview
    public void inicializarAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        listaMascotas.setAdapter(adapter);
    }

    //llena el arraylist the mascotas
    public void FillMascotaList(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Chiqui",R.drawable.perrita_1,0));
        mascotas.add(new Mascota("Ramonita",R.drawable.gatito_2,0));
        mascotas.add(new Mascota("Kim",R.drawable.hamster_3,0));
        mascotas.add(new Mascota("Pepito",R.drawable.loro_4,0));
        mascotas.add(new Mascota("Tutankamon",R.drawable.tortuga_5,0));
    }

}
