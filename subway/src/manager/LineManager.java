package manager;

import model.Station;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineManager {
    public static java.util.Map<String, model.Line> lines;

    public static List<String> check(String linename){
        model.Line line=lines.get(linename);
        List<Station>stations=line.getStations();
        List<String>strings=new ArrayList<String>();
        for(Station station:stations){
            strings.add(station.getStationName());
        }
        return strings;
    }

    public static Set<List<String>> readline(String filename) throws Exception {
        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Set<List<String>>set=new HashSet<List<String>>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {

            String[] lineInformations = str.split(" ");
            List<String>stations=new ArrayList<String>();
            for (String s : lineInformations) {
                stations.add(s);

            }
            set.add(stations);
        }
        //close
        inputStream.close();
        bufferedReader.close();
        return set;
    }
    public static void statisticsStation() {
        for (List<String> lineList : manager.Map.listSet)
            for (int i = 1; i < lineList.size(); i++)
                manager.Map.set.add(lineList.get(i));
    }
}
