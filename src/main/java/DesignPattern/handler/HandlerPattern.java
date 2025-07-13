package DesignPattern.handler;


import lombok.Getter;

/**
 * 责任链模式
 * 处理者Handler ：定义一个处理请求的接口，包含一个处理请求的抽象方法和一个指向下一个处理者的链接。
 * 具体处理者ConcreteHandler: 实现处理请求的方法，并判断能否处理请求，如果能够处理请求则进行处理，否则将请求传递给下一个处理者。
 * 客户端：创建并组装处理者对象链，并将请求发送到链上的第一个处理者。
 */
public class HandlerPattern {
    public static void main(String[] args) {
        ConcreteHandler1 concreteHandler1 = new ConcreteHandler1();
        ConcreteHandler2 concreteHandler2 = new ConcreteHandler2();
        concreteHandler1.setNext(concreteHandler2);

        Request request1 = new Request("TypeA", "Request A");
        Request request2 = new Request("TypeB", "Request B");
        Request request3 = new Request("TypeC", "Request C");
        concreteHandler1.handlerRequest(request1);
        concreteHandler1.handlerRequest(request2);
        concreteHandler1.handlerRequest(request3);
    }
}

interface Handler {
    void handlerRequest(Request request);

    void setNext(Handler handler);
}

/**
 * 抽象类可以写公共方法，子类继承
 */
abstract class AbstractHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void handlerRequest(Request request) {
        if (canHandle(request)) {
            // 自己能处理
            doHandle(request);
        } else if (nextHandler != null) {
            // 自己不能处理，往下一级
            nextHandler.handlerRequest(request);
        } else {
            System.out.println("error");
        }
    }

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    public abstract boolean canHandle(Request request);

    public abstract void doHandle(Request request);
}

class ConcreteHandler1 extends AbstractHandler {

    @Override
    public boolean canHandle(Request request) {
        return "TypeA".equals(request.getType());
    }

    @Override
    public void doHandle(Request request) {
        System.out.println("ConcreteHandlerA is handling the request: " + request.getContent());
    }
}

class ConcreteHandler2 extends AbstractHandler {

    @Override
    public boolean canHandle(Request request) {
        return "TypeB".equals(request.getType());
    }

    @Override
    public void doHandle(Request request) {
        System.out.println("ConcreteHandlerB is handling the request: " + request.getContent());
    }
}

class Request {
    @Getter
    private String type;
    @Getter
    private String content;

    public Request(String type, String content) {
        this.type = type;
        this.content = content;
    }
}