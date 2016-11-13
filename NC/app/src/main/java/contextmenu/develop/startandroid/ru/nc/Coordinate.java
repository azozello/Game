package contextmenu.develop.startandroid.ru.nc;

import android.widget.Button;

import static contextmenu.develop.startandroid.ru.nc.MainActivity.field;

public class Coordinate {

    private Button button;
    int x,y;
    int value;

    public Coordinate(Button button, int line, int column) {
        this.button = button;
        this.x = line;
        this.y = column;
        this.value = field[x][y];
    }

    public void setCoord(int value){
        this.value = value;
        field[x][y] = value;
        switch (value){
            case 0:
                this.button.setText("");
                break;
            case 1:
                this.button.setText("x");
                break;
            case 2:
                this.button.setText("o");
                break;
        }
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getValue() {
        return value;
    }

}
