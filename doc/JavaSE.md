p'pJavaSE

Java发布于1995年5月23日，Java之父是高斯林，Java前身语言是Oak语言，衍生自C++，Java是Sun公司，2009年被Oracle公司收购，现属于Oracle公司的产品

最初版本 1995年1.0版本

被Oracle收购后的第一个版本是7

新的举措：每半年发布一个版本

### Java语言的特点

1.面向对象

2.跨平台

3.多线程

4.健壮性

### Java平台的组成部分

JVM：Java虚拟机，使Java程序跨平台

JRE：Java运行环境，包含JVM，运行Java程序的最小单位

JDK：Java开发工具包，包含JRE，开发Java程序的最小单位

### 第一个Java程序

创建项目：File → New (Other) → Java Project → Project Name → Finish

创建包：在src上右键 → new → Package → Name → Finish

创建类：在包上右键 → new → Class → Name → Finish

**注释：**

// 单行注释

/* */ 多行注释

/** */ 文档注释

输出语句：

1.不换行输出：System.out.print();

2.换行输出：System.out.println();

### 转义字符

双引号：\"

单引号：\'

反斜线：\ \

制表符 ：\t(Tab键，适合不对齐的输出)

换行：\n	

### JAVA和JAVAC命令的作用

JAVAC：作用是将.java文件编译生成.class字节码文件

JAVA：作用将.class字节码文件解释并执行

### 数据类型

1.基本数据类型：

整数类型：

byte 		字节型		1个字节	 8位		  范围：-128~127

short		短整型		2个字节	 16位		 范围：-32768~32767

int		  整型		  4个字节	 32位		 范围：约正负21亿

long		 长整型		8个字节	  64位		范围：约正负92亿亿      后缀：L 或 l

浮点类型：

float		单精度		4个字节		32位        后缀：F 或 f

double       双精度		8个字节		64位		后缀：D 或 d

字符类型：

char         字符型		2个字节		16位		范围：0~65535（\u0000~\uFFFF）

布尔类型：

boolean      布尔型		1个			8位			值：true false

2.引用数据类型

类类型（class）

​	字符串（String）：多个字符组成了字符串，用双引号表示  如"高斯林"

数组类型（array）

接口类型（interface）

枚举类型（enum）

注解类型（annotation）

### 变量

程序中可以变量的量

1.变量的三大要素：数据类型 变量名 变量值

2.声明变量并赋值：数据类型 变量名 = 值;

3.声明多个同一类型的变量：数据类型 变量名1, 变量名2...

标识符强制规范：

1.可以由字母，数字，下划线，$ 组成

2.不能以数字开头

3.字母区分大小写

4.不能使用关键字，字面量，保留字（goto const）

5.在同一作用域下不能重名

### 控制台输入 

Scanner是用来输入的  首先定义Scanner

Scanner sc = new Scanner(System.in);

导入Scanner

1.在package下面  写上import java.util.Scanner;

2.将鼠标放在Scanner上，根据提示，选择...

3.将光标放在Scanner后面，按Alt+/(?)

4.使用快捷键：按Ctrl+shift+o 会自动导入所有所须的类

一般语法：sc.next类型()  ：类型要求首字母大写

输入double类型：sc.nextDouble();

输入int类型：sc.nextInt();

输入字符串：sc.next();

注意：没有char类型的输入

### 类型转换

1.自动类型转换（隐式类型转换）：范围小的类型转到范围大的类型

2.强制类型转换（显式类型转换）：范围大的类型转到范围小的类型

强制类型转换可能会出现溢出（精度丢失）

3.在八大基本类型中，除了boolean之外的七种3类型都可以互相转换

范围：byte<short [char] < int < long < float < double

**字符串转基本类型**

1.一般语法：数据类型.parse数据类型(字符串)   数据类型首字母大写

double score = Double.parseDouble(strScore);

2.注意：对于字符串转int类型：Integer.parseInt(字符串)   例： int port = Integer.parseInt(strPort);

3.对于字符串转不二类型：如果字符串是true（不区分大小写），则结果就是true，否则就是false

4.没有转成char类型的方法

**基本类型转字符串**：""+基本类型变量   或者  String.valueOf(基本类型变量)

### 运算符

**算术运算符：+ - * / % ++ --** 

1.两个整数相除的结果是整数（即整除），若想得到小数，需要将其中一个强制类型转换成浮点数

利用整除可以去掉整数的最后一位：整数/10

2.浮点类型的计算不一定精准（加减乘除取余）

3.负数取余数，以第一个数的正负为准，若第一个数是正数，则结果为正，若第一个数是负数，则结果为负

  判断奇偶：整数%2 若结果是0则是偶数  若结果是非0则是奇数

  获取整数的最后一位：整数 % 10

  判断整数：整数 % 1  若结果是0则是整数，若结果非0则是浮点数

4.两种类型进行计算的结果

1)都是整数类型：若有long类型参与，则结果为long类型，否则为int类型

2)若有浮点类型参与，如果有double类型参与，则结果为double，否则为float类型

5.除了boolean之外的七种类型，都可以进行算术运算

6.++ --

++：自加1  --：自减1

++a：先加后用

a++：先用后加

习题：

```Java
		int i = 1;
		//int c = i++ + ++i;
		int a = i++;//a=1  i=2
		int b = ++i;//b=3  i=3
		int c = a+b;//4
		System.out.println(i);
		System.out.println(c);
```

注意：

```Java
		int x = 1;
		x = x++;
		x = x++;
		x = x++;
		x = x++;
		//...
		System.out.println(x);//1  值永远不变
```

**赋值运算符**

简单赋值运算符：=

复合赋值运算符：+=  -=  *=  /=  %=

short a = 1;

a+=2;//a=3

a+=2与a=a+2并不完全一样，a+=2里边自动进行强转，结果是+=左边的类型，相当于a = (short)(a+2);，

**关系运算符**

```
>, >=, <, <=，==，!=    结果为布尔类型
```

**逻辑运算符**

与  或  非

与：并且  如果两个条件同时为true，则结果为true

&&：短路与，如果第一个条件为false，则不会判断后面的条件

&：非短路与，即使第一个条件为false，也会判断后面的条件

或：或者  如果有一个条件为true，则结果为true

||：短路或，如果第一个条件为true，则不会判断后面的条件

|：非短路或，即使第一个条件为true，也会判断后面的条件

非：取反  !   

**条件运算符**

? :

布尔类型表达式 ? 结果为true则执行此部分 : 否则执行此部分

嵌套条件运算符：在问号或者冒号部分还有条件运算符

**按操作数划分**

一元运算符（单目运算符）：只有一个操作数：a++   -1

二元运算符（双目运算符）：有两个操作数：a+b

三元运算符（三目运算符）：有三个操作数  即：? ：

### 快捷键

万能键：alt+/(?)    main=>主方法

复制：ctrl+c

粘贴：ctrl+v

剪切：ctrl+x

撤回：ctrl+z

删除一行：ctrl+d

保存：ctrl+s

单行注释：ctrl+/(?)

多行注释：ctrl+shift+/(?)

复制一行：ctrl+alt+下

挪到下一行：alt+下

挪到上一行：alt+上

变成大写：ctrl+shift+x

变成小写；ctrl+shiff+y

### 流程控制语句

1.顺序执行		2.分支     3.循环

### 分支语句

【if】  【switch】

一、单分支

if(条件){

​	//如果条件为true，则执行此部分代码

}

二、双分支

if(条件){

​	//如果条件成立，则执行此部分代码

}else{

​	//否则执行此部分代码

}

三、多分支

if(条件1){

​	// 如果条件1为true，则执行此部分代码，不会判断下面的条件

}else if(条件2){

​	// 如果条件2为true，则执行此部分代码，不会判断下面的条件

}else{

​	//如果以上条件都不满足，则执行此部分

}

switch(变量){

​	case 值1:

​		//如果变量和值1相等，则执行此部分代码

​		break;

​	...

​	default:

​		//如果变量和以上值都不相等，则执行此部分代码

​		break;

}

注意：


1.case贯穿：如果没有break，会继续执行，直到遇到一个break或者程序结束才完事

2.case后面是一个具体的值，不能变量，也不能是多个值，也不能表示范围 

3.case的值不能重复 

4.default可以是任意位置

5.switch支持的6种类型：byte short int char String(Java 7) 枚举(Java 5)

### 循环

1.while		2.for循环		3.do-while      	4.新型for循环

【while循环语法】

1.初始变量

while(2.循环条件){

​	3.循环体

​	4.迭代因子

}

执行顺序：1234   234   234...

【for循环语法】

for(1.初始变量;2.循环条件;4.迭代因子){

​	3.循环体

}

执行顺序：1234  234  234...

【do-while循环条件】

1.初始变量

