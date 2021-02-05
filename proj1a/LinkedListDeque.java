

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
    Node sentinel = new Node(null,null,null);
    private int size=0;

    LinkedListDeque(){
        sentinel.prev= sentinel;
        sentinel.next= sentinel;
    }

    public void addFirst(bala item){
        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prev= sentinel.next;
        size++;
    }

    public void addLast(bala item){
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next= sentinel.prev;
        size++;
    }

    public boolean isEmpty(){
        if(size>0) return false;
        else return true;
    }

    public bala removeFirst(){
        bala temp = sentinel.next.item;
        sentinel.next= sentinel.next.next;
        sentinel.next.prev= sentinel;
        size--;
        return temp;
    }

    public bala removeLast(){
        bala temp = sentinel.next.item;
        sentinel.prev= sentinel.prev.prev;
        sentinel.prev.next= sentinel;
        size--;
        return temp;
    }

    public bala get(int index){
        Node op = sentinel.next;
        for(int i=0;i<index;i++){
            op = op.next;
        }
        return op.item;
    }

    public bala getRecursive(int index){
        Node op = sentinel.next;
        for(int i=0;i<index;i++){
            op = op.next;
        }
        return op.item;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = sentinel.next;
        while(p!= sentinel){
            System.out.print(p.item+" ");
            p=p.next;
        }
    }
}