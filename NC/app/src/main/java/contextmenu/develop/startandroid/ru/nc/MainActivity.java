package contextmenu.develop.startandroid.ru.nc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    final int WIN_DIALOG = 7;

    public static int[][] field = new int[3][3];
    Button B1_1, B1_2, B1_3, B2_1, B2_2, B2_3, B3_1, B3_2, B3_3;
    static Coordinate C1_1, C1_2, C1_3, C2_1, C2_2, C2_3, C3_1, C3_2, C3_3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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

        C1_1 = new Coordinate(B1_1, 0, 0);
        C1_2 = new Coordinate(B1_2, 0, 1);
        C1_3 = new Coordinate(B1_3, 0, 2);
        C2_1 = new Coordinate(B2_1, 1, 0);
        C2_2 = new Coordinate(B2_2, 1, 1);
        C2_3 = new Coordinate(B2_3, 1, 2);
        C3_1 = new Coordinate(B3_1, 2, 0);
        C3_2 = new Coordinate(B3_2, 2, 1);
        C3_3 = new Coordinate(B3_3, 2, 2);

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
        switch (v.getId()) {
            case R.id.button1_1:
                C1_1.setCoord(1);
                break;
            case R.id.button1_2:
                C1_2.setCoord(1);
                break;
            case R.id.button1_3:
                C1_3.setCoord(1);
                break;
            case R.id.button2_1:
                C2_1.setCoord(1);
                break;
            case R.id.button2_2:
                C2_2.setCoord(1);
                break;
            case R.id.button2_3:
                C2_3.setCoord(1);
                break;
            case R.id.button3_1:
                C3_1.setCoord(1);
                break;
            case R.id.button3_2:
                C3_2.setCoord(1);
                break;
            case R.id.button3_3:
                C3_3.setCoord(1);
                break;
        }
        upDate();
    }

    private void upDate() {

        ArrayList<Vector> vectors = new ArrayList<>();

        Vector V1 = new Vector(C1_1, C1_2, C1_3);
        Vector V2 = new Vector(C2_1, C2_2, C2_3);
        Vector V3 = new Vector(C3_1, C3_2, C3_3);
        Vector V4 = new Vector(C1_1, C2_1, C3_1);
        Vector V5 = new Vector(C1_2, C2_2, C3_2);
        Vector V6 = new Vector(C3_3, C3_3, C3_3);
        Vector V7 = new Vector(C1_1, C2_2, C3_3);
        Vector V8 = new Vector(C3_1, C2_2, C1_3);

        vectors.add(V1);
        vectors.add(V2);
        vectors.add(V3);
        vectors.add(V4);
        vectors.add(V5);
        vectors.add(V6);
        vectors.add(V7);
        vectors.add(V8);

        for (Vector v : vectors) {
            if (v.isWin()) {
                Toast.makeText(this, "You win", Toast.LENGTH_LONG).show();
                showDialog(WIN_DIALOG);
                break;
            }
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == WIN_DIALOG) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("YOU WIN!");
            adb.setMessage("Start new game?");
            adb.setPositiveButton(R.string.N_G,dialogOnClick);
            adb.setNegativeButton(R.string.C,dialogOnClick);
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    DialogInterface.OnClickListener dialogOnClick = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    reset();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };

    private void reset(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = 0;
            }
        }
        C1_1.setCoord(0);
        C1_2.setCoord(0);
        C1_3.setCoord(0);
        C2_1.setCoord(0);
        C2_2.setCoord(0);
        C2_3.setCoord(0);
        C3_1.setCoord(0);
        C3_2.setCoord(0);
        C3_3.setCoord(0);
    }
}