do{

​	3.循环体

​	4.迭代因子

}while(2.循环条件)；

执行顺序：1342  342  342...

特点：至少执行一次

【循环控制】

break：终止整个循环0

continue：终止本次循环，还会执行下次循环

### 随机数

Math.random() 生成0~1之间的随机小数

 [0,10)：(int)(Math.random()*10) 

产生随机数：[min,max) (int)(Math.random()*(max-min))+min

定义Random类：Random rand = new Random();

rand.nextInt(num) 生成0~num之间的随机整数 [0,num) 

随机生成[min,max)=> rand.nextInt(max-min)+min

```Java
// 随机生成字母（不区分大小写）或者数字（0~9）
int num = (int) (Math.random() * 62);
if (num < 10) {// [0,9]
    System.out.println(num);
} else if (num < 36) {// [10,35]
    System.out.println((char) (num - 10 + 'a'));
} else {// [36,61]
    System.out.println((char) (num - 36 + 'A'));
}
```

### 数组

1.声明数组：数据类型[] 数组名;

​					  数据类型  数组名[];  不推荐

2.实例化数组：数组名 = new 数据类型[长度]

3.使用数组：为元素赋值：数组名[索引] = 值; 最大索引比长度小1

​					   获取元素值：数组名[索引]

4.数组长度：数组名.length

5.遍历数组

```Java
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]);
		}
		
		System.out.println("========");
		/*
		 * 	新型for循环，增强for循环，foreach循环，for冒号循环，迭代循环
		 *  for(元素的数据类型  变量 : 数组名){
		 * 	   //每次循环 ，变量的值，就是数组中的每个元素值
		 *  }
		 */
		for(int score : scores) {
			System.out.println(score);
		}
```

6.数组默认值

数组的默认值

整数类型：0

byte：(byte)0

short：(short)0

int :0

long:0L

浮点类型：0.0

float：0.0F

double：0.0

字符类型：char   0

布尔类型：false

字符串类型：null

7.数组初始化

数组初始化：1.数据类型[] 数组名 = new 数据类型[]{值1,值2,...};

​						2.数据类型[] 数组名 = {值1,值2,...};  此方式只能在声明数组时使用

ArrayIndexOutOfBoundsException：数组下标越界异常

8.冒泡排序

```Java
	public static void main(String[] args) {
		int[] arr = { 25, 16, 7, 51, 65, 78, 91, 1 };// 8个数
		for (int i = 0; i < 7; i++) {
			for(int j=0;j<7-i;j++) {
				//升序
				if(arr[j] > arr[j+1]) {
					// 交换
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
```

数组排序：Arrays.sort(数组 名)；默认是正序排序

数组转字符串：Arrays.toString(数组名);

数组扩容/缩容：Arrays.copyOf(数组名, 新长度);

比较两个数组是否相等：Arrays.equals(数组1, 数组2);

数组克隆：数组名.clone()；    或者   Arrays.copyOf(数组名, 原长度);

**二维锯齿数据**

数据类型[] [] 数组名  = new 数据类型[长度] [长度]

int[] [] nums = new int[2] [3]

nums是一个数组  里面有2个元素，长度是2

nums[0]也是一个数组  里面有3个元素，长度是3

nums[1]也是一个数组 里面有3个元素，长度是3

```Java
//		int[][] nums = new int[2][3];
//		//第一行
//		nums[0][0] = 1;
//		nums[0][1] = 2;
//		nums[0][2] = 3;
//		//第二行
//		nums[1][0] = 4;
//		nums[1][1] = 5;
//		nums[1][2] = 6;
//		System.out.println(nums.length);//2
//		System.out.println(nums[0].length);//3
//		System.out.println(nums[1].length);//3
		
		int[][] nums = new int[2][];
		nums[0] = new int[] {1,2};
		nums[1] = new int[] {7,8,9};
		
		/*
		 * 1 2 3
		 * 4 5 6
		 */
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
```

### 面向对象

面向对象：是模型化的，注重的是对象与对象之间的协作，不必去一步一步的实现

优点：易维护，易复用，易扩展，，由于面向对象有封装，继承，多态的特性，可以设计出低耦合的系统，使系统更加灵活，更加易于维护

类：是一种抽象的表示，可以把具有相同特征的事物归为一类  例如：人类   车类   电脑类

对象：类别中具体的一个事物

对象的成员

1.属性：指对象的特征

2.方法：指对象的动作（行为）

#### 定义类

定义类

访问修饰符  class 类名{

}

#### 定义方法

访问修饰符 返回值类型 方法名(参数列表){

​	方法体

}

**方法参数**：方法中需要数据，但是它本身没有，需要从外部传入时，就要定义参数

形参：形式参数  在方法定义时写的参数

实参：实际参数 在方法调用时传入的参数

**返回值**：外部需要方法内部数据时

1.在定义方法时，需要指定返回值的类型

2.在方法体中，使用return关键字，返回一个具体的值

#### 方法重载

方法重载：方法名相同，参数 列表不同（参数个数不同，参数类型不同）

方法签名：方法名+参数列表

#### 可变长参数/不定长参数

数据类型...  变量名   必须是最后一个参数

#### 成员变量

默认值：整数类型：0	

​				浮点类型：0.0

​				字符类型：0

​				布尔类型：false

​				类类型：null

成员变量可以在本类方法中使用

成员变量和局部变量的区别

1.作用域不同：局部变量的作用域仅局限于定义他的方法

成员变量的作用域在整个类内部是可见的，还可以在外部访问 到

2.初始值不同：Java会给成员变量一个初始值

Java不会给局部变量一个初始值

注意：在同一个方法中，不允许有同名局部变量

在不同的方法中，可以有同名局部变量

两类变量同名时，局部变量具有更高的优先级

#### 面向对象三大特征

封装   继承   多态

#### 封装

将信息隐藏起来，提高安全性

1.定义一个方法是一种封装

2.成员变量或者方法用private修饰是一种封装

属性组成部分：属性变量和属性访问器 

属性变量：用于表示属性的成员变量

属性访问器：setter和getter

只读属性：只有getter没有setter

```Java
	//赋值方法 setter set访问器
	public void setName(String name) {
		this.name = name;
	}
	
	// 取值方法 getter get访问器
	public String getName() {
		return name;
	}
```

#### 构造器（构造方法）

没有返回值 类型   名称和类名相同

构造方法是在实例化对象时自动调用

默认构造方法：

1.如果不创建构造方法，也有一个默认的构造方法

2.默认构造方法没有参数  

3.如果创建了有参构造方法，则默认构造方法消失

在构造器中调用本类其他构造器：this(参数);  必须写在构造器的第一行代码上

#### 静态方法（类方法）

静态方法（类方法）：是属于类的  不属于对象  使用类调用

static：静态的，在类加载的时候执行

static：可以修饰属性，该属性不属于某个对象，而是属于整个类，在使用时用类名.属性名调用

static：修饰方法，该方法不属于某个对象，而是属于整个类，在使用时用类名.方法名调用

静态方法不能调用成员方法，也不用使用成员变量

静态方法不能使用this

成员方法可以调用静态方法，也可以使用静态变量

**静态块  静态代码块**

static{

}

在第一次使用类时自动调用，而且只调用一次

静态块的执行要优先于主方法的执行

多个静态代码块按照定义顺序执行

**静态块和静态方法的区别：**

1.静态块是自动调用，静态方法手动调用

2.静态块只能调用一次，静态方法可以调用多次

3.静态块没有访问修饰符，返回值类型，名称，参数，静态方法有

**动态块：**{}   实例化对象时自动调用

动态块是优先于构造方法执行，且执行次数与创建对象有关，多个动态块按照定义顺序执行

#### JVM内存

栈

栈帧：JVM为每一个方法都定义了一个栈帧，栈帧中存放局部变量，地址

堆：实例化出来的对象，成员变量

#### 继承（泛化）

减少代码冗余，实现代码重用性

访问修饰符 class 子类 extends 父类{

}

子类又叫派生类

父类又叫基类，超类

1.子类可以继承父类非私有成员（同包）

2.构造方法不能继承

3.类与类之间是单继承

4.Object类是所有的类的基类

**继承中的构造器**

1.先调用父类构造器，再调用子类构造器

2.子类默认调用父类的无参构造器

3.构造器不能继承

4.子类调用父类构造器：super(参数)  super()必须写在构造器的第一行代码上

5.如果父类没有无参构造器，则子类必须手动调用父类的其他构造器

super：父类的

super.属性：父类的属性

super.方法(参数)：父类 的方法

super(参数)：父类的构造方法，必须放在第一行

this：本类对象

this.属性：当前对象的属性

this.方法()：当前对象的方法

this(参数列表)：当前构造方法，必须徐放在第一行

#### 访问修饰符

