package salt.movil.green;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import salt.movil.green.databinding.ActivityDetalleBinding;
import salt.movil.green.models.Desecho;
import salt.movil.green.utils.DatosQuemados;

public class DetalleActivity extends AppCompatActivity {

    List<Desecho> data;
    ActivityDetalleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detalle);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int pos = getIntent().getIntExtra("posicion",0);
        binding.setDes(getDesecho(pos));

    }

    private Desecho getDesecho(int position){
        DatosQuemados dq = new DatosQuemados();
        List<Desecho> data = dq.getData();
        return data.get(position);
    }
}
