package D4;

public class Pair<K, V> {
    K V1;
    V V2;

    public Pair(K V1, V V2) {
        this.V1 = V1;
        this.V2 = V2;
    }

    public K getV1() {
        return V1;
    }

    public void setV1(K v1) {
        this.V1 = v1;
    }

    public V getV2() {
        return V2;
    }

    public void setV2(V v2) {
        this.V2 = v2;
    }
}
