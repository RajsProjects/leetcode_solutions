class MedianFinder {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private final PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
    }

    public void addNum(int num) {

        // 1. Decide which half gets the number
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // 2. Rebalance
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } 
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        // Empty stream
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0.0;
        }

        // Even number of elements
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // Odd number of elements
        return maxHeap.peek();
    }
}