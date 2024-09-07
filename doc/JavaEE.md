## JavaEE

基于web开发，浏览器与服务器之间的传递

C/S模式：客户端与服务的交互

B/S模式：浏览器与服务器交互

### MVC

M：Model  模型层   主要与数据库进行连接的（java jdbc oracle）

V：View   视图层   用户可以看见的  (html  css js等)

C：Controller   控制层   是V与M的桥梁，起到了连接作用（Servlet）

### Servlet

是前后端衔接的桥梁

Servlet是一个接口，GenericServlet是Servlet的实现类，在使用时用的是HttpServlet，它是GenericServlet的子类

Servlet，只实例化一次，单例模式

**创建Servlet对象3.0**

1、创建一个类，继承HttpServlet

2、重写service（doGet/doPost）

3、需要在web.xml中进行配置

```xml
  <!-- 配置Servlet -->
  <servlet>
  	<!-- Servlet的名字 -->
  	<servlet-name>First</servlet-name>
  	<!-- Servlet的类全名 -->
  	<servlet-class>com.zretc.javaee.demo01.FirstServlet</servlet-class>
  </servlet>
  
  <!-- Servlet映射 -->
  <servlet-mapping>
  	<!-- 名称和配置节中servlet-name必须保持 一致 -->
  	<servlet-name>First</servlet-name>
  	<!-- 请求映射路径 -->
  	<url-pattern>/firstDemo</url-pattern>
  </servlet-mapping>
```

在service方法中有两个对象，分别是请求与响应，当客户端发出请求时，会产生请求对象，请求对象中可以携带请求参数，请求头等数据，服务器会产生一个响应对象，携带一些数据

**请求对象方法：**

setCharacterEncoding   设置请求编码集

getParameter   获得提交参数值

getParameterValues   接收同名键的多个值   返回是一个数组

**响应对象的方法：**

setContentType   设置响应的类型及编码

getWriter   获得响应输出流

**Servlet3.0之后，采用的是注解形式**

1、创建一个类，继承HttpServlet

2、重写service（doGet/doPost）

3、在类上加注解@WebServlet(虚拟路径)   注意：虚拟路径是唯一值

### **Servlet生命周期**

单例模式

1、实例化阶段

2、初始化阶段

3、服务/就绪阶段

4、销毁阶段

其中实例化对象，初始化，销毁只执行一次

### 转发和重新向

重定向：resp.sendRedirect("login.html");

转发：req.getRequestDispatcher("jsp03.jsp").forward(req, resp);

|                      | 重定向 | 转发 |
| -------------------- | ------ | ---- |
| 操作对象             | 响应   | 请求 |
| 发送请求的次数       | 2次    | 1次  |
| 路径是否发生变化     | 变     | 不变 |
| 是否可恶意ii携带数据 | 不可以 | 可以 |

请求对象中与传递参数有关的方法：

setAttribute   设置参数，成键值对形式

getAttribute  根据key取值

removeAttribute   移除参数

### 开发的架构

MVC架构：视图层   控制层    模型层（业务层  数据层）

### Servlet设置参数配置

局部配置参数，设置在Servlet中，只许当前Servlet进行访问，访问两种方式：

1.this.getInitParameter(参数名字)

2.this.getServletConfig().getInitParameter(参数名字)

getServletConfig()：获得Servlet配置

```html
  <servlet>
  	<servlet-name>ParamServlet</servlet-name>
  	<servlet-class>com.zretc.javaee.demo03.ParamServlet</servlet-class>
  	<!-- 局部初始化参数 -->
  	<init-param>
  		<param-name>data</param-name>
  		<param-value>快点敲代码</param-value>
  	</init-param>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ParamServlet</servlet-name>
  	<url-pattern>/paramservlet</url-pattern>
  </servlet-mapping>
```

全局配置参数，设置在web.xml里，整个项目都可以进行访问，request.getServletContext().getInitParameter(参数名字)   

getServletContext()：获得Servlet上下文

