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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* rfirst = reverse(l1);
        ListNode* rsecond = reverse(l2);
        ListNode* cfirst = rfirst;
        ListNode* csecond = rsecond;
        ListNode* pfirst = nullptr;
        ListNode* psecond = nullptr;
        int carry = 0, val = 0;
        while (cfirst != nullptr && csecond != nullptr) {
            val = cfirst -> val + csecond -> val + carry;
            carry = (val > 9) ? 1 : 0;
            cfirst -> val = val % 10;
            pfirst = cfirst;
            psecond = csecond;
            cfirst = cfirst -> next;
            csecond = csecond -> next;
        }
        if (cfirst == nullptr && csecond != nullptr) {
            pfirst -> next = csecond;
            cfirst = csecond;
        }
        while (cfirst != nullptr || carry > 0) {
            if (cfirst == nullptr) {
                pfirst -> next = new ListNode();
                cfirst = pfirst -> next;
            }
            val = cfirst -> val + carry;
            carry = (val > 9) ? 1 : 0;
            cfirst -> val = val % 10;
            pfirst = cfirst;
            cfirst = cfirst -> next;
        }
        return reverse(rfirst);
    }

    ListNode* reverse(ListNode* root) {
        ListNode* prev = nullptr;
        ListNode* curr = root;
        ListNode* foll = root;
        while (curr != nullptr) {
            foll = foll -> next;
            curr -> next = prev;
            prev = curr;
            curr = foll;
        }
        return prev;
    }
};
