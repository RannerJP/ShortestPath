public class Main {
    public static void main(String[] args) {
        ShortPathGraph test = new ShortPathGraph();
        test.generateValues(30, 10);
        test.dijkstra();
        System.out.println("      ");
        test.floydWarshall();
    }
}
