package dev.deyve.strategy;

public class JpegCompressor implements Compressor {
    @Override
    public void compress(String fineName) {
        System.out.println("Compressing using JPEG");
    }
}
