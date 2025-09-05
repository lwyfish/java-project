package objectpool.after;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.misc.Perf;

/**
 * 对象池bean配置
 *
 * @author lwy
 * @date 2025/09/05 11:49
 **/
@Configuration
public class ObjectPoolConfig {
    /**
     * 使用对象池示例
     *
     * @return
     */
    @Bean
    public PerfObjectPool PerfBoPool() {
        return new PerfObjectPool(new AbstractObjectFactory() {
            @Override
            public Object createObj() {
                return new PerfBo();
            }
        });
    }
}
