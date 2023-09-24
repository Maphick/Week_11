public class Test {
    public static String someMethod() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            return "catch";
        } finally {
            return "finally";
        }
    }


    class A extends java.lang.Exception{}
    class B extends A{}
    class C extends B{}
    class D extends A{}
    class E extends A{}
    class F extends D{}
    class G extends D{}
    class H extends E{}

    public void exeptions() {
        System.out.println(someMethod());
        try
        {
            throw new C();
            throw new D();
            throw new G();
            throw new H();

        }
        catch (C e) {
            throw new RuntimeException(e);
        } catch (D e) {
            throw new RuntimeException(e);
        } catch (H e) {
            throw new RuntimeException(e);
        }
        catch (A e) {
            throw new RuntimeException(e);
        }
        finally {

        }


    }

    public static void main(String[] args) {

    }
}