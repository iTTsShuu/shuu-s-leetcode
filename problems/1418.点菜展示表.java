/*
 * @lc app=leetcode.cn id=1418 lang=java
 *
 * [1418] 点菜展示表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import java.util.Map;
import java.util.Set;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // 统计菜名 和 每桌号点餐数量
        Set<String> nameSet = new HashSet<>();
        // 每桌号点餐数量
        Map<Integer, Map<String, Integer>> tableFoodCnt = new HashMap();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            Integer tableId = Integer.parseInt(order.get(1));
            Map<String, Integer> cur = tableFoodCnt.getOrDefault(tableId, new HashMap<String, Integer>());
            cur.put(order.get(2), cur.getOrDefault(order.get(2), 0) + 1);
            tableFoodCnt.put(tableId, cur);
        }
        // 餐品名字母排序
        // shuu:Arrays.asList()方法 nameSet.toArray()方法
        List<String> names = Arrays.asList(nameSet.toArray(new String[nameSet.size()]));
        Collections.sort(names);

        // 餐桌号排序
        Integer[] ids = tableFoodCnt.keySet().toArray(new Integer[tableFoodCnt.size()]);
        Arrays.sort(ids);
        List<Integer> idsList = Arrays.asList(ids);

        // 拼接答案
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(names);
        List<List<String>> tableF = new ArrayList<>();
        tableF.add(header);
        for (Integer id : idsList) {
            Map<String, Integer> map = tableFoodCnt.get(id);
            List<String> tmp = new ArrayList<>();
            tmp.add(String.valueOf(id));
            for (String name : names) {
                Integer curFoodCnt = map.getOrDefault(name, 0);
                tmp.add(String.valueOf(curFoodCnt));
            }
            tableF.add(tmp);
        }

        return tableF;
    }
}

// @lc code=end
class test1418 {
    public static void main(String[] args) {
        Solution1418 solution1418 = new Solution1418();
        List<List<String>> orders = new ArrayList<>();
        String[][] sOrders = new String[][] {
                { "David", "3", "Ceviche" }, { "Corina", "10", "Beef Burrito" },
                { "David", "3", "Fried Chicken" }, { "Carla", "5", "Water" },
                { "Carla", "5", "Ceviche" }, { "Rous", "3", "Ceviche" }
        };
        for (String[] strings : sOrders) {
            orders.add(Arrays.asList(strings));
        }
        List<List<String>> displayTable = solution1418.displayTable(orders);
        for (List<String> list : displayTable) {
            for (String col : list) {
                System.out.printf("%8s", col + " ");
            }
            System.out.println();
        }
    }
}