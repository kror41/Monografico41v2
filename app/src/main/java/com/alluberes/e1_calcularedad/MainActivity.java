package com.alluberes.e1_calcularedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    /// TODO (11) Declarar objeto tipo EditText de "nombre_persona"
    EditText nombre_persona;
    /// TODO (12) Declarar objeto tipo DatePicker de "date_of_birth"
    DatePicker date_or_birth;
    /// TODO (13) Declarar objeto tipo Button de "calcular_edad"
    Button calcular_edad;
    /// TODO (14) Declarar objeto tipo EditText de "edad_actual"
    TextView edad_actual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /// TODO (15) Relacionar elemento de layout para nombre de persona con variable
        nombre_persona = (EditText)findViewById(R.id.nombre_persona);
        /// TODO (16) Relacionar elemento de layout para fecha de nacimiento con variable
        date_or_birth = (DatePicker)findViewById(R.id.date_of_birth);
        /// TODO (17) Relacionar elemento de layout para accion de calcular edad con variable
        calcular_edad = (Button)findViewById(R.id.calcular_edad);
        /// TODO (18) Relacionar elemento de layout para mostrar la edad actual con variable
        edad_actual = (TextView)findViewById(R.id.edad_actual);

        /// TODO (20) Asignar accion para el evento setOnClickListener del elemento de boton que calcula la edad
        /// en el evento onClick se debe tomar el valor del DatePicker que indica la fecha de nacimiento,
        /// e invocar la funcion que se crea en el paso 19 para calcular la edad
        /// y mostrar en el elemento del layout para mostrar edad un texto en el siguiente orden
        /// [nombre de la persona] tiene [edad] años de edad
        /// debe sustituir los valores que estan en los corchetes por los valores de los elementos del layout
        calcular_edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int dia = date_or_birth.getDayOfMonth();
                int m = date_or_birth.getMonth();
                int y = date_or_birth.getYear();

                calcularEdad(y,m,dia);

            }
        });
    }

    /// TODO (19) Crear funcion para calcular edad. Ha de recibir como parametro año, mes y dia
    /// internamente ha de sacar la diferencia entre la fecha actual y la fecha dada y retornara el valor
   public void calcularEdad(int y, int m, int dia) {

       Calendar fecha_actual = Calendar.getInstance();
       int cDia = fecha_actual.get(Calendar.DAY_OF_MONTH);
       int cM = fecha_actual.get(Calendar.MONTH);
       int cY = fecha_actual.get(Calendar.YEAR);
       String nombre = nombre_persona.getText().toString();

        /*String d = String.valueOf(date_or_birth.getDayOfMonth());
        String month = String.valueOf(date_or_birth.getMonth());
        String ano = String.valueOf(date_or_birth.getYear());
        int edad = cy - date_or_birth.getYear();
        */
       int edad = cY - y;
       if(m>cM){
           edad--;
       }else if(cM==m){
           if(dia>cDia){

               edad--;
           }
       }

       if (nombre.length() == 0) {
           Toast.makeText(this, "Completar Nombre", Toast.LENGTH_SHORT).show();
       } else{
           edad_actual.setText(nombre + " tiene: " + " edad:" + edad);
       }
   }


}
