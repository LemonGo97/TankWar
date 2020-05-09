import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bson.BSONDecoder;
import org.bson.BSONObject;
import org.bson.BasicBSONDecoder;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, DecoderException {
        String str = "7e000000026576616c006f00000064622e746573742e66696e6428292e6d61702866756e6374696f6e286974656d29207b6966202827616464726573732720696e206974656d29207b6974656d2e616464726573732e63697479203d20273138332a2a2a2a2a2a2a273b7d3b2072657475726e206974656d207d293b0000";
        byte[] bytes = Hex.decodeHex(str);
        BSONDecoder decoder = new BasicBSONDecoder();
        BSONObject bsonObject = decoder.readObject(bytes);
        System.out.println(bsonObject);

    }
}
