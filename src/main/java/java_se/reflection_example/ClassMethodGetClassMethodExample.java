package java_se.reflection_example;

import java.lang.reflect.Method;

public class ClassMethodGetClassMethodExample {
    /*
    我们已经能通过Class实例获取所有Field对象，同样的，可以通过Class实例获取所有Method信息。
    Class类提供了以下几个方法来获取Method：
    Method getMethod(name, Class...)：获取某个public的Method（包括父类）
    Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
    Method[] getMethods()：获取所有public的Method（包括父类）
    Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
    我们来看一下示例代码：
     */

    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
        /*
        当我们获取到一个Method对象时，就可以对它进行调用。我们以下面的代码为例：

String s = "Hello world";
String r = s.substring(6); // "world"
如果用反射来调用substring方法，需要以下代码：
         */
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 6);
        // 打印调用结果:
        System.out.println(r); // "world"
        /*
        调用静态方法
如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，
所以invoke方法传入的第一个参数永远为null。我们以Integer.parseInt(String)为例：
         */
        // 获取Integer.parseInt(String)方法，参数为String:
        Method ms = Integer.class.getMethod("parseInt", String.class);
        // 调用该静态方法并获取结果:
        Integer n = (Integer) ms.invoke(null, "12345");
        // 打印调用结果:
        System.out.println(n);
        /*
        调用非public方法
和Field类似，对于非public方法，
我们虽然可以通过Class.getDeclaredMethod()获取该方法实例，
但直接对其调用将得到一个IllegalAccessException。为了调用非public方法，
我们通过Method.setAccessible(true)允许其调用：
         */
        People p = new People();
        Method maa = p.getClass().getDeclaredMethod("setName", String.class);
        maa.setAccessible(true);
        maa.invoke(p, "Bob");
        System.out.println(p.name);
        /*
        此外，setAccessible(true)可能会失败。如果JVM运行期存在SecurityManager，
        那么它会根据规则进行检查，有可能阻止setAccessible(true)。例如，
        某个SecurityManager可能不允许对java和javax开头的package的类调用setAccessible(true)，
        这样可以保证JVM核心库的安全。

         */
    }

}
class People {
    String name;
    private void setName(String name) {
        this.name = name;
    }
}