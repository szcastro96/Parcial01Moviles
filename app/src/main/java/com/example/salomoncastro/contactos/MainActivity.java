package com.example.salomoncastro.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContactos;
    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContactos = (ListView) findViewById(R.id.lvContactos);
        contactos = new ArrayList<>();
        contactos.add(new Contacto("Carlos","Castro",73237053,"Santa Tecla"));
        contactos.add(new Contacto("Andrea","Rovelo",73237053,"Santa Tecla1"));
        contactos.add(new Contacto("Josseh","Menjivar",73237053,"Santa Tecla2"));
        contactos.add(new Contacto("Rodrigo","Castro",73237053,"Santa Tecla3"));
        contactos.add(new Contacto("Adriana","Castaneda",73237053,"Santa Tecla4"));
        contactos.add(new Contacto("Salomon","Zepeda",73237053,"Santa Tecla5"));

        ArrayList<String> nombreContacto = new ArrayList<>();

        for (Contacto contacto: contactos){
            nombreContacto.add(contacto.getNombre()+" "+contacto.getApellido());
        }

        lvContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));
        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra("NOMBRECONTACTO",contactos.get(posicion).getNombre());
                intent.putExtra("APELLIDOCONTACTO",contactos.get(posicion).getApellido());
                intent.putExtra("TELEFONOCONTACTO",contactos.get(posicion).getTelefono());
                intent.putExtra("DIRECCIONCONTACTO",contactos.get(posicion).getDireccion());
                startActivity(intent);
            }
        });
    }
}
