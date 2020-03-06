package com.example.cambiomodena.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cambiomodena.R;
import com.example.cambiomodena.model.Conversion;
import com.example.cambiomodena.model.RespMonedas;
import com.example.cambiomodena.model.ResultConversion;
import com.example.cambiomodena.retrofit.ConversorClient;
import com.example.cambiomodena.retrofit.ConversorService;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;

    Button btnConvertir;
    ConversorClient conversorClient;
    ConversorService conversorService;
    Spinner spFrom;
    Spinner spTo;
    EditText cantidad;
    TextView respuesta;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        root = inflater.inflate(R.layout.fragment_tools, container, false);
        // final TextView textView = root.findViewById(R.id.text_tools);

        btnConvertir = root.findViewById(R.id.button);
        spFrom = root.findViewById(R.id.spFrom);
        spTo = root.findViewById(R.id.spTo);
        cantidad = root.findViewById(R.id.cantidad);
        respuesta = root.findViewById(R.id.respuesta);

        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
           //     textView.setText(s);
            }
        });

        retrofitInit();

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDatos();


            }
        });

        init();

        return root;
    }


    private void init() {
        final ArrayList<String> comboMonedasList = new ArrayList<>();
        Call<RespMonedas> call;

        ArrayAdapter<String> comboAdapter;

        comboMonedasList.add("EUR");

        try {
            call = conversorService.full("EUR");
        } catch (Exception e) {
            throw e;
        }

        call.enqueue(new Callback<RespMonedas>() {
            @Override
            public void onResponse(Call<RespMonedas> call, Response<RespMonedas> response) {
                RespMonedas r;
                if (response.isSuccessful()) {

                    r = response.body();

                    ArrayAdapter<String> comboAdapter;

                    for(Conversion c : r.getResult().getConversion()) {
                        comboMonedasList.add(c.getTo());
                    }

                    ArrayAdapter<String> adapter =
                            new ArrayAdapter<String>(root.getContext(),  android.R.layout.simple_spinner_dropdown_item, comboMonedasList);
                    adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

                    spFrom.setAdapter(adapter);
                    spTo.setAdapter(adapter);

                    respuesta.setText("Se cargo la lista de monedas con exito");
                } else {
                    respuesta.setText("Todo mal");
                    //Toast.makeText(com.example.myapplication.ui.Conversor.this, "Todo mal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RespMonedas> call, Throwable t) {
                //Toast.makeText(com.example.cambiomodena.ui..this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void events() {

    }


    private void retrofitInit() {
        conversorClient = ConversorClient.getInstance();
        conversorService = conversorClient.getConversorService();
    }

    private void getDatos() {
        String from;
        final String to;
        String quantity = "1";

        from =  spFrom.getSelectedItem().toString();
        to =  spTo.getSelectedItem().toString();

        Call<ResultConversion> call = conversorService.quotes(from, to);
        call.enqueue(new Callback<ResultConversion>() {
            @Override
            public void onResponse(Call<ResultConversion> call, Response<ResultConversion> response) {
                ResultConversion r;
                if (response.isSuccessful()) {


                    r = response.body();
                    Double c = new Double(cantidad.getText().toString());


                    String total = (c * r.getResult().getAmount()) + "";

                    respuesta.setText("El cambio da " + total);

                } else {
                    respuesta.setText("Todo mal");
                }
            }

            @Override
            public void onFailure(Call<ResultConversion> call, Throwable t) {
                // Toast.makeText(com.example.myapplication.ui.Conversor.this, "Problemas de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}