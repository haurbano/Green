package salt.movil.green;

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
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import salt.movil.green.adapters.AdapterDes;
import salt.movil.green.databinding.ActivityMainBinding;
import salt.movil.green.models.Desecho;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActivityMainBinding binding;
    List<Desecho> data;

    ImageView imgHeaderDrawer;

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

    }

    private void quemarDatos() {
        data = new ArrayList<>();

        Desecho desecho1 = new Desecho();
        desecho1.setNombre("Salchichas dañadas");
        desecho1.setCantidad(25);
        desecho1.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");

        Desecho desecho2 = new Desecho();
        desecho2.setNombre("Suero de queso");
        desecho2.setCantidad(25);
        desecho2.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");

        Desecho desecho3 = new Desecho();
        desecho3.setNombre("Huesos de marrano");
        desecho3.setCantidad(65);
        desecho3.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");

        Desecho desecho4 = new Desecho();
        desecho4.setNombre("deseños tecnologicos");
        desecho4.setCantidad(28);
        desecho4.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");

        Desecho desecho5 = new Desecho();
        desecho5.setNombre("Desecho de carbon");
        desecho5.setCantidad(10);
        desecho5.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");

        Desecho desecho6 = new Desecho();
        desecho6.setNombre("Astillas de madera");
        desecho6.setCantidad(56);
        desecho6.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");

        data.add(desecho1);
        data.add(desecho2);
        data.add(desecho3);
        data.add(desecho4);
        data.add(desecho5);
        data.add(desecho6);

        AdapterDes adapterDes = new AdapterDes(data,getLayoutInflater());
        binding.containerList.setAdapter(adapterDes);


    }

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
}
