package java_se.string_method_example;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println(sb);
        sb.append(" World");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.insert(3,"java");
        System.out.println(sb);
        sb.deleteCharAt(2);
        System.out.println(sb);
        sb.delete(3,8);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        //返回容量
        System.out.println(sb.capacity());
        sb.trimToSize();
        System.out.println(sb.capacity());
        /*
            1	int capacity()
            返回当前容量。
            2	char charAt(int index)
            返回此序列中指定索引处的 char 值。
            3	void ensureCapacity(int minimumCapacity)
            确保容量至少等于指定的最小值。
            4	void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
            将字符从此序列复制到目标字符数组 dst。
            5	int indexOf(String str)
            返回第一次出现的指定子字符串在该字符串中的索引。
            6	int indexOf(String str, int fromIndex)
            从指定的索引处开始，返回第一次出现的指定子字符串在该字符串中的索引。
            7	int lastIndexOf(String str)
            返回最右边出现的指定子字符串在此字符串中的索引。
            8	int lastIndexOf(String str, int fromIndex)
            返回 String 对象中子字符串最后出现的位置。
            9	int length()
             返回长度（字符数）。
            10	void setCharAt(int index, char ch)
            将给定索引处的字符设置为 ch。
            11	void setLength(int newLength)
            设置字符序列的长度。
            12	CharSequence subSequence(int start, int end)
            返回一个新的字符序列，该字符序列是此序列的子序列。
            13	String substring(int start)
            返回一个新的 String，它包含此字符序列当前所包含的字符子序列。
            14	String substring(int start, int end)
            返回一个新的 String，它包含此序列当前所包含的字符子序列。
            15	String toString()
            返回此序列中数据的字符串表示形式。
         */
    }
}