|                     | 本类 | 本包其他类 | 其他包子类 | 其他包 |
| ------------------- | ---- | ---------- | ---------- | ------ |
| public（公有的）    | √    | √          | √          | √      |
| protected（保护的） | √    | √          | √          |        |
| 默认的              | √    | √          |            |        |
| private（私有的）   | √    |            |            |        |

#### 重写

重写：子类重新写父类的方法

一大两小两相同

两相同：方法名相同，参数列表相同

一大：访问修饰符要大于等于父类的

两小：1.返回值类型要小于等于父类的（类类型）

​				如果是基本类型和void必须保持一致

​            2.抛出异常的类型要小于等于父类的，如果父类没有，则子类不可以写

**不能重写的方法：**

 1.构造器不能重写

 2.私有方法不能重写

 3.静态方法不能重写

 4.final修饰的方法不能重写

| 重载与重写 | 重写（override）                                             | 重载（overload）                     |
| ---------- | ------------------------------------------------------------ | ------------------------------------ |
| 作用域     | 子重写父的                                                   | 是同一作用域（重载自己，子重载父的） |
| 方法名     | 必须一致                                                     | 必须一致                             |
| 参数列表   | 必须一致                                                     | 必须不一致                           |
| 访问修饰符 | 子大于等于父的                                               | 无所谓                               |
| 返回值类型 | 返回值类型要小于等于父类的（类类型）<br/>如果是基本类型和void必须保持一致 | 无所谓                               |
| 异常       | 抛出异常的类型要小于等于父类的                               | 无所谓                               |
| 次数       | 一次                                                         | 多次                                 |

#### 多态

同一种行为，产生不同的结果

满足多态的条件：继承 重写 向上造型

**面向对象三大特征**：封装 继承 多态

**面向对象四大特征**：封装 继承 多态 抽象

#### instanceof

判断左边的对象是否属于右边类的实例，结果是boolean类型，是返回true  不是返回false

#### 抽象

抽象类：类上用abstract修饰

抽象方法：方法上用abstract修饰，没有方法体

抽象类有构造方法，但是不能创建对象

抽象类可以有抽象方法，也可以有非抽象方法

抽象方法要求写在抽象类里

如果子类不是抽象类，则必须实现父类的抽象方法

如果子类也是抽象类，则可以不是想父类的抽象方法

private 与 abstract 不能连用

final 与 abstract 不能连用

#### final能修饰什么

1.修饰类，不能被继承

2.修饰方法，不能被重写

3.修饰变量，不能被重复赋值

   修饰成员变量，可以在定义时赋值，也可以在构造器和动态块中赋值

   修饰局部变量，在使用前赋值即可，但只能赋值一次

   参数上用final修饰，不可以赋值，值是通过方法调用传过来，在方法内部不能改值

### 接口

是一种公共的规范标准，引用数据类型，一系列抽象方法的集合

接口语法

[public]  interface 接口名{}

1.在默认情况下，接口中的方法是公有抽象方法（public abstract）

2.接口不能实例化对象

3.在Java8中，提供了接口的默认方法（default）和静态方法（static）

4.在Java9中，提供了接口的私有方法

5.接口中没有构造器

6.接口中的变量，都是公共静态常量（public static final 修饰）

7.类实现接口的语法：

[public] class 实现类  implements 接口名1, 接口名2,...{

}

8.类即可以继承 父类，又可以实现接口

[public] class 类名 extends 父类 implements 接口1,接口名2,...{

}

9.

类与类是单继承

类与接口是多实现

接口与接口是多继承

10.抽象类和接口的区别

|              | 抽象类               | 接口                                 |
| ------------ | -------------------- | ------------------------------------ |
| 定义关键字   | abstract class       | interface                            |
| 构造方法     | 有                   | 吴                                   |
| 实例化对象   | 不能                 | 不能                                 |
| 普通成员     | 可以                 | 不能有变量，普通方法是jdk1.8之后可以 |
| 与接口的关系 | 多实现【implements】 | 多继承【extends】                    |
| 实现多态效果 | 实现                 | 实现                                 |

### 内部类

静态内部类  动态内部类 局部内部类  匿名内部类

**静态内部类**

[public] class 外部类{

​	访问修饰符  static class 内部类{

​	}

}

```Java
public class Outer {

	private static int n = 1;

	public static class Inner {
		private int n = 2;

		public void show() {
			int n = 3;
			System.out.println(Outer.n + "," + this.n + "," + n);
		}
	}

	public void display() {
		Inner inner = new Inner();
		inner.show();
	}

}
```

在外面访问静态内部类：外部类.内部类 变量 = new 外部类..内部类();

```Java
Outer.Inner inner = new Outer.Inner();
inner.show();
```

**动态内部类**

[public] class 外部类{

​	访问修饰符  class 内部类{

​	}

}

```Java
public class Outer {
	private int n = 1;

	class Inner {
		private int n = 2;

		public void show() {
			int n = 3;
			System.out.println(Outer.this.n + "," + this.n + "," + n);
		}
	}
	
	public void display() {
		Inner inner = new Inner();
		inner.show();
	}

}
```

在外面访问动态内部类：

外部类 变量 = new 外部类();

外部类.内部类 变量 = 外部类变量.new 内部类();

```Java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
inner.show();
```

**局部内部类**

```Java
	public static void main(String[] args) {
		// 局部内部类
		class Inner{
			public void show() {
				System.out.println("hello");
			}
		}
		
		Inner inner = new Inner();
		inner.show();
	}
```

**匿名内部类**

```Java
	public static void main(String[] args) {
		/*
		 * 	匿名内部类：类名 变量名 = new 类名(){};
		 */
		Human h = new Human() {

			@Override
			public void work() {
				System.out.println("工作");
			}
			
		};
		
		h.work();
	}

}
```

**类能用什么访问修饰符修饰？？**

1.对于外部类，只能用public和默认

2.对于内部类：

​	1）如果是静态内部类和动态内部类，四种都可以

​	2）如果是局部内部类和匿名内部类，不可以写

### 常用类

#### 包装类型

包装类型：每一种基本类型，都对应着一个个类，它将基本类型封装到类中，添加了额外的功能，还可以赋值为null

| 基本类型 | 包装类型  | 父类型 |
| -------- | --------- | ------ |
| byte     | Byte      | Number |
| short    | Short     | Number |
| int      | Integer   | Number |
| long     | Long      | Number |
| float    | Float     | Number |
| double   | Double    | Number |
| char     | Character | Object |
| boolean  | Boolean   | Object |

装箱：基本类型转换成包装类型的过程

拆箱：包装类型转换成基本类型的过程

Java 5之前

手动拆装箱

手动装箱：将基本类型写在包装类型的构造器中

手动拆箱：包装类类型变量,xxxValue();

Java 5之后

自动拆装箱

自动装箱：包装类型 变量 = 基本类型值;

自动拆箱：基本类型 变量 = 包装类型变量;

注意：自动装箱赋值时，要求严格对应上类型

如：Long n1 = 10L;

Double n2 = 10.0;

包装类型比较相等要用equals

【整型池】

整型缓存池  整型常量池

范围：-128~127

```Java
Integer num1 = 128;
Integer num2 = 128;
System.out.println(num1.equals(num2));//ture
System.out.println(num1 == num2);//false
System.out.println(num1 >= num2);//true  将两个包装类型变量自动拆箱成基本类型，然后比较基本类型的值
```

类型转换：包装类型.parse类型(字符串)：返回基本类型

​					包装类型.valueOf(字符串)：返回包装类型

```Java
	String str = "10";
	int num = Integer.parseInt(str);
	Integer num2 = Integer.valueOf(num);
	System.out.println(num+10);
	System.out.println(num2+10);
```

MAX_VALUE：最大值

MIN_VALUE：最小值

SIZE：位数

```Java
System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE);
System.out.println(Integer.SIZE);
```

**Double**

```Java
public class DoubleTest {
	
	public static void main(String[] args) {
		/*
		 * NaN:Not a Number
		 * NaN和任何一个数都不相等，包括它自己
		 * 
		 * Double.isNaN(数值)：判断是否是NaN
		 * 
		 * Double.NaN:0.0d / 0.0
		 * 
		 * Double.POSITIVE_INFINITY:1.0 / 0.0
		 * Double.NEGATIVE_INFINITY:-1.0 / 0.0
		 * 
		 */
		double num = 0.0 / 0.0;// NaN Not a Number
		System.out.println(num == num);// false
		System.out.println(Double.isNaN(num));

		System.out.println(Double.NaN);

		// Infinity：正无穷大
		System.out.println(1.0 / 0.0);
		// -Infinity：负无穷大
		System.out.println(-1.0 / 0.0);

		System.out.println(Double.POSITIVE_INFINITY);
		double a = Double.NEGATIVE_INFINITY;
		System.out.println(a + 10);
	}

}
```

