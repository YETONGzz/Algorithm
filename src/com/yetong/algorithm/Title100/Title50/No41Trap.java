package com.yetong.algorithm.Title100.Title50;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * 接雨水
 */
public class No41Trap {

    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 5};
        No41Trap no41Trap = new No41Trap();
        System.out.println(no41Trap.trapTwo(arr));
    }

    public int trap(int[] walls) {
        if (walls == null || walls.length <= 2) {
            return 0;
        }

        // 思路：
        // 单调不增栈，walls元素作为右墙依次入栈
        // 出现入栈元素（右墙）比栈顶大时，说明在右墙左侧形成了低洼处，低洼处出栈并结算该低洼处能接的雨水

        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int right = 0; right < walls.length; right++) {
            // 栈不为空，且当前元素（右墙）比栈顶（右墙的左侧）大：说明形成低洼处了
            while (!stack.isEmpty() && walls[right] > walls[stack.peek()]) {
                // 低洼处弹出，尝试结算此低洼处能积攒的雨水
                int bottom = stack.pop();
                // 看看栈里还有没有东西（左墙是否存在）
                // 有右墙+有低洼+没有左墙=白搭
                if (stack.isEmpty()) {
                    break;
                }

                // 左墙位置以及左墙、右墙、低洼处的高度
                int left = stack.peek();
                int leftHeight = walls[left];
                int rightHeight = walls[right];
                int bottomHeight = walls[bottom];

                // 能积攒的水=(右墙位置-左墙位置-1) * (min(右墙高度, 左墙高度)-低洼处高度)
                water += (right - left - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);
            }

            // 上面的pop循环结束后再push，保证stack是单调不增
            stack.push(right);
        }

        return water;
    }

    /**
     * 双指针 最优解
     *
     * @param height
     * @return
     */
    public int trapTwo(int[] height) {

        int n = height.length;
        //左指针 用来控制左侧柱子的移动 并与左侧最大柱子相减得到左侧存水量
        int left = 0;
        //右指针 用来控制右侧柱子的移动 并与右侧最大柱子相减得到右侧存水量
        int right = n - 1;
        //左侧的最大柱子
        int l_max = height[0];
        //右侧的最大柱子
        int r_max = height[n - 1];

        int ans = 0;
        //当左指针小于右指针时进行判断
        while (left <= right) {
            //获得左侧的最大柱子
            l_max = Math.max(l_max, height[left]);
            //获得右侧的最大柱子
            r_max = Math.max(r_max, height[right]);

            //当左侧最大小于右侧最大时 可以计算左侧的存水量
            if (l_max < r_max) {
                //左侧最大柱子减去当前左指针所代表的的柱子，就是当前所可以存储的水量
                ans += l_max - height[left];
                //计算之后 左指针向右移
                ++left;
            } else {
                //当右侧最大小于左侧最大时 可以计算右侧的存水量
                //右侧最大柱子减去当前右指针所代表的的柱子，就是当前所可以存储的水量
                ans += r_max - height[right];
                //计算之后右指针左移
                --right;
            }
        }
        return ans;

    }


}
