package hello.id_s;

import java.util.*;

public class ID_s {
    static private List<Integer> usedIDs = new LinkedList<>();
    static private List<Integer> removedIDs = new LinkedList<>();

    static public int generate(){
        if (removedIDs.isEmpty()){
            if (!usedIDs.isEmpty()) {
                usedIDs.add(usedIDs.get(usedIDs.size()-1)+1); //adds last elem + 1
            }else {
                usedIDs.add(0);
            }
        }
        else {
            usedIDs.add(removedIDs.get(0));
            Collections.sort(usedIDs);
        }
        return usedIDs.get(usedIDs.size()-1);
    }

    static public boolean removeID(final Integer ID){
        if(usedIDs.remove(Integer.valueOf(ID))){
            removedIDs.add(ID);
            return true;
        }
        else {
            return false;
        }
    }

}