**Character**

```Java
public class CharacterTest {

	public static void main(String[] args) {
		char c = '\n';
		// 判断是否是整数
		System.out.println(c >= '0' && c <= '9');
		System.out.println(Character.isDigit(c));
		// 判断是否是小写字母
		System.out.println(c >= 'a' && c <= 'z');
		System.out.println(Character.isLowerCase(c));
		// 判断是否是大写字母
		System.out.println(c >= 'A' && c <= 'Z');
		System.out.println(Character.isUpperCase(c));
		// 判断是否是字母
		System.out.println((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
		System.out.println(Character.isLetter(c));
		// 判断是否是字母或者数字
		System.out.println((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
		System.out.println(Character.isLetterOrDigit(c));
		// 判断是否是空白字符(空格 Tab 换行等)
		System.out.println(Character.isWhitespace(c));
	}

}
```

#### String

```Java
	public static void main(String[] args) {
		String str = "abcdefga";
		// 依据索引查找字符   字符串索引从0开始   最大索引比长度小1
		System.out.println(str.charAt(0));
		
		String s1 = "abc";
		String s2 = "ABC";
		
		//字符串比较  正数：第一个数大   负数：第二个数大  0相等
		System.out.println(s1.compareTo(s2));
		//不区分大小写比较
		System.out.println(s1.compareToIgnoreCase(s2));
		
		//判断是否存在
		System.out.println(str.contains("df"));
		
		//判断是否以某子串开头
		System.out.println(str.startsWith("abc"));
		//判断是否以某子串结尾
		System.out.println(str.endsWith("ga"));
		
		//字符串比较相等
		System.out.println(s1.equals(s2));
		//不区分大小写比较相等
		System.out.println(s1.equalsIgnoreCase(s2));
		
		//将字符粗转成字节数组
		byte[] arr = str.getBytes();
		System.out.println(Arrays.toString(arr));
		
		//String str = "abcdefga";
		//依据元素查找字符 从左往右找第一个    找不到-1
		System.out.println(str.indexOf("ad"));
		//依据元素查找字符 从左往右找最后一个
		System.out.println(str.lastIndexOf("a"));
		
		//判断是否是空串
		System.out.println(str.isEmpty());
		System.out.println(str.length() == 0);
		//字符串替换
		System.out.println(str.replace("a", "q"));
		
		//字符串分割  返回值是字符串数组
		String strArr = "tom,amy,john";
		String[] sArr = strArr.split(",");
		System.out.println(Arrays.toString(sArr));
		
		/*
		 * 	截取子串：substring(开始位置，结束位置)   不包含结束位置   含头不含尾
		 *  substring(开始位置)：从开始位置截取到最后 
		 */
		String str3 = "abcdefg";
		System.out.println(str3.substring(1));
		System.out.println(str3.substring(1, 3));
 
		// toUpperCase转成大写   toLowerCase转成小写
		System.out.println(str3.toUpperCase());

		String s = "    abc  ";
		// 去掉左右两边空格
		s = s.trim();
		System.out.println(s.length());
	}
```

字符串常量池：程序中直接写上双引号的字符串，就在常量池中

对于基本类型来说：==是进行数值的比较

对于引用类型来说，==是进行地址值的比较

**地址相同的情况：**

情况1：

String str1 = "abc";

String str2 = "abc";

情况2：

String str1 = "abc";

String str2 = "ab"+"c";

**地址不相同的情况**：

情况1：

String str1 = "abc";

String s = "c";

String str2 = "ab"+s;

情况2：

String str1 = new String("abc");

String str2 = new String("abc");

情况3：

Scanner sc = new Scanner(System.in);

String str1 = sc.next();

String str2 = new String("abc");

**StringBuilder，StringBuffer**

专门用来字符串拼接，拼接时不生产新的对象，拼接速度快

String StringBuilder StringBuffer的区别

1.String是常量，值不能改变  拼接字符串时生成新的对象，拼接速度慢

   StringBuilder，StringBuffer是动态拼接，拼接时不生成新的对象，拼接速度快

2.StringBuilder，StringBuffer提供了更多的方法，如插入删除等

3.StringBuilder 是线程不安全的，拼接速度稍快

   StringBuffer 是线程安全的，拼接速度稍慢

```Java
		StringBuilder s = new StringBuilder();
		// 添加字符串
		s.append("ab");
		s.append("Hello");
		System.out.println(s);
		// 插入字符串
		s.insert(1, "q");
		System.out.println(s);
		// 删除字符串 含头不含尾
		s.delete(1, 4);
		System.out.println(s);

		// 转成字符串
		System.out.println(s.toString());

		StringBuilder ss = new StringBuilder("acde");
		System.out.println(ss);
		System.out.println(ss.reverse());
```

#### 正则表达式

Java是从Java 1.4开始支持的正则表达式，正则表达式，简写为regex，regexp，regxp等

是用于匹配、查找、替换文本等操作的表达式

正则表达式中包含普通字符和元字符，元字符就是一类特殊字符，有具体的含义：

 ^、$：开始和结束

 [abc]：匹配abc中任意字符

 [ ^abc]：除了abc的任意字符

 [a-z]：a到z之间的字符

 [a-zA-Z0-9]：a到z、A到Z、0到9之间的任意字符

 \d  ：数字字符，等效于[0-9]

 \w ：单词字符，等效于[ a-zA-Z0-9_ ]

 \s  ：空白字符，如空格，制表符，换行，回车等。

 \D ：非数字字符

 \W：非单词字符

 \S ：非空白字符

?：0到1个

*：0到多个

+：1到多个

 .：任意字符

 |：或者

 \：转译

 X{n}：n个X

 X{n,}：n到多个X

 X{n,m}：n到m个X

 ^：非

 ()：分组

```Java
	public static void main(String[] args) {
		String str = "中国";
		// 验证是否是整数
//		boolean ok = str.matches("^\\d+$");
//		System.out.println(ok);
		
		// 验证是否是小数  12.12
//		boolean ok = str.matches("^\\d+\\.\\d+$");
//		System.out.println(ok);
		
		// 验证两位小数
//		boolean ok = str.matches("^\\d+\\.\\d{2}$");
//		System.out.println(ok);
		
		// 验证整数或者小数
		//boolean ok = str.matches("^(\\d+)|(\\d+\\.\\d+)$");
//		boolean ok = str.matches("^\\d+(\\.\\d+)?$");
//		System.out.println(ok);
		
		//验证大多数汉字：\u4E00  \u9FA5
		boolean ok = str.matches("^[\u4E00-\u9FA5]+$");
		System.out.println(ok);
		
	}
```

```Java
	public static void main(String[] args) {
		String str = "abc123dfa456sdf";
		// str = str.replace("123", "-");
		str = str.replaceAll("\\d+", "-");
		System.out.println(str);
		
		
		String str2 = "Java.Python.PHP";
		String[] ss = str2.split("\\.");
		System.out.println(Arrays.toString(ss));
	}
```

```Java
	public static void main(String[] args) {
//		String str = "Java123Python456";
//		// 模式对象，设置正则表达式
//		Pattern p = Pattern.compile("[a-zA-Z]+");
//		// 匹配对象，匹配字符串
//		Matcher m = p.matcher(str);
//		// 判断有没有找到匹配上的字符串
//		while (m.find()) {
//			// 匹配上的字符串
//			System.out.println(m.group());
//		}
		
		/*
		 * name		tom
		 * salary	18000
		 */
		String str = "nam@e=to%m@;salary=18000;";
		Pattern p = Pattern.compile("([^=]+)=([^;]+);");
		Matcher m = p.matcher(str);
		while(m.find()) {
			// m.group(组索引)，从1开始
			System.out.println(m.group(1)+"\t"+m.group(2));
		}
	}
```

#### Object

Object是所有类的父类，又叫顶级父类，万类之源

如果一个类没有指定父类，也默认继承了Object    类名 extends Object

除了Object之外，剩下的所有类都有父类

Object中有一些方法，有的时候我们需要重写

如：toString()，默认是返回类全名@哈希值

​	一般用作返回类中信息（成员变量的值），所以需要重写

对于print或println，如果传入类类型变量 就是调用了toString方法

```Java
System.out.println(emp);
```

equals()，equals方法是Object中的方法，默认是比较地址相等（==）

但是官方建议重写euqals()，用于比较值相等

比如String，在String类中定义的equals能够比较值相等，是因为String中重写了equals

#### Math

