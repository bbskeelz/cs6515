package dynamicprogramming;

public class KnapsackUnique{

    int constraint;
    int[] values;
    int[] weights;

    public KnapsackUnique(){

    }

    public KnapsackUnique(int constraint, int[] values, int[] weights){
        this.constraint = constraint;
        this.values = values;
        this.weights = weights;
    }

    public int solve(){
        int[][] savedVdub = new int[values.length+1][constraint+1];
        for (int i = 0; i <= values.length; i++){
            savedVdub[i][0] = 0;  //0 values will never be used
            savedVdub[0][i] = 0;  //0 weight will not be satisfied
        }

        for (int i = 1; i <= values.length; i++){
            for (int j = 1; j <= constraint; j++){
                int v = this.values[i-1];
                int w = this.weights[i-1];
                if (w > j){
                    savedVdub[i][j] = savedVdub[i-1][j];
                    continue;
                }
                savedVdub[i][j] =
                    Math.max(v + savedVdub[i-1][j-w], savedVdub[i-1][j]);
            }
        }
        PracticeUtils.printArray(2, savedVdub);
        return savedVdub[values.length][constraint];
    }

    public void printSolution(boolean[] in){
        StringBuilder ret = new StringBuilder("Solutions: ");
        int finalWeight = 0;
        int finalValue = 0;
        for (int i = 0; i < values.length; i++){
            if (in[i]){
                ret.append((finalValue > 0) ? "," : "").append(i);
                finalWeight += weights[i];
                finalValue += values[i];
            }
        }
        System.out.println(ret.toString());
        System.out.print("TotalWeight: " + finalWeight + " ");
        System.out.println("TotalValue: " + finalValue);
    }

    public static void main(String[] args){
        int c1 = 1;
        int[] v1 = new int[]{1};
        int[] w1 = new int[] {1};
        KnapsackUnique ks1 = new KnapsackUnique(c1, v1, w1);
        System.out.println(ks1.solve());
        int c2 = 22;
        int[] v2 = new int[] {15, 10, 8, 1};
        int[] w2 = new int[] {15, 12, 10, 5};
        KnapsackUnique ks2 = new KnapsackUnique(c2, v2, w2);
        System.out.println(ks2.solve());

    }
}
