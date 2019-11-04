package game;

public class Main {
    public static void main(String[] args) {
        Player p = new Player(1,1);
        Key k = new Key(Key.KeyType.blue,1,1);

        p.pickUp(k);
        p.pickUp(k);

        System.out.println(p.checkInventory(Key.KeyType.blue));
    }
}
