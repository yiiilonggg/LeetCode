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
    ListNode* swapPairs(ListNode* head) {
        ListNode* dummy = new ListNode(0, head);
        ListNode* prev = dummy;
        ListNode* curr = head;
        ListNode* foll = head;
        while (foll != NULL && foll -> next != NULL) {
            foll = foll -> next;
            prev -> next = foll;
            curr -> next = foll -> next;
            foll -> next = curr;
            prev = curr;
            curr = curr -> next;
            foll = curr;
        }
        return dummy -> next;
    }
};