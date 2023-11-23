package com.example.salim_chahed__mesure_glycemie.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salim_chahed__mesure_glycemie.R;
import com.example.salim_chahed__mesure_glycemie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private EditText edtext;
    private RadioButton rbtOui;
    private RadioButton rbtNon;
    private Button btnConsulter;
    private SeekBar sbAge;
    private TextView tvAge ;
    private TextView tvMessage ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valeurMesuree = edtext.getText().toString();
                int age = sbAge.getProgress();
                boolean jeune = rbtOui.isChecked();
                Controller cn = Controller.getInstance();

                cn.createPatient(age,valeurMesuree,jeune);
                //jai un prop dans le toast
                if (cn.patient.age == 0 && cn.patient.val.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "age et valeur mesure invalide", Toast.LENGTH_SHORT).show();
                } else if (cn.patient.age == 0) {
                    Toast.makeText(getApplicationContext(), "age null", Toast.LENGTH_SHORT).show();
                } else if (cn.patient.val.isEmpty()) {
                    Toast.makeText(getApplicationContext(), " valeur mesure invalide", Toast.LENGTH_SHORT).show();
                } else{
                    cn.patient.calcule();
                    tvMessage.setText(cn.patient.getRes());
                }

                edtext.setText("");
                sbAge.setProgress(0);
                rbtOui.setChecked(false);
                rbtNon.setChecked(false);
            }
        });
    }
    private void init() {
        edtext = findViewById(R.id.edtext);
        rbtOui = findViewById(R.id.rbtOui);
        rbtNon = findViewById(R.id.rbtNon);
        btnConsulter = findViewById(R.id.btnConsulter);
        sbAge= findViewById(R.id.sbAge);
        tvAge=findViewById(R.id.tvAge);
        tvMessage=findViewById(R.id.tvMessage);
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged "+progress);
                tvAge.setText("Votre âge : "+ progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}