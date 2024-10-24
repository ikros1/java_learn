package java_se.reference_type_example;

public class ReferenceExample {
    // java中有值类型也有引用类型，引用类型一般是针对于java中对象来说的，
    // java为引用类型专门定义了一个类叫做Reference。
    // Reference是跟java垃圾回收机制息息相关的类
    // java对象的引用包括强引用，软引用，弱引用，虚引用。
    // Java中提供这四种引用类型主要有两个目的：
    // 一是可以让程序员通过代码的方式决定某些对象的生命周期；
    // 二是有利于JVM进行垃圾回收。
    public static void main(String[] args) {

        // 强引用有引用变量指向时永远不会被垃圾回收，
        // 任何一个对象的赋值操作就产生了对这个对象的强引用。
        // JVM宁愿抛出OutOfMemory错误也不会回收这种对象。
        // 可以显示地将引用赋值为null，JVM就会在合适的时间回收该对象。
        String name = "h_name";
        HardReferenceExample hdr = new HardReferenceExample(name);
        System.out.println(hdr.getName());
        hdr = null;
        for(int i=0;i<10;i++){
            System.out.println(i);
            System.out.println("---------");
        }
        // 软引用
        //软引用在java中有个专门的SoftReference类型，软引用的意思是只有在内存不足的情况下，被引用的对象才会被回收。
        //先看下SoftReference的定义：
        //public class SoftReference<T> extends Reference<T>
        // 如果一个对象具有软引用，内存空间足够，垃圾回收器就不会回收它；
        // 如果内存空间不足了，
        // 垃圾收集线程会在虚拟机抛出OutOfMemoryError之前回收软可及对象，
        // 而且虚拟机会尽可能优先回收长时间闲置不用的软可及对象，
        // 对那些刚刚构建的或刚刚使用过的“新”软可反对象会被虚拟机尽可能保留
        // （软引用有两个特殊的变量：clock——记录上一次GC的时间；
        // timestamp——记录该变量上一次get的时间。
        // 这两个变量之差表示这个软引用对象距离上次GC时一直没被使用的时间，
        // 当这个差值大于阈值_max_interval
        // （该阈值由上一次GC后剩余可用空间计算得出，空间越大，该阈值越大）时，
        // 则该对象标记为可废弃的，将在下一次GC时回收）。
        // 只要垃圾回收器没有回收它，该对象就可以被程序使用。
        // 软引用可用来实现内存敏感的高速缓存,比如网页缓存、图片缓存等。
        // 使用软引用能防止内存泄露，增强程序的健壮性。
        // 软引用示例如下

    }
}
