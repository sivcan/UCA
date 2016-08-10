#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
}*head;



void append(int num)
{
    struct node *temp,*right;
    temp= (struct node *)malloc(sizeof(struct node));
    temp->data=num;
    right=(struct node *)head;
    while(right->next != NULL)
    right=right->next;
    right->next =temp;
    right=temp;
    right->next=NULL;
}



void add( int num )
{
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));
    temp->data=num;
    if (head== NULL)
    {
    head=temp;
    head->next=NULL;
    }
    else
    {
    temp->next=head;
    head=temp;
    }
}
void addafter(int num, int loc)
{
    int i;
    struct node *temp,*left,*right;
    right=head;
    for(i=1;i<loc;i++)
    {
    left=right;
    right=right->next;
    }
    temp=(struct node *)malloc(sizeof(struct node));
    temp->data=num;
    left->next=temp;
    left=temp;
    left->next=right;
    return;
}



void insert(int num)
{
    int c=0;
    struct node *temp;
    temp=head;
    if(temp==NULL)
    {
    add(num);
    }
    else
    {
    while(temp!=NULL)
    {
        if(temp->data<num)
        c++;
        temp=temp->next;
    }
    if(c==0)
        add(num);
    else if(c<count())
        addafter(num,++c);
    else
        append(num);
    }
}



int delete(int num)
{
    struct node *temp, *prev;
    temp=head;
    while(temp!=NULL)
    {
    if(temp->data==num)
    {
        if(temp==head)
        {
        head=temp->next;
        free(temp);
        return 1;
        }
        else
        {
        prev->next=temp->next;
        free(temp);
        return 1;
        }
    }
    else
    {
        prev=temp;
        temp= temp->next;
    }
    }
    return 0;
}


void  display(struct node *r)
{
    r=head;
    if(r==NULL)
    {
    return;
    }
    while(r!=NULL)
    {
    printf("%d ",r->data);
    r=r->next;
    }
    printf("\n");
}


int count()
{
    struct node *n;
    int c=0;
    n=head;
    while(n!=NULL)
    {
    n=n->next;
    c++;
    }
    return c;
}

void countElements()
{
    if(head == NULL)
    {
        printf("\nThe list is empty!");
    }
    else
    {
        int k = 0;
        int arr[1000]={0};
        struct node * ptr = head;
        while(ptr!=NULL)
        {
            arr[ptr->data]++;
            ptr = ptr->next;
            k++;
        }

        for(int i = 0; i < k; i++)
        {
            if(arr[i] > 0)
            printf("%d appears %d times.\n ", i, arr[i]);
        }

    }
}


void mid() {
    if(head == NULL) {
        printf("\nThe head is null.");
    }
    else if(head->next->next!=NULL){
        struct node * ptr1 = head;
        struct node * ptr2 = head;
        while(ptr2 !=NULL && ptr2->next!= NULL) {
            if(ptr2->next != NULL && ptr2->next->next !=NULL)
                ptr2 = ptr2->next->next;
            else {
                break;
            }
            ptr1 = ptr1->next;

        }

        printf("\nThe mid is : %d\n", ptr1->data);
    }
}
void deleteCrazy(struct node * del) {
    struct node *store = del;
    store->data = del->next->data;
    store->next = del->next->next;
    del = del->next;
    free(del);
    printf("\nDeletion done.");
}

void crazy()
{
    if(head == NULL ) {
        printf("\nEmpty list!");
    }
    else {
        struct node * ptr = head;
        ptr = ptr->next;
        ptr = ptr->next;
        deleteCrazy(ptr);
    }
}

void loopDetector() {
    if(head == NULL) {
        printf("\nNull head. No loop detected.");
    }
    else {

    }
}
int  main()
{
    int i,num;
    struct node *n;
    head=NULL;
    while(1)
    {
    printf("\nList Operations\n");
    printf("===============\n");
    printf("1.Insert\n");
    printf("2.Display\n");
    printf("3.Size\n");
    printf("4.Delete\n");
    printf("5.Count Elements\n");
    printf("6.Exit\n");
    printf("7.Find Mid\n");
    printf("8.Delete it crazy.\n");
    printf("Enter your choice : ");
    if(scanf("%d",&i)<=0){
        printf("Enter only an Integer\n");
        exit(0);
    } else {
        switch(i)
        {
        case 1:      printf("Enter the number to insert : ");
                 scanf("%d",&num);
                 insert(num);
                 break;
        case 2:     if(head==NULL)
                {
                printf("List is Empty\n");
                }
                else
                {
                printf("Element(s) in the list are : ");
                }
                display(n);
                break;
        case 3:     printf("Size of the list is %d\n",count());
                break;
        case 4:     if(head==NULL)
                printf("List is Empty\n");
                else{
                printf("Enter the number to delete : ");
                scanf("%d",&num);
                if(delete(num))
                    printf("%d deleted successfully\n",num);
                else
                    printf("%d not found in the list\n",num);
                }
                break;
        case 5:     countElements(); break;
        case 6 :    return 0; break;
        case 7 : mid(); break;
        case 8 : crazy(); break;
        default:    printf("Invalid option\n");
        }
    }
    }
    return 0;
}
