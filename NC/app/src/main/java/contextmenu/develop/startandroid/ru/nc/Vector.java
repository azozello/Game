package contextmenu.develop.startandroid.ru.nc;


public class Vector {

    Coordinate x,y,z;

    public Vector(Coordinate x, Coordinate y, Coordinate z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public boolean contains(Coordinate coordinate){
        if (x.equals(coordinate)) return true;
        else if (y.equals(coordinate)) return true;
        else if (z.equals(coordinate)) return true;
        else return false;
    }

    public boolean isFull(){
        if (x.getValue()!=0 && y.getValue()!=0 && z.getValue()!=0) return true;
        else return false;
    }
    public boolean isWin(){
        int flag = x.getValue()+y.getValue()+z.getValue();
        if (flag==3 || flag==6) return true;
        else return false;
    }
    public Coordinate getX() {
        return x;
    }
    public Coordinate getY() {
        return y;
    }
    public Coordinate getZ() {
        return z;
    }
}
