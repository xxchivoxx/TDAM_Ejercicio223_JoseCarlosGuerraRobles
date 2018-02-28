package com.example.carlos.tdam_ejercicio223_josecarlosguerrarobles;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPersonas;
    private LinearLayoutManager llm;
    private List<Persona> personas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPersonas = findViewById(R.id.recyclePersonas);
        llm = new LinearLayoutManager(getApplicationContext());
        rvPersonas.setLayoutManager(llm);
        personas = new ArrayList<>();

        HelperSQLiteDB con = new HelperSQLiteDB(this,"bd_personas",null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        db.execSQL("INSERT INTO persona VALUES('Jose Carlos Guerra Robles','14401032','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Gerardo Emmanuel Tovar Barragan','14401052','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Jorge Daniel Rubio Rodriguez','14401038','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Jose Carlos Guerra Robles','14401032','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Gerardo Emmanuel Tovar Barragan','14401052','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Jorge Daniel Rubio Rodriguez','14401038','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Jose Carlos Guerra Robles','14401032','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Gerardo Emmanuel Tovar Barragan','14401052','TICs')");
        db.execSQL("INSERT INTO persona VALUES('Jorge Daniel Rubio Rodriguez','14401038','TICs')");
        db.close();

        db = con.getReadableDatabase();
        String SQL = "SELECT * FROM persona";
        int i=0;
        Cursor resultadoConsulta = db.rawQuery(SQL,null);
        if (resultadoConsulta.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                personas.add(new Persona(resultadoConsulta.getString(0),resultadoConsulta.getString(1),resultadoConsulta.getString(2)));
                Toast.makeText(this, ""+i, Toast.LENGTH_SHORT).show();
                i++;
            } while(resultadoConsulta.moveToNext());
        }

        /*
        db.execSQL("INSERT INTO usuario VALUES('14401052','Gerardo Emmanuel Tovar Barragan','TICs')");
        db.execSQL("INSERT INTO usuario VALUES('14401036','Jorge Daniel Rubio Rodriguez','TICs')");
        db.execSQL("INSERT INTO usuario VALUES('14401032','Jose Carlos GUerra Robles','TICs')");
        db.execSQL("INSERT INTO usuario VALUES('14401052','Gerardo Emmanuel Tovar Barragan','TICs')");
        db.execSQL("INSERT INTO usuario VALUES('14401036','Jorge Daniel Rubio Rodriguez','TICs')");
        */

        //AQUI SE INSERTAN LAS PERSONAS EN EL LIST, DE LA BASE DE DATOS PARA MOSTRAR EN RECUCLE VIEW
        /*
        personas.add(new Persona("Jose Carlos Guerra Robles","14401032","TIC"));
        personas.add(new Persona("Gerardo Emmanuel Tovar Barragan","14401052","TIC"));
        personas.add(new Persona("Jorge Daniel Rubio Rodriguez","14401036","TIC"));
        personas.add(new Persona("Jose Carlos Guerra Robles","14401032","TIC"));
        personas.add(new Persona("Gerardo Emmanuel Tovar Barragan","14401052","TIC"));
        personas.add(new Persona("Jorge Daniel Rubio Rodriguez","14401036","TIC"));
        personas.add(new Persona("Jose Carlos Guerra Robles","14401032","TIC"));
        personas.add(new Persona("Gerardo Emmanuel Tovar Barragan","14401052","TIC"));
        personas.add(new Persona("Jorge Daniel Rubio Rodriguez","14401036","TIC"));
        //...
        */
        RVAdapterPersona adapter = new RVAdapterPersona(personas);
        rvPersonas.setAdapter(adapter);

    }
}
