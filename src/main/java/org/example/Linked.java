package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Linked{
    private static final String com="com.api.jar";
    public String [] getdata()
    {

        String [] data=new String[3];
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger(com);
       log.info("Enter Name:");
        data[0]=sc.next();
       log.info("Enter Email:");
        data[1]=sc.next();
       log.info("Enter number:");
        data[2]=sc.next();
        return data;
    }
    public static void main(String[] args) {
        String []data1;
        String com="com.api.jar";
        Logger log=Logger.getLogger(com);
        LinkedList l=new LinkedList();
        Linked l1=new Linked();
        Scanner sc=new Scanner(System.in);

        int ch=0;
      
        while(ch!=10)
        {
           log.info("1.Add Contact at last");
           log.info("2.Add Contact at First");
           log.info("3.Delete Contact at last");
           log.info("4.Delete Contact at First");
           log.info("5.Insert by Position");
           log.info("6.Delete by Position ");
           log.info("7.Search by Number");
           log.info("8.Display the linked list");
           log.info("9.Display the number of nodes");
           log.info("10.Exit");
           log.info("Enter the choice");
            ch=sc.nextInt();
            switch (ch) {


                case 1:{
                    data1 = l1.getdata();
                    Person p1 = new Person(data1[0], data1[1], data1[2]);
                    l.addNode(p1);break;
                } case 2: {
                    data1 = l1.getdata();
                    Person p1 = new Person(data1[0], data1[1], data1[2]);
                    l.addNodeFirst(p1);break;
                } case 3: {
                    l.deleteNodeLast();break;
                } case 4: {
                    l.deleteNodeFirst();break;
                }case 5: {
                    log.info("Enter the position");
                    int pos = sc.nextInt();
                    data1 = l1.getdata();
                    Person p1 = new Person(data1[0], data1[1], data1[2]);
                    l.addNodePos(p1, pos);break;
                } case 6: {
                    log.info("Enter the position");
                    int pos = sc.nextInt();
                    l.deleteNodePos(pos);break;
                } case 7: {
                    log.info("Enter the number for searching");
                    String num = sc.next();
                    int res = l.searchbyNumber(num);
                    if (res > 0) {
                        log.info("The contact is found at the position of");
                        log.log(Level.INFO, () -> "" + res);
                    } else if (res == 0) {
                        log.info("The list is empty");
                    } else if (res == -1) {
                        log.info("The contact is not presented in the Linked list");
                    }break;
                } case 8: {
                    l.display();break;
                } case 9: {
                    l.displayCount();
                    break;
                } default: {
                    log.info("Enter valid choice");
                    break;
                }
            }
        }


    }
}
class Person
{
    private static final String com="com.api.jar";

    String name;
    String email;
    String num;
    Person(String name,String email,String num)
    {
        this.name=name;
        this.num=num;
        this.email=email;
    }
    void display()
    {
        Logger log=Logger.getLogger(com);
       log.info("Name=");
        log.info(this.name);
       log.info("Number=");
        log.info(this.num);
       log.info("Email=");
        log.info(this.email);
       log.info("");
    }
}
class Node
{
    Person p;
    Node nextnode;
    Node(Person a)
    {
        this.p=a;
        this.nextnode=null;
    }
}
class LinkedList
{
    Node root;
    Node temp;
    Node prev;
    int count;
    private static final String com="com.api.jar";
    Logger log=Logger.getLogger(com);
    LinkedList()
    {
        this.root=null;
    }
    public void addNodeFirst(Person a) {
        Node a1 = new Node(a);
        if (this.root == null) {
            this.root = a1;
        }
        else {
            temp=this.root;
            this.root=a1;
            a1.nextnode=temp;
        }
        count++;
       log.info(" Node inserted at 1st");
    }
    public void addNodePos(Person a,int pos)
    {
        int cnt=0;
        Node a1=new Node(a);
        if(this.root==null)
        {
            this.root=a1;
            count++;
           log.info("As list is empty Node inserted at First");
        }
        else {
            temp=this.root;
            while(temp.nextnode!=null)
            {
                if(cnt==pos+1)
                {
                    break;
                }
                prev=temp;
                temp=temp.nextnode;
                cnt++;
            }
            a1.nextnode=temp;
            prev.nextnode=a1;
            count++;
           log.info("Node inserted at Position");
            log.log(Level.INFO,()->""+pos);
        }
    }
    public void deleteNodePos(int pos)
    {
        int cnt=0;

        if(this.root==null)
        {
           log.info("List is Empty");
        }
        else {
            temp=this.root;
            if(this.root.nextnode==null)
            {
                this.root=null;
            }
            else {
                while (temp.nextnode != null) {
                    if (cnt == pos - 1) {
                        break;
                    }
                    prev = temp;
                    temp = temp.nextnode;
                    cnt++;
                }
                prev.nextnode = temp.nextnode;
            }
            count--;
           log.info("Node deleted at position");
            log.log(Level.INFO,()->""+ pos);
        }
    }
    public void addNode(Person a)
    {
        Node a1=new Node(a);
        if(this.root==null)
        {
            this.root=a1;
            count++;
           log.info("1st Node inserted");
        }
        else {
            temp=this.root;
            while(temp.nextnode!=null)
            {
                temp=temp.nextnode;
            }
            temp.nextnode=a1;
            count++;
           log.info("Node inserted at last");
        }
    }
    public void deleteNodeLast()
    {
        temp=this.root;
        while(temp.nextnode!=null)
        {
            prev=temp;
            temp=temp.nextnode;
        }
        prev.nextnode=null;
        count--;
       log.info(" Node deleted at Last");

    }
    public void deleteNodeFirst()
    {
        temp=this.root;
        temp=temp.nextnode;
        this.root=temp;
        count--;
       log.info(" Node deleted at First");
    }
    public int searchbyNumber(String number)
    {
        int cnt=1;
        temp=this.root;
        if(temp==null)
        {

            return 0;
        }
        else
        {
            while(temp!=null)
            {

                if(temp.p.num.equals(number))
                {
                    return cnt;
                }
                temp=temp.nextnode;
                cnt++;

            }
        }
        return -1;
    }
    public void displayCount()
    {
       log.info("Number of Nodes=");
        log.log(Level.INFO,()->""+ this.count);
    }
    public void display()
    {
        int cnt=1;
        temp=this.root;
        if(temp==null)
        {
           log.info("Empty list");
        }
        else
        {
            while(temp!=null)
            {
               log.info("Node");

                int finalCnt1 = cnt;
                log.log(Level.INFO,()->""+ finalCnt1);
                temp.p.display();
                temp=temp.nextnode;
                cnt++;
            }
        }

    }
}
