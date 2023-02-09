package dev.deyve.strategy;

public class PngCompressor implements Compressor {
    @Override
    public void compress(String fineName) {
        System.out.println("Compressing using PNG");
    }
}
