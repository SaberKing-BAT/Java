package LYC.数据结构.八大排序算法.交换排序;

public class FastSort {
    public static void main(String[] args) {
        int[] arr={123,1221,1235,334,34,126,54,745,95,342,232};
        fastSort(arr,0,10);
        for (int i:arr
             ) {
            System.out.println(i);
        }

    }
    public static void fastSort(int[]arr,int left,int right ){
        if (left>right){
            return ;
        }
        int temp=0;
        int key=arr[left],i=left,j=right;
        while (i<j){
            /*步骤一：从右往左找到第一个小于key的值，找不到(j=0)说明key最小，右边都大*/
            while (i<j&&arr[j]>=key){
                j--; //当找不到j--,找到了break；
            }
            /*步骤二：从左往右找打一个大于key的值，在*/
            while (i<j&&arr[i]<=key){
                i++;//找不到；找到或者，i=j时，break；
            }
            if (i<j){ //步骤三：
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //i=j时，key<a[i]
        arr[left]=arr[i];//把key和a[i]互换位置
        arr[i]=key;
        fastSort(arr,left,i-1);//左调用
        fastSort(arr,i+1,right);
    }

}
