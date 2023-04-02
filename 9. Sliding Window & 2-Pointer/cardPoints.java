// There are several cards arranged in a row, and each has an associated number of points. The points are given in the integer array cardPoints of size N.
// In one step, you can take one card from beginning or from the end of the row. You have to take exactly k cards.
// Your score is the sum of the points of the cards you have taken.
// Given the integer array cardPoints, and its size N and the integer k, return the maximum score you can obtain.
public class cardPoints {
    static long maxScore(int cardPoints[], int n, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int curr=sum;
        for(int i=k-1;i>=0;i--){
            curr-=cardPoints[i];
            curr+=cardPoints[n-k+i];
            sum=Math.max(curr,sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] cards = { 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392,
                605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812,
                323, 334 };
        int n = 42;
        int k = 30;

        // int right = cards[n-1];
        // int left = cards[0];

        // for (int i = 0; i < 30; i++) {
        // left += cards[i];
        // }

        // for (int i = 30; i >= 0; i--) {
        // right += cards[i];
        // }

        // System.out.println("Left:"+left);
        // System.out.println("Right:"+right);

        System.out.println(maxScore(cards, cards.length, k));
    }
}
