package com.rongshu.api.test.strategy;

import java.io.IOException;
import java.io.OutputStream;

public interface CompressionStrategy {
    public OutputStream compress(OutputStream data) throws IOException;
}
