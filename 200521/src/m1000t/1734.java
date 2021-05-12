package m1000t;

class J1734 {
    public int[] decode(int[] encoded) {
        int r = 0;
        for (int i = encoded.length - 1; i > 0; i -= 2)
            r ^= encoded[i];
        for (int i = 1; i <= encoded.length + 1; i++)
            r ^= i;
        int[] res = new int[encoded.length + 1];
        res[0] = r;
        int i = 0;
        for (int e : encoded)
            res[i + 1] = res[i++] ^ e;
        return res;
    }
}
