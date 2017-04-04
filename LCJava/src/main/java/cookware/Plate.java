package cookware;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaobo on 4/4/17.
 */
public class Plate {

    private String name;

    public Plate(String name) {
        this.name = name;
    }

    public void Print() {
        Set<Plate> set = new HashSet<Plate>();
        Plate p1 = new Plate("Jingde");
        Plate p2 = new Plate("Jingde");
        set.add(p1);
        set.add(p2);
        System.out.println(p1.equals(p2));
        System.out.println(set.size());
    }

    //layman implmentation of equals and hashcode
    @Override
    public boolean equals(Object object){
        if (object == null){
            return false;
        }

        final Plate other = (Plate)object;
        if (this.name == other.name) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
}
