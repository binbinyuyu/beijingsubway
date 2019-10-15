package main;
import manager.*;


public class Main {
    //主函数
    public static void main(String[] args) throws Exception {
        //-map 地图读入
        if(args[0].equals("-map")){
            readMap(args[1]);
            System.out.println("地图读取成功！");
        }
        // -a 地铁线站点输出
        else if (args[0].equals("-a")){
            readMap(args[3]);
            manager.LineManager.check(args[1]);
            //读取
            FileWrite.outstation(args[1],args[5]);
            System.out.println("车站信息输出成功！");
        }
        // -b 最短路径查询
        else if(args[0].equals("-b")){
            readMap(args[4]);
            ShortestPath.makeTb();
            //读取输出文件，起点和终点
            FileWrite.outroutine(args[6],args[1],args[2]);
            System.out.println("路线信息输出成功！");
        }
        else{
            System.out.println("请输入指定命令进行相应操作！");
        }
    }
    //地图文件读取
    public static void readMap(String x) throws Exception {
        String readfile =x;
        manager.Map.in(readfile);
        manager.LineManager.statisticsStation();
        manager.Map.getHashMap();
        Map.setMap();
        manager.LineManager.readline(readfile);
    }

}
