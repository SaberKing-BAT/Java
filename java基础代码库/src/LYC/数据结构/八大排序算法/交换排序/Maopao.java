package LYC.数据结构.八大排序算法.交换排序;

public class Maopao {
    public static void main(String[] args) {
        int arr[]={3,123,13,34,54,67,45,112,66,9,334,99};
        int arr1[]=maoPaoSort(arr);
        for (int i:arr1
             ) {
            System.out.println(i);
        }

    }
    public static int[] maoPaoSort(int[] arr){
        int temp;
        boolean flag=false;//如果没有发生位置交换，证明排好序了（优化1）
        for (int i=0;i<arr.length-1;i++){//n个数，做n-1次循环，最后一个数不需要排序。
            for (int j=0;j<arr.length-1-i;j++){//每次内循环排好一个最大的数放在最后
                if (arr[j]>arr[j+1]){           //-i，i后已经拍好序了，后面无需比较（优化2）
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if (!flag) return arr;
        }
        return arr;
    }
}
