package manager;
import model.*;
import java.util.*;
public class Map {
    public static java.util.Map<Integer, Station> map;
    public static java.util.Map<String, Integer> numMap;
    public static Set<String> set;
    public static Set<List<String>> listSet;
    public static void in(String filename) throws Exception {
        map = new HashMap<Integer, Station>();
        numMap = new HashMap<String, Integer>();
        set = new HashSet<String>();
        manager.LineManager.lines = new HashMap<String,model.Line>();
        listSet=LineManager.readline(filename);

    }
    public static void getHashMap() {
        int i = 0;
        for (String s : set) {
            Station station = new Station(s);
            map.put(i, station);
            numMap.put(s, i);
            i++;
        }
    }
    public static void setMap() {
        for (List<String> lineList : listSet) {
            model.Line line = new model.Line();
            for (int i = 1; i < lineList.size(); i++) {
                Station station = map.get(numMap.get(lineList.get(i)));
                station.addLineName(line);
                if (i != 1) {
                    Station laStation = map.get(numMap.get(lineList.get(i - 1)));
                    station.addlinkStations(laStation);
                    laStation.addlinkStations(station);
                }
                line.addStation(station);
            }
            manager.LineManager.lines.put(lineList.get(0), line);
        }
    }

}
