package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Linked{
    private static final String COM="com.api.jar";
    public String [] getdata()
    {

        String [] data=new String[3];
        Scanner sc=new Scanner(System.in);
        Logger log=Logger.getLogger(COM);
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

        Logger log=Logger.getLogger(COM);
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



