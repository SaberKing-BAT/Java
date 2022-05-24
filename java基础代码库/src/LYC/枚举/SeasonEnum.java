package LYC.枚举;

/*
* 枚举理解:
*   其实就是一个特殊的类，不过他的实例对象都定义好了放在类里如：SPRING，相当于常量。
* 关于继承：
*   所有的枚举类都继承 Enum 类，所以不能extends类， 只能implements接口。
*   枚举隐式被 public static final 修饰，因此枚举不能有子枚举；
* 扩展：
*   万物皆继承object，单继承？
*   间接继承eg： child --->extends parent --->extends objet
*/

public enum SeasonEnum {  //为了方便，名字后缀带上Enum
    /*注释：每个枚举成员，最好注释含义、用途*/
    SPRING("春天","蒲公英发芽"),
    SUMMER("夏天","蒲公英花开"),
    AUTUMN("秋天","蒲公英白絮飞舞"),
    WINTER("冬天","蒲公英枯萎泛黄"); //注意后面有内容，结尾加分号。

    private String name;
    private String description;

    SeasonEnum (String name, String description) {  //一定要有构造方法。
        this.name=name;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {     //重写toString方法
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    //switch 支持枚举
    public static String getSeasonDescription(SeasonEnum s){
        switch (s){
            case SPRING:
                return SPRING.getDescription();
            case SUMMER:
                return SUMMER.getDescription();
            case AUTUMN:
                return AUTUMN.getDescription();
            case WINTER:
                return WINTER.getDescription();
            default:
                return "该季节无描述";
        }
    }
    //用接口实现枚举的子继承，对其进行分类
    interface Food {
        enum Coffee implements Food{
            BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
        }
        enum Dessert implements Food{
            FRUIT, CAKE, GELATO
        }
    }
    public static void main(String[] args) {
        System.out.println(SeasonEnum.valueOf("SPRING")); //valueOf(String name)也是编译器添加的在编译期。
        System.out.println(SPRING.name());   //父类Enum类自带name 和ordinal 属性和方法
        System.out.println(SPRING.ordinal());
        SeasonEnum [] seasonEnums=SeasonEnum.values(); //values方法是编译器添加的
        System.out.println(getSeasonDescription(SPRING));
        System.out.println(Food.Coffee.BLACK_COFFEE);
    }
}

