package me.garrypriambudi.hitungluas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText txtPanjang, txtLebar;
    private Button btnHitung;
    private TextView lblLuas;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarTitle = (TextView)findViewById(R.id.main_toolbar_title);
        txtPanjang = (EditText)findViewById(R.id.txtPanjang);
        txtLebar = (EditText)findViewById(R.id.txtLebar);
        btnHitung = (Button)findViewById(R.id.btnHitung);
        lblLuas = (TextView)findViewById(R.id.lblLuas);

        toolbarTitle.setText("Hitung Luas Persegi Panjang");

        btnHitung.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    String panjang = txtPanjang.getText().toString().trim();
                    String lebar = txtLebar.getText().toString().trim();

                    double p = Double.parseDouble(panjang);
                    double l = Double.parseDouble(lebar);

                    double luas = p * l;
                    DecimalFormat format = new DecimalFormat("#.#");

                    lblLuas.setText(format.format(luas));
                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
