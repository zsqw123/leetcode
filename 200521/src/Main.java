public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        class CloneClass implements Cloneable{
            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        }
        CloneClass a=new CloneClass();
        System.out.println(a);
        CloneClass b=a;
        System.out.println(b);
        System.out.println(a.clone());
    }
}
