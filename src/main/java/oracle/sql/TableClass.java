//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.util.HashMap;

class TableClass {
    private HashMap<String, Integer> zoneToIdMap;
    private HashMap<Integer, String> idToZoneMap;
    private HashMap<Integer, String> oldIdToZoneMap;

    TableClass(int var1, float var2) {
        this.zoneToIdMap = new HashMap(var1, var2);
        this.idToZoneMap = new HashMap(var1, var2);
        this.oldIdToZoneMap = new HashMap(10, 0.99F);
    }

    void put(String var1, Integer var2) {
        this.zoneToIdMap.put(var1, var2);
        this.idToZoneMap.put(var2, var1);
    }

    void putOld(String var1, Integer var2) {
        this.oldIdToZoneMap.put(var2, var1);
    }

    Integer getID(String var1) {
        return (Integer)this.zoneToIdMap.get(var1);
    }

    String getZone(Integer var1) {
        return (String)this.idToZoneMap.get(var1);
    }

    String getOldZone(Integer var1) {
        return (String)this.oldIdToZoneMap.get(var1);
    }
}
