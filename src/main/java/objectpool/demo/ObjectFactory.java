package objectpool.demo;

public interface ObjectFactory<T> {
    // 创建新对象
    T create();

    // 对象归还后重置状态
    boolean reset(T obj);

    // 销毁对象
    void destroy(T obj);

    // 检测对象是否有效
    boolean isValid(T obj);
}
