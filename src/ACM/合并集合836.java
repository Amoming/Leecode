package ACM;

import java.util.Scanner;

public class 合并集合836 {
    static int[] fa;
    public static int find(int x){
        if(fa[x] == x){
            return x;
        }
        fa[x] = find(fa[x]);
        return fa[x];
    }

    // 不能这样写，因为只有子节点指向，父节点没指，那么下次别的节点指向父节点就没有了
//    public  static void join(int x, int y){
//        if (find(x) != find(y)){
//            fa[x] = find(y);
//        }
//    }
    public  static void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            fa[fx] = fy;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        fa = new int[n + 1];
        for (int i = 0 ; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String operation = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(operation.equals("M")){
                join(x, y);
            }else {
                if(find(x) != find(y)) System.out.println("No");
                else System.out.println("Yes");
            }
        }
    }
}
