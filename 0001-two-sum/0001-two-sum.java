class Solution {
    public int[] twoSum(int[] nums, int target) {
        //make hashmap
        HashMap<Integer, Integer> map= new HashMap<>();
        //run a lop across array

        // for(int i=0; i<nums.length;i++){
        //     map.put(nums[i],i); //added value and its index to hashmap
        // }

        // 
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        } 
        return new int[] {-1,-1};
    }
}