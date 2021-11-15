package com.montoyaweb.findme.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.montoyaweb.findme.Lugares;
import com.montoyaweb.findme.Modelos.Lugar;
import com.montoyaweb.findme.R;

public class LugaresAdapter extends RecyclerView.Adapter<LugaresAdapter.ViewHolderRegistro> {

    ArrayList<Lugar> registros;

    public LugaresAdapter(ArrayList<Lugar> r){this.registros = r;}

    @NonNull
    @Override
    //crea vista
    public ViewHolderRegistro onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lugares_edit_delete, null, false);//(inflate pide la vista, raiz y si se agrega o no a la raiz
        return new ViewHolderRegistro(vista);// instancia y llama viholderregistro
    }

    @Override
    //conexion
    public void onBindViewHolder(@NonNull ViewHolderRegistro holder, int position) {

        holder.datosTarjeta(registros.get(position));

    }

    @Override
    //cantidad registros
    public int getItemCount() {
        return this.registros.size();
    }

    public class ViewHolderRegistro extends RecyclerView.ViewHolder {
        int id;

        TextView txtLugar;
        TextView txtdescripcion;
        TextView txtLatitud;
        TextView txtLongitud;



        public ViewHolderRegistro(@NonNull View itemView) {
            super(itemView);

            txtLugar =(TextView) itemView.findViewById(R.id.txt_Lugar_LugaresEditDelete);
            txtdescripcion =(TextView) itemView.findViewById(R.id.txt_Descripcion_LugaresEditDelete);
            txtLatitud =(TextView) itemView.findViewById(R.id.txt_Latitud_LugaresEditDelete);
            txtLongitud =(TextView) itemView.findViewById(R.id.txt_Longitud_LugaresEditDelete);

            ImageButton btnActualizar = (ImageButton) itemView.findViewById(R.id.btn_Update_LugaresEditDelete);
            ImageButton btnEliminar= (ImageButton) itemView.findViewById(R.id.btn_Delete_LugaresEditDelete);



        }

        public void datosTarjeta(Lugar lug){
            id=lug.getId();
            txtLugar.setText(lug.getLugar());
            txtdescripcion.setText(lug.getDescripcion());
            txtLatitud.setText(lug.getLatitud());
            txtLongitud.setText(lug.getLongitud());

        }
    }




}