```Java
	public static void main(String[] args) {
		// 最大值
		System.out.println(Math.max(1, 2));
		// 最小值
		System.out.println(Math.min(1, 2));
		// 四舍五入
		System.out.println(Math.round(4.5));
		// 向上取整
		System.out.println(Math.ceil(4.1));
		// 向下取整
		System.out.println(Math.floor(-4.9));
		// 求幂
		System.out.println(Math.pow(10, 2));
		// 开平方
		System.out.println(Math.sqrt(16));
		// 开立方
		System.out.println(Math.cbrt(27));
		// 绝对值
		System.out.println(Math.abs(-8.5));
		// Π
		System.out.println(Math.PI);

		//随机数
		System.out.println(Math.random());
	}
```

#### Date

```Java
	public static void main(String[] args) {
		// 调用了System.currentTimeMillis() 系统毫秒数
		Date date = new Date();
		System.out.println(date);
		// 传入系统毫秒数
		Date date2 = new Date(1234567899989L);
		System.out.println(date2);// 2009

		// 获取系统毫秒数
		System.out.println(date.getTime());
		// 设置系统毫秒数
		// date.setTime(1234567899989L);
		System.out.println(date);// 2024

		// 日期比较 返回值 正数第一个日期大 负数第二个日期大 0相同
		System.out.println(date.compareTo(date2));

		// 判断日期是否是另一个日期之后
		System.out.println(date.after(date2));
		// 判断日期是否是另一个日期之前
		System.out.println(date.before(date2));

	}
```

SimpleDateFormat  简单日期格式  用来做日期的格式化

格式化字符：

y：年（yyyy，四位及以上     yy：两位年）

M：月（MM  两位月）

d：日（dd 两位日期）

h：12进制小时（hh：两位小时）

H：24进制小时（HH：两位小时）

m：分钟

s：秒

S：毫秒

E：星期

X、Z：时区

a：上午/下午

注意：如果想直接显示字母，需要加上单引号

```Java
		Date date = new Date();
		System.out.println(date);
		//2024-03-06 15:05
		//如果想直接显示字母，需要加上单引号
		SimpleDateFormat fmt = new SimpleDateFormat("yy年MM月dd日  'at' HH:mm:ss");
		//Date对象转格式化字符串
		String str = fmt.format(date);
		System.out.println(str);
		
		String s = "2022-01-03";
		Date date2 = fmt.parse(str,new ParsePosition(0));
		System.out.println(date2);
```

Calendar 日历类  也是一个抽象类，通过本身静态方法或者子类构造方法产生对象，可以将日期字段单独取出，赋值

```Java
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);

//		Calendar cal2 = new GregorianCalendar();
//		System.out.println(cal2);

		// 获取年份
		System.out.println(cal.get(Calendar.YEAR));
		// 获取月份 月份从0开始
		System.out.println(cal.get(Calendar.MONTH) + 1);
		// 获取日期
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));

		// 获取小时（12进制）
		System.out.println(cal.get(Calendar.HOUR));
		// 获取小时（24进制）
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		// 获取分钟
		System.out.println(cal.get(Calendar.MINUTE));
		// 获取秒
		System.out.println(cal.get(Calendar.SECOND));
		// 获取毫秒
		System.out.println(cal.get(Calendar.MILLISECOND));
		// 获取星期 星期是从1开始 星期日是1
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) - 1);

	}
```

```Java
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DATE, 10);
		System.out.println(cal);
		
		// 获取Date对象
		Date date = cal.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(date));
		
		Calendar cal2 = Calendar.getInstance();
		//Date对象转Calendar
		cal2.setTime(date);
		System.out.println(cal2);
		
		// 获取系统毫秒数
		System.out.println(cal2.getTimeInMillis());
		// 设置系统毫秒数
		cal2.setTimeInMillis(1234567891111L);
		System.out.println(cal2);
		
	}
```

add()：添加字段的值

roll()：滚动字段的值

区别：

add：如果超出本字段的范围，会影响上一个字段

roll：如果超出本字段的返回，不会影响上一个字段，会在本字段中循环滚动

getActualMaximum和getMaximum的区别

getActualMaximum跟当前字段的值有光

getMaximum跟当前字段的值无关  只获取本字段的最大值

### 异常

在语法正确的情况下，发生的问题，且程序员可以通过异常类解决的问题

Throwable  是错误与异常的父类

异常是程序员可以解决的问题，错误是程序员无法解决的问题

语法：try-catch

