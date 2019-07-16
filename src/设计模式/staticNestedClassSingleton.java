package 设计模式;

//    静态内部类 static nested class
//    这种方法也是《Effective Java》上所推荐的。
class staticNestedClassSingleton {
    //当类第一次被加载到内存它就实例化了，所以这种实例的创建方式是线程安全的。
    private final static staticNestedClassSingleton INSTANCE=new staticNestedClassSingleton();

    private staticNestedClassSingleton() {
    }

    public static final staticNestedClassSingleton getInstance() {
        return INSTANCE;
    }
}
