package java_se.propagation;

public class PropagationExample {
    //博客链接：https://www.ikaros.love/?p=445
    public static void main(String[] args) {
        int count = 0;
        update(count);
        System.out.println("main方法中count：" + count);

        User user = new User();
        user.setId(0);
        update(user);
        System.out.println("main方法中user：" + user);
    }
    private static void update(int count){
        count++;
        System.out.println("update方法中count：" + count);
    }
    private static void update(User user){
        user = new User();
        user.setId(1);
        System.out.println("update方法中user：" + user);
    }
}
