package com.universidadcauca.movil.fragmentos;

import android.content.res.Configuration;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {



    static final String POS = "pos";

    private String [] opciones;

    private DrawerLayout drawerLayout;
    private ListView listView;

    private ActionBarDrawerToggle drawerToggle;

    int pos;


    //modificar el titulo

    private CharSequence tituloSec;
    private CharSequence tituloApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        opciones= new String[]{"Home","Favoritos","Datos Personales","Publica","Buscar"};
        drawerLayout= (DrawerLayout) findViewById(R.id.contenedor_principal);
        listView = (ListView) findViewById(R.id.menu_izquierda);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(), android.R.layout.simple_list_item_1, opciones
         ));

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        changeFragment(position);


        }
        });


        tituloSec = getTitle();
        tituloApp= getTitle();

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_action_image_dehaze,R.string.abierto,R.string.cerrado){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);

            }
        };


        //para iconos
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        if(savedInstanceState != null)
            pos = savedInstanceState.getInt(POS);


        else
            pos =0 ;

        changeFragment(pos);

      }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //abrir menu lateral en la esquina

        if (drawerToggle.onOptionsItemSelected(item)){
            return true;

        }

        int id = item.getItemId();



        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //dudas
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();

    }

    public void onConfigurationChanged(Configuration newConfig){

        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void changeFragment(int position){
        pos= position;
        Fragment fragment = null;

        if (position == 0) {

            fragment = new principal();
        }


        if (position == 1) {

            fragment = new favorito();
        }

        if (position == 2) {

            fragment = new datos_personales();
        }
        if (position==3){
            fragment = new publicar();

        }

        if (position==4){

            fragment= new Buscar();

        }




        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        //trnsaccion para poner el fragmen en el layut principal

        fragmentManager.beginTransaction().replace(R.id.contenedor_frame, fragment).commit();

        listView.setItemChecked(position,true);

        //para el titulo de laseccion
        tituloSec=opciones[position];
        getSupportActionBar().setTitle(tituloSec);
        drawerLayout.closeDrawer(listView);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(POS, pos);

        super.onSaveInstanceState(outState);
    }
}