```html
  <!-- 全局初始化参数 -->
  <context-param>
  	<param-name>myip</param-name>
  	<param-value>192.168.102.200</param-value>
  </context-param>
```

### Servlet三大范围对象

HttpServletRequest				请求						同一个请求

HttpSession							 会话						同一个会话

ServletContext						Servlet上下文		整个项目

设置参数时：setAttribute(key,value)

取值：getAttribute(key)

移除数据：removeAttribute(key)

### Session

代表是会话的意思，一个会话就是一个Session对象，存储在服务器中（cookie）里，对应的类HttpSession

session对象第一次调用getSession产生的，其中getSession(true)代表是如果有session对象则返回，没有则创建对象，getSession(false) 代表是如果有session对象返回，没有返回null

session有有效时长，默认是30分钟

设置session时长方法：

1、在web.xml中设置session标签

```xml
  <session-config>
  	<!-- 单位是分钟 -->
  	<session-timeout>60</session-timeout>
  </session-config>
```

2、session对象设置有效时长，setMaxInactiveInterval    单位是秒

### Session失效情况

1、清楚cookie了（找不到上一个session了）

2、关闭浏览器了

3、时长过了

4、调用invalidate()方法

应用在登录拦截，登录时每一个页面显示账号或相关信息的，退出时让session失效

### 过滤器

3.0之前

1.创建一个类，实现Filter接口

2.实现init，doFilter，destroy

3.在web.xml中配置

```xml
  <!-- 配置过滤器 -->
  <filter>
  	<!-- 过滤器的名字 -->
  	<filter-name>encoding</filter-name>
  	<!-- 过滤器的路径 -->
  	<filter-class>com.zretc.javaee.demo05.EncodingFilter</filter-class>
  </filter>
  <!-- 配置过滤器映射 -->
  <filter-mapping>
  	<!-- 与上面名字保持一致 -->
  	<filter-name>encoding</filter-name>
  	<!-- 过滤路径 -->
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
```

3..之后

1.创建一个类，实现Filter接口

2.实现init，doFilter，destroy

3.在实现类上加@WebFilter(过滤路径)

### Filter生命周期

是单例模式，在启动服务器时执行了

1.创建对象（实例化）

2.初始化init方法

3.doFilter

4.销毁destroy

执行一次的是实例化对象，初始化init，销毁destroy只执行一次

一般会利用过滤器做编码集设置，与登录拦截

注意：一个项目中是可以设置多个过滤器的，如果在web.xml配置的，则按照配置的顺序执行，如果是注解形式，取决于服务器

### Cookie

是存储在浏览器中的技术

cookie中没有设置时长，默认是会话级别的

cookie设置有效时长，则代表是永久级别的，除非手动清除或者超时，否则会一直都在

写入Cookie时，需要建立一个Cookie对象，增加到响应中，通过setMaxAge设置有效时长，单位是秒

读取Cookie时，是从请求中获得Cookie数组，getName获得Cookie名字，getValue获得Cookie值

```Java
@WebServlet("/WriteCookieServlet")
public class WriteCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建Cookie对象
		Cookie c1 = new Cookie("uname", "jack");

		// 设置cookie的时长 默认是秒
		c1.setMaxAge(60 * 10);

		// 写到响应对象中
		resp.addCookie(c1);
	}
}
```

```Java
@WebServlet("/ReaderCookieServlet")
public class ReaderCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cs = req.getCookies();
		for (Cookie cookie : cs) {
			System.out.println(cookie.getName() + "," + cookie.getValue());
		}
	}
}

```

### Session和Cookie的区别

1、Session存储在服务端，Cookie存储在客户端

2、Session安全，Cookie不安全

3、Session可以存储任何数据类型，Cookie只能存储字符串

4、Session可以存储大量信息，Cookie只能存储少量信息

5、浏览器可以禁用Cookie，但是不能禁用Session

6、Cookie可以在浏览器中手动清除，Session不能

### JSP

