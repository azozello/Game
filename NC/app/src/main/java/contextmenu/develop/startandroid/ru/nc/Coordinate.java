package contextmenu.develop.startandroid.ru.nc;

import android.widget.Button;


class Coordinate {

    private Button button;
    private int value;

    public Coordinate(Button button) {
        this.button = button;
        this.value = 0;
    }

    public void setValue(int value){
        this.value = value;
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

    public int getCValue() {
        return this.value;
    }
}
