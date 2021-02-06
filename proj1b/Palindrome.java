public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return (Deque<Character>) deque;
    }
    public boolean isPalindrome(String word){
        Deque deque = wordToDeque(word);
        for (int i=0;i<deque.size()/2;i++){
            char a = (char) deque.removeFirst();
            char b = (char) deque.removeLast();
            if(!(a==b||java.lang.Math.abs(a-b)==32)) return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque deque = wordToDeque(word);
        for (int i=0;i<deque.size()/2;i++){
            char a = (char) deque.removeFirst();
            char b = (char) deque.removeLast();
            if(!cc.equalChars(a,b)) return false;
        }
        return true;
    }
}