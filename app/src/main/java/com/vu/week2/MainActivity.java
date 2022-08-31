package com.vu.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText edNombre, edTelefono, edEmail, edDescripcion;
    private String nombre, telefono, email, descripcion;
    private Date data;
    private Button btnSiguiente;
    private DatePicker datePicker;
    private InfoClass infoClass= new InfoClass();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre        = findViewById(R.id.edNombre);
        edTelefono      = findViewById(R.id.edTelefono);
        edEmail         = findViewById(R.id.edEmail);
        datePicker      = findViewById(R.id.datePicker);
        edDescripcion   = findViewById(R.id.edDescripcion);
        btnSiguiente    = findViewById(R.id.btnSiguiente);


        if(getIntent().getExtras() != null){
            infoClass = (InfoClass) getIntent().getExtras().getSerializable("infoclass");
            edNombre.setText(infoClass.getNombre());
            edTelefono.setText(infoClass.getTelefono());
            edEmail.setText(infoClass.getEmail());
            edDescripcion.setText(infoClass.getTelefono());
            Calendar calBundle= Calendar.getInstance();
            calBundle.setTime(infoClass.getData());
            int mDay = calBundle.get(Calendar.DAY_OF_MONTH);
            int mMonth = calBundle.get(Calendar.MONTH);
            int mYear = calBundle.get(Calendar.YEAR);
            datePicker.init(mYear, mMonth, mDay, null);
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getScreenData();
               Bundle bundle = new Bundle();
                Intent intent = new Intent (MainActivity.this, showdata.class);
                bundle.putSerializable("infoclass",infoClass);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    private void getScreenData(){
        //Get name
        if(!edNombre.getText().toString().isEmpty()){
            nombre = edNombre.getText().toString();
        }else{
            edNombre.requestFocus();
            edNombre.setHint("Debe introducir un nombre");
        }

        //Get Phone
        if(!edTelefono.getText().toString().isEmpty()){
            telefono = edTelefono.getText().toString();
        }else{
            edTelefono.requestFocus();
            edTelefono.setHint("Debe introducir un telefono");
        }
        //Get email
        if(!edEmail.getText().toString().isEmpty()){
            email = edEmail.getText().toString();
        }else{
            edEmail.requestFocus();
            edEmail.setHint("Debe introducir un email");
        }

        //Get descripcion
        if(!edDescripcion.getText().toString().isEmpty()){
            descripcion = edDescripcion.getText().toString();
        }else{
            edDescripcion.requestFocus();
            edDescripcion.setHint("Debe introducir un email");
        }

        //Get info DatePicker
        Calendar calendar = Calendar.getInstance();
        int anyo = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        //data = new SimpleDateFormat("dd/MM/yyyy").parse(mes +"/"+dia+"/"+anyo);
        try{
            data = new SimpleDateFormat("dd/MM/yyyy").parse(mes +"/"+dia+"/"+anyo);
        }catch(Exception e){ }
        infoClass.setNombre(nombre);
        infoClass.setTelefono(telefono);
        infoClass.setEmail(email);
        infoClass.setDescripcion(descripcion);
        infoClass.setData(data);

    }
}