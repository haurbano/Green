package salt.movil.green.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import salt.movil.green.databinding.TemplateAdapterDesBinding;
import salt.movil.green.models.Desecho;

/**
 * Created by Hamilton on 27/02/2016.
 */
public class AdapterDes extends BaseAdapter {
    List<Desecho> data;
    LayoutInflater inflater;

    public AdapterDes(List<Desecho> data, LayoutInflater inflater) {
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TemplateAdapterDesBinding template = TemplateAdapterDesBinding
                .inflate(inflater,parent,false);

        template.setDes(data.get(position));
        return template.getRoot();
    }
}
