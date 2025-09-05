package objectpool.after;

/**
 * demo
 *
 * @author lwy
 * @date 2025/09/05 13:45
 **/
public class demo1 {
    public static void main(String[] args) {
        PerfObjectPool perfObjectPool = new PerfObjectPool(new AbstractObjectFactory() {
            @Override
            public Object createObj() {
                return new PerfBo();
            }
        });
        Object o = perfObjectPool.borrowObject();
        perfObjectPool.returnObject(o);
    }
}
