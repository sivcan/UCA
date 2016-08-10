#include <iostream>
using namespace std;

struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
}
struct node *head = NULL;

void insert(struct Node **head, int val) {
    struct Node new_node = new Node;
    new_node->data = val;
    new_node->next = *head;
    new_node->prev = NULL;

    if(*head != NULL) {
        (*head)->prev = new_node;
    }
    *head = new_node;
}


int main() {
    cout<<"\nDoubly Linked List.";

}
