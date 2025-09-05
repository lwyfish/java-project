package objectpool.after;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * 对象池，
 * 用来组装工厂、配置，并提供借用对象、归还对象方法
 *
 * @author lwy
 * @date 2025/09/05 11:50
 **/
public class PerfObjectPool<T> {

    public static final int DEFAULT_MAX_TOTAL = 8;
    public static final int DEFAULT_MAX_IDLE = 8;
    public static final int DEFAULT_MIN_IDLE = 0;
    private int maxTotal = 8;
    private int maxIdle = 8;
    private int minIdle = 0;

    /**
     * 对象池配置
     */
    private GenericObjectPoolConfig<T> config = new GenericObjectPoolConfig();
    /**
     * 工厂
     */
    private AbstractObjectFactory<T> factory;

    /**
     * 对象池总
     */
    private ObjectPool<T> pool;

    /**
     * 构造方法
     *
     * @param factory
     */
    public PerfObjectPool(AbstractObjectFactory<T> factory) {
        this.factory = factory;
        // 配置对象池
        this.pool = new GenericObjectPool(factory, config);
    }

    /**
     * 借用
     *
     * @return
     */
    public T borrowObject() {
        try {
            return pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 归还
     */
    public void returnObject(T obj) {
        try {
            pool.returnObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
