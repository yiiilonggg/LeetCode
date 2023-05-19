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
    ListNode* swapNodes(ListNode* head, int k) {
        vector<int> v;
        ListNode* curr = head;
        while (curr != NULL) {
            v.push_back(curr -> val);
            curr = curr -> next;
        }
        int n = v.size(), temp = v[k - 1];
        v[k - 1] = v[n - k];
        v[n - k] = temp;
        curr = head;
        for (int i = 0; i < n; i++, curr = curr -> next) {
            curr -> val = v[i];
        }
        return head;
    }
};