//package javabasic.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component // 声明为 Spring Bean
//public class LoggingAspect {
//
//    // 定义切入点：拦截 com.example.service 包下的所有方法
//    @Pointcut("execution(* com.example.service.*.*(..))")
//    public void serviceMethods() {}
//
//    // 前置通知：方法执行前调用
//    @Before("serviceMethods()")
//    public void beforeAdvice(JoinPoint joinPoint) {
//        System.out.println("Before method: " + joinPoint.getSignature().getName());
//    }
//
//    // 后置通知：方法执行后调用（无论是否异常）
//    @After("serviceMethods()")
//    public void afterAdvice(JoinPoint joinPoint) {
//        System.out.println("After method: " + joinPoint.getSignature().getName());
//    }
//
//    // 返回通知：方法成功返回后调用
//    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
//    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
//        System.out.println("Method returned: " + result);
//    }
//
//    // 异常通知：方法抛出异常后调用
//    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
//    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
//        System.out.println("Method threw exception: " + ex.getMessage());
//    }
//
//    // 环绕通知：可控制方法的执行
//    @Around("serviceMethods()")
//    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Around before: " + joinPoint.getSignature().getName());
//        Object result = joinPoint.proceed(); // 执行目标方法
//        System.out.println("Around after: " + joinPoint.getSignature().getName());
//        return result;
//    }
//}