package method.singleton;

import java.io.Serializable;

/**
 * @Author Justin
 * @Time 2018/7/6 10:09
 * @Description 序列化单例
 * 反序列化时都会创建一个新的实例对象，所以我们需要在反序列化时做处理
 * 反序列化时，我们替换掉反序列化出来的对象，并指向内存中存在的那个单例对象即可
 * 扩展：idea生成序列化编号设置 进入setting→inspections→serialization issues→选择图中的选项。serializable class without ‘serialVersionUID
 */
public class SerializableSingleton implements Serializable {

    private static final long serialVersionUID = 3739244093451204044L;
    // 创建对象
    SerializableSingleton serializableSingleton = new SerializableSingleton();

    // 构造
    private SerializableSingleton(){}

    private Object readResolve(){
        return serializableSingleton;
    }

}
