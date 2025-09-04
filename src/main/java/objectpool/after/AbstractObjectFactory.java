package objectpool.after;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;

/**
 * 抽象对象工厂
 *
 * @author lwy
 * @date 2025/09/04 17:54
 **/
public abstract class AbstractObjectFactory<T> extends BasePooledObjectFactory<T> {
    @Override
    public T create() throws Exception {
        return null;
    }

    @Override
    public PooledObject wrap(Object o) {
        return null;
    }
}
