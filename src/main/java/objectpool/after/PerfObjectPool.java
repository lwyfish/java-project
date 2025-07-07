package objectpool.after;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 性能对象池
 *
 * @author lwy
 * @date 2025/04/17 09:41
 **/
public class PerfObjectPool<T> {


    // 创建对象池配置
    private static final GenericObjectPoolConfig config = new GenericObjectPoolConfig<>();
    private CommonObjectFactory commonObjectFactory;
    private ObjectPool<T> objectPool;


    public PerfObjectPool(CommonObjectFactory commonObjectFactory) {
        config.setMaxIdle(1);
        this.commonObjectFactory = commonObjectFactory;
        this.objectPool = new GenericObjectPool<>(commonObjectFactory, config);
        try {
            objectPool.addObjects(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//
//// 设置最大空闲对象数
//        poolConfig.setMaxIdle(5);
//    // 设置最小空闲对象数
//        poolConfig.setMinIdle(2);
//    // 设置最大对象数
//        poolConfig.setMaxTotal(10);


}
