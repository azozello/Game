package contextmenu.develop.startandroid.ru.nc;

import android.widget.Button;

class Coordinate {

    private Button button;
    private String name;
    private int value;
    private int weight;

    public Coordinate(Button button,String name) {
        this.button = button;
        this.value = 0;
        this.weight = 0;
        this.name = name;
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

    public int getValue() {
        return this.value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        else if (obj.getClass()!=this.getClass()) return false;
        else if (obj.hashCode()!=this.hashCode()) return false;
        else return true;
    }

    @Override
    public int hashCode() {
        return button.getId();
    }

    @Override
    public String toString() {
        return name;
    }
}

