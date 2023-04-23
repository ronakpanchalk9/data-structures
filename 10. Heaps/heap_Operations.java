public class heap_Operations {
    class MinHeap {
        int[] harr;
        int capacity;
        int heap_size;

        MinHeap(int cap) {
            heap_size = 0;
            capacity = cap;
            harr = new int[cap];
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return (2 * i + 1);
        }

        int right(int i) {
            return (2 * i + 2);
        }

        // Function to extract minimum value in heap and then to store
        // next minimum value at first index.
        int extractMin() {
            int min = -1;
            if(heap_size > 0){
                min = harr[0];
                harr[0] = harr[heap_size-1];
                MinHeapify(0);
            }
            return min;
        }

        // Function to insert a value in Heap.
        void insertKey(int k) {
            harr[this.heap_size] = k;
            int x = this.heap_size - 1;
            int par = parent(x);

            while (harr[x] < harr[par]) {
                int temp = harr[x];
                harr[x] = harr[par];
                harr[par] = temp;
            }

        }

        // Function to delete a key at ith index.
        void deleteKey(int i) {
            int temp = harr[i];
            harr[i] = harr[heap_size-1];
            harr[heap_size-1] = temp;

            harr[heap_size-1] = -1;

            heap_size--;

            MinHeapify(i);
        }

        // Function to change value at ith index and store that value at first index.
        void decreaseKey(int i, int new_val) {
            harr[i] = new_val;
            while (i != 0 && harr[parent(i)] > harr[i]) {
                int temp = harr[i];
                harr[i] = harr[parent(i)];
                harr[parent(i)] = temp;
                i = parent(i);
            }
        }
 
        /*
         * You may call below MinHeapify function in
         * above codes. Please do not delete this code
         * if you are not writing your own MinHeapify
         */
        void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < heap_size && harr[l] < harr[smallest])
                smallest = l;
            if (r < heap_size && harr[r] < harr[smallest])
                smallest = r;
            if (smallest != i) {
                int temp = harr[i];
                harr[i] = harr[smallest];
                harr[smallest] = temp;
                MinHeapify(smallest);
            }
        }
    }

}
