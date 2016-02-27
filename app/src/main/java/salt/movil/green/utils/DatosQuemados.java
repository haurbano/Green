package salt.movil.green.utils;

import java.util.ArrayList;
import java.util.List;

import salt.movil.green.models.Desecho;
import salt.movil.green.models.Empresa;

/**
 * Created by usuario on 27/02/2016.
 */
public class DatosQuemados {

    List<Desecho> data;
    public DatosQuemados() {
        QuemarDatos();
    }

    private void QuemarDatos() {
        data = new ArrayList<>();
        Empresa emp = new Empresa();
        emp.setDireccion("Carrera 4 # 20N-65");

        Desecho desecho1 = new Desecho();
        desecho1.setNombre("Salchichas dañadas");
        desecho1.setCantidad(25);
        desecho1.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");
        desecho1.setPrecio(250000);
        desecho1.setEmpresa(emp);
        desecho1.setCiudad("Popayan Cauca");

        Desecho desecho2 = new Desecho();
        desecho2.setNombre("Suero de queso");
        desecho2.setCantidad(25);
        desecho2.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");
        desecho2.setPrecio(3500000);
        desecho2.setEmpresa(emp);
        desecho2.setCiudad("Cali Valle");

        Desecho desecho3 = new Desecho();
        desecho3.setNombre("Huesos de marrano");
        desecho3.setCantidad(65);
        desecho3.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");
        desecho3.setPrecio(562033220);
        desecho3.setEmpresa(emp);
        desecho3.setCiudad("Medellin antioquia");

        Desecho desecho4 = new Desecho();
        desecho4.setNombre("deseños tecnologicos");
        desecho4.setCantidad(28);
        desecho4.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");
        desecho4.setPrecio(5000000);
        desecho4.setEmpresa(emp);
        desecho4.setCiudad("Medellin Antioquia");

        Desecho desecho5 = new Desecho();
        desecho5.setNombre("Desecho de carbon");
        desecho5.setCantidad(10);
        desecho5.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");
        desecho5.setPrecio(6500000);
        desecho5.setEmpresa(emp);
        desecho5.setCiudad("Bucaramanga Santander");

        Desecho desecho6 = new Desecho();
        desecho6.setNombre("Astillas de madera");
        desecho6.setCantidad(56);
        desecho6.setUrlImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavzaCW70NEExWCJUMYNRCRKkuPjuNGetrvOkNfd2I4QKA176G");
        desecho6.setPrecio(5680000);
        desecho6.setEmpresa(emp);
        desecho6.setCiudad("Pasto Nariño");

        data.add(desecho1);
        data.add(desecho2);
        data.add(desecho3);
        data.add(desecho4);
        data.add(desecho5);
        data.add(desecho6);
    }

    public List<Desecho> getData(){
        return data;
    }
}
