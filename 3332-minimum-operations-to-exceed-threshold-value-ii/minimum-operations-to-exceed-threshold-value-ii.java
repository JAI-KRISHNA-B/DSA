class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int operations = 0;

        for(long num:nums)
        queue.add(num);

        while(queue.peek()<k && queue.size()>=2){
            long x = queue.peek();
            queue.poll();
            Long y = queue.peek();
            queue.poll();
            Long z = (Math.min(x,y) * 2) + Math.max(x,y);
            queue.add(z);
            operations+=1;
        }
        return operations;
    }
}