package hello.id_s;

import java.util.*;

public class ID_s {
    private List<Integer> usedIDs = new LinkedList<>();
    private List<Integer> removedIDs = new LinkedList<>();

    public int generate(){
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

    public boolean removeID(final Integer ID){
        if(usedIDs.remove(Integer.valueOf(ID))){
            removedIDs.add(ID);
            return true;
        }
        else {
            return false;
        }
    }

}
