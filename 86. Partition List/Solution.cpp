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
    ListNode* partition(ListNode* head, int x) {
        ListNode* lessDummy = new ListNode();
        ListNode* moreDummy = new ListNode();
        ListNode* curr = head;
        ListNode* currLess = lessDummy;
        ListNode* currMore = moreDummy;
        while (curr != nullptr) {
            ListNode* foll = curr -> next;
            if (curr -> val < x) {
                currLess -> next = curr;
                currLess = currLess -> next;
            } else {
                currMore -> next = curr;
                currMore = currMore -> next;
            }
            curr -> next = nullptr;
            curr = foll;
        }
        currLess -> next = moreDummy -> next;
        return lessDummy -> next;
    }
};
