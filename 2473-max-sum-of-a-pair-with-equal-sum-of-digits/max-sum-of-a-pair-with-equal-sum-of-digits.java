class Solution {
    public int maximumSum(int[] nums) {
        // HashMap<Integer,List<Integer>> map = new HashMap<>();
        // int c = 0;
        // for(int i=0;i<nums.length;i++){
        //     int sum = 0;
        //     int num = nums[i];
        //     while(num>0){
        //         sum += num%10;
        //         num = num/10;
        //     }
        //     if(map.containsKey(sum)){
        //         map.get(sum).add(nums[i]);
        //         c+=1;
        //     }else{
        //         map.put(sum,new ArrayList<>(Arrays.asList(nums[i])));
        //     }
        // }
        // if(c==0)
        // return -1;
        // int max1=0,max2=0;
        // int maxval= 0;
        // for(HashMap.Entry<Integer,List<Integer>> entry: map.entrySet()){
        //     max1=0;
        //     max2=0;
        //     if(entry.getValue().size()>=2){
        //         for(int x:entry.getValue()){
        //             if(x>max1){
        //                 int temp = max1;
        //                 max1 = x;
        //                 x = temp;
        //             }if(x>max2)
        //                 max2 = x;
        //         }
        //     }
        //     if(maxval<max1+max2)
        //     maxval = max1+max2;
        // }
        // return maxval;


        // OPTIMAL APPROACH

        HashMap<Integer,int[]> map = new HashMap<>();
        int maxval = -1;

        for(int num:nums){

            int sum = sumofdigits(num);

            if(map.containsKey(sum)){
                int[] two = map.get(sum);

                if(num>two[0]){
                    two[1] = two[0];
                    two[0] = num;
                }else if(num>two[1])
                two[1] = num;

                if(two[0]+two[1]>maxval)
                maxval = two[0]+two[1];
            }else{
                map.put(sum,new int[]{num,0});
            }
        }

        return maxval;
    }
            int sumofdigits(int x){
            int sum = 0;
            while(x>0){
                sum += x%10;
                x /=10;
            }
            return sum;
        }
}