package salt.movil.green;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import salt.movil.green.adapters.AdapterDes;
import salt.movil.green.databinding.ActivityMainBinding;
import salt.movil.green.models.Desecho;
import salt.movil.green.models.Empresa;
import salt.movil.green.utils.DatosQuemados;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener, AdapterView.OnItemClickListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActivityMainBinding binding;
    List<Desecho> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_drawer);


        drawer.setDrawerListener(this);
        toggle =  new ActionBarDrawerToggle(this, drawer,R.string.open, R.string.close);
        navigationView.setNavigationItemSelectedListener(this);

        quemarDatos();
        binding.containerList.setOnItemClickListener(this);
    }

    //region quemar datos
    private void quemarDatos() {
        DatosQuemados dq =  new DatosQuemados();
        data = dq.getData();
        AdapterDes adapterDes = new AdapterDes(data,getLayoutInflater());
        binding.containerList.setAdapter(adapterDes);


    }

    public List<Desecho> getData(){
        return data;
    }
    //endregion

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_buscar, menu);

        MenuItem menuBusqueda = menu.findItem(R.id.menu_buscar);
        SearchView buscar = (SearchView) MenuItemCompat.getActionView(menuBusqueda);
        buscar.setQueryHint("Buscar desecho");
        buscar.setOnQueryTextListener(this);

        return true;
    }

    //region Ddrawer
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //endregion

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawers();
        return false;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        BuscarDes(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        BuscarDes(newText);
        return false;
    }

    private void BuscarDes(String newText) {
        List<String> nombresDes = LLenarNombres();
        String txtUp = newText.toUpperCase();
        List<Desecho> resultado = new ArrayList<>();

        for (int i=0;i<nombresDes.size();i++){
            if (nombresDes.get(i).toUpperCase().contains(txtUp)){
                resultado.add(data.get(i));
            }
        }
        AdapterDes adapter = new AdapterDes(resultado,getLayoutInflater());
        binding.containerList.setAdapter(adapter);
    }

    private List<String> LLenarNombres() {
        List<String> nombres = new ArrayList<>();
        for(Desecho d: data){
            nombres.add(d.getNombre());
        }
        return nombres;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DetalleActivity.class);
        intent.putExtra("posicion",position);
        startActivity(intent);
    }
}
