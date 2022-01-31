package n_proxy.g.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface Subject {

    //gong tong de jie kou,ta de fang fa ying gai shi abstract de ,bu neng shi ju ti de ,bu ran bu neng
    // not  to be implented!!!
    public void rent();
    public void hello(String str);


}

 class RealSubject implements Subject {

    @Override
    public void rent() {
        System.out.println("i want to rent my house");
    }

    @Override
    public void hello(String str) {
        System.out.println("nnnnnn");

    }
}

 class DynamicProxy implements InvocationHandler {

    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("llllllllllll");
        System.out.println("method:"+ method);
        method.invoke(subject,args);
        System.out.println("aaaaaaaaaaaaaa");


        return null;
    }
}

class Client{

    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicProxy(realSubject);
        Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                               realSubject.getClass().getInterfaces(),
                               handler);
        System.out.println(realSubject.getClass());
        System.out.println(realSubject.getClass().getClassLoader());
        System.out.println(Subject.class.getClass().getName());
        realSubject.hello(handler.toString());

    }




}




/*
 代理模式是一种常用的Java设计模式，其定义为Provide a surrogate or placeholder for another object to controlaccess to it. 可以理解为创建代理对象，使用代理对象控制对目标对象的访问。其UML图如下所示：

Subject接口：为抽象主题角色，定义方法，可以是抽象类也可以是接口。
*
*
*   1.Subject接口：为抽象主题角色，定义方法，可以是抽象类也可以是接口。

    2.RealSubject类：具体主题角色，它是业务逻辑的具体实现者。

    3.ProxySubject：代理主题角色，他代理具体主题角色，并将其中的方法暴露给客户，由其调用。
*
/

 */


























