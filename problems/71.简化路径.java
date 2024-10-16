import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] strings=path.split("/");
        // for (String str : strings) {
        //     System.out.println(str);
        // }
        Stack<String> stack=new Stack<>();
        for (int i=0 ; i<strings.length ; i++) {
            String str=strings[i];
            
            if(str.equals("..")){
                if(!stack.empty()){
                    stack.pop();
                }
            }
            else if(!str.equals(".") && !str.equals("")){
                stack.push(str);
            }
        }
        //System.out.println(stack.size());
        StringBuilder sb=new StringBuilder();
        sb.append("/");
        if(!stack.empty()){
            while(!stack.empty()){
                sb.insert(1, stack.pop()+"/");
            }
            int n=sb.length();
            sb.replace(n-1, n, "");
        }
        
        return sb.toString();
    }
}
// @lc code=end

class test  {
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        String s="/a/./b/../../c/";
        System.out.println(solution.simplifyPath(s));
    }
}
