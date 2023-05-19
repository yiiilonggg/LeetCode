/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int pairSum(ListNode* head) {
        ListNode* dummy = head;
        ListNode* fast = head;
        ListNode* slow = head;
        int halfn = 0, res = 0;
        while (dummy != NULL && dummy -> next != NULL) {
            dummy = dummy -> next -> next;
            fast = fast -> next;
            halfn++;
        }
        vector<int> v(halfn, 0);
        for (int i = 0; i < halfn; i++) {
            v[halfn - i - 1] += fast -> val;
            v[i] += slow -> val;
            fast = fast -> next;
            slow = slow -> next;
            res = max(res, max(v[halfn - i - 1], v[i]));
        }
        return res;
    }
};