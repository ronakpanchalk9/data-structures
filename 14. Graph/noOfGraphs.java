public class noOfGraphs {
    static long count(int n) {
    // code here
    long edges = (n * (n-1)/2);
    long graphs = (long)Math.pow(2,edges);
    return graphs;
  }
}
