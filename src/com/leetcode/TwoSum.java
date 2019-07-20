package com.leetcode;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.Arrays;

public class TwoSum implements Solution {

    @Override
    public FileContent solve(FileContent t) {
        int[] nums = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        int target = Integer.parseInt(t.getLineByIndex(1));

        int[] ret_arr = twoSum(nums, target);
        String ret_string = ret_arr[0] + " " + ret_arr[1];

        return new FileContent(ret_string);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] nums1 = nums.clone();
        Arrays.sort(nums);

        int[] ret_arr = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];

            int pairIndex = binarySearch(target - element, nums, 0, nums.length - 1, i);

            if (pairIndex == -1 || pairIndex == i) continue;

            ret_arr[0] = linearSearch(nums[i], nums1, -1);
            ret_arr[1] = linearSearch(nums[pairIndex], nums1, ret_arr[0]);

            break;
        }

        return ret_arr;
    }

    public int linearSearch(int element, int[] nums, int excludeIndex) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element && i != excludeIndex) {
                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int element, int[] nums, int start, int end, int excludeIndex) {
        if (start > end) return -1;

        if (start + 1 == end) {
            if (nums[start] == element && start != excludeIndex) return start;
            if (nums[end] == element && end != excludeIndex) return end;
            return -1;
        }

        int mid  = (start + end) / 2;

        if (mid == excludeIndex) return -1;

        if (nums[mid] == element) {
            return mid;
        }

        if (start == end) return -1;

        int leftSearch = binarySearch(element, nums, start, mid - 1, excludeIndex);

        if (leftSearch != -1) {
            return leftSearch;
        }

        int rightSearch = binarySearch(element, nums, mid + 1, end, excludeIndex);

        if (rightSearch != -1) {
            return rightSearch;
        }

        return -1;
    }
}
