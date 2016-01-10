package com.yata.alcoolougasolina;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valorAlcool;
    private EditText valorGasolina;
    private Button btnVerificar;
    private TextView resultadoAnalise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorAlcool = (EditText) findViewById(R.id.campo_valor_alcool);
        valorGasolina = (EditText) findViewById(R.id.campo_valor_gasolina);
        btnVerificar = (Button) findViewById(R.id.btn_verificar_valor);
        resultadoAnalise = (TextView) findViewById(R.id.resultado);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoPrecoAlcool = valorAlcool.getText().toString();
                String textoPrecoGasolina = valorGasolina.getText().toString();

                Double valor_Alcool = Double.parseDouble(textoPrecoAlcool);
                Double valor_Gasolina = Double.parseDouble(textoPrecoGasolina);

                double resultado = valor_Alcool / valor_Gasolina;

                if (resultado >= 0.7)
                    resultadoAnalise.setText("Melhor utilizar  gasolina");
                else
                    resultadoAnalise.setText("Melhor utilizar alcool");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
