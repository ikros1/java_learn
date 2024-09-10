package java_se.keyword;

public class VoidExample {
    public static void main(String[] args) {
       /*
       void关键字到底是什么类型？
        java不像是php这些弱类型的语言，
        java语言是强类型的，意 思就是说我们的方法必须要有一个确定类型的返回值，
        举个例子

        public String test(){};
        上面这个test方法有一个String类型的返回值，
        我们也可以返回int等基础类型的。 不管返回什么都要返回一个确定的类型。

        现在！！！出现了一个问题，我们的方法也可以返回void，
        那么void肯定也是一种数据类型吧。 但是java好像只提供了两种数据类型：
        基本数据类型和引用数据类型 。那这个void到底是什么呢？
        其实你可以把他理解成一个特殊的数据类型也可以理解成一个方法的修饰符。
        从Void看void
        我们的基础类型好像都有一个封装类，比如int基本类型的封装类是Integer，char基本类型的封装类是Character， void也不例外，他也有一个封装类叫做Void，没错就是把“v”换成了大写的V。你可以这样去理解Void：
        其实Void类是一个不可实例化的占位符类，用来保存一个引用代表Java关键字void的Class对象。
        Void类型不可以继承和实例化。而且修饰方法时候必须返回null。
        */
        System.out.println(Void.class);
        System.out.println(void.class);
        //使用场景：泛型中使用
        //
        //Future用来保存结果。Future的get方法返回结果(类型为T)。但如果操作并没有返回值呢？这种情况下就可以用Future表示。当调用get后结果计算完毕则返回后将会返回null。
        //
        //Void也用于无值的Map中，例如Map<,Void>这样map将具Set有一样的功能。
        //
        // 在反射中确定某个函数的返回类型
        /*
        public class Test {
            // 在这里定义两个方法：
            //（1）a方法返回void
            //（2）b方法返回int
            public void a() {}
            public int b() {
                return 1;
            }
            public static void main(String args[]) {
                for (Method method : Test.class.getMethods()) {
                    if (method.getReturnType().equals(Void.TYPE)) {
                        System.out.println("返回void的方法是："+method.getName());
                    }
                    else if(method.getReturnType().equals(Integer.TYPE)) {
                        System.out.println("返回int的方法是："+method.getName());
                    }
                }
            }

         */


    }
    public class Test {
        //返回void，return可有可无
        public void a1() {
            return;
        }
        //必须且只能返回null
        public Void a2() {
            return null;
        }
    }
}


