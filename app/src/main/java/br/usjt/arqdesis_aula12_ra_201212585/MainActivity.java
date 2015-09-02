package br.usjt.arqdesis_aula12_ra_201212585;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import entity.Voo;

public class MainActivity extends Activity implements Serializable{

    private Spinner spnOrigem;
    private Spinner spnDestino;
    private Button btnBuscar;
    private ArrayAdapter<String> arrayAdapterOrigem;
    private ArrayAdapter<String> arrayAdapterDestino;
    private ArrayList<Voo> voos;
    private ArrayList<Voo>  voosEncontrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.voos = this.cadastroDeVoos();

        //vincula meu recurso da tela ao spn da classe java
        spnOrigem = (Spinner) findViewById(R.id.spn_origem);
        spnDestino = (Spinner) findViewById(R.id.spn_destino);
        //ArrayAdapter usada para vincular itens(array de strings) a um componente ListView(layout que iremos usar)
        //acessar o res simple_spiner_item (cria um spn exibindo um unico valor por linha)
        ArrayAdapter aaOrigem = ArrayAdapter.createFromResource(this, R.array.origem, android.R.layout.simple_spinner_item);
        spnOrigem.setAdapter(aaOrigem);
        ArrayAdapter aaDestino = ArrayAdapter.createFromResource(this, R.array.destino, android.R.layout.simple_spinner_item);
        spnDestino.setAdapter(aaDestino);

        btnBuscar = (Button) findViewById(R.id.btn_buscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String itemDestino = spnDestino.getSelectedItem().toString();
                String itemOrigem = spnOrigem.getSelectedItem().toString();
                //Toast.makeText(getApplicationContext(), "Voo escolhido. De: "+ itemOrigem + " Para: "+ itemDestino, Toast.LENGTH_SHORT).show();

                if (itemOrigem.equals(itemDestino)) {
                    Toast.makeText(getApplicationContext(), "A origem não pode ser a mesma do destino!", Toast.LENGTH_SHORT).show();
                } else {

                   // Toast.makeText(getApplicationContext(), buscarVoos(itemOrigem,itemDestino).size(), Toast.LENGTH_SHORT).show();

                    Bundle extra = new Bundle();
                    extra.putSerializable("extra", buscarVoos(itemOrigem, itemDestino));

                    Intent intent = new Intent(MainActivity.this, ListaVoos.class);
                    intent.putExtra("lista", extra);


                   // Intent i = new Intent(MainActivity.this,ListaVoos.class);
                    //i.putExtra("voos", ));
                    startActivity(intent);

                    try {
                    } catch (android.content.ActivityNotFoundException ex) {
                       ex.printStackTrace();
                        Toast.makeText(MainActivity.this, "Erro inesperado!", Toast.LENGTH_SHORT).show();
                    }                   // Bundle bundle= new Bundle();
                   // i.putExtras(bundle);

                  //  bundle.putSerializable("voos", );

                  //  i.putExtra("voos", voosEncontrados);
                }
            }
        });
    }




    public ArrayList<Voo> cadastroDeVoos() {
        ArrayList<Voo> voos = new ArrayList<Voo>();
        voos.add(new Voo("São Paulo", "Rio de Janeiro", "13:00", "01/09/2015"));
        voos.add(new Voo("São Paulo", "Minas Gerais", "14:00", "02/09/2015"));
        voos.add(new Voo("Rio de Janeiro", "São Paulo", "15:00", "03/09/2015"));
        voos.add(new Voo("Rio de Janeiro", "Minas Gerais", "16:00", "04/09/2015"));
        voos.add(new Voo("Minas Gerais", "São Paulo", "17:00", "04/09/2015"));
        voos.add(new Voo("Minas Gerais", "Rio de Janeiro", "18:00", "04/09/2015"));

        return voos;
    }

    private Voo buscarVoos(String origem, String destino) {
        for (Voo voo : voos) {

            if (origem.equals(voo.getOrigem()) && destino.equals(voo.getDestino())) {
                Log.i("info", "Voo: "+ voo);
                return voo;
            }
        }
        return null;
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
