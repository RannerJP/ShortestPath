import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ShortPathGraph test = new ShortPathGraph();
        test.dijkstra();
        System.out.println("      ");
        test.floydWarshall();
        PrintWriter file = new PrintWriter("Averages.txt");
        for(int i = 10; i <= 1000; i += 20){
            long runTimeAvg= 0;
            test.generateValues(i, i);
            for(int j = 1; j<=20; j++){
                long startTime = System.currentTimeMillis();
                test.dijkstra();
                runTimeAvg += (System.currentTimeMillis() - startTime);
            }
            runTimeAvg = runTimeAvg/20; 
            file.println(runTimeAvg + " for size: " + i + " sparse Dijkstras");
            file.println(" ");
            runTimeAvg = 0;
            for(int j = 1; j<=20; j++){
                long startTime = System.currentTimeMillis();
                test.floydWarshall();
                runTimeAvg += (System.currentTimeMillis() - startTime);

            }
            runTimeAvg = runTimeAvg/20;
            file.println(runTimeAvg + " for size: " + i +  " sparse Floyd Warshall");
            file.println(" ");
            runTimeAvg = 0;

            test.generateValues(i*3, i);
            for(int j = 1; j<=20; j++){
                long startTime = System.currentTimeMillis();
                test.dijkstra();
                runTimeAvg += (System.currentTimeMillis() - startTime);

            }
            runTimeAvg = runTimeAvg/20; 
            file.println(runTimeAvg + " for size: " + i  + " dense Dijkstras");
            file.println(" ");
            runTimeAvg = 0;
            for(int j = 1; j<=20; j++){
                long startTime = System.currentTimeMillis();
                test.floydWarshall();
                runTimeAvg += (System.currentTimeMillis() - startTime);
            }
            runTimeAvg = runTimeAvg/20;
            file.println(runTimeAvg + " for size: " + i + " dense Floyd Warshall");
            file.println(" ");
            runTimeAvg = 0;
            System.out.println("Finised size" + i);
        }
        file.close();
    }
}
