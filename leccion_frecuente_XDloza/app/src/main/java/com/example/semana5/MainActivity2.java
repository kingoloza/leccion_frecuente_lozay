package com.example.semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

public class MainActivity2 extends AppCompatActivity implements Asynchtask {
    ListView Lstlibros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle  = this.getIntent().getExtras();
        Lstlibros = (ListView)findViewById(R.id.lista_libros);
        View header = getLayoutInflater().inflate(R.layout.header,null);
        Lstlibros.addHeaderView(header);
        int a = bundle.getInt("ID");
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=" + a;
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(url, datos, MainActivity2.this, MainActivity2.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Libros> lstUsuarios = Libros.JsonObjectsBuild(jsonArray);
        AdaptadorLibros adaptadorLibros = new AdaptadorLibros(this, lstUsuarios);
        Lstlibros.setAdapter(adaptadorLibros);

    }
}