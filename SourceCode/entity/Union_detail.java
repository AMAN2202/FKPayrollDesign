package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Union_detail {

    private boolean union_member;
    private ArrayList<Integer> charges;


    public Union_detail() {
        this.union_member=false;
        this.charges=new ArrayList<Integer>();;
        this.charges.add(10000);
        this.charges.add(10000);

    }

    public Union_detail(boolean union_member, ArrayList<Integer> charges) {
        this.union_member = union_member;
        this.charges = charges;

    }

    @Override
    public String toString() {
        return "Union_detail{" +
                "union_member=" + union_member +
                ", charges=" + charges.get(0) +" "+charges.get(1)+
                '}';
    }

    public boolean isUnion_member() {
        return union_member;
    }

    public void setUnion_member(boolean union_member) {
        this.union_member = union_member;
    }


    public ArrayList<Integer> getCharges() {
        return charges;
    }

    public void setCharges(ArrayList<Integer> charges) {
        this.charges = charges;
    }
}