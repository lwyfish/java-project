package DesignPattern.strategy;

/**
 * 策略模式
 * 举个例子，电商网站对于商品的折扣策略有不同的算法，比如新用户满减优惠，不同等级会员的打折情况不同，
 * 这种情况下会产生大量的if-else语句, 并且如果优惠政策修改时，还需要修改原来的代码，不符合开闭原则。
 * 这就可以将不同的优惠算法封装成独立的类来避免大量的条件语句
 * <p>
 * 那什么时候可以考虑使用策略模式呢？
 * 当一个系统根据业务场景需要动态地在几种算法中选择一种时，可以使用策略模式。例如，根据用户的行为选择不同的计费策略。
 * 当代码中存在大量条件判断，条件判断的区别仅仅在于行为，也可以通过策略模式来消除这些条件语句。
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context(new MultiplyStrategy());
        int i = context.execStrategy(1, 2);
        System.out.println(i);

        context.setStrategy(new SumStrategy());
        int i1 = context.execStrategy(1, 2);
        System.out.println(i1);
    }
}
