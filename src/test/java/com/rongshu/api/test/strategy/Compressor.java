package com.rongshu.api.test.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipOutputStream;

public class Compressor {
    private final CompressionStrategy strategy;
    public Compressor(CompressionStrategy strategy){
        this.strategy=strategy;
    }
    public void compress(Path infile,File outfile) throws IOException {
        try (OutputStream out = new FileOutputStream(outfile)) {
            Files.copy(infile,strategy.compress(out));
        }
    }

    public static void main(String[] args) throws IOException {
        Path infile = null;
        File outfile = null;
        // old way
        Compressor gzip=new Compressor(new GzipCompressionStrategy());
        gzip.compress(infile,outfile);

        //lambda way
        Compressor zip=new Compressor(ZipOutputStream::new);
        zip.compress(infile,outfile);
    }
}
