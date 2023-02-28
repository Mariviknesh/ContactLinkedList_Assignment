package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

class LinkedList
{
    Node root;
    Node temp;
    Node prev;
    int count;
    private static final String COM="com.api.jar";
    Logger log=Logger.getLogger(COM);
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