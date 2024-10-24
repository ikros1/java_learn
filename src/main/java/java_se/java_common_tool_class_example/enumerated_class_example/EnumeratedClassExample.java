package java_se.java_common_tool_class_example.enumerated_class_example;

public class EnumeratedClassExample {
    public static void main(String[] args) {
        //普通常量类使用内部常量时
        System.out.println(Weekday.FRI);
        //普通常量使用时编译器无法每个常量值都检查
        //所以使用特定的枚举类
        EnumWeekday day = EnumWeekday.SUN;
        //使用enum定义的枚举类是一种引用类型。前面我们讲到，引用类型比较，要使用equals()方法，
        // 如果使用==比较，它比较的是两个引用类型的变量是否是同一个对象。因此，引用类型比较，
        // 要始终使用equals()方法，但enum类型可以例外。
        //这是因为enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较：
        if (day == EnumWeekday.SAT || day == EnumWeekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
        //通过enum定义的枚举类，和其他的class有什么区别？
        //
        //答案是没有任何区别。enum定义的类型就是class，只不过它有以下几个特点：
        //
        //定义的enum类型总是继承自java.lang.Enum，且无法被继承；
        //只能定义出enum的实例，而无法通过new操作符创建enum的实例；
        //定义的每个实例都是引用类型的唯一实例；
        //可以将enum类型用于switch语句。
        //所以，编译后的enum类和普通class并没有任何区别。
        // 但是我们自己无法按定义普通class那样来定义enum，必须使用enum关键字，
        // 这是Java语法规定的。
        //因为enum是一个class，每个枚举的值都是class实例，因此，这些实例有一些方法
        //返回常量名
        String s = EnumWeekday.SUN.name();
        System.out.println(s);
        //返回定义的常量的顺序。从0开始计数
        int n = EnumWeekday.MON.ordinal();
        System.out.println(n);
        //因为enum本身是class，所以我们可以定义private的构造方法，并且，给每个枚举常量添加字段：
        EnumWeekdayHasValue en_day = EnumWeekdayHasValue.MON;
        if (en_day.dayValue == 6 || en_day.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
        //默认情况下，对枚举常量调用toString()会返回和name()一样的字符串。
        // 但是，toString()可以被覆写，而name()则不行。
        // 我们可以给Weekday添加toString()方法：
        EnumWeekdayHasValueOverRideToString day_has_to_string = EnumWeekdayHasValueOverRideToString.SUN;
        if (day_has_to_string.dayValue == 6 || day_has_to_string.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }
        //最后，枚举类可以应用在switch语句中。因为枚举类天生具有类型信息和有限个枚举常量
        // ，所以比int、String类型更适合用在switch语句中：
        switch(day_has_to_string) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day_has_to_string + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day_has_to_string + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day_has_to_string);
        }



    }
    //枚举类
    enum EnumWeekday {
        SUN, MON, TUE, WED, THU, FRI, SAT;
    }
    enum EnumWeekdayHasValue {
        MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

        public final int dayValue;

        private EnumWeekdayHasValue(int dayValue) {
            this.dayValue = dayValue;
        }
    }
    enum EnumWeekdayHasValueOverRideToString {
        MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

        public final int dayValue;
        private final String chinese;

        private EnumWeekdayHasValueOverRideToString(int dayValue, String chinese) {
            this.dayValue = dayValue;
            this.chinese = chinese;
        }

        @Override
        public String toString() {
            return this.chinese;
        }
    }
    //普通常量类
    public class Weekday {
        public static final int SUN = 0;
        public static final int MON = 1;
        public static final int TUE = 2;
        public static final int WED = 3;
        public static final int THU = 4;
        public static final int FRI = 5;
        public static final int SAT = 6;
    }
}

