package gabriela.vibrar;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.id.edit;

public class main extends AppCompatActivity {
    Button btn;
    EditText txt;
    EditText txt2;
    TextView aviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button)findViewById(R.id.button);
        txt = (EditText)findViewById(R.id.editText);
        txt2 = (EditText)findViewById(R.id.editText2);
        aviso = (TextView)findViewById(R.id.textView4);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txt.getText().toString().trim().isEmpty()){
                    txt.setError("Campo Obrigatório");
                    txt.requestFocus();
                }
                else if(txt2.getText().toString().trim().isEmpty()){
                    txt2.setError("Campo Obrigatório");
                    txt2.requestFocus();
                }
                else if(txt.getText().toString().trim().equals(txt2.getText().toString().trim())){
                    aviso.setText("Sucesso: Senhas conferem!");
                    aviso.setTextColor(Color.GRAY);
                }else{
                    aviso.setText("Aviso: As senhas não conferem. Tente novamente!");
                    aviso.setTextColor(Color.RED);
                    Vibrator notificar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    long milliseconds = 1000;
                    notificar.vibrate(milliseconds);
                }
            }
        });

    }
}
