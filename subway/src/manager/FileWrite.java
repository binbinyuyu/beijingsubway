package manager;
import main.Main;
import model.Station;
import java.io.*;


public class FileWrite {
    public static void outstation(String linename,String fileName) throws Exception {
        if(fileName.equals("")||fileName.equals(" ")){
            System.out.println("输出文件名不能为空！");
        }
        else if(linename.equals("")||linename.equals(" ")){
            System.out.println("查询线路名不能为空");
        }
        else {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            out.write(linename+"所经过的站点有");
            out.newLine(); //换行
            for (Station s : manager.LineManager.lines.get(linename).getStations()) {
                out.write(s.getStationName());
                out.newLine();
            }
            out.flush();
            out.close();
        }


    }

    public static void outroutine(String fileName,String a,String b) throws Exception {
        if(fileName.equals("")||fileName.equals(" ")){
            System.out.println("输出文件名不能为空！");
        }
        else {
            int x =manager.Map.numMap.get(a);
            int y =manager.Map.numMap.get(b);
            ShortestPath.findCheapestPath(x, y, ShortestPath.table);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            out.write(" 从 " + manager.Map.map.get(x).getStationName() + " 到 " + manager.Map.map.get(y).getStationName() + " 一共历经" + ShortestPath.dist[x][y] + "站" + " 的最佳路径是 ");
            out.newLine();  //换行
            for (int r : ShortestPath.result) {
                if (!manager.Map.map.get(r).getStationName().equals(manager.Map.map.get(x).getStationName())) {
                    out.write("  |");
                    out.newLine();
                }
                out.write(manager.Map.map.get(r).getStationName());
                out.newLine();
            }
            out.flush();
            out.close();
        }
    }
}
