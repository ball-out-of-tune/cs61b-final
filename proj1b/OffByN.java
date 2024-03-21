public class OffByN implements CharacterComparator {
    private int gap;
    public OffByN(int x) {
        gap = x;
    }
    public boolean equalChars(char x, char y) {
        return  (x - y == gap || y - x == gap);
    }
}
