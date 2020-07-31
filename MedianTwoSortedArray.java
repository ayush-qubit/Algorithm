//import java.util.Scanner;

public class MedianTwoSortedArray{
    public static int mid(int low,int high){
        if(high+1==low){
            high=low;
        }
        return (high+low)/2;
    }
    public static double avg(double ele1,double ele2){
        return (ele1+ele2)/2;
    }
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n=nums1.length;
        int m=nums2.length;
        int total=(n+m+1)/2;
        boolean found=false;
        int low=0,high=n-1;
        int leftmaxx=-1,leftmaxy=-1,rightminx=-1,rightminy=-1;
        while(found!=true){
            int middle=mid(low,high);
            int parx=middle;
            int pary=total-parx;
            leftmaxx=parx-1<0?Integer.MIN_VALUE:nums1[parx-1];
            leftmaxy=pary-1<0?Integer.MIN_VALUE:nums2[pary-1];
            rightminx=parx>n-1?Integer.MAX_VALUE:nums1[parx];
            rightminy=pary>m-1?Integer.MAX_VALUE:nums2[pary];
            if(leftmaxx<=rightminy && leftmaxy<=rightminx){
                found=true;
                break;
            }else if(leftmaxx>rightminy){
                high=parx;
            }else{
                low=parx+1;
            }
        }
        if((n+m)%2==0){
            return avg((double)Math.max(leftmaxx, leftmaxy),(double)Math.min(rightminx, rightminy));
        }else{
            return Math.max((double)leftmaxx, (double)leftmaxy);
        }
    }
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}