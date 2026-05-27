package dev.deyve.decorator;

import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(wrappee.readData());
    }

    private static String compress(String input) {
        byte[] source = input.getBytes();
        var deflater = new Deflater();
        deflater.setInput(source);
        deflater.finish();
        byte[] buffer = new byte[source.length * 2 + 32];
        int compressedSize = deflater.deflate(buffer);
        deflater.end();
        byte[] compressed = new byte[compressedSize];
        System.arraycopy(buffer, 0, compressed, 0, compressedSize);
        return Base64.getEncoder().encodeToString(compressed);
    }

    private static String decompress(String input) {
        if (input.isEmpty()) {
            return "";
        }
        byte[] compressed = Base64.getDecoder().decode(input);
        var inflater = new Inflater();
        inflater.setInput(compressed);
        byte[] buffer = new byte[compressed.length * 4 + 64];
        try {
            int size = inflater.inflate(buffer);
            inflater.end();
            return new String(buffer, 0, size);
        } catch (Exception e) {
            throw new IllegalStateException("decompression failed", e);
        }
    }
}
