public class ExistTriangle {
    private static final String Exception = "Side lenght should be >= 0 ";

    public static boolean IsPossible(double a, double b, double c){

        if (a <= 0 || b <= 0 || c <= 0){
            throw new IllegalArgumentException(Exception);
        }
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
