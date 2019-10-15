package manager;

import model.Station;
import java.util.ArrayList;
import java.util.List;

public class ShortestPath {
    public static int len;
    public static int[][] path;
    public static int[][] dist;
    public static int[][] table;
    public static int INF = Integer.MAX_VALUE;   //设置INF无限大
    public static List<Integer> result = new ArrayList<Integer>();
    public static void findFloydRoad(int[][] table) {
        int size = len;
        path = new int[size][size];
        dist = new int[size][size];
        //initialize dist and path
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                path[i][j] = -1;
                dist[i][j] = table[i][j];
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (dist[i][k] != INF &&
                            dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }

    }
    public static void makeTb(){
        len = manager.Map.map.size();
        table =new int[len][len];
        for(int i=0;i<len;i++){
            for(int  j=0;j<len;j++){
                table[i][j]=INF;
            }
        }
        for(int i=0;i<len;i++){
            Station station=manager.Map.map.get(i);
            for(Station s:station.getlinkStations()){
                int j=manager.Map.numMap.get(s.getStationName());
                table[i][j]=1;
                table[j][i]=1;
            }
        }
    }
    public static void findCheapestPath(int begin, int end, int[][] table) {
        ShortestPath.findFloydRoad(table);
        result.add(begin);
        findPath(begin, end);
        result.add(end);
    }

    public  static void findPath(int i, int j) {
        int k = path[i][j];
        if (k == -1)        //当k=-1时，递归结束，否则一直递归
            return ;
        else {
            findPath(i, k);
            result.add(k);
            findPath(k, j);
        }
    }
}
