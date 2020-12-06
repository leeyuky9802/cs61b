

public class LinkedListDeque<bala> {
    private class Node{
        bala item;
        Node next;
        Node prev;
        Node(bala a, Node ne, Node pr){
            item=a;
            next=ne;
            prev=pr;
        }
    }
    Node sentinal = new Node(null,null,null);
    private int size=0;

    LinkedListDeque(){
        sentinal.prev=sentinal;
        sentinal.next=sentinal;
    }

    public void addFirst(bala item){
        sentinal.next = new Node(item,sentinal.next,sentinal);
        sentinal.next.next.prev=sentinal.next;
        size++;
    }

    public void addLast(bala item){
        sentinal.prev = new Node(item,sentinal,sentinal.prev);
        sentinal.prev.prev.next=sentinal.prev;
        size++;
    }

    public boolean isEmpty(){
        if(size>0) return false;
        else return true;
    }

    public bala removeFirst(){
        bala temp = sentinal.next.item;
        sentinal.next=sentinal.next.next;
        sentinal.next.prev=sentinal;
        size--;
        return temp;
    }

    public bala removeLast(){
        bala temp = sentinal.next.item;
        sentinal.prev=sentinal.prev.prev;
        sentinal.prev.next=sentinal;
        size--;
        return temp;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinal.next;
        while(p!=sentinal){
            System.out.print(p.item+" ");
            p=p.next;
        }
    }
}