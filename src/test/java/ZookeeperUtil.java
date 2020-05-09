import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * @author LemonGo
 */
public class ZookeeperUtil {
    private final static CuratorFramework client;

    static {
        client = getClient("192.168.1.109:2181","mongo");
    }

    public static CuratorFramework getClient() {
        if (client!=null){
            return client;
        }
        return getClient("192.168.1.109:2181","mongo");
    }

    private static CuratorFramework getClient(String connectString,String namespace){
        return CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                //连接超时时间，默认15秒
                .connectionTimeoutMs(15 * 1000)
                //会话超时时间，默认60秒
                .sessionTimeoutMs(60 * 1000)
                //设置命名空间
                .namespace(namespace)
                .build();
    }

    public static void create(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        client.create().creatingParentsIfNeeded().forPath(path, payload);
    }

    public static void createEphemeral(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        client.create().withMode(CreateMode.EPHEMERAL).forPath(path, payload);
    }

    public static String createEphemeralSequential(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        return client.create().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, payload);
    }

    public static void setData(final CuratorFramework client, final String path, final byte[] payload) throws Exception {
        client.setData().forPath(path, payload);
    }

    public static void delete(final CuratorFramework client, final String path) throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath(path);
    }

    public static void guaranteedDelete(final CuratorFramework client, final String path) throws Exception {
        client.delete().guaranteed().forPath(path);
    }

    public static String getData(final CuratorFramework client, final String path) throws Exception {
        return new String(client.getData().forPath(path));
    }

    public static List<String> getChildren(final CuratorFramework client, final String path) throws Exception {
        return client.getChildren().forPath(path);
    }

}
