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
            if (coordinates[i].getCValue()==0) return false;
        }
        return true;
    }

    public boolean isWin(){
        int temp = coordinates[0].getCValue();
        if (temp==0) return false;
        else {
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i].getCValue() != temp) return false;
            }
            return true;
        }
    }

    public int toWin(){
        int win = 0;
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].getCValue()==1) win++;
        }
        return win;
    }

    public int toLose(){
        int lose = 0;
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].getCValue()==2) lose++;
        }
        return lose;
    }
}
