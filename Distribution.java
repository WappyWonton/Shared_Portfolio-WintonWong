// PDF, CDF, Binomial, Hygrometric.. 

class Distribution {
    protected int x; // Choose this amount from Kind X
    protected int N; // Total of all Kind
    protected int X; // Total of X kind
    protected double probability; // probability
    protected boolean cumulative; 

    Distribution (){
        this.x = 1;
        this.N = 1;
        this.X = 1;
        this.probability = 1; 
    }

    Distribution(int x, int N, int X, double probability){
        this.x = x;
        this.N = N;
        this.X = X;
        this.probability = probability; 
    }

    public int factorial (int n){
        int sum = n; 
        if (n == 0){return 1; }
        else {
            for (int i = n-1; i > 0; i--){
                sum = sum*i; 
                // System.out.print(i);
            }
        }
        return sum; 
    }

    public int permutation (int n, int r){
        return factorial(n)/(factorial((n-r)));
    }

    public int combinations (int n, int r){
        return factorial(n)/(factorial(r)*factorial(n-r));
    }
}

