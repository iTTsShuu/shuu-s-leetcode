import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> val2index;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        val2index = new HashMap<Integer,Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (val2index.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        System.out.println("insert index:"+nums.size());
        nums.add(val);
        val2index.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!val2index.containsKey(val)) {
            return false;
        }
        // 找到要删除元素的位置，与最后一个元素交换位置，再删除最后位置元素
        int index = val2index.get(val);
        int lastval=nums.get(nums.size()-1);
        nums.set(index,lastval);
        val2index.put(lastval, index);
        nums.remove(nums.size()-1);
        val2index.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex=random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
// class tetetest {
//     public static void main(String[] args) {
//         RandomizedSet randomizedSet = new RandomizedSet();
//         System.out.println("insert 0:"+String.valueOf(randomizedSet.insert(0)));
//         System.out.println("insert 1:"+String.valueOf(randomizedSet.insert(1)));
//         System.out.println("remove 0:"+String.valueOf(randomizedSet.remove(0)));
//         System.out.println("insert 2:"+String.valueOf(randomizedSet.insert(2)));
//         System.out.println("remove 1:"+String.valueOf(randomizedSet.remove(1)));
//         System.out.println("random"+randomizedSet.getRandom());
//     }
// }
