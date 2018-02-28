package com.example.carlos.tdam_ejercicio223_josecarlosguerrarobles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlos on 27/02/18.
 */

public class RVAdapterPersona extends RecyclerView.Adapter<RVAdapterPersona.PersonaViewHolder> {
    List<Persona> personas;

    RVAdapterPersona(List<Persona> personas){
        this.personas = personas;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona,parent,false);
        PersonaViewHolder pvh = new PersonaViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {
        holder.personaName.setText(personas.get(position).nombre);
        holder.personaNumControl.setText(personas.get(position).NumControl);
        holder.personaCarrera.setText(personas.get(position).carrera);
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder {

        TextView personaName;
        TextView personaNumControl;
        TextView personaCarrera;

        PersonaViewHolder(View itemView) {
            super(itemView);
            personaName = itemView.findViewById(R.id.txtNombre);
            personaNumControl = itemView.findViewById(R.id.txtNoControl);
            personaCarrera = itemView.findViewById(R.id.txtCarrera);
        }
    }
}

