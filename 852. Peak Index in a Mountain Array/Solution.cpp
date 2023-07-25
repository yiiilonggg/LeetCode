class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                left = mid;
                break;
            }
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
};
