package containers;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

@Slf4j
public class Bits {
    public static void printBitSet(BitSet b) {
        log.info("bits: {}", b);
        StringBuilder bbits = new StringBuilder();
        for (int j = 0; j < b.size(); j++)
            bbits.append(b.get(j) ? "1" : "0");
        log.info("bit pattern: {}", bbits);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        //Take the LSB of nextInt():
        byte bt = (byte)rand.nextInt();
        BitSet bb = new BitSet();
        for (int i = 7; i >= 0; i--)
            if (((1 << i) & bt) != 0)
                bb.set(i);
            else
                bb.clear(i);
        log.info("byte value:{}", bt);
        printBitSet(bb);

        short st = (short) rand.nextInt();
        BitSet bs = new BitSet();
        for (int i = 15; i >=0; i--)
            if (((1 << i) & st) != 0)
                bs.set(i);
            else
                bs.clear(i);
        log.info("short value:{}", st);
        printBitSet(bs);

        int it = rand.nextInt();
        BitSet bi = new BitSet();
        for (int i = 31; i >= 0; i--)
            if (((1 << i) & it) != 0)
                bi.set(i);
            else
                bi.clear(i);
        log.info("int value:{}", it);
        printBitSet(bi);

        //Test bitsets >= 64 bites:
        BitSet b127 = new BitSet();
        b127.set(127);
        log.info("set bit 127:{}", b127);
        BitSet b255 = new BitSet(65);
        b255.set(255);
        log.info("set bit 255:{}", b255);
        BitSet b1023 = new BitSet(512);
        b1023.set(1023);
        b1023.set(1024);
        log.info("set bit 1023:{}", b1023);
    }
}
/**
 * 随机数发生器被用来生成随机的byte、short和int,每一个都被转换为BitSet中相应的位模式.因为BitSet是64位的,
 * 所以任何生成的随机数都不会导致BitSet扩充容量.然后创建了一个更大的BitSet.你可以看到,BitSet在必要时会进行
 * 扩充.
 * 如果拥有一个可以命名的固定的标志集合,那么EnumSet与BitSet相比,通常是一种更好的选择,因为EnumSet允许你按照
 * 名字而不是数字位的位置进行操作,因此可以减少错误.EnumSet还可以防止你因不注意而添加新的标志位置,这种行为能
 * 够引发严重的、难以发现的缺陷.你应该使用BitSet而不是EnumSet的理由只包括:只有在运行时才知道需要多少个标志;
 * 对标志命名不合理;需要BitSet中的某种特殊操作(查看BitSet和EnumSet的JDK文档).
 */
