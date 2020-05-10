package entity;

import java.util.HashMap;

public class Union_detail {

    private boolean union_member;
    private HashMap<String,Integer> charges;



    public Union_detail(boolean union_member, HashMap<String, Integer> charges) {
        this.union_member = union_member;
        this.charges = charges;
    }

    public boolean isUnion_member() {
        return union_member;
    }

    public void setUnion_member(boolean union_member) {
        this.union_member = union_member;
    }

    public HashMap<String, Integer> getCharges() {
        return charges;
    }

    public void setCharges(HashMap<String, Integer> charges) {
        this.charges = charges;
    }
}