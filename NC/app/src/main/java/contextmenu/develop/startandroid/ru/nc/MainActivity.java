package contextmenu.develop.startandroid.ru.nc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    int[][] field = new int[3][3];
    Button B1_1, B1_2, B1_3, B2_1, B2_2, B2_3, B3_1, B3_2, B3_3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                field[i][j] = 0;
            }
        }

        B1_1 = (Button) findViewById(R.id.button1_1);
        B1_2 = (Button) findViewById(R.id.button1_2);
        B1_3 = (Button) findViewById(R.id.button1_3);
        B2_1 = (Button) findViewById(R.id.button2_1);
        B2_2 = (Button) findViewById(R.id.button2_2);
        B2_3 = (Button) findViewById(R.id.button2_3);
        B3_1 = (Button) findViewById(R.id.button3_1);
        B3_2 = (Button) findViewById(R.id.button3_2);
        B3_3 = (Button) findViewById(R.id.button3_3);

        B1_1.setOnClickListener(this);
        B1_2.setOnClickListener(this);
        B1_3.setOnClickListener(this);
        B2_1.setOnClickListener(this);
        B2_2.setOnClickListener(this);
        B2_3.setOnClickListener(this);
        B3_1.setOnClickListener(this);
        B3_2.setOnClickListener(this);
        B3_3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1_1:
                B1_1.setText("x");
                break;
            case R.id.button1_2:
                B1_2.setText("x");
                break;
            case R.id.button1_3:
                B1_3.setText("x");
                break;
            case R.id.button2_1:
                B2_1.setText("x");
                break;
            case R.id.button2_2:
                B2_2.setText("x");
                break;
            case R.id.button2_3:
                B2_3.setText("x");
                break;
            case R.id.button3_1:
                B3_1.setText("x");
                break;
            case R.id.button3_2:
                B3_2.setText("x");
                break;
            case R.id.button3_3:
                B3_3.setText("x");
                break;
        }
    }
    private void checkAll(){

    }
    private void checkLine(){

    }
}