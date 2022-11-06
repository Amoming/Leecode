package 字符串;

public class 比较版本号 {
    public static int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        for (int i = 0; i < Math.max(version1Array.length, version2Array.length); i++) {
            int v1 = 0, v2 = 0;
            if(i < version1Array.length) v1 = Integer.parseInt(version1Array[i]);
            if(i < version2Array.length) v2 = Integer.parseInt(version2Array[i]);
            System.out.println(v1 + "   "+v2);
            if(v1 < v2) return -1;
            if(v1 > v2) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("0.1","1.1");
    }
}
