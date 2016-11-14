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
    public static String GAME_OVER = "";

    Button B1_1, B1_2, B1_3, B2_1, B2_2, B2_3, B3_1, B3_2, B3_3;
    Coordinate C1_1, C1_2, C1_3, C2_1, C2_2, C2_3, C3_1, C3_2, C3_3;
    ArrayList<Vector> vectors = new ArrayList<>();
    ArrayList<Coordinate> coordinates = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1_1 = (Button) findViewById(R.id.button1);
        B1_2 = (Button) findViewById(R.id.button2);
        B1_3 = (Button) findViewById(R.id.button3);
        B2_1 = (Button) findViewById(R.id.button4);
        B2_2 = (Button) findViewById(R.id.button5);
        B2_3 = (Button) findViewById(R.id.button6);
        B3_1 = (Button) findViewById(R.id.button7);
        B3_2 = (Button) findViewById(R.id.button8);
        B3_3 = (Button) findViewById(R.id.button9);

        C1_1 = new Coordinate(B1_1,"C1_1");
        C1_2 = new Coordinate(B1_2,"C1_2");
        C1_3 = new Coordinate(B1_3,"C1_3");
        C2_1 = new Coordinate(B2_1,"C2_1");
        C2_2 = new Coordinate(B2_2,"C2_2");
        C2_3 = new Coordinate(B2_3,"C2_3");
        C3_1 = new Coordinate(B3_1,"C3_1");
        C3_2 = new Coordinate(B3_2,"C3_2");
        C3_3 = new Coordinate(B3_3,"C3_3");

        coordinates.add(C1_1);
        coordinates.add(C1_2);
        coordinates.add(C1_3);
        coordinates.add(C2_1);
        coordinates.add(C2_2);
        coordinates.add(C2_3);
        coordinates.add(C3_1);
        coordinates.add(C3_2);
        coordinates.add(C3_3);

        vectors.add(new Vector(C1_1,C2_1,C3_1));
        vectors.add(new Vector(C1_2,C2_2,C3_2));
        vectors.add(new Vector(C1_3,C2_3,C3_3));
        vectors.add(new Vector(C1_1,C1_2,C1_3));
        vectors.add(new Vector(C2_1,C2_2,C2_3));
        vectors.add(new Vector(C3_1,C3_2,C3_3));
        vectors.add(new Vector(C1_1,C2_2,C3_3));
        vectors.add(new Vector(C3_1,C2_2,C1_3));

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
            case R.id.button1:
                if (C1_1.getValue()==0) {
                    C1_1.setValue(1);
                    upDate();
                }
                break;
            case R.id.button2:
                if (C1_2.getValue()==0) {
                    C1_2.setValue(1);
                    upDate();
                }
                break;
            case R.id.button3:
                if (C1_3.getValue()==0) {
                    C1_3.setValue(1);
                    upDate();
                }
                break;
            case R.id.button4:
                if (C2_1.getValue()==0) {
                    C2_1.setValue(1);
                    upDate();
                }
                break;
            case R.id.button5:
                if (C2_2.getValue()==0) {
                    C2_2.setValue(1);
                    upDate();
                }
                break;
            case R.id.button6:
                if (C2_3.getValue()==0) {
                    C2_3.setValue(1);
                    upDate();
                }
                break;
            case R.id.button7:
                if (C3_1.getValue()==0) {
                    C3_1.setValue(1);
                    upDate();
                }
                break;
            case R.id.button8:
                if (C3_2.getValue()==0) {
                    C3_2.setValue(1);
                    upDate();
                }
                break;
            case R.id.button9:
                if (C3_3.getValue()==0) {
                    C3_3.setValue(1);
                    upDate();
                }
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == WIN_DIALOG) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle(GAME_OVER);
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

    private void upDate(){
        check();
        step();
        check();
    }

    private void step(){

        ArrayList<Coordinate> activeCoordinates = new ArrayList<>();
        ArrayList<Vector> activeVectors = new ArrayList<>();

        for (Coordinate coordinate : coordinates){
            if (coordinate.getValue()==0) {
                activeCoordinates.add(coordinate);
            }
        }
        for (Coordinate coordinate : activeCoordinates){
            for (Vector vector : vectors){
                if (!activeVectors.contains(vector)){
                    if (!vector.isFull()){
                        if (vector.contains(coordinate)){
                            activeVectors.add(vector);
                        }
                    }
                }
            }
        }

        for (Vector vector : activeVectors){
            if (vector.toLose()>1 || vector.toWin()>1){
                vector.setEmpty();
                return;
            }
        }

        for (Vector vector : activeVectors){
            if (vector.containsX()){
                vector.setEmpty();
                return;
            }
        }
    }

    public void check(){
        boolean flag = true;
        for (Vector vector : vectors){
            if (!vector.isFull()){
                flag = false;
            }
            if (vector.isWin()) {
                showDialog(WIN_DIALOG);
                break;
            }
        }
        if (flag){
            setTitle("OMFG!");
            showDialog(WIN_DIALOG);
        }
    }

    public static void setTitle(String title){
        MainActivity.GAME_OVER = title;
    }

    public void reset(){
        C1_1.setValue(0);
        C1_2.setValue(0);
        C1_3.setValue(0);
        C2_1.setValue(0);
        C2_2.setValue(0);
        C2_3.setValue(0);
        C3_1.setValue(0);
        C3_2.setValue(0);
        C3_3.setValue(0);
    }
}
/*
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("C3_3 contained in: ");
                    for (Vector vector : vectors){
                        if (vector.contains(C3_3)) stringBuilder.append(vector.toString()+" ");
                    }
                    Toast.makeText(this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
                    upDate();
 */