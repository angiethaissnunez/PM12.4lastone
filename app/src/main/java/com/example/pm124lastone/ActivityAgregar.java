package com.example.pm124lastone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.pm124lastone.Configuraciones.transaccion;
import com.example.pm124lastone.Configuraciones.SQLiteConexion;
import java.io.ByteArrayOutputStream;

public class ActivityAgregar extends AppCompatActivity {

    SQLiteConexion conexion;
    Linetest line;
    Button back,save;
    EditText name;
    boolean estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        estado=true;

        conexion = new SQLiteConexion(this, transaccion.NAME_DATABASE,null,1);
        name = (EditText) findViewById(R.id.txtname);
        line = (Linetest) findViewById(R.id.Line);
       save = (Button) findViewById(R.id.btnsave);

       //if u want to go back
       back = (Button) findViewById(R.id.btnback);
       back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityAgregar.this, MainActivity.class));

            }
        });



        save .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write();
            }
        });


    }

    private void write(){
        if(line.clean){
            Toast.makeText(getApplicationContext(), "Write your sign.", Toast.LENGTH_LONG).show();
            return;
        }else if(name.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Write your name here.", Toast.LENGTH_LONG).show();
            return;
        }

        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(transaccion.descripcion,name.getText().toString());
        ByteArrayOutputStream bay = new ByteArrayOutputStream(10480);

        Bitmap bitmap = Bitmap.createBitmap(line.getWidth(), line.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        line.draw(canvas);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , bay);
        byte[] bl = bay.toByteArray();
        String img= Base64.encodeToString(bl,Base64.DEFAULT);
        values.put(transaccion.imagen, img);

        Long result = db.insert(transaccion.TABLE_SIGN, transaccion.id, values);
        Toast.makeText(getApplicationContext(), "your signature is saved", Toast.LENGTH_LONG).show();
      line.drawhere();
      name.setText("");

        db.close();
    }
}