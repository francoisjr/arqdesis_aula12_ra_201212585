package br.usjt.arqdesis_aula12_ra_201212585;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import entity.Voo;

public class ListaVoos extends AppCompatActivity {
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voos);
        ListView listView = (ListView) findViewById(R.id.layoutListaVoos);

       // ArrayList<Voo> dados = (ArrayList<Voo>) getIntent().getExtras("voos");

        //Intent intent = new Intent();
       // ArrayList<Voo> lista = (ArrayList<Voo>) intent.getSerializable("nvp");

        Bundle extra = getIntent().getBundleExtra("extra");
        ArrayList<Voo> lista = (ArrayList<Voo>) extra.getSerializable("lista");


        // Recupera os parâmetros passados pelo atributo estatico
      //  ArrayList dados = (ArrayList<Voo>) getIntent().get

      //  ArrayList arrayLista = (ArrayList) bundle.getBundle("voos");

        ArrayAdapter<Voo> aa = new ArrayAdapter<Voo>(this, android.R.layout.simple_list_item_2, android.R.id.text1, lista );

        listView.setAdapter(aa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_voos, menu);
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
