package containers;

public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
/**
 * 对于String而言,hashCode()明显是基于String的内容的.
 * 因此,要想使hashCode()实用,它必须速度快,并且必须有意义.也就是说,它必须基于对象的内容生成散列码.
 * 记得吗,散列码不必是独一无二的(应该更关注生成速度,而不是唯一性),但是通过hashCode()和equals(),
 * 必须能够完全确定对象的身份.
 * 因为在生成桶的下标前,hashCode()还需要做进一步的处理,所以散列码的生成范围并不重要,只要是int即可.
 * 还有另一个影响因素:好的hashCode()应该产生分布均匀的散列码.如果散列码都集中在一块,那么HashMap或
 * 者HashSet在某些区域的负载会很重,这样就不如分布均匀的散列函数快.
 **/