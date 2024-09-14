package java_se.reference_type;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
//https://www.ikaros.love/?p=457
// 软引用的特点
//内存回收: 软引用对象的回收是基于 JVM 的内存需求。
// 当系统内存不足时，垃圾回收器会优先回收软引用指向的对象。
// 即，如果 JVM 发现内存紧张，它会回收所有软引用对象，
// 但在内存充足时，这些对象不会被回收。
//
//用途: 软引用常用于实现缓存。比如，你可以用软引用来缓存图片、
// 文件等，这样在内存不足时，JVM 会自动清除这些缓存对象，从而释放内存。
//
//4. 构造函数
//SoftReference 提供了几个构造函数：
//
//SoftReference(T referent): 创建一个新的软引用，指向给定的对象。
//SoftReference(T referent, ReferenceQueue<? super T> queue):
// 创建一个新的软引用，指向给定的对象，并将其与指定的 ReferenceQueue
// 关联。
//5. 方法
//SoftReference 类继承了 Reference 类的方法，其中最重要的是：
//
//get(): 返回被软引用引用的对象。如果对象已被垃圾回收，则返回 null。
//enqueue(): 将软引用放入与之关联的 ReferenceQueue 中（如果有的话）。
public class SoftReferenceExample {
    public static void main(String[] args) {
        Map<String, SoftReference<byte[]>> cache = new HashMap<>();

        // 将大对象缓存到软引用中
        byte[] largeArray = new byte[1024 * 1024 * 10]; // 10MB
        SoftReference<byte[]> softRef = new SoftReference<>(largeArray);
        cache.put("largeArray", softRef);

        // 尝试从缓存中获取对象
        SoftReference<byte[]> ref = cache.get("largeArray");
        byte[] retrievedArray = (ref != null) ? ref.get() : null;

        if (retrievedArray != null) {
            System.out.println("Object is still available in cache.");
        } else {
            System.out.println("Object has been garbage collected.");
        }
    }
}
