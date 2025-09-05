package objectpool.after;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * 抽象对象工厂
 *
 * @author lwy
 * @date 2025/09/04 17:54
 **/
public abstract class AbstractObjectFactory<T> extends BasePooledObjectFactory<T> {

    /**
     * 抽象方法，使子类必须继承
     * @return
     */
    public abstract T createObj();

    @Override
    public T create() throws Exception {
        return createObj();
    }

    @Override
    public PooledObject wrap(Object obj) {
        return new DefaultPooledObject(obj);
    }
}
