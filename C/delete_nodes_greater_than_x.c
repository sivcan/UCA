Sol 1 : 11/16 test cases.
--
/*
 * Complete the function below.
 */
/*
For your reference:
LinkedListNode {
    int val;
    LinkedListNode *next;
};
*/

LinkedListNode* removeNodes(LinkedListNode* list, int x) {
    LinkedListNode *ptr1, *ptr2, *rem;
    ptr2 = list;
    ptr1 = list;
    int c = 0;
    if(ptr2->val > x) {
        ptr2 = ptr2->next;
        list = ptr2;
    }
    while(ptr2 && ptr2->next) {
       c++;
       if(ptr2->next->val > x) {
           rem = ptr2->next;
           ptr2->next = ptr2->next->next;
           free(rem);
       }
       else {
           ptr2 = ptr2->next;
       }

       if(c > 0) {  //Following pointer..
           ptr1 = ptr1->next;
       }
   }
   if(ptr2 && ptr2->val > x) {
       ptr1->next = NULL;
   }

   return list;

}



Sol 2 : 14/16 cases passed.
   -----

   /*
 * Complete the function below.
 */
/*
For your reference:
LinkedListNode {
    int val;
    LinkedListNode *next;
};
*/

LinkedListNode* removeNodes(LinkedListNode* list, int x) {
    LinkedListNode *ptr1, *ptr2;
    ptr1 = list;
    int arr[1000000];
    int c = 0;
    while(ptr1) {
        if(ptr1->val <= x)
            arr[c++] = ptr1->val;
        ptr1 = ptr1->next;
    }

    ptr1 = list;
    ptr2 = list;
    for(int i = 0; i < c; i++) {
        ptr1->val = arr[i];
        ptr1 = ptr1->next;
        if(i > 0) {
            ptr2 = ptr2->next;
        }

    }

    ptr2->next = NULL;
    return list;

}
