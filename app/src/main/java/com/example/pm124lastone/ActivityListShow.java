package com.example.pm124lastone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

import com.example.pm124lastone.Configuraciones.SQLiteConexion;
import com.example.pm124lastone.Configuraciones.transaccion;
public class ActivityListShow extends AppCompatActivity {

    SQLiteConexion conexion;
    Button btnbacki;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Descripcion> lisshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        conexion = new SQLiteConexion(this, transaccion.NAME_DATABASE,null,1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewline);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        lisshow = new ArrayList<>();
        yoursign();

        adapter = new AdapterHolder(lisshow);
        recyclerView.setAdapter(adapter);

        btnbacki = (Button) findViewById(R.id.btnbacki);
        btnbacki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityListShow.this, MainActivity.class));

            }
        });

    }

    private void yoursign(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Descripcion Dfirm = null;
        Cursor cursor = db.rawQuery
                ("SELECT * FROM "+ transaccion.TABLE_SIGN,null);
        while (cursor.moveToNext()){
            Dfirm = new Descripcion();
            Dfirm.setId(cursor.getInt(0));
            Dfirm.setDescripcion(cursor.getString(1));
            Dfirm.setImagen(cursor.getString(2));

            lisshow.add(Dfirm);
        }
    }


}