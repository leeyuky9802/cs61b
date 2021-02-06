public class OffByN implements CharacterComparator{
    private int value;
    private int value2;

    public OffByN(int n){
        value =n;
        value2=-n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if((x-y)==value||(x-y)==value2) return true;
        else return false;
    }
}
