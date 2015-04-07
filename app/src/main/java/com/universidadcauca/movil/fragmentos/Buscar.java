package com.universidadcauca.movil.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class Buscar extends Fragment {



   String[] ciudades = {"Popayan", "Pasto","Huila"};
   String[] tipo_inmueble = {"Casa", "Habitacion","Local Comercial"};


    public Buscar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false);
    }


/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


      /*  View v = inflater.inflate(R.layout.fragment_buscar, container, false);
        //agregado
        View r = inflater.inflate(R.layout.fragment_buscar, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        //agregada
        Spinner spinner1 = (Spinner) r.findViewById(R.id.spinner_2);

        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, ciudades);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(LTRadapter);

        //para el segundo sniper
        ArrayAdapter<String> LTRadapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, tipo_inmueble);
        LTRadapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(LTRadapter1);


        return v;

     }
         */

/*
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);


        //SPINNER
        Spinner spinner = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.ciudades, android.R.layout.simple_spinner_item);// Create an ArrayAdapter using the string array and a default spinner layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Specify the layout to use when the list of choices appears
        spinner.setAdapter(adapter);    // Apply the adapter to the spinner


        //SPINNER
        Spinner spinner_2 = (Spinner)view.findViewById(R.id.spinner_2);
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(getActivity(), R.array.tipo_inmueble, android.R.layout.simple_spinner_item);// Create an ArrayAdapter using the string array and a default spinner layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Specify the layout to use when the list of choices appears
        spinner.setAdapter(adapter);    // Apply the adapter to the spinner

        return view;
    }

*/

 }

