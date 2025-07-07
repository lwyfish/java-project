package objectpool.after;

import objectpool.before.MyObject;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

// 定义对象工厂
public abstract class CommonObjectFactory<T> extends BasePooledObjectFactory<T> {
    /**
     * 创建对象
     * @return
     */
    public abstract T createObj();

    /**
     * 初始化对象
     * @param obj
     */
    public abstract void initObj(T obj);

    @Override
    public T create() throws Exception {
        return createObj();
    }

    @Override
    public PooledObject<T> wrap(T t) {
        return new DefaultPooledObject<>(t);
    }
}