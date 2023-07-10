package com.example.semana5.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revistas {
    private String id;
    private String name;
    private String portada;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Revistas(JSONObject a) throws JSONException {
        id = a.getString("journal_id").toString();
        name = a.getString("name").toString() ;
        portada = a.getString("portada").toString() ;
    }
    public static ArrayList<Revistas> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revistas> usuarios = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            usuarios.add(new Revistas(datos.getJSONObject(i)));
        }
        return usuarios;
    }


}
