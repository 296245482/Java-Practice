package springrecruit;//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

public class RectCover {
    public int Solution(int target) {
        if(target<=3)
            return target;
        else
            return Solution(target-1)+Solution(target-2);
//        return 0;
    }
    public static void main(String[] args){
        RectCover rc = new RectCover();
        System.out.println(rc.Solution(4));
    }
}
