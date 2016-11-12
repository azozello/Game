package contextmenu.develop.startandroid.ru.nc;

import android.widget.Button;

public class Vector {
    private Button[] buttons = new Button[3];
    int[] values = new int[3];

    public Vector(Button button1, Button button2, Button button3) {
        this.buttons[0] = button1;
        this.buttons[1] = button2;
        this.buttons[2] = button3;
        for (int i=0;i<3;i++){
            values[i] = 0;
        }
    }

    public void setValue(int pos, int value) {
        this.values[pos] = value;
    }
}
