/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * 有一个数组,里面的数字为大于零的整数, 代表木板的高度, 求其中一对木板的高度, 这两个数和地板一起,能够得到最大的木桶容积
 * 
 * 利用了常见的"双指针"法, 两个指针一个指向最前,一个指向最后, 然后 "数值小"的指针向里运动,
 * 这里利用了"水桶的容积只取决于最断的那个木板"的原理!,最终 把复杂度降到了O(n)
 * 
 * @author cassie9082
 * 
 */
public class ContainerWithMostWater {

}
