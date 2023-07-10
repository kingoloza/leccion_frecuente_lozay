package com.example.semana5.Adaptadores;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.semana5.Modelos.Revistas;
import com.example.semana5.R;

import java.util.ArrayList;

public class AdaptadorRevistas extends ArrayAdapter<Revistas> {
    public AdaptadorRevistas(Context context, ArrayList<Revistas> datos) {
        super(context, R.layout.lista_revistas, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_revistas, null);
        TextView lblNombre = (TextView)item.findViewById(R.id.titulo);lblNombre.setText(getItem(position).getName());
        ImageView imageView = (ImageView)item.findViewById(R.id.portada);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);
        return(item);
    }
}
