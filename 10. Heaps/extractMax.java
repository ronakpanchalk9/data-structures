// Given a binary heap implementation of Priority Queue. Extract the maximum element from the queue i.e. remove it from the Queue and return it's value.
class GFG {
    public static int H[] = new int[10009];
    public static int s = -1;

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int left_child(int i) {
        return ((2 * i) + 1);
    }

    public int right_child(int i) {
        return ((2 * i) + 2);
    }

    public void shiftUp(int i) {
        while (i > 0 && H[parent(i)] < H[i]) {
            int temp = H[i];
            H[i] = H[parent(i)];
            H[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void shiftDown(int i) {
        int maxIndex = i;
        int l = left_child(i);

        if (l <= s && H[l] > H[maxIndex]) {
            maxIndex = l;
        }

        int r = right_child(i);

        if (r <= s && H[r] > H[maxIndex]) {
            maxIndex = r;
        }

        if (i != maxIndex) {
            int temp = H[i];
            H[i] = H[maxIndex];
            H[maxIndex] = temp;
            shiftDown(maxIndex);
        }
    }

    public void insert(int p) {
        s = s + 1;
        H[s] = p;
        shiftUp(s);
    }
}

public class extractMax {
    public int extract_max() {
        GFG obj = new GFG();
        int k = obj.H[0];
        int p = obj.s;
        obj.H[0] = obj.H[p];
        obj.s--;
        obj.shiftDown(0);
        return k;
    }
}
