package com.vu.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showdata extends AppCompatActivity {

    InfoClass infoClass;
    TextView tvNombreGet, tvTelefonoGet, tvEmailGet, tvDateGet, tvDescriptionGet;
    Button btEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        tvNombreGet         = findViewById(R.id.tvNombreGet);
        tvTelefonoGet       = findViewById(R.id.tvTelefonoGet);
        tvEmailGet          = findViewById(R.id.tvEmailGet);
        tvDateGet           = findViewById(R.id.tvDateGet);
        tvDescriptionGet    = findViewById(R.id.tvDescriptionGet);
        btEditar            = findViewById(R.id.btEditar);

        if(getIntent().getExtras() != null){
            infoClass = (InfoClass) getIntent().getExtras().getSerializable("infoclass");
        }
        tvNombreGet.setText(infoClass.getNombre());
        tvTelefonoGet.setText(infoClass.getTelefono());
        tvEmailGet.setText(infoClass.getEmail());
        tvDescriptionGet.setText(infoClass.getDescripcion());
        tvDateGet.setText(infoClass.getData().toString());

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(showdata.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("infoclass",infoClass);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}