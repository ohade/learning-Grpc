package hello;

import java.util.List;
import com.google.protobuf.ByteString;
import static java.util.stream.Collectors.joining;

public class FeMessage {
    private String combine;

    public FeMessage(List<ByteString> combine) {
        if (combine != null) {
            this.combine = combine.stream().map(ByteString::toStringUtf8).collect(joining("|"));
        }
    }

    public String getCombine() {
        return combine;
    }
}
