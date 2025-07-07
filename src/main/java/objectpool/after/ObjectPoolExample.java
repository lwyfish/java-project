//package objectpool.after;
//
//import objectpool.before.MyObjectFactory;
//import org.apache.commons.pool2.ObjectPool;
//import org.apache.commons.pool2.impl.GenericObjectPool;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//
//public class ObjectPoolExample {
//    public static void main(String[] args) {
//        // 创建对象池配置
//        GenericObjectPoolConfig<T> poolConfig = new GenericObjectPoolConfig<>();
//        // 设置最大空闲对象数
//        poolConfig.setMaxIdle(5);
//        // 设置最小空闲对象数
//        poolConfig.setMinIdle(2);
//        // 设置最大对象数
//        poolConfig.setMaxTotal(10);
//
//        // 创建对象工厂
//        MyObjectFactory factory = new MyObjectFactory();
//        // 创建对象池
//        ObjectPool<T> pool = new GenericObjectPool<>(factory, poolConfig);
//
//        try {
//            // 从对象池中获取对象
//            T obj1 = pool.borrowObject();
//            obj1.doSomething();
//
//            // 归还对象到对象池
//            pool.returnObject(obj1);
//
//            // 再次从对象池中获取对象
//            T obj2 = pool.borrowObject();
//            obj2.doSomething();
//
//            // 归还对象到对象池
//            pool.returnObject(obj2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭对象池
//            pool.close();
//        }
//    }
//}