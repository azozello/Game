package contextmenu.develop.startandroid.ru.nc;

public class Vector {
    Coordinate[] coordinates = new Coordinate[3];

    public Vector(Coordinate coordinate1, Coordinate coordinate2, Coordinate coordinate3) {
        this.coordinates[0] = coordinate1;
        this.coordinates[1] = coordinate2;
        this.coordinates[2] = coordinate3;
    }

    public boolean isFull(){
        for (int i=0;i<coordinates.length;i++){
            if (coordinates[i].getValue()==0) return false;
        }
        return true;
    }

    public boolean isWin(){
        int temp = coordinates[0].getValue();
        if (temp==0) return false;
        else {
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i].getValue() != temp) return false;
            }
            switch (temp){
                case 1:
                    MainActivity.setTitle("You won!");
                    break;
                case 2:
                    MainActivity.setTitle("You lost!");
                    break;
            }
            return true;
        }
    }

    public void setEmpty(){
        if (!this.isFull()){
            for (int i=0;i<coordinates.length;i++){
                if (coordinates[i].getValue()==0){
                    coordinates[i].setValue(2);
                    break;
                }
            }
        }
    }

    public boolean contains(Coordinate coordinate){
        for (int i=0;i<this.coordinates.length;i++){
            if (this.coordinates[i].equals(coordinate)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsX(){
        for (int i=0;i<this.coordinates.length;i++){
            if (this.coordinates[i].getValue()==1) {
                return true;
            }
        }
        return false;
    }

    public boolean containsO(){
        for (int i=0;i<this.coordinates.length;i++){
            if (this.coordinates[i].getValue()==2) {
                return true;
            }
        }
        return false;
    }

    public int toWin(){
        int win = 0;
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].getValue()==1) win++;
        }
        return win;
    }

    public int toLose(){
        int lose = 0;
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].getValue()==2) lose++;
        }
        return lose;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i=0;i<this.coordinates.length;i++){
            toReturn += coordinates[i].toString()+" ";
        }
        toReturn += "|";
        return toReturn;
    }
}
