package org.junit;

import java.util.stream.DoubleStream;

public class HesapMakinesi {
    static double topla(double...  sayi) {

        return DoubleStream.of(sayi).sum();
    }
    static double carp(double... sayi){

        return DoubleStream.of(sayi).reduce(1,(a,b) -> a*b);
    }
}
