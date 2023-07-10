package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.semana5.Adaptadores.AdaptadorLibros;
import com.example.semana5.Adaptadores.AdaptadorRevistas;
import com.example.semana5.Modelos.Libros;
import com.example.semana5.Modelos.Revistas;
import com.example.semana5.WebService.Asynchtask;
import com.example.semana5.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener{
    ListView LstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LstOpciones = (ListView) findViewById(R.id.lista_usuario);
        View header = getLayoutInflater().inflate(R.layout.header, null);
        LstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
        LstOpciones.setOnItemClickListener(this);
    }


    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Revistas> lstUsuarios = Revistas.JsonObjectsBuild(jsonArray);
        AdaptadorRevistas adaptadorUsuario = new AdaptadorRevistas(this, lstUsuarios);
        LstOpciones.setAdapter(adaptadorUsuario);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Revistas revista = (Revistas) adapterView.getItemAtPosition(position);
        if (position == 1) {
            int a = 3;
            Bundle b = new Bundle();
            b.putInt("ID", a);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 2) {
            int d = 2;
            Bundle b = new Bundle();
            b.putInt("ID", d);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 3) {
            int c = 1;
            Bundle b = new Bundle();
            b.putInt("ID", c);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtras(b);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
    }
}


