public class Encoder {
	
	//ArrayFunctions
    public boolean[] intToBoolArray(int n) {
        String s = Integer.toBinaryString(n);
        boolean[] newArray = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            newArray[i] = s.charAt(i) - '0' != 0;
        }
        return newArray;
    }

    private boolean[] fixArray(boolean[] a, int newLength) {
        if (newLength < a.length) return a;
        boolean[] newBooleanArray = new boolean[newLength];
        for (int i = 0; i < newLength; i++) {
            newBooleanArray[i] = (i >= newLength - a.length) && a[i - (newLength - a.length)];
        }
        return newBooleanArray;
    }

    public int boolArrayToInt(boolean[] a) {
        StringBuilder sb = new StringBuilder(a.length);

        for (boolean b : a) {
            if (b) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    //Logical operators
    public boolean[] not(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = !a[i];
        }
        return a;
    }

    public boolean[] and(boolean[] a, boolean[] b) {
        boolean[] newArray = new boolean[a.length];

        a = fixArray(a, Math.max(a.length, b.length));
        b = fixArray(b, Math.max(a.length, b.length));

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = a[i] && b[i];
        }

        return newArray;
    }

    public boolean[] or(boolean[] a, boolean[] b) {
        boolean[] newArray = new boolean[a.length];

        a = fixArray(a, Math.max(a.length, b.length));
        b = fixArray(b, Math.max(a.length, b.length));

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = a[i] || b[i];
        }

        return newArray;
    }

    public boolean[] xor(boolean[] a, boolean[] b) {
        boolean[] newArray = new boolean[a.length];

        a = fixArray(a, Math.max(a.length, b.length));
        b = fixArray(b, Math.max(a.length, b.length));
        
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = a[i] != b[i];
        }
        return newArray;
    }
}