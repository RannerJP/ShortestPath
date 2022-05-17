public class ShortPathGraph{
    private int[][] cost = {{0,3,100000,2,100000,100000,6},
                            {100000, 0, 6, 100000, 1, 100000, 100000},
                            {100000, 100000, 0, 100000, 100000, 1, 100000},
                            {100000, 2, 100000, 0, 3, 100000, 100000},
                            {100000, 100000, 100000, 100000, 0, 4, 100000},
                            {100000, 100000, 100000, 100000, 100000, 0, 100000},
                            {100000, 100000, 100000, 100000, 100000, 2, 0}};
    /**
     *  An algorithm to randomly generate a the cost matrix of a graph
     * @param density how many edge connections should be in the graph
     * @param vertices how many vertices should be in the graph
     */
    public void generateValues(int density, int vertices){

    }

    /**
     * Solving the Shortest path using dijkstra's algorithm
     */
    public void dijkstra(){
        int[][] shortPath = new int[3][cost.length]; // row 1 =mark, row 2 = distance, row 3 = prev
        for(int vertex = 0; vertex < shortPath[0].length; vertex++){
            shortPath[0][vertex] = 0;
            shortPath[1][vertex] = cost[0][vertex]; //0 represent starting vertex
            shortPath[2][vertex] = 0; //0 represents starting vertex
        }
        shortPath[0][0] = 1; //second 0 represents start vertex
        for(int neighbor =1; neighbor<shortPath[0].length; neighbor++){
            int min = 1000001;//Bigger than our range of weights 1-1000
            int minNeighbor = -1;

            for(int findMin =1; findMin < shortPath[0].length; findMin++){
                if(shortPath[0][findMin] == 0 && shortPath[1][findMin] < min){
                    min = shortPath[1][findMin];
                    minNeighbor = findMin;
                }
            }

            shortPath[0][minNeighbor] = 1;

            for(int j =0; j<shortPath[0].length; j++){
                if(cost[minNeighbor][j] < 100000 && shortPath[0][j] == 0){
                    if(shortPath[1][j] > shortPath[1][minNeighbor] + cost[minNeighbor][j]){
                        shortPath[1][j] = shortPath[1][minNeighbor] + cost[minNeighbor][j];
                        shortPath[2][j] = minNeighbor;
                    }
                }
            }
        }
        
        for(int vertex =1; vertex< shortPath[0].length; vertex++){
            int prev = vertex;
            boolean endPoint = false;
            String shortestPath = "";
            while(endPoint == false){
                if(shortPath[2][prev] == 0){
                    shortestPath += prev + " <- 0 cost: " + shortPath[1][vertex];
                    System.out.println(shortestPath);
                    endPoint = true;
                }
                else{
                    shortestPath += prev + " <- ";
                    prev = shortPath[2][prev];
                }
            }
        }
    }

    /**
     * solves the shortest path by using the Floyd-Warshall algorithm
     */
    public void floydWarshall(){

    }

}