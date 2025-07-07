package objectpool.before;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

// 定义对象工厂
public class MyObjectFactory extends BasePooledObjectFactory<MyObject> {
    private static int counter = 0;

    @Override
    public MyObject create() throws Exception {
        // 创建新的对象
        return new MyObject(++counter);
    }

    @Override
    public PooledObject<MyObject> wrap(MyObject obj) {
        // 将对象包装成 PooledObject
        return new DefaultPooledObject<>(obj);
    }

    @Override
    public void destroyObject(PooledObject<MyObject> p) throws Exception {
        // 销毁对象
        super.destroyObject(p);
    }

    @Override
    public boolean validateObject(PooledObject<MyObject> p) {
        // 验证对象是否有效
        return true;
    }
}