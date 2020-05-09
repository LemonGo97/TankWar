import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InstanceDetails {

    private String id;

    private String listenAddress;

    private int listenPort;

    private String interfaceName;

    public InstanceDetails(String id, String listenAddress, int listenPort, String interfaceName) {
        this.id = id;
        this.listenAddress = listenAddress;
        this.listenPort = listenPort;
        this.interfaceName = interfaceName;
    }

}