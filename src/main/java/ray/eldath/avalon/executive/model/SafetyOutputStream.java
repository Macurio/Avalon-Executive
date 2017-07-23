package ray.eldath.avalon.executive.model;

import ray.eldath.avalon.executive.pool.ConstantPool;

import java.io.IOException;
import java.io.OutputStream;

public class SafetyOutputStream extends OutputStream {
    private boolean full = false;
    private StringBuilder builder = new StringBuilder();

    @Override
    public void write(int b) throws IOException {
        if (full)
            return;
        if (builder.length() + 1 > ConstantPool._MAX_OUTPUT_STREAM_LENGTH()) {
            builder.append("...");
            full = true;
        }
        builder.append((char) b);
    }

    public String get() {
        return builder.toString();
    }
}