Java Server Pages  动静结合的技术，既可以写Java，又可以写html，每一个jsp都是一个Servlet类，jsp中有一些内置对象（request，response，session等） 可以直接使用

方式一：JSP小脚本：<%java脚本%>   可以写java代码，可以使用JSP内置对象，不能直接定义方法

方式二：JSP表达式：<%=表达式%>  可以放表达式，有返回值的方法调用，可以取代out输出

方式三：JSP声明：<%! %>  可以定义方法，不能使用JSP内置对象

<%@ 指令%>  page指令：可以设置语言，编码集，导包等

​						 taglib指令：引入标签库

​						 include指令：可以导入页面文件

### JSP生命周期

1.编译阶段=》利用Servlet容器，将jsp编译成Servlet文件

2.初始化阶段=》加载类  创建对象  初始化方法(_jspInit())

3.执行阶段=》调用服务方法（_jspService）

4.销毁=》调用销毁方法（_jspDestroy()）

### JSP的九大内置对象

| JSP对象     | 后台对象            | 描述                               |
| ----------- | ------------------- | ---------------------------------- |
| request     | HttpServletRequest  | 请求对象                           |
| response    | HttpServletResponse | 响应对象                           |
| session     | HttpSession         | 会话对象                           |
| config      | ServletConfig       | Servlet配置                        |
| application | ServletContext      | Servlet上下文（整个项目）          |
| pageContext | pageContext         | 页面的上下文  设置参数  取其他对象 |
| page        | this                | 当前页对象                         |
| out         | JspWriter           | 输出流                             |
| exception   | Throwable           | 异常                               |

### 配置jsp的局部初始化参数

```xml
  <servlet>
  	<servlet-name>configjsp</servlet-name>
  	<!-- jsp文件的路径 -->
  	<jsp-file>/jsp05_config.jsp</jsp-file>
  	<!-- 局部初始化参数 -->
  	<init-param>
  		<param-name>ip</param-name>
  		<param-value>192.168.102.100</param-value>
  	</init-param>
  </servlet>
  <servlet-mapping>
  	<servlet-name>configjsp</servlet-name>
  	<url-pattern>/configjsp</url-pattern>
  </servlet-mapping>
```

### 配置jsp的全局初始化参数

```xml
  <!-- 全局初始化参数 -->
  <context-param>
  	<param-name>myip</param-name>
  	<param-value>192.168.102.200</param-value>
  </context-param>
```

### 错误页配置

两种方式：

1、在发生异常的页中加errorPage="错误页路径"，在错误页中加isErrorPage="true"才可以获得异常信息

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="exception.jsp"%><!-- 方式一：在发生异常的页中加errorPage="错误页路径" -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=8/0 %>
</body>
</html>
```

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%><!-- 在错误页中加isErrorPage="true"才可以获得异常信息 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=exception.getMessage() %>
页面出错了，暂时无法访问~~~~~~~~~~
</body>
</html>
```

2、web.xml中设置发生错误的跳转页面

```xml
  <!-- 配置错误页 -->
  <!-- <error-page>
  	配置状态码  依据状态码来转向错误页
  	<error-code>500</error-code>
  	<location>/500.jsp</location>
  </error-page> --> 
  
  <error-page>
  	<error-code>404</error-code>
  	<location>/404.jsp</location>
  </error-page>  
  
  
  <!-- 配置错误页 -->
  <error-page>
  	<exception-type>java.lang.Exception</exception-type>
  	<location>/exception.jsp</location>
  </error-page>
```

### JSP四大范围对象

pageContext      页面的上下文

request			请求

session			 会话

application       整个应用

设置参数时：setAttribute

取值：getAttribute

移除数据：removeAttribute

### el表达式

### el四大域对象=》四大范围对象

pageScope

requestScope

sessionScope

applicationScope

取值的是jsp四大范围对象中设置的setAttribute中的值

语法：对象.key的名字    或者  对象["key的值"]

当没有写范围对象时，会按照范围由小到大依次进行查找