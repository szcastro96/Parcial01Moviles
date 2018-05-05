package com.example.salomoncastro.contactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNombre, tvTelefono, tvApellido, tvDireccion;
    ImageView ivRegresar;
    RelativeLayout relativeLayout;
    Button button;
    int telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("NOMBRECONTACTO");
        String apellido = bundle.getString("APELLIDOCONTACTO");
        telefono = bundle.getInt("TELEFONOCONTACTO");
        String direccion = bundle.getString("DIRECCIONCONTACTO");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvApellido = (TextView) findViewById(R.id.tvApellido);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvDireccion = (TextView) findViewById(R.id.tvDireccion);
        relativeLayout = (RelativeLayout) findViewById(R.id.rlCall);
        button = (Button) findViewById(R.id.btnCall);

        ivRegresar = (ImageView) findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }

          });

        tvNombre.setText(nombre);
        tvApellido.setText(apellido);
        tvTelefono.setText(""+telefono);
        tvDireccion.setText(direccion);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(DetalleContacto.this, "Falta activar el permiso de llamadas", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            }
        });
    }

    public void llamar(View v){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(DetalleContacto.this, "Falta activar el permiso de llamadas", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }

}