try{

​	可能会出现异常的代码

}catch(异常对象）{

​	捕捉到异常之后执行的代码

}

运行时异常：编写程序和编译程序时不会出现异常，但是运行的时候有可能出现异常

非运行时异常：在编写程序或编译程序时就出现了异常，需要异常处理

常见运行时异常：ArithmeticException:算术异常

​							   NumberFormatException:数字格式异常

​								NullPointerException:空指针异常

​								StringIndexOutOfBoundsException:字符串索引越界异常

​								ArrayIndexOutOfBoundsException:数组索引越界异常

​								ClassCastException:类型转换异常

注意：catch  可以有多个，但是范围必须由小到大

抛异常：throw new 异常对象();

throws 自动抛出  向上一级抛出

throw 手动抛出 自定义异常

try：将有可能发生异常的代码放在try里

catch：通过大于等于本身异常进行捕获

finally：无论是否有异常，都会执行的代码  System.exit(0) 退出程序除外

try可以分别和catch，finally连用，也可以三个一起使用

try，catch里有return，finally也会执行，且在return之前执行

```Java
	public static int method() {
		int[]arr = {1,2,3,4,5};
		int j=9;
		for(int i=0;i<=arr.length;i++) {
			try {
				System.out.println("当前元素："+arr[i]);//当前元素：1
				j++;//j=10
				return j;
			}catch(RuntimeException e) {
				System.out.println("数组下标越界异常："+e.getMessage());
			}finally {
				System.out.println("当前下标是："+i);//当前下标是0
				j++;//j=11
				return j;
			}
		}
		return 3;
	}
```

final，finally，finalize的区别

1.final修饰类不能被继承，修饰方法不可被重写，修饰变量值不能改变

2.finally，在异常处理中，一定能执行的部分   System.exit(0) 退出程序除外

3.finalize，Object中的方法，在销毁对象之前调用，不建议重写

### 设计模式

单例模式：只有一个实例

1.将构造方法私有化

2.设置公共的静态方法返回当前类对象

懒汉模式  使用时才会创建

饿汉模式  使用前就创建好对象

```Java
public class Earth {

	/*
	 * 	单例模式：只有一个实例
	 * 	1.将构造方法私有化
	 * 	2.设置公共的静态方法返回当前类对象
	 */
	// 懒汉模式  使用时才会创建
//	private static Earth earth;
//
//	private Earth() {
//		System.out.println("创建对象");
//	}
//
//	public static Earth getEarth() {
//		if (earth == null) {
//			earth = new Earth();
//		}
//		return earth;
//	}
	
	//饿汉模式  事先创建好对象
	private static Earth earth = new Earth();
	
	private Earth() {
		System.out.println("创建对象");
		
	}
	
	public static Earth getEarth() {
		return earth;
	}

}
```

```Java
	public static void main(String[] args) {

		Earth e1 = Earth.getEarth();
		Earth e2 = Earth.getEarth();
		
		System.out.println(e1==e2);
		
		
	}
```

工厂模式：工厂里有n个管理类，统一由工厂来产生对象

枚举：将可以选择的数据，一一列出，只能选择给你列出的数据

枚举的第一行上必须是枚举项，最后一个枚举项的分号可以省略 

如果后面还有其他内容，分号不能省略

语法：

修饰符 enum 枚举名字{

​	枚举对象，对象与对象用,隔开；

​	[属性

​	构造方法

​	普通方法等

​	]

}

### 泛型

泛型：参数化的类型

泛型：泛型方法  泛型类（泛型接口）

泛型：不支持基本类型，不能实例化对象

Java中的泛型，是Java 5增加的特性

擦除法泛型：Java的泛型是语法层面的，编译之后，泛型类型是Object

在Java 7之前：类名<泛型类型> 变量 = new 类名<Integer>();

在Java 7 及之后的版本：类名<泛型类型> 变量 = new 类名<>();

泛型限定：

```Java
// 泛型限定
public class MyArray2<T extends Number> {

	// 泛型不能实例化对象
	Object[] nums = new Object[0];
	
	public void add(T value) {
		nums = Arrays.copyOf(nums, nums.length+1);
		nums[nums.length-1] = value;
	}

	@Override
	public String toString() {
		return "MyArray2 [nums=" + Arrays.toString(nums) + "]";
	}
	
}
```

### 集合

有可以存重复数据的集合，也有不可以存重复数据的集合，还有可以以存储两种数据类型的键值对

Collection是一个接口，存储单一类型的集合

**List是Collection的子接口，主要存储有序重复数据**

ArrayList是List接口的实现类，是一个线性存储，按照存储的顺序进行存放的，可以存放重复数据以及null值

添加元素：list.add();

插入元素：list.add(索引, 元素)

添加方法：list.addAll(Collection c)

插入方法：list.addAll(int index,  Collection c)

替换方法（修改方法）：list.set(索引，元素)

删除方法（依据索引删除）：list.remove(索引)

删除方法（依据元素删除）：list.remove(元素)   注意：如果泛型类型是Integer，使用remove时，传入元素，会当成索引，所以需要将元素强制类型转换成Integer或Object

依据索引获取元素：list.get(索引)

集合长度：list.size()

清空集合：list.clear()

判断是否有某字串：list.contains()

依据元素查找索引（从前往后）：list.indexOf();

依据元素查找索引（从后往前）：list.lastIndexOf();

判断集合是否为空：isEmpty()

遍历集合方法

```Java
List<Integer> list = new ArrayList<>();
list.add(1433);
list.add(1521);
list.add(3305);
// 普通for循环
for(int i=0;i<list.size();i++){
	System.out.println(list.get(i));
}
// 增强for循环
for(Integer num : list){
	System.out.println(num);
}
// 迭代器
Iterator<Integer> it = list.iterator();
// 判断有没有下一条数据
while(it.hasNext()){
	// 移动到下一条，并获取到数据
	System.out.println(it.next());
}
```

获取子集合（含头不含尾）

实际上是从集合中获取一部分，但是还是同一个集合，一个修改，会影响另一个

如果想互不影响，需要将list.subList()放到集合的构造器中

**Collection 集合工具类**

Collections.addAll(集合, 元素,...)：向集合中添加若干元素

**Collection 和 Collections的区别：**

Collection是集合的总接口，是存储单一类型的集合

Collections是集合工具类，提供操作集合的相关方法

**数组转List**

Arrays.asList(数组)：转成了只读集合

正确做法：将Arrays.asList()放在List实现类的构造器中

语法：List<泛型类型> list = new ArrayList<>(Arrays.asList(数组));

**List转数组**

方法一：类型[] 数组名 = list.toArray(new 类型[0]);

方法二：类型[] 数组名 = new 类型[集合长度];

list.toArray(数组);

**排序**

```Java
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, 3306, 1433, 1521);
		// 正序排序
		Collections.sort(list);
		
		/*
		 * 	正序排序：第一个数减第二个数
		 *	倒序排序：第二个数减第一个数
		 */
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		});

		System.out.println(list);
	
		List<String> list2 = new ArrayList<>();
		Collections.addAll(list2, "d", "a", "c", "b");
		list2.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		System.out.println(list2);
			
	}

```

LinkedList   链表集合

**ArrayList和LinkedList的区别**

ArrayList是用数组实现的，在内存中是连续的，适合遍历和追加

LinkedList是用链表实现的，在内存中不是连续的，适合插入和删除。能够实现队列和栈

**队列：先进先出（FIFO）**

**栈：先进后出（FILO）**

```Java
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		// 添加元素
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		System.out.println(queue);
		// 获取元素(不删除)
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		// 获取元素并删除
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());

		for (Integer num : queue) {
			System.out.println(num);
		}
		System.out.println("-------------------");
		Deque<Integer> stack = new LinkedList<>();
		// 进栈
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack);
		// 出栈
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
```

**Vector 是List接口的实现类 版本比ArrayList早 线程安全的 效率较低**

```Java
public static void main(String[] args) {
		// Vector 是List接口的实现类 版本比ArrayList早 线程安全的 效率较低
		Vector<String> vectors = new Vector<String>();
		vectors.add("aa");
		// 添加
		vectors.addElement("tom");
		System.out.println(vectors);

		// 替换
		vectors.setElementAt("jack", 0);
		System.out.println(vectors);

		// 移除
//		vectors.removeElementAt(0);
//		System.out.println(vectors);
//		
//		vectors.removeAllElements();
//		System.out.println(vectors);

		// 获得第一个元素
		System.out.println(vectors.firstElement());
		System.out.println(vectors.elementAt(0));
		System.out.println(vectors.get(0));

		// 获得最后一个元素
		System.out.println(vectors.lastElement());
		System.out.println(vectors.elementAt(vectors.size() - 1));
		System.out.println(vectors.get(vectors.size() - 1));
	}
```

**Set是Collection的子接口，无序存储，不可重复存储，可以存储null值**

HashSet:无序的

LinkedHashSet:添加的顺序

TreeSet:排序的（默认按照正序排序）

添加元素：add()

依据元素删除：remove(元素)

获取长度：size()

**遍历Set集合**

```Java
// 遍历Set集合
for(String str : phone) {
	System.out.println(str);
}

Iterator<String> s = phone.iterator();
while(s.hasNext()) {
	System.out.println(s.next());
}
```

Set转List   放到List实现类的构造器中

List转Set   放到Set实现类的构造器中

```Java
	public static void main(String[] args) {
		Set<String> phone = new HashSet<>();
		phone.add("13312345688");
		phone.add("13912345688");
		phone.add("13612345688");
		//Set转List   放到List实现类的构造器中
		List<String> list = new ArrayList<>(phone);
		list.add(1,"13612345688");
		System.out.println(list);
		
		//List转Set   放到Set实现类的构造器中
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		
	}
```

排序

```Java
public class SetTest03 {

	public static void main(String[] args) {
		// 倒序排序：将比较器放在TreeSet的构造器
		Set<String> phone = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		phone.add("13312345688");
		phone.add("13912345688");
		phone.add("13612345688");

		System.out.println(phone);

	}

}

```

**Map 以键值对的形式存储，键是不能重复的，值是可以重复的**

HashMap：无序的

LinkendHashMap:添加的顺序

TreeMap：排序的（默认按照键的正序顺序）

添加：put(key, value)

修改：put(key, value)  如果没有这个key就是添加，有就是修改

依据键删除：remove(key)

是否包含某键：containsKey()

集合长度：size()

获取键集合：keySet()

获取值集合：values()

依据键获取值：get(key)

清空集合：clear()

```Java
		// 遍历   通过遍历键集合
		for (String str : map.keySet()) {
			System.out.println(str + "\t" + map.get(str));
		}
		System.out.println("-------------");
		
		/*
		 * 	遍历  通过遍历键值对对象
		 * 	Entry：键值对对象
		 * 	entry.getKey():获取键
		 * 	entry.getValue():获取值
		 */
		//Set<Entry<String, String>> s = map.entrySet();
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
```

倒序排序

```Java
	public static void main(String[] args) {
		// 倒序：将比较器放在TreeMap的构造器中
		Map<String,String> map = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		map.put("name", "高斯林");
		map.put("sex", "男");
		map.put("job", "架构师");
		System.out.println(map);
	}

```

**Properties 属性集合 键值对都是字符串 可以保存到文件中**

Properties prop = new Properties();

添加值：setProperty(key, value);

获取值：getProperty(key);

​			    getProperty(key, 默认值) 如果没有键，就返回默认值

```Java
	public static void main(String[] args) {
		// Properties 属性集合 键值对都是字符串 可以保存到文件中
		Properties prop = new Properties();
		// 添加值
		prop.setProperty("name", "tom");
		prop.setProperty("sex", "男");

		System.out.println(prop);

		// 获取值
		System.out.println(prop.getProperty("sex"));

		// 获取值，如果没有键，就返回默认值
		System.out.println(prop.getProperty("job", "程序员"));
	}
```

### File

File在io包中

```Java
public class FileTest {

	public static void main(String[] args) throws IOException {
		// 获得当前操作系统的分隔符：File.separator    / 
		File file = new File("files"+File.separator+"a.txt");
		if (!file.exists()) {
			System.out.println("文件不存在，即将创建一个新的文件");
			// 创建文件
			file.createNewFile();
		}
		
		// 文件长度
		System.out.println(file.length());
		
		// 文件路径  相对路径
		System.out.println(file.getPath());
		
		// 文件路径  绝对路径
		System.out.println(file.getAbsolutePath());
		
		// 设置最后修改时间
		file.setLastModified(System.currentTimeMillis());
		
		// 获取最后修改时间
		System.out.println(file.lastModified());
		//yyyy-MM-dd
		Date date = new Date(file.lastModified());
		System.out.println(date);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(date));
		
		// 只获取文件名 不包含路径
		System.out.println(file.getName());
		
		
		// 获取父级名称
		System.out.println(file.getParent());
		
		// 设置只读
		file.setReadOnly();
		
		// 设置是否可写
		file.setWritable(true);
		
		// 是否是隐藏文件
		System.out.println(file.isHidden());
		
		// 判断是否是文件
		System.out.println(file.isFile());
		// 判断是否是文件夹（目录）
		System.out.println(file.isDirectory());
		
	}

}

```

```Java
		File file = new File("files/a");
		if(!file.exists()) {
			// 创建文件夹
			file.mkdirs();
		}
		
		// 删除文件夹
		file.delete();
		/*
		 *  File[] listFiles() 获取当前目录下一级所有文件及目录
		 *  
		 * 	文件：a
		 * 	目录；a.txt
		 */
		File[] files = file.listFiles();//File[] [a.txt,b]
		for(File f : files) {
			if(f.isFile()) {
				System.out.print("文件：");
			}else {
				System.out.print("目录：");
			}
			System.out.println(f.getName());
		}
		
		// list()   String[]  获得当前目录下一级所有的文件及目录
		System.out.println("------------");
		String[] fs = file.list();
		for(String f : fs) {
			System.out.println(f);
		}
```

### IO流

程序要向磁盘中写入数据，叫输出

程序要从磁盘中读取数据，叫输入

按照流向：输入流   输出流

按照单位：字节流  字符流（1个字符=2个字节）

流处理的过程：

1.确认操作路径

2.创建流对象

3.读/写

4.关闭

OutputStream是字节输出流的根，是一个抽象类，在使用时使用的是其子类FileOutputStream

FileOutputStream：文件输出流，向文件中写入数据

FileOutputStream构造器参数：

FileOutputStream(String pathName);

FileOutputStream(String pathName, boolean append);

append值代表是否追加（默认不追加，将以前的内容清空，重新写），追加保留以前的内容，在后面写

在写时，操作文件可以是不存在的，输出流会新建一i个与路径一致的文件，操作文件存在，则在该文件操作

fos.write()：向文件中写入数据

fos.write(int c)

fos.write(byte[] b)

fos.write(byte[] b, int offset, int len)     offset开始位置    len写的长度

close()  关闭

```Java
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("f1.txt", true);
		fos.write(97);
		fos.write(98);
		fos.write(99);
		fos.write(100);
		fos.write('\n');
		byte[] bs = { 65, 66, 67, 68, 69 };
		// fos.write(bs);
		fos.write(bs, 1, 3);// 从1的位置开始 3个长度
		
		/*
		 * 	fos.write()：向文件中写入数据
		 * 	字符串.getBytes(编码)：将字符串转换成指定编码格式的字节数组
		 */
		fos.write("Hello world!".getBytes("UTF-8"));

		fos.close();
	}
```

读取：

```java
	public static void main(String[] args) throws IOException {
		// FileInputStream:文件输入流，从文件中读取数据
		FileInputStream fis = new FileInputStream("f1.txt"); 
		
		/*
		 * read() int  读取一个字符  返回值是读取到的内容
		 * read(byte[] bs)  读取一组数据，将数据放在数组中，返回值是读取长度  没有内容长度是-1
		 */
		byte[] bs = new byte[10240];// 每次最多读取的长度
		int len;// 真实长度
		String str = "";
		while((len=fis.read(bs)) != -1) {
			// byte数组转字符串
			str += new String(bs,0,len);
		}
		
		fis.close();
		System.out.println(str);
		
	}
```

拷贝

```Java
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入源文件：");
		String str = sc.next();
		System.out.println("请输入目标文件：");
		String str2 = sc.next();

		FileInputStream fis = new FileInputStream(str);
		FileOutputStream fos = new FileOutputStream(str2);
		byte[] bs = new byte[10240];
		int len;
		while ((len = fis.read(bs)) != -1) {
			fos.write(bs, 0, len);
		}

		fis.close();
		fos.close();

		File file = new File(str);
		File file2 = new File(str2);
		file2.setLastModified(file.lastModified());

		System.out.println("拷贝成功！！");
	}
```

BufferedOutputStream，BufferedInputStream：缓冲流

低级流，节点流：直接操作硬件设备的流，比如FileOutputStream

高级流，处理流：不直接操作硬件设备，需要传入一个流来进行操作，比如BufferedOutputStream

```Java
public class BufferedStream {

	public static void main(String[] args) throws IOException {
		write();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("f2.txt"));
		byte[] bs = new byte[10240];
		int len;
		String str = "";
		while ((len = bis.read(bs)) != -1) {
			str += new String(bs, 0, len);
		}
		bis.close();
		System.out.println(str);
	}

	private static void write() throws FileNotFoundException, IOException {
		// BufferedOutputStream 缓冲流
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("f2.txt"));
		bos.write("hello world".getBytes());
		bos.write('\n');
		byte[] bs = { 97, 98, 99, 100 };
		bos.write(bs, 0, 1);
		bos.close();
	}

}

```

DataOutputStream，DataInputStream：数据流，高级流

```jAVA
public class DataStream {

	public static void main(String[] args) throws IOException {

		write();
		DataInputStream dis = new DataInputStream(new FileInputStream("d:/a/f3.txt"));
		System.out.println(dis.readInt());
		System.out.println(dis.readUTF());
		System.out.println(dis.readDouble());
		dis.close();
	}

	private static void write() throws FileNotFoundException, IOException {
		File file = new File("d:\\a");
		if (!file.exists()) {
			file.mkdirs();
		}

		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file + "/f3.txt"));
		dos.writeInt(100);
		dos.writeUTF("Hello World!");
		dos.writeDouble(3.14);
		dos.close();
	}

}

```

ObjectOutputStream，ObjectInputStream：对象流，高级流

序列化：将对象转成byte数组、字符串等。

反序列化：将byte数组、字符串等转成对象。

```Java
// 若想进行二进制序列化，实现Serializable （可序列化接口）
public class Emp implements Serializable {

	private String name;
	private double salary;

	public Emp() {
		super();
	}

	public Emp(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", salary=" + salary + "]";
	}

}

```

```Java
public class ObjectStream {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		write();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.txt"));
		// 数据写入对象  （反序列化的过程）
		Emp emp = (Emp) ois.readObject();
		
		System.out.println(emp);
		ois.close();
	}

	private static void write() throws IOException, FileNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.txt"));
		Emp emp = new Emp();
		emp.setName("tom");
		emp.setSalary(18000);
		
		// 对象写入到流中  （序列化的过程）
		oos.writeObject(emp);
		
		oos.close();
	}

}

```

PrintStream 打印流

```Java
	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println("Hello");
		
		// 打印流
//		PrintStream ps = new PrintStream(System.out);
		PrintStream ps = new PrintStream("p.txt");
		ps.println("hello Java");
		ps.println("hello");
		ps.close();
	}
```

**字符流**





### 多线程

并发：指两个或多个事件在同一个时间段内发生（交替执行）

并行：指两个或多个事件在同一时刻发生（同时发生）

进程：是程序执行最小单位，一个进程就是一个应用程序

线程：是运行的最小单位，必须依赖进程，进程结束，线程关闭

​			一个进程中至少有一个线程

​			一个进程中是可以有多个线程的，这个应用程也可以称之为多线程程序

​			一个程序运行后至少有一个进程，一个进程中可以包含多个线程

线程调度：

1）分时调度：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间。 

2）抢占式调度：优先让优先级高的线程使用 CPU，如果线程的优先级相同，

​	   那么会随机选择一个(线程随机性)，Java使用的为抢占式调度。

主线程：执行主方法（main）的线程

单线程程序：Java程序中只有一个线程，执行从main方法开始，从上到下依次执行

**实现线程方法：**

**方式一：**

1.继承Thread类

2.重写run方法，设置线程任务

3.创建Threa类的子类对象

4.调用Thread类中的start方法，开启新的线程 ，执行run方法

```Java
// 1.创建一个Thread类的子类
public class MyThread extends Thread {

	// 2.重写run方法，设置线程任务
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("run:" + i);

		}
	}
}

```

```Java
public class MyThreadTest {

	public static void main(String[] args) {
		// 3.创建Threa类的子类对象
		MyThread mt = new MyThread();

		// 4.调用Thread类中的start方法，开启新的线程
		mt.start();

		for (int i = 0; i < 20; i++) {
			System.out.println("main:" + i);
		}
	}
}

```

**方式二：**

1.实现Runnable接口

2.重写run方法，设置线程的任务

3.创建Runnable接口的实现类对象

4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象

5.调用Thread类中的start方法，开启新的线程

```Java
//1.实现Runnable接口
public class RunnableImpl implements Runnable {

	// 2.重写run方法，设置线程的任务
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "---" + i);
		}
	}

}

```

```Java
public class RunnableImplTest {

	public static void main(String[] args) {
		// 3.创建Runnable接口的实现类对象
		RunnableImpl run = new RunnableImpl();
		// 4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象
		Thread t = new Thread(run);
		// 5.调用Thread类中的start方法，开启新的线程
		t.start();
	}

}

```

**使用匿名内部类实现线程**

```Java
public class InnerClassThread {

	public static void main(String[] args) {
		// 继承   匿名内部类
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName()+"Hello");

				}
			}
		}.start();
		
		
		// 实现
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName()+"Hello2");

				}
			}
			
		};
		
		Thread t = new Thread(r);
		t.start();	
		
		
		// 简化接口的方式
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName()+"Hello3");

				}
			}
			
		}).start();
			
	}
}

```

第一种方式，使用简单，但是影响子类继承其他类

第二种方式，不影响继承，还可以共享实现类资源

**获取线程名称**

1.使用Thread类中的方法getName() 返回线程的名称

```Java
String name = getName();
```

2.先获取当前正在执行的线程，使用 线程中的getName()方法获取线程的名称

Thread.currentThread()：返回正在执行的线程对象

```Java
System.out.println(Thread.currentThread().getName());
```

**设置线程名称**

1.setName();

```Java
public class MyThread02 extends Thread{
	
	public MyThread02() {}
	
	public MyThread02(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	

}

```

```Java
public class MyThread02Test {

	public static void main(String[] args) {
		MyThread02 mt = new MyThread02();
		// 设置线程名称
		mt.setName("小健");
		mt.start();
		
		new MyThread02("小强").start();
	}

}

```

sleep：让程序睡眠

```Java
public class MyThread03 {
	/*
	 * 	putlic static void sleep(long millis)
	 * 	使当前正在执行的线程以指定的毫秒数暂停（暂时停止）
	 * 	毫秒数结束后，线程继续执行
	 */
	public static void main(String[] args) {
		// 模拟秒表
		for (int i = 1; i <= 60; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

```

线程安全问题

解决方案一：使用同步代码块解决

synchronized(锁对象){

​	可能会出现线程安全问题的代码（访问了共享数据）

}

注意：代码块中的锁对象，可以使用任意对象

但必须保证多个线程使用的锁对象是同一个

锁对象作用：把同步代码块锁住，只让一个线程在同步代码块中执行

```Java
public class TicketThread implements Runnable {

	private int ticket = 100;

	// 创建一个锁对象
	Object obj = new Object();

	// 卖票
	@Override
	public void run() {
		// 让卖票操作重复执行
		while (true) {
			synchronized (obj) {
				// 判断票是否还有
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "这是卖的第" + ticket + "张票");
					// 票存在，卖票ticket--
					ticket--;
				}
			}
		}

	}

}

```

```Java
	public static void main(String[] args) {
		// 访问共享票源，得创建一个实现类
		TicketThread t = new TicketThread();
		
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t0.start();
		t1.start();
		t2.start();
	}
```

**解决方案2：使用同步方法**

1.把访问了共享数据的代码抽取出来，放到一个方法中

2.在方法上添加synchronized修饰符

```Java
public class TicketThread2 implements Runnable {
	private int ticket = 100;
	
	public synchronized void payTicket() {
		// 判断票是否还有
		if (ticket > 0) {
			System.out.println(Thread.currentThread().getName() + "这是卖的第" + ticket + "张票");
			// 票存在，卖票ticket--
			ticket--;
		}
	}

	@Override
	public void run() {
		while (true) {
			payTicket();
		}
	}

}

```

死锁：多个线程访问共同的资源，且处于互相等待的状态，会导致死锁

sleep：让当前线程处于休眠状态，但是不释放资源

wait：让当前线程处于等待状态，释放资源，但是需要通过notify/notifyAll进行唤醒

**线程的5种状态（线程生命周期）**

1.新建状态：线程被建立

2.就绪状态：将新建的线程，加入到执行队列中

3.运行状态：线程被执行

4.阻塞状态：执行过程中发生了等待状态，导致线程暂停

5.消亡状态：线程结束

同步：顺序执行（ABCD接力赛）

异步：同时执行（ABCD比赛）

### JDK 8新特性

#### lamdba表达式

主要针对是接口，且接口中只有一个抽象方法，替换匿名内部类

**无参数无返回值**

```Java
public class Demo01 {

	public static void main(String[] args) {
		// 匿名内部类
		Interface1 i1 = new Interface1() {

			@Override
			public void method() {
				System.out.println("哈哈哈哈");
			}
			
		};
		i1.method();
		
		// 是接口，且只有一个抽象方法
		// lamdba表达式
		Interface1 i2 = () -> {
			System.out.println("啦啦啦啦");
		};
		i2.method();
		
		// 由于只有一条语句，所以{} 可以省略
		Interface1 i3 = () -> System.out.println("hello");
		i3.method();
	}
	
}

interface Interface1{
	// 无参数无返回值
	public abstract void method();
}



```

**无参数有返回值**

```Java
public class Demo02 {
	
	public static void main(String[] args) {
		Interface2 i1 = new Interface2() {
			
			@Override
			public int method() {
				
				return 100;
			}
		};
		System.out.println(i1.method());
		
		Interface2 i2 = () ->{
			return 200;
		};
		System.out.println(i2.method());
		
		
		Interface2 i3 = () -> 300;
		System.out.println(i3.method());
	}

}

interface Interface2{
	public abstract int method();
}

```

**有参数无返回值**

```Java
package com.zretc.javase.d0319;

public class Demo03 {

	public static void main(String[] args) {

		Interface3 i1 = new Interface3() {

			@Override
			public void method(int x, int y) {
				System.out.println("x=" + x + ",y=" + y);
			}
		};
		i1.method(1, 2);

		Interface3 i2 = (x, y) -> System.out.println("x=" + x + ",y=" + y);
		i2.method(3, 4);

	}

}

interface Interface3 {
	public abstract void method(int x, int y);
}

```

有参数有返回值

```Java
public class Demo04 {

	public static void main(String[] args) {
		Interface4 i1 = new Interface4() {

			@Override
			public int method(int x, int y) {
				// TODO Auto-generated method stub
				return x + y;
			}
		};
		System.out.println(i1.method(1, 2));

		Interface4 i2 = (x, y) -> x + y;
		System.out.println(i2.method(4, 5));
	}

}

interface Interface4 {
	public abstract int method(int x, int y);
}

```

**集合遍历  排序**

```Java
public class Demo05 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("tom");
		list.add("amy");
		list.add("jack");
		list.add("july");
		
		// Consumer 函数式接口
		list.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		});
		System.out.println("------------");
		
		list.forEach(t->System.out.println(t));
		
		System.out.println("==================");
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		
		list.forEach(t->System.out.println(t));
		
		System.out.println("=============");
		Collections.sort(list, (o1,o2)->o2.compareTo(o1));
		list.forEach(t->System.out.println(t));
		
		list.forEach(System.out::println);
	}

}

```

**可以调用静态方法**

```Java
public class Demo06 {

	public static void main(String[] args) {
		Interface6 i1 = new Interface6() {

			@Override
			public int getInt(String s) {
				// TODO Auto-generated method stub
				return Integer.parseInt(s);
			}
		};

		System.out.println(i1.getInt("123") + 1);

		Interface6 i2 = (s) -> Integer.parseInt(s);
		System.out.println(i2.getInt("456") + 1);

		Interface6 i3 = Integer::parseInt;
		System.out.println(i3.getInt("789") + 1);
	}

}

interface Interface6 {
	int getInt(String s);
}

```

**构造方法**

```Java
public class Demo07 {

	public static void main(String[] args) {
		Interface7 i1 = new Interface7() {

			@Override
			public Student getStudent(String name, int age) {
				return new Student(name, age);
			}
		};
		i1.getStudent("tom", 20);

		Interface7 i2 = Student::new;
		i2.getStudent("jack", 18);
	}

}

class Student {
	public Student(String name, int age) {
		System.out.println(name + "\t" + age);
	}
}

interface Interface7 {
	public Student getStudent(String name, int age);
}

```

#### 日期类

LocalDate：年月日

LocalTime：时分秒毫秒

LocalDateTime：年月日时分秒毫秒

```Java
public class Demo08 {

	public static void main(String[] args) {

		// jdk 8 新增时间类
		// 获取当前系统时间
		LocalDate ld = LocalDate.now();
		System.out.println(ld);

		LocalDate ld2 = LocalDate.of(2025, 3, 12);
		System.out.println(ld2);
		// 完成加减
		ld2 = ld2.plusYears(-3);
		System.out.println(ld2);
		ld2 = ld2.plusMonths(-13);
		System.out.println(ld2);
		ld2 = ld2.plusDays(1);
		System.out.println(ld2);
		// 周 1代表7天
		ld2 = ld2.plusWeeks(2);
		System.out.println(ld2);
		// 格式化
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		System.out.println(dtf.format(ld2));

		// 时分秒毫秒
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		DateTimeFormatter d = DateTimeFormatter.ofPattern("HH:mm:ss");//HH:24进制     hh：12进制
		System.out.println(d.format(lt));
		
		// 年月日时分秒毫秒
		LocalDateTime lt2 = LocalDateTime.now();
		System.out.println(lt2);
		
		DateTimeFormatter d2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println(d2.format(lt2));
		
		
	}

}

```